package com.tj.newsreader.ui.main

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.tj.newsreader.models.Article
import com.tj.newsreader.network.main.MainApi

import javax.inject.Inject

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


import io.reactivex.internal.operators.single.SingleInternalHelper.toObservable

class MainViewModel @Inject
constructor(private val mainApi: MainApi) : ViewModel() {

    //
    private val mainArticle = MediatorLiveData<Article>()

    init {
        Log.d(TAG, "MainViewModel:viewmodel is working...")

    }

    //Init call of the API

    fun authenticateWithtitle(sources: String, apiKey: String) {

        val source = LiveDataReactiveStreams.fromPublisher(
            mainApi.getArticle(sources, apiKey)
                .subscribeOn(Schedulers.io())


        )

        mainArticle.addSource(source) { article ->
            mainArticle.value = article
            mainArticle.removeSource(source)
        }


    }


    fun observeArticle(): LiveData<Article> {
        return mainArticle


    }

    companion object {

        private val TAG = "AuthViewModel"
    }
}

package com.tj.newsreader.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.tj.newsreader.models.Article;
import com.tj.newsreader.network.main.MainApi;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



import static io.reactivex.internal.operators.single.SingleInternalHelper.toObservable;

public class MainViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final MainApi mainApi;

    //
    private MediatorLiveData<Article> mainArticle = new MediatorLiveData<>();

    @Inject
    public MainViewModel(MainApi mainApi) {
        this.mainApi = mainApi;
        Log.d(TAG, "MainViewModel:viewmodel is working...");

    }

    //Init call of the API

    public void authenticateWithtitle(String sources, String apiKey){

        final LiveData<Article> source = LiveDataReactiveStreams.fromPublisher(
                mainApi.getArticle(sources,apiKey)
                .subscribeOn(Schedulers.io())


        );

        mainArticle.addSource(source, new Observer<Article>() {
            @Override
            public void onChanged(Article article) {
                mainArticle.setValue(article);
                mainArticle.removeSource(source);
            }
        });





    }


    public LiveData<Article> observeArticle(){
        return mainArticle;


    }
}

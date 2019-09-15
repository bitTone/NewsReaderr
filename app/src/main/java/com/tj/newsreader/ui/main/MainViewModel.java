package com.tj.newsreader.ui.main;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.tj.newsreader.models.Article;
import com.tj.newsreader.network.main.MainApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



import static io.reactivex.internal.operators.single.SingleInternalHelper.toObservable;

public class MainViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final MainApi mainApi;

    @Inject
    public MainViewModel(MainApi mainApi) {
        this.mainApi = mainApi;
        Log.d(TAG, "MainViewModel:viewmodel is working...");

        mainApi.getArticle("article")
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Article>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Article article) {

                        Log.d(TAG, "onNext: " + article.getTitle());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }


                });

    }
}

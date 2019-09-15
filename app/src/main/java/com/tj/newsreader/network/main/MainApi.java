package com.tj.newsreader.network.main;

import com.tj.newsreader.models.Article;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MainApi {

    @GET("article{title}")
    Flowable<Article> getArticle(
        @Path("article") String id

    );


}

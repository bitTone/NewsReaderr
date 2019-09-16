package com.tj.newsreader.network.main;

import com.tj.newsreader.models.Article;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainApi {

    @GET("top-headlines")
    Flowable<Article> getArticle(
        @Query("sources") String sources,@Query("apiKey") String apiKey);




}

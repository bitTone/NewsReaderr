package com.tj.newsreader.models;

import com.squareup.moshi.Json;

import java.util.List;


public class Article {

//name,title,description,Image


    @Json(name = "status")
    private String status;
    @Json(name = "totalResults ")
    private int totalResults;
    @Json(name = "articles")
    private List<NewsArticle> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles() {
        setArticles();
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }
}












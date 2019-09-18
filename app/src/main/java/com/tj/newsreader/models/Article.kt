package com.tj.newsreader.models

import com.squareup.moshi.Json


class Article {

    //name,title,description,Image


    @Json(name = "status")
    var status: String? = null
    @Json(name = "totalResults ")
    private var totalResults: Int = 0
    @Json(name = "articles")
    var articles: List<NewsArticle>? = null

    fun getTotalResults(): Int? {
        return totalResults
    }

    fun setTotalResults(totalResults: Int?) {
        this.totalResults = totalResults!!
    }

    fun setArticles() {
        setArticles()
    }
}












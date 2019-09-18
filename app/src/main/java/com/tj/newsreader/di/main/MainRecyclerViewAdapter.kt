package com.tj.newsreader.di.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.tj.newsreader.R
import com.tj.newsreader.models.Article
import com.tj.newsreader.models.NewsArticle

import java.util.ArrayList


class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var articles: List<NewsArticle> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.mainmodellayout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainViewHolder).bind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setPosts(articles: List<NewsArticle>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var title: TextView

        init {
            title = itemView.findViewById(R.id.title)
        }

        fun bind(articles: NewsArticle) {
            title.text = articles.title
        }
    }
}






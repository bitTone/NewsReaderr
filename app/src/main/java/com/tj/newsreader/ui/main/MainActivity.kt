package com.tj.newsreader.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toolbar

import com.bumptech.glide.RequestManager
import com.tj.newsreader.R
import com.tj.newsreader.models.Article
import com.tj.newsreader.network.main.MainApi
import com.tj.newsreader.viewmodels.ViewModelProviderFactory

import java.util.ArrayList

import javax.inject.Inject

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable


class MainActivity : DaggerAppCompatActivity() {
    private val mArticleList = ArrayList<Article>()
    private var mRecyclerView: RecyclerView? = null
    private val mToolbar: Toolbar? = null
    private val mProgressBar: ProgressBar? = null
    private val mImageView: ImageView? = null

    @Inject
    internal var mService: MainApi? = null

    private var viewModel: MainViewModel? = null


    @Inject
    internal var providerFactory: ViewModelProviderFactory? = null

    //GLIDE LIBRARY
    @Inject
    internal var requestManager: RequestManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mRecyclerView = findViewById(R.id.recyclerView);
        // mToolBar = findViewById(R.id.toolbar);
        //  mProgressBar = findViewById(R.id.progressBar);
        // mImageView = findViewById(R.id.imageView);

        //setSupportActionBar(mToolbar);
        // getSupportActionBar().setTitle("NewsReader");
        // initViews();

        //mCompositeDisposable = new CompositeDisposable();
        // Timber.plant(new Timber.DebugTree());
        // MainActivityComponent

        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel::class.java)

        subscribeObservers()

    }


    private fun initViews() {
        mRecyclerView = findViewById(R.id.recycler_view)
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
    }


    private fun subscribeObservers() {
        viewModel!!.observeArticle().observe(this, Observer { })

    }

    companion object {
        //@Inject RecyclerViewAdapter mAdapter;

        private val TAG = "MainActivity"

        private val API_KEY = "2c9e6edd68e142d9b130d4db0e7613f2"
    }


}
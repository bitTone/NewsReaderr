package com.tj.newsreader.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.bumptech.glide.RequestManager;
import com.tj.newsreader.R;
import com.tj.newsreader.models.Article;
import com.tj.newsreader.network.main.MainApi;
import com.tj.newsreader.viewmodels.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends DaggerAppCompatActivity {
    private List<Article> mArticleList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;
    private ImageView mImageView;

    @Inject MainApi mService;
    //@Inject RecyclerViewAdapter mAdapter;

    private static final String TAG = "MainActivity";

    private MainViewModel viewModel;

    private static final String API_KEY = "2c9e6edd68e142d9b130d4db0e7613f2";





    @Inject
    ViewModelProviderFactory providerFactory;

    //GLIDE LIBRARY
    @Inject
    RequestManager requestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);

        subscribeObservers();

    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void subscribeObservers(){
        viewModel.observeArticle().observe(this, new Observer<Article>() {
            @Override
            public void onChanged(Article article) {

            }
        });

    }


}
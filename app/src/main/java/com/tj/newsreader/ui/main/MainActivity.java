package com.tj.newsreader.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.tj.newsreader.R;
import com.tj.newsreader.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class MainActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private MainViewModel viewModel;



    @Inject
    ViewModelProviderFactory providerFactory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);

    }


}
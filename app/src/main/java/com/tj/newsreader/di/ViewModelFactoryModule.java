package com.tj.newsreader.di;


import androidx.lifecycle.ViewModelProvider;

import com.tj.newsreader.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;


//responsible for doing dependency injection in the model class
@Module
public abstract class ViewModelFactoryModule {
    //Injects into MainActivity
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}

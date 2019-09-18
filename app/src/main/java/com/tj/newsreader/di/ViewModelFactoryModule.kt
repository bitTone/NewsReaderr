package com.tj.newsreader.di


import androidx.lifecycle.ViewModelProvider

import com.tj.newsreader.viewmodels.ViewModelProviderFactory

import dagger.Binds
import dagger.Module


//responsible for doing dependency injection in the model class
@Module
abstract class ViewModelFactoryModule {
    //Injects into MainActivity
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}

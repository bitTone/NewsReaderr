package com.tj.newsreader.di.main


import androidx.lifecycle.ViewModel

import com.tj.newsreader.di.ViewModelKey
import com.tj.newsreader.ui.main.MainActivity
import com.tj.newsreader.ui.main.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel


}

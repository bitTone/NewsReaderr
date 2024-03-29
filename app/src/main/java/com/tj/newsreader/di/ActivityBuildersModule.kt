package com.tj.newsreader.di

import com.tj.newsreader.di.main.MainModule
import com.tj.newsreader.di.main.MainViewModelsModule
import com.tj.newsreader.ui.main.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {


    @ContributesAndroidInjector(modules = [MainViewModelsModule::class, MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity


}

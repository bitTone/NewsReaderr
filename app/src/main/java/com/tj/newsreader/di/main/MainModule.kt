package com.tj.newsreader.di.main

import com.tj.newsreader.network.main.MainApi

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MainModule {

    @Provides
    internal fun provideAdapter(): MainRecyclerViewAdapter {
        return MainRecyclerViewAdapter()

    }


    @Provides
    internal fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)


    }
}

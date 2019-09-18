package com.tj.newsreader.di

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.tj.newsreader.util.Constants

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


//Al dependencies that are used throughout the lifespan of the application

@Module
object AppModule {

    @Singleton
    @Provides
    internal fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()


    }

    @Singleton
    @Provides
    internal fun provideRequestOptions(): RequestOptions {
        return RequestOptions.placeholderOf(ColorDrawable(Color.WHITE))
            .error(ColorDrawable(Color.RED))

    }

    @Singleton
    @Provides
    internal fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }


}

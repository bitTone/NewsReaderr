package com.tj.newsreader.di.main;

import com.tj.newsreader.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @Provides
    static MainRecyclerViewAdapter provideAdapter(){
        return new MainRecyclerViewAdapter();

    }


    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);



    }
}

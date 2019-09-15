package com.tj.newsreader.di;

import com.tj.newsreader.di.main.MainModule;
import com.tj.newsreader.di.main.MainViewModelsModule;
import com.tj.newsreader.ui.main.MainActivity;

import dagger.android.ContributesAndroidInjector;

public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class} )
            abstract MainActivity contributeAuthActivity();


}
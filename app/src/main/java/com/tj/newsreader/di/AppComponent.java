package com.tj.newsreader.di;

import android.app.Application;

import com.tj.newsreader.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//persists across entire lifetime of the application.
//App Component is equivalent to a service
//Base Application is equivalent to a client
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuildersModule.class,
                ViewModelFactoryModule.class

        })


public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        //Binds application instance to the appllication component.
        //want app component to exist throughout entire lifetime of the application.
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

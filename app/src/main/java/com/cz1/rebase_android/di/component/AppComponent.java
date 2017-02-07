package com.cz1.rebase_android.di.component;

import android.content.Context;

import com.cz1.rebase_android.App;
import com.cz1.rebase_android.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cz1 on 2017/2/7.
 */
@Singleton
@Component(modules =  {AppModule.class})
public interface AppComponent {

    void inject(App app);

    Context getContext();

}

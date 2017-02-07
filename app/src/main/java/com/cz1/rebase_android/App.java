package com.cz1.rebase_android;

import android.app.Application;
import android.content.Context;

import com.cz1.rebase_android.di.component.AppComponent;
import com.cz1.rebase_android.di.component.DaggerAppComponent;
import com.cz1.rebase_android.di.module.AppModule;

/**
 * Created by cz1 on 2017/2/7.
 */

public class App extends Application {

    private AppComponent mAppComponent;

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        sContext = this;

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }
}

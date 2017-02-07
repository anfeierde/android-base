package com.cz1.rebase_android.di.module;

import com.cz1.rebase_android.ui.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cz1 on 2017/2/7.
 */
@Module
public class LoginModule {

    private final LoginContract.View mView;

    public LoginModule(LoginContract.View view) {
        this.mView = view;
    }

    @Provides
    LoginContract.View provideLoginView() {
        return mView;
    }
}

package com.cz1.rebase_android.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.cz1.rebase_android.R;
import com.cz1.rebase_android.di.component.DaggerLoginComponent;
import com.cz1.rebase_android.di.module.LoginModule;
import com.cz1.rebase_android.ui.base.ToolbarActivity;

import javax.inject.Inject;

/**
 * Created by cz1 on 2017/2/7.
 */

public class LoginActivity extends ToolbarActivity{

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected int layoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public boolean canBack() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_login);
        if (fragment == null) {
            fragment = LoginFragment.newInstance();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_login, fragment);
            ft.commit();
        }

        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(fragment))
                .appComponent(getAppComponent())
                .build()
                .inject(this);
    }
}

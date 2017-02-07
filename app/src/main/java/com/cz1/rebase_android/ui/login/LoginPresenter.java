package com.cz1.rebase_android.ui.login;

import javax.inject.Inject;

/**
 * Created by cz1 on 2017/2/7.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private final LoginContract.View loginView;

    @Inject
    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        this.loginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onLogin(String mobile, String password) {
        if (mobile.length() > 0 && password.length() > 0) {
            loginView.setLogin();
        } else {
            loginView.loginError();
        }
    }
}

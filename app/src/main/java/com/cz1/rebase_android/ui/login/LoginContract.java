package com.cz1.rebase_android.ui.login;

import com.cz1.rebase_android.ui.base.BasePresenter;
import com.cz1.rebase_android.ui.base.BaseView;

/**
 * Created by cz1 on 2017/2/7.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {

        void setLogin();

        void loginError();
    }

    interface Presenter extends BasePresenter {

        void onLogin(String mobile, String password);

    }

}

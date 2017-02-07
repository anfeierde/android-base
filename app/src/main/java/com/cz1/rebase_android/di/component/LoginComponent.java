package com.cz1.rebase_android.di.component;

import com.cz1.rebase_android.di.module.LoginModule;
import com.cz1.rebase_android.di.scope.PreActivity;
import com.cz1.rebase_android.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by cz1 on 2017/2/7.
 */
@PreActivity
@Component(dependencies = AppComponent.class,modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}

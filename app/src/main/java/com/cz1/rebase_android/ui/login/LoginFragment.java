package com.cz1.rebase_android.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.cz1.rebase_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cz1 on 2017/2/7.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private static final String TAG = LoginFragment.class.getSimpleName();

    protected LoginContract.Presenter mPresenter;

    @BindView(R.id.et_mobile)
    TextInputEditText mEtMobile;

    @BindView(R.id.et_password)
    TextInputEditText mEtPassword;

    @BindView(R.id.btn_login)
    Button mBtnLogin;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick(R.id.btn_login)
    public void onLogin() {
        mPresenter.onLogin(mEtMobile.getText().toString(), mEtPassword.getText().toString());
    }

    @Override
    public void setLogin() {
        Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}

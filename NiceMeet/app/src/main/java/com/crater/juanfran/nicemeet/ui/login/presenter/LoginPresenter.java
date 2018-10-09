package com.crater.juanfran.nicemeet.ui.login.presenter;

import android.content.Context;

import com.crater.juanfran.nicemeet.ui.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.ui.login.interactor.LoginInteractor;
import com.crater.juanfran.nicemeet.utils.ErrorsClass;

public class LoginPresenter implements LoginContract.presenter,LoginInteractor.LoginInteractorListener {

    public LoginContract.view view;
    public LoginContract.interactor interactor;
    public LoginPresenter(LoginContract.view view) {
        this.view=view;
        interactor=new LoginInteractor(this);
    }

    @Override
    public void onSignIn(String email, String password) {
        interactor.SignIn(email,password);
    }

    @Override
    public void onError(int error) {

        view.onError(ErrorsClass.onError(error,(Context) view));

    }

    @Override
    public void onErrorFirebase(String error) {
        view.onError(error);
    }

    @Override
    public void onAccess() {
        view.goMain();
    }

    @Override
    public void onStartProgress() {
        view.onStartProgress();
    }
}

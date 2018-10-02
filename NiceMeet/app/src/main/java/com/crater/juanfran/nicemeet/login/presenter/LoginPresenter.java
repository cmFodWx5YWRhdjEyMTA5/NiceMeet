package com.crater.juanfran.nicemeet.login.presenter;

import com.crater.juanfran.nicemeet.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.login.interactor.LoginInteractor;

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
    public void onError(String mensaje) {
        view.onError(mensaje);
    }

    @Override
    public void onAccess() {
        view.goMain();
    }
}

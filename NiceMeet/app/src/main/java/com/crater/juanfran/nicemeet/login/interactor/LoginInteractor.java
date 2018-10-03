package com.crater.juanfran.nicemeet.login.interactor;

import com.crater.juanfran.nicemeet.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.login.contract.LoginContract;

public class LoginInteractor implements LoginContract.interactor, FirebaseAuthClass.FbSignInListener {
    private final LoginInteractorListener listener;

    public LoginInteractor(LoginInteractorListener listener) {
        this.listener=listener;
    }

    @Override
    public void SignIn(String email, String password) {
        FirebaseAuthClass.loginWithEmail(email,password,this);
    }

    @Override
    public void onError() {
        listener.onError("TODO");
    }


    @Override
    public void onSignIn() {
        listener.onAccess();
    }

    public interface LoginInteractorListener
    {
        void onError(String mensaje);
        void onAccess();
    }
}

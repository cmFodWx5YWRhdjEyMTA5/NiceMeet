package com.crater.juanfran.nicemeet.login.interactor;

import com.crater.juanfran.nicemeet.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.login.contract.LoginContract;

public class LoginInteractor implements LoginContract.interactor {
    private final LoginInteractorListener listener;

    public LoginInteractor(LoginInteractorListener listener) {
        this.listener=listener;
    }

    @Override
    public void SignIn(String email, String password) {
        FirebaseAuthClass.loginWithEmail(email,password);
    }
    public interface LoginInteractorListener
    {
        void onError(String mensaje);
        void onAccess();
    }
}

package com.crater.juanfran.nicemeet.ui.login.contract;

public interface LoginContract {
    interface view
    {
        void goRegister(String email);
        void goMain();
        void onError(String error);
        void goForget(String email);
    }
    interface presenter
    {
        void onSignIn(String email, String password);
    }
    interface interactor
    {
        void SignIn(String email,String password);
    }
}

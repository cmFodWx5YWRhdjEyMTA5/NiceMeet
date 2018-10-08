package com.crater.juanfran.nicemeet.ui.Register.Contrats;

public interface RegisterContract {

    interface View {
        void onSuccess();
        void onPasswordEmptyError();
        void onEmailEmptyError();
        void onPasswordError();
        void onEmailError();
        void onPasswordDifferent();
        void onFirebaseError();
    }

    interface Presenter {
        void validateCredentials(String password,String passwordAgain, String email);
    }

    interface Interactor
    {
        void signIn( String password,String passwordAgain, String email);
    }
}
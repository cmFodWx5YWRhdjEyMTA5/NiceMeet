package com.crater.juanfran.nicemeet.ui.Register.Contrats;

import java.util.ArrayList;

public interface RegisterContract {

    interface View {
        void onSuccess();
        void onPasswordEmptyError();
        void onEmailEmptyError();
        void onPasswordError();
        void onEmailError();
        void onPasswordDifferent();
        void onFirebaseError(Exception e);

        void setTags(String[] tags);

        void setNationLangs(String[] countries, String[] langs);
    }

    interface Presenter {
        void validateCredentials(String password,String passwordAgain, String email);

        void getTags();

        void getNationLangs();
    }

    interface Interactor
    {
        void signIn( String password,String passwordAgain, String email);

        void getTags();

        void getNationLangs();
    }
}
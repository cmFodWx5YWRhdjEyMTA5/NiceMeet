package com.crater.juanfran.nicemeet.ui.Register.Contrats;

import com.crater.juanfran.nicemeet.db.model.User;

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

    }

    interface Presenter {

        void getTags();

        void saveUser(User usuarioRegistrando);
    }

    interface Interactor
    {

        void getTags();

        void saveUser(User usuarioRegistrando);
    }
}
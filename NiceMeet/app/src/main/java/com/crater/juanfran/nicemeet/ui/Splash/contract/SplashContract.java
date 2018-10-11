package com.crater.juanfran.nicemeet.ui.Splash.contract;

public interface SplashContract {
    interface View{
        void goMain();
        void showError(String error);
    }
    interface Presenter{
        void obtainLikes(String uid);
    }
    interface Interactor{
        void obtainLikes(String uid);
    }
}

package com.crater.juanfran.nicemeet.ui.Splash.interactor;

import com.crater.juanfran.nicemeet.ui.Splash.contract.SplashContract;

public class SplashInteractor implements SplashContract.Interactor{
    SplashListener listener;
    public SplashInteractor(SplashListener listener) {
        this.listener=listener;
    }

    @Override
    public void obtainLikes(String uid) {
        //Obtiene los likes y los guarda en local.

        listener.goMain();
    }
    public interface SplashListener
    {
        void goMain();
        void showError(String error);
    }
}

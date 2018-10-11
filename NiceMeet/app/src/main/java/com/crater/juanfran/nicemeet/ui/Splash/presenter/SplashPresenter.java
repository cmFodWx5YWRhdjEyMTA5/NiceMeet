package com.crater.juanfran.nicemeet.ui.Splash.presenter;

import com.crater.juanfran.nicemeet.ui.Splash.interactor.SplashInteractor;
import com.crater.juanfran.nicemeet.ui.Splash.contract.SplashContract;

public class SplashPresenter implements SplashContract.Presenter, SplashInteractor.SplashListener {
    SplashContract.View view;
    SplashContract.Interactor interactor;
    public SplashPresenter(SplashContract.View view) {
        this.view=view;
        this.interactor = new SplashInteractor(this);
    }

    @Override
    public void obtainLikes(String uid) {
    interactor.obtainLikes(uid);
    }

    @Override
    public void goMain() {
        view.goMain();
    }

    @Override
    public void showError(String error) {
        view.showError(error);
    }
}

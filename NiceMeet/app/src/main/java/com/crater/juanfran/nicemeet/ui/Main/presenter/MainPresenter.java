package com.crater.juanfran.nicemeet.ui.Main.presenter;

import com.crater.juanfran.nicemeet.ui.Main.contract.MainContract;
import com.crater.juanfran.nicemeet.ui.Main.interactor.MainInteractor;

public class MainPresenter implements MainContract.presenter, MainInteractor.MainInteractorListener {
    MainContract.view view;
    MainContract.interactor interactor;
    public MainPresenter(MainContract.view view) {
        this.view=view;
        this.interactor=new MainInteractor(this);
    }

    @Override
    public void OnLike(String uid) {
        interactor.OnLike(uid);
    }

    @Override
    public void onDislike(String uid) {
        interactor.onDislike(uid);
    }
}

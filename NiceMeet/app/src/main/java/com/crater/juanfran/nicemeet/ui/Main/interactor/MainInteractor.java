package com.crater.juanfran.nicemeet.ui.Main.interactor;

import com.crater.juanfran.nicemeet.ui.Main.contract.MainContract;

public class MainInteractor implements MainContract.interactor {
    MainInteractorListener listener;
    public MainInteractor(MainInteractorListener listener) {
        this.listener=listener;
    }

    @Override
    public void OnLike(String uid) {
        //Llamada a la api, sera asyncrono(?)
    }

    public interface MainInteractorListener
    {

    }
}

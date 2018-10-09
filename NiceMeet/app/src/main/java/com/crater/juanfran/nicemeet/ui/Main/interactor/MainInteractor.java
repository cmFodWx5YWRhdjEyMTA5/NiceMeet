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
        //A las 72 horas, la tabla de likes se borra
    }

    @Override
    public void onDislike(String uid) {
        //Llamada a la api, asyncrono.
        //A las 48 horas, la tabla de dislikes se borra
    }

    public interface MainInteractorListener
    {

    }
}

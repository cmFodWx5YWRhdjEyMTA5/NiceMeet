package com.crater.juanfran.nicemeet.ui.Main.contract;

public interface MainContract {
    interface view
    {
    }
    interface presenter
    {
      void OnLike(String uid);
    }
    interface interactor
    {
       void OnLike(String uid);
    }
}

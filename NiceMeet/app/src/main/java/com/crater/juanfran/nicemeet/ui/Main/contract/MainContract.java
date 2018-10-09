package com.crater.juanfran.nicemeet.ui.Main.contract;

public interface MainContract {
    interface view
    {
    }
    interface presenter
    {
      void OnLike(String uid);

        void onDislike(String uid);
    }
    interface interactor
    {
       void OnLike(String uid);

        void onDislike(String uid);
    }
}

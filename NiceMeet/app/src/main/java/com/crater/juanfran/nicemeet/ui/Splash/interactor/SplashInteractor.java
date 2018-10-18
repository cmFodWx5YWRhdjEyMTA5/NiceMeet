package com.crater.juanfran.nicemeet.ui.Splash.interactor;

import com.crater.juanfran.nicemeet.db.Repository.LikesRepository;
import com.crater.juanfran.nicemeet.db.model.Likes;
import com.crater.juanfran.nicemeet.ui.Splash.contract.SplashContract;
import com.crater.juanfran.nicemeet.utils.api.ApiAdapter;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashInteractor implements SplashContract.Interactor{
    SplashListener listener;
    public SplashInteractor(SplashListener listener) {
        this.listener=listener;
    }

    @Override
    public void obtainLikes(String uid) {
        Call<ArrayList<Likes>> call = ApiAdapter.getInstance().getLikes(uid);
        call.enqueue(new Callback<ArrayList<Likes>>() {
            @Override
            public void onResponse(Call<ArrayList<Likes>> call, Response<ArrayList<Likes>> response) {
                if (response.isSuccessful()) {
                    LikesRepository.getInstance().deleteOldLikes();
                    LikesRepository.getInstance().saveLikes(response.body());

                    listener.goMain();
                } else {
                    StringBuilder message = new StringBuilder();
                    message.append("Download error: " + response.code());
                    if (response.body() != null)
                        message.append("\n" + response.body());
                    if (response.errorBody() != null)
                        try {
                            message.append("\n" + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    listener.showError(message.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Likes>> call, Throwable t) {
                if (t != null)
                    listener.showError("Failure in the communication\n" + t.getMessage());
            }
        });

        listener.goMain();
    }
    public interface SplashListener
    {
        void goMain();
        void showError(String error);
    }
}

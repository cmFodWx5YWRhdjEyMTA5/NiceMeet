package com.crater.juanfran.nicemeet.ui.Register.View.fragments;

import android.support.v4.app.Fragment;

import com.crater.juanfran.nicemeet.db.model.User;

public class SecondRegisterFragment extends Fragment {
    private User dataFromUser;

    public boolean getData() {
        return false;
    }

    public void setDataFromUser(User dataFromUser) {
        this.dataFromUser = dataFromUser;
    }
}

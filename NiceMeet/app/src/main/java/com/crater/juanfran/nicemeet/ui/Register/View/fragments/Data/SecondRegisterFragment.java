package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Data;

import android.support.v4.app.Fragment;

import com.crater.juanfran.nicemeet.db.model.User;

public class SecondRegisterFragment extends Fragment {

    public interface OnDataRegisterListener {
        void setData(String email,String gender,long date);
    }

}

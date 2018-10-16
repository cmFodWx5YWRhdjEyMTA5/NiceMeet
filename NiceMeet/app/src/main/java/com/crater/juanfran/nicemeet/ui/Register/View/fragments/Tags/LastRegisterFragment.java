package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Tags;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.crater.juanfran.nicemeet.db.model.User;


public class LastRegisterFragment extends Fragment {
    public static Fragment newInstance(User usuarioRegistrando) {
        LastRegisterFragment fragment = new LastRegisterFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public interface OnTagsRegisterListener {
        void setTags(String[] tags);
    }
}

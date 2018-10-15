package com.crater.juanfran.nicemeet.ui.Register.View.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ReadyRegisterFragment extends Fragment {
    public static Fragment newInstance() {
        ReadyRegisterFragment fragment = new ReadyRegisterFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
}

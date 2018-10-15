package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Tags;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class LastRegisterFragment extends Fragment {
    public static Fragment newInstance() {
        LastRegisterFragment fragment = new LastRegisterFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public interface OnTagsRegisterListener {
        void setTags(String[] tags);
    }
}

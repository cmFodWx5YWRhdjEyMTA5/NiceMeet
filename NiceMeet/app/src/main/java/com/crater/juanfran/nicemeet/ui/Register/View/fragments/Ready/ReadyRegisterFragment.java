package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Ready;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

public class ReadyRegisterFragment extends Fragment {
    User usuarioRegistrando;
    OnFinishRegisterListener mListener;

    public ReadyRegisterFragment()
    {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_fin, container, false);
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFinishRegisterListener) {
            mListener = (OnFinishRegisterListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onPause(){
        super.onPause();
        mListener.goMain();
    }
    public static Fragment newInstance() {
        ReadyRegisterFragment fragment = new ReadyRegisterFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    public interface OnFinishRegisterListener {
        void goMain();
    }
}

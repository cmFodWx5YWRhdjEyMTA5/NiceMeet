package com.crater.juanfran.nicemeet.ui.Register.View.fragments.NationLang;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

import java.util.ArrayList;

public class NationLangRegisterFragment extends Fragment {
    private OnNatioLangRegisterListener mListener;

    public NationLangRegisterFragment()
    {

    }

    public static Fragment newInstance(User usuarioRegistrand) {
        NationLangRegisterFragment fragment = new NationLangRegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_nala, container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNatioLangRegisterListener) {
            mListener = (OnNatioLangRegisterListener) context;
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
    public void onDestroy() {
      //mListener.saveNL();
        super.onDestroy();

    }

    public interface OnNatioLangRegisterListener {
        void saveNL(ArrayList<String> langs, String nati);
    }
}

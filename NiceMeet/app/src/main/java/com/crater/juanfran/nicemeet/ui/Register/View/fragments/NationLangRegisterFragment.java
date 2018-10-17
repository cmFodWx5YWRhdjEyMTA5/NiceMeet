package com.crater.juanfran.nicemeet.ui.Register.View.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

import java.util.ArrayList;

public class NationLangRegisterFragment extends Fragment {
    private OnNatioLangRegisterListener mListener;
    private String[] langs;
    private ArrayList<String> selectedLangs;
    private String[] natios;
    private String selectedNation;

    public NationLangRegisterFragment()
    {

    }

    public static Fragment newInstance(User usuarioRegistrando,String[] lang, String[] nati) {
        NationLangRegisterFragment fragment = new NationLangRegisterFragment();
        Bundle args = new Bundle();
        args.putStringArray("lang",lang);
        args.putStringArray("nati",nati);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        langs=getArguments().getStringArray("lang");
        natios=getArguments().getStringArray("nati");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_tags, container, false);

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
        mListener.saveNL(selectedLangs,selectedNation);
        super.onDestroy();

    }

    public interface OnNatioLangRegisterListener {
        void saveNL(ArrayList<String> langs, String nati);
    }
}

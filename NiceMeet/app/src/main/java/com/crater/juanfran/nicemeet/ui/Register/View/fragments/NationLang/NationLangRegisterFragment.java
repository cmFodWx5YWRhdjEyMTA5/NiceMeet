package com.crater.juanfran.nicemeet.ui.Register.View.fragments.NationLang;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Data.SecondRegisterFragment;
import com.mukesh.countrypicker.Country;

import java.util.ArrayList;

public class NationLangRegisterFragment extends Fragment {
    private OnNatioLangRegisterListener mListener;
    User usuarioRegistrando;
    EditText edtNation;
    TextView textContinua;

    public NationLangRegisterFragment()
    {

    }

    public static Fragment newInstance(User usuarioRegistrando) {
        NationLangRegisterFragment fragment = new NationLangRegisterFragment();
        Bundle args = new Bundle();
        args.putParcelable("user",usuarioRegistrando);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usuarioRegistrando= getArguments().getParcelable("user");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_nala, container, false);
        edtNation=v.findViewById(R.id.edtNation);
        textContinua=v.findViewById(R.id.txtContinua);
        textContinua.setText(getResources().getString(R.string.almostthere)+" "+usuarioRegistrando.getName());
        edtNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openDialogNL();
            }
        });
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
    public void onPause() {
        super.onPause();
        mListener.saveNL(null,usuarioRegistrando.getNation());
    }

    public void saveCountry(Country country) {
        usuarioRegistrando.setNation(country.getName());
        edtNation.setText(country.getName());
    }

    public interface OnNatioLangRegisterListener {
        void saveNL(ArrayList<String> langs, String nati);
        void openDialogNL();
    }
}

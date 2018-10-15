package com.crater.juanfran.nicemeet.ui.Register.View.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;

public class RegisterNameFragment extends Fragment {

    private OnNameRegisterListener mListener;
    EditText edtName;
    public RegisterNameFragment() {
    }

    public static RegisterNameFragment newInstance() {
        RegisterNameFragment fragment = new RegisterNameFragment();
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
        View v = inflater.inflate(R.layout.fragment_register_name, container, false);
        edtName =  v.findViewById(R.id.edT_User2);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNameRegisterListener) {
            mListener = (OnNameRegisterListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener.setName(edtName.getText().toString());
        mListener = null;
    }

    public boolean getName() {
        return !edtName.getText().toString().isEmpty();
    }

    public void setName(String name) {
       edtName.setText(name);
    }

    public interface OnNameRegisterListener {
        void setName(String name);
    }
}

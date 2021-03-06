package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Name;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.crater.juanfran.nicemeet.R;

public class RegisterNameFragment extends Fragment {

    private OnNameRegisterListener mListener;
    EditText edtName;
    String name="";
    public RegisterNameFragment() {
    }

    public static RegisterNameFragment newInstance(String name) {
        RegisterNameFragment fragment = new RegisterNameFragment();
        Bundle args = new Bundle();
        if(name!=null&&!name.isEmpty())
        {
            args.putString("name",name);
        }
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().getString("name") != null) {
            name= getArguments().getString("name");
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_name, container, false);
        edtName =  v.findViewById(R.id.edT_User2);
        edtName.setText(name);
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
        mListener = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        mListener.setName(edtName.getText().toString());
    }

    public boolean nameCorrect() {
        if(edtName.getText().toString().trim().length() != 0) {
            return true;
        }else {

            mListener.showEmptyName();
            return false;
        }

    }

    public interface OnNameRegisterListener {
        void setName(String name);

        void showEmptyName();
    }

}

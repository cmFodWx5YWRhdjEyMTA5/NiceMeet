package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Data;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

public class SecondRegisterFragment extends Fragment {
    private OnDataRegisterListener mListener;
    TextView textView;
    Spinner spinner;
    EditText edtMail,edtDate,edtPassword;
    long date;

    public static SecondRegisterFragment newInstance(User usuarioRegistrando) {
        SecondRegisterFragment fragment = new SecondRegisterFragment();
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
        View v = inflater.inflate(R.layout.fragment_register_data, container, false);
        textView=v.findViewById(R.id.textView);
        edtMail=v.findViewById(R.id.edT_Mail);
        edtDate=v.findViewById(R.id.edt_Date);
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openDialog();
            }
        });
         spinner = v.findViewById(R.id.spnGender);
        String[] gend = getResources().getStringArray(R.array.genderspn);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, gend);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        edtPassword=v.findViewById(R.id.edT_Passw);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDataRegisterListener) {
            mListener = (OnDataRegisterListener) context;
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
        mListener.setData(edtMail.getText().toString(),spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString(),date,edtPassword.getText().toString());
        super.onDestroy();

    }

    public void setDate(long date) {
        this.date = date;
    }

    public interface OnDataRegisterListener {
        void setData(String email,String gender,long date,String password);

        void openDialog();
    }

}

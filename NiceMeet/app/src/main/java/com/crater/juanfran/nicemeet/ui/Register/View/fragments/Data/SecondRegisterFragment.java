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

import java.util.Calendar;

public class SecondRegisterFragment extends Fragment {
    private OnDataRegisterListener mListener;
    TextView textView;
    Spinner spinner;
    EditText edtMail,edtDate,edtPassword;
    long date;
    private User user;

    public static SecondRegisterFragment newInstance(User usuarioRegistrando) {
        SecondRegisterFragment fragment = new SecondRegisterFragment();
        Bundle args = new Bundle();
        args.putParcelable("user",usuarioRegistrando);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       user= getArguments().getParcelable("user");
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_data, container, false);
        textView=v.findViewById(R.id.textView);
        textView.setText(getResources().getString(R.string.welcome)+" "+user.getName()+", \n"+getResources().getString(R.string.moreinfo));
        edtMail=v.findViewById(R.id.edT_Mail);
        edtMail.setText(user.getEmail());
        edtDate=v.findViewById(R.id.edt_Date);
        edtDate.setText(user.getDate());
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
         for(int i=0;spinner.getAdapter().getCount()>i;i++)
         {
             if(spinner.getItemAtPosition(i).toString().equals(user.getGender()))
             {
                 spinner.setSelection(i);
             }
         }
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
        Calendar data=Calendar.getInstance();
        data.setTimeInMillis(date);
        edtDate.setText(data.get(Calendar.DAY_OF_MONTH)+"/"+data.get(Calendar.MONTH)+"/"+data.get(Calendar.YEAR));
    }

    public interface OnDataRegisterListener {
        void setData(String email,String gender,long date,String password);

        void openDialog();
    }

}

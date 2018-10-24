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
import com.crater.juanfran.nicemeet.utils.ErrorsClass;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Calendar;

public class SecondRegisterFragment extends Fragment {
    private OnDataRegisterListener mListener;
    TextView textView;
    Spinner spinner;
    EditText edtMail,edtDate,edtPassword;
    long date;
    private User user;
    private int edadUsuario=0;

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
        setDate(user.getDate());

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openDialog();
            }
        });
         spinner = v.findViewById(R.id.spnGender);
        String[] gend = getResources().getStringArray(R.array.genderspn);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, gend);
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
    public void onPause() {
        super.onPause();
        mListener.setData(edtMail.getText().toString(),spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString(),date,edtPassword.getText().toString());
    }

    public void setDate(long date) {
        this.date = date;
        Calendar data=Calendar.getInstance();
        data.setTimeInMillis(date);
        edtDate.setText(data.get(Calendar.DAY_OF_MONTH)+"/"+data.get(Calendar.MONTH)+"/"+data.get(Calendar.YEAR));
        edadUsuario=getAge(data.get(Calendar.YEAR),data.get(Calendar.MONTH),data.get(Calendar.DAY_OF_MONTH));
    }
    private int getAge(int year, int month, int day){
        LocalDate birthdate = new LocalDate(year, month, day);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        return age.getYears();
    }
    public boolean dataCorrect() {
        if(edtMail.getText().toString().trim().length() == 0)
        {
            mListener.emptyMail();
            return false;
        }
        if(!ValidatorsClass.validateEmail(edtMail.getText().toString().trim()))
        {
            mListener.errorEmail();
            return false;
        }
        if(edadUsuario<16)
        {
            mListener.errorMenor();
            return false;
        }
       switch (ValidatorsClass.validatePassword(edtPassword.getText().toString().trim())) {
           case ErrorsClass.PASSWORDISEMPTY:
               mListener.emptyPass();
               return false;
           case ErrorsClass.PASSWORDTOOSHORT:
               mListener.shortPass();
               return false;
           case ErrorsClass.PASSWORDNOTCONTAINNUMBER:
               mListener.numberPassword();
               return false;
       }
       return true;
    }

    public interface OnDataRegisterListener {
        void setData(String email,String gender,long date,String password);

        void errorEmail();

        void errorDate();

        void errorMenor();

        void errorPassword();

        void openDialog();

        void emptyMail();

        void emptyPass();

        void shortPass();

        void numberPassword();
    }

}

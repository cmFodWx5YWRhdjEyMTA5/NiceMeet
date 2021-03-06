package com.crater.juanfran.nicemeet.ui.Register.View;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.ui.Register.Presenter.RegisterPresenter;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.NationLang.NationLangRegisterFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Tags.LastRegisterFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Ready.ReadyRegisterFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Name.RegisterNameFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Data.SecondRegisterFragment;
import com.crater.juanfran.nicemeet.utils.DialogsUtils;
import com.crater.juanfran.nicemeet.utils.ThisApplication;
import com.crater.juanfran.nicemeet.utils.prefs.AppPreferencesHelper;
import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.OnCountryPickerListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity implements
        RegisterContract.View,
        RegisterNameFragment.OnNameRegisterListener,
        SecondRegisterFragment.OnDataRegisterListener,
        LastRegisterFragment.OnTagsRegisterListener,
NationLangRegisterFragment.OnNatioLangRegisterListener,
        ReadyRegisterFragment.OnFinishRegisterListener{

    RegisterContract.Presenter presenter;
    Button btnNext,btnBack;
    User usuarioRegistrando;
    int position;

    Fragment fragment;
    private AppPreferencesHelper sharedPreferences;
    private String[] tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferences=((ThisApplication) getApplicationContext()).getAppPreferencesHelper();
        btnNext=findViewById(R.id.next);
        btnBack=findViewById(R.id.back);
        presenter= new RegisterPresenter(this);
        getSupportActionBar().setTitle(R.string.registro);
        fragment= RegisterNameFragment.newInstance(null);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.registry_frame, fragment);
        transaction.commit();
        position=0;
        usuarioRegistrando=new User();
        presenter.getTags();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
        } });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               back();
        }});

    }

    private boolean loadFragment(Fragment fragment,boolean next) {
        if (fragment != null) {
            if(next) {
                position++;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                        .replace(R.id.registry_frame, fragment)
                        .commit();
                return true;
            }else {
                position--;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.registry_frame, fragment)
                        .commit();
                return true;
            }
        }
        return false;
    }
    @Override
    public void onSuccess() {
        sharedPreferences.setNewUser(false);
        finish();
    }

    @Override
    public void onPasswordEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.passwordEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.emailEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(this,getResources().getString(R.string.passwordError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailError() {
        Toast.makeText(this,getResources().getString(R.string.error_invalid_email),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordDifferent() {
        Toast.makeText(this,getResources().getString(R.string.passwordDifferent),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFirebaseError(Exception e) {

        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTags(String[] tags) {
        this.tags=tags;
    }

    @Override
    public void setName(String name) {
        sharedPreferences.setCurrentUserName(name);
        usuarioRegistrando.setName(name);
    }

    @Override
    public void showEmptyName() {

        Toast.makeText(this,getResources().getString(R.string.nameEmpty),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(String email, String gender, long date,String password) {
        usuarioRegistrando.setEmail(email);
        usuarioRegistrando.setGender(gender);
        usuarioRegistrando.setDate(date);
        usuarioRegistrando.setPassword(password);
    }

    @Override
    public void errorEmail() {
        Toast.makeText(this,getResources().getString(R.string.error_invalid_email),Toast.LENGTH_SHORT).show();
    }


    @Override
    public void errorMenor() {
        Toast.makeText(this,getResources().getString(R.string.olderthan16),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void openDialog() {

        final Calendar hoy=Calendar.getInstance();
        final int[] year = {hoy.get(Calendar.YEAR)};
        final int[] month = {hoy.get(Calendar.MONTH)};
        final int[] day = {hoy.get(Calendar.DAY_OF_MONTH)};

        final DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                 year[0] =arg1;
                 month[0] =arg2;
                 day[0] =arg3;
                hoy.set(year[0], month[0], day[0]);
                ((SecondRegisterFragment)fragment).setDate(hoy.getTimeInMillis());
            }};

        DatePickerDialog pickerDialog= new DatePickerDialog(this, myDateListener, year[0], month[0], day[0]);
        pickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        pickerDialog.show();

    }

    @Override
    public void emptyMail() {
        Toast.makeText(this,getResources().getString(R.string.emailEmptyError),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void emptyPass() {
        Toast.makeText(this,getResources().getString(R.string.passwordEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void shortPass() {
        Toast.makeText(this,getResources().getString(R.string.shortPassError),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void numberPassword() {
        Toast.makeText(this,getResources().getString(R.string.passwordNotNumber),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void saveTags(ArrayList<String> tags) {
        usuarioRegistrando.setTags(tags);
    }

    @Override
    public void openDialogTags() {
        DialogsUtils.onInfoDialog(this,getResources().getString(R.string.tagsExplain)).show();
    }

    @Override
    public void TooMuchTags() {
        Toast.makeText(this,getResources().getString(R.string.tooMuchTags),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notEnoughTags() {
        Toast.makeText(this,getResources().getString(R.string.tooLittleTags),Toast.LENGTH_SHORT).show();
    }

    public void next ()
    {
        if(position==0&&((RegisterNameFragment)fragment).nameCorrect()) {
            fragment = SecondRegisterFragment.newInstance(usuarioRegistrando);
            btnBack.setVisibility(View.VISIBLE);
            btnBack.setEnabled(true);
            loadFragment(fragment,true);
        }else
        if(position==1&&((SecondRegisterFragment)fragment).dataCorrect()) {
            fragment = NationLangRegisterFragment.newInstance(usuarioRegistrando);
            loadFragment(fragment, true);
        }else
        if(position==2&&((NationLangRegisterFragment)fragment).dataCorrect()) {
            fragment = LastRegisterFragment.newInstance(usuarioRegistrando, tags);
            loadFragment(fragment, true);
        }else
        if(position==3&&((LastRegisterFragment)fragment).dataCorrect())
        {
            fragment = ReadyRegisterFragment.newInstance();
            loadFragment(fragment,true);
            btnNext.setText(R.string.finish);
        }



    }
    public void back()
    {
        if(position!=0){
        if(position==1)
        {
            fragment=RegisterNameFragment.newInstance(usuarioRegistrando.getName());
            btnBack.setVisibility(View.INVISIBLE);
            btnBack.setEnabled(false);
            loadFragment(fragment,false);
        }else
        if(position==2) {
            fragment = SecondRegisterFragment.newInstance(usuarioRegistrando);
            loadFragment(fragment,false);
        }else
        if(position==3) {
            fragment = NationLangRegisterFragment.newInstance(usuarioRegistrando);
            loadFragment(fragment,false);
        }else
        if(position==4) {
            fragment = LastRegisterFragment.newInstance(usuarioRegistrando, tags);
            loadFragment(fragment,false);
            btnNext.setText(R.string.siguiente);
        }


    }else{
    finish();
    }
    }


    @Override
    public void onBackPressed() {
        back();
    }

    @Override
    public void saveNL(ArrayList<String> langs, String nati) {
        usuarioRegistrando.setLanguages(langs);
        usuarioRegistrando.setNation(nati);
    }

    @Override
    public void openDialogNL() {
        CountryPicker.Builder builder =
                new CountryPicker.Builder().with(this)
                        .listener(new OnCountryPickerListener() {
                            @Override
                            public void onSelectCountry(Country country) {
                                ((NationLangRegisterFragment)fragment).saveCountry(country);
                            }
                        });
        CountryPicker picker = builder.build();

        picker.showDialog(RegisterActivity.this);
    }

    @Override
    public void goMain() {
        presenter.saveUser(usuarioRegistrando);
    }
}

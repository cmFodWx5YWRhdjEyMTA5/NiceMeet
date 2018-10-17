package com.crater.juanfran.nicemeet.ui.Register.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
import com.crater.juanfran.nicemeet.utils.ThisApplication;
import com.crater.juanfran.nicemeet.utils.prefs.AppPreferencesHelper;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements
        RegisterContract.View,
        RegisterNameFragment.OnNameRegisterListener,
        SecondRegisterFragment.OnDataRegisterListener,
        LastRegisterFragment.OnTagsRegisterListener,
NationLangRegisterFragment.OnNatioLangRegisterListener{

    RegisterContract.Presenter presenter;
    Button btnNext,btnBack;
    User usuarioRegistrando;
    int position;

    Fragment fragment;
    private AppPreferencesHelper sharedPreferences;
    private String[] tags;
    private String[] langs;
    private String[] nations;

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
        presenter.getNationLangs();
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
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                        .replace(R.id.registry_frame, fragment)
                        .commit();
                return true;
            }else {
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
    public void setNationLangs(ArrayList<String> countries, ArrayList<String> langs) {
        this.nations= (String[]) countries.toArray();
        this.langs= (String[]) langs.toArray();
    }

    @Override
    public void setName(String name) {
        sharedPreferences.setCurrentUserName(name);
        usuarioRegistrando.setName(name);
    }


    @Override
    public void setData(String email, String gender, long date,String password) {
        usuarioRegistrando.setEmail(email);
        usuarioRegistrando.setGender(gender);
        usuarioRegistrando.setDate(date);
        usuarioRegistrando.setPassword(password);
    }

    @Override
    public void openDialog() {
        long date=0;
        ((SecondRegisterFragment)fragment).setDate(date);
    }

    @Override
    public void saveTags(ArrayList<String> tags) {
        usuarioRegistrando.setTags(tags);
    }


    public void next ()
    {
        position++;
        if(position==1) {
            fragment = SecondRegisterFragment.newInstance(usuarioRegistrando);
            btnBack.setVisibility(View.VISIBLE);
            btnBack.setEnabled(true);
        }
        if(position==2)
            fragment = NationLangRegisterFragment.newInstance(usuarioRegistrando,langs,nations);
        if(position==3)
            fragment = LastRegisterFragment.newInstance(usuarioRegistrando,tags);
        if(position==4)
            fragment = ReadyRegisterFragment.newInstance();

        loadFragment(fragment,true);
    }
    public void back()
    {if(position!=0){
        position--;
        if(position==0)
        {
            fragment=RegisterNameFragment.newInstance(usuarioRegistrando.getName());
            btnBack.setVisibility(View.INVISIBLE);
            btnBack.setEnabled(false);
        }
        if(position==1)
            fragment = SecondRegisterFragment.newInstance(usuarioRegistrando);
        if(position==2)
            fragment = NationLangRegisterFragment.newInstance(usuarioRegistrando,langs,nations);
        if(position==3)
            fragment = LastRegisterFragment.newInstance(usuarioRegistrando,tags);

        loadFragment(fragment,false);
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
}

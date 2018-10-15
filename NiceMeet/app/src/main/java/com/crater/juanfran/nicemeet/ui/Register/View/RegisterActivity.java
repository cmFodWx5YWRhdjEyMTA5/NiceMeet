package com.crater.juanfran.nicemeet.ui.Register.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.ui.Register.Presenter.RegisterPresenter;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Tags.LastRegisterFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.ReadyRegisterFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Name.RegisterNameFragment;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.Data.SecondRegisterFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, RegisterNameFragment.OnNameRegisterListener,SecondRegisterFragment.OnDataRegisterListener,LastRegisterFragment.OnTagsRegisterListener {

    RegisterContract.Presenter presenter;
    private String TAG_FRAGMENTNAME="NAME";
    Button btnNext,btnBack;
    User usuarioRegistrando;

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnNext=findViewById(R.id.next);
        btnBack=findViewById(R.id.back);
        presenter= new RegisterPresenter(this);
        getSupportActionBar().setTitle(R.string.registro);
        fragment= new RegisterNameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.registry_frame, fragment, TAG_FRAGMENTNAME);
        transaction.addToBackStack(null);
        transaction.commit();
        usuarioRegistrando=new User();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        } });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayu, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
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
    public void setName(String name) {
        usuarioRegistrando.setName(name);
    }

    @Override
    public void setData(String email, String gender, long date) {
        usuarioRegistrando.setEmail(email);
        usuarioRegistrando.setGender(gender);
        usuarioRegistrando.setDate(date);
    }

    @Override
    public void setTags(String[] tags) {
        usuarioRegistrando.setTags(tags);
    }
}

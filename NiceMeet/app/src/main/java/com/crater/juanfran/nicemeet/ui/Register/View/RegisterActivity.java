package com.crater.juanfran.nicemeet.ui.Register.View;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.ui.Register.Presenter.RegisterPresenter;
import com.crater.juanfran.nicemeet.ui.Register.View.fragments.RegisterNameFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, RegisterNameFragment.OnNameRegisterListener {

    RegisterContract.Presenter presenter;
    private String TAG_FRAGMENTNAME="NAME";
    User usuarioRegistrando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter= new RegisterPresenter(this);
        getSupportActionBar().setTitle(R.string.registro);
        RegisterNameFragment fragment = new RegisterNameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.registry_frame, fragment, TAG_FRAGMENTNAME);
        transaction.addToBackStack(null);
        transaction.commit();
        usuarioRegistrando=new User();
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

    //Register Name
    @Override
    public void addName() {

    }

    @Override
    public void nextPace() {

    }
}

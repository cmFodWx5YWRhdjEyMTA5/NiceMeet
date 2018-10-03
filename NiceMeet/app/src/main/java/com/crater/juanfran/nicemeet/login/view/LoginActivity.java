package com.crater.juanfran.nicemeet.login.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.crater.juanfran.nicemeet.Main.MainActivity;
import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.Register.RegisterActivity;
import com.crater.juanfran.nicemeet.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

    @Override
    public void goRegister(String email) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        if(ValidatorsClass.validateEmail(email))
        {
            Bundle bundle = new Bundle();
            bundle.putString("email",email);
        }
        startActivity(intent);
    }

    @Override
    public void goMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(String error) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CookiesDialogCustom);
        dialogBuilder.setTitle(getResources().getString(R.string.errorHappen));
        dialogBuilder.setMessage(error);
    }
}


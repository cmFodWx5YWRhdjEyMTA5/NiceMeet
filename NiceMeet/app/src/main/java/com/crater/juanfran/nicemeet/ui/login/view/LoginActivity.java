package com.crater.juanfran.nicemeet.ui.login.view;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.ui.Main.view.MainActivity;
import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.ui.Register.View.RegisterActivity;
import com.crater.juanfran.nicemeet.ui.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.ui.login.presenter.LoginPresenter;
import com.crater.juanfran.nicemeet.utils.DialogsUtils;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;
    private Button btn_SignIn,btnGoogle,btnFacebook,btnTwitter;
    private EditText edtUser;
    private EditText edtpassword;
    private TextView txtVIfSignUp,txtVPasswordForget;
    private ProgressDialog progressDialog;
    private AlertDialog.Builder alertDig;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        presenter=new LoginPresenter(this);

        initUI();
    }

    private void initUI() {
        edtUser=findViewById(R.id.edT_User);
        edtpassword=findViewById(R.id.edT_Passw);
        txtVIfSignUp=findViewById(R.id.txtVIfSignUp);
        txtVPasswordForget=findViewById(R.id.txtVForgetPassword);
        btn_SignIn=findViewById(R.id.btn_SignIn);
        btnTwitter=findViewById(R.id.btn_TwitterLogin);
        btnGoogle=findViewById(R.id.btn_GoogleLogin);
        btnFacebook=findViewById(R.id.btn_FacebookLogin);
        txtVIfSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRegister(edtUser.getText().toString());
            }
        });
        txtVPasswordForget.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goForget(edtUser.getText().toString());
            }
        });

        btn_SignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.onSignIn(edtUser.getText().toString(),edtpassword.getText().toString());
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void goRegister(String email) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        if(ValidatorsClass.validateEmail(email))
        {
            Bundle bundle = new Bundle();
            bundle.putString("email",email);
            intent.putExtra("bnd",bundle);
        }
        startActivity(intent);
    }

    @Override
    public void goMain() {
        progressDialog.cancel();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(String error) {
        alertDig= DialogsUtils.onErrorDialog(this,error);
        alertDig.show();
        progressDialog.cancel();
    }

    @Override
    public void goForget(String email) {
        Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
        if(ValidatorsClass.validateEmail(email))
        {
            Bundle bundle = new Bundle();
            bundle.putString("email",email);
            intent.putExtra("bnd",bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onStartProgress() {
    progressDialog= DialogsUtils.showProgress(this);
    progressDialog.show();
    }
}


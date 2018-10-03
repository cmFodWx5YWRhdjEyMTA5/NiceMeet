package com.crater.juanfran.nicemeet.login.view;

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

import com.crater.juanfran.nicemeet.Main.MainActivity;
import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.Register.RegisterActivity;
import com.crater.juanfran.nicemeet.ThisApplication;
import com.crater.juanfran.nicemeet.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.login.presenter.LoginPresenter;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;
    private Button btn_SignIn,btnGoogle,btnFacebook,btnTwitter;
    private EditText edtUser;
    private EditText edtpassword;
    private TextView txtVIfSignUp,txtVPasswordForget;
    private CheckBox chkB_Remember;
    private View screen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        presenter=new LoginPresenter(this);

        initUI();
    }

    private void initUI() {
        screen=findViewById(R.id.screen);
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
        View.OnClickListener clickTemporal = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(screen,"Aun no funciona esto, hay que programarlo",Snackbar.LENGTH_SHORT).show();
            }
        };
        btnGoogle.setOnClickListener(clickTemporal);
        btnFacebook.setOnClickListener(clickTemporal);
        btnTwitter.setOnClickListener(clickTemporal);

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
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(String error) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CookiesDialogCustom);
        dialogBuilder.setTitle(getResources().getString(R.string.errorHappen));
        dialogBuilder.setMessage(error);
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
}


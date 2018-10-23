package com.crater.juanfran.nicemeet.ui.login.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.ui.Main.view.MainActivity;
import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.ui.Register.View.RegisterActivity;
import com.crater.juanfran.nicemeet.ui.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.ui.login.presenter.LoginPresenter;
import com.crater.juanfran.nicemeet.utils.DialogsUtils;
import com.crater.juanfran.nicemeet.utils.ThisApplication;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;
import com.crater.juanfran.nicemeet.utils.prefs.AppPreferencesHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;

    private AppPreferencesHelper sharedPreferences;
    private Button btn_SignIn;
    private EditText edtUser;
    private EditText edtpassword;
    private TextView txtVIfSignUp,txtVPasswordForget;
    private CircularProgressBar progressDialog;
    private AlertDialog.Builder alertDig;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        sharedPreferences=((ThisApplication) getApplicationContext()).getAppPreferencesHelper();
        presenter=new LoginPresenter(this);

        initUI();
    }

    private void initUI() {
        progressDialog=findViewById(R.id.marker_progress);
        edtUser=findViewById(R.id.edT_User);
        edtpassword=findViewById(R.id.edT_Passw);
        txtVIfSignUp=findViewById(R.id.txtVIfSignUp);
        txtVPasswordForget=findViewById(R.id.txtVForgetPassword);
        btn_SignIn=findViewById(R.id.btn_SignIn);

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

    }

    @Override
    public void goRegister(String email) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void goMain() {
        progressDialog.setVisibility(View.INVISIBLE);
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        sharedPreferences.setCurrentUserName(currentFirebaseUser.getUid());
        if(currentFirebaseUser.isEmailVerified()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            alertDig= DialogsUtils.onErrorDialog(this,getResources().getString(R.string.emailvalidateyet));
            alertDig.show();
        }
    }

    @Override
    public void onError(String error) {
        progressDialog.setVisibility(View.INVISIBLE);
        alertDig= DialogsUtils.onErrorDialog(this,error);
        alertDig.show();
    }

    @Override
    public void goForget(String email) {
        Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
        Bundle bundle = new Bundle();
        if(ValidatorsClass.validateEmail(email))
        {
            bundle.putString("email",email);
        }
        intent.putExtra("bnd",bundle);
        startActivity(intent);
    }

    @Override
    public void onStartProgress() {
    progressDialog.setVisibility(View.VISIBLE);
    }
}


package com.crater.juanfran.nicemeet.Register.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.Register.Presenter.RegisterPresenter;
import com.crater.juanfran.nicemeet.ThisApplication;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    EditText edtPassword,edtPasswordAgain,edtEmail;
    Button btnSignIn;
    RegisterContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtPasswordAgain=findViewById(R.id.edtPasswordAgain);
        btnSignIn=findViewById(R.id.btnSignIn);
        presenter= new RegisterPresenter(this);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateCredentials(edtPassword.getText().toString(),edtPasswordAgain.getText().toString(),edtEmail.getText().toString());
            }
        });
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
    public void onFirebaseError() {

        Toast.makeText(this,getResources().getString(R.string.firebase_error),Toast.LENGTH_SHORT).show();
    }
}

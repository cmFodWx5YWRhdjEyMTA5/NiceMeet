package com.crater.juanfran.nicemeet.ui.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.utils.api.FirebaseAuthClass;

public class ForgetActivity extends AppCompatActivity implements FirebaseAuthClass.FbResetEmailListener {

    private EditText inputEmail;

    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forget);
        inputEmail = (EditText) findViewById(R.id.email);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuthClass.ResetEmail(inputEmail.getText().toString(),ForgetActivity.this);
            }
        });
    }

    @Override
    public void onSucces() {
        Toast.makeText(ForgetActivity.this, getResources().getString(R.string.resetComplet), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(ForgetActivity.this, R.string.failedReset, Toast.LENGTH_SHORT).show();
    }
}

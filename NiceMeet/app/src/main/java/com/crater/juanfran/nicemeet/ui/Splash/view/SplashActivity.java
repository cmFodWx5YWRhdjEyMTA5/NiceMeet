package com.crater.juanfran.nicemeet.ui.Splash.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.ui.Main.view.MainActivity;
import com.crater.juanfran.nicemeet.ui.Register.View.RegisterActivity;
import com.crater.juanfran.nicemeet.ui.Splash.presenter.SplashPresenter;
import com.crater.juanfran.nicemeet.ui.Splash.contract.SplashContract;
import com.crater.juanfran.nicemeet.ui.login.view.LoginActivity;
import com.crater.juanfran.nicemeet.utils.DialogsUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    SplashContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       mAuth=FirebaseAuth.getInstance();
       progressBar=findViewById(R.id.marker_progress);
       presenter= new SplashPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            progressBar.setVisibility(View.VISIBLE);
            presenter.obtainLikes(user.getUid());
        } else if (true) {
            //NO es la primera vez
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        } else {
            //Primera vez va a registro directo.
            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
        }
        finish();
    }

    private void updateUI() {
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
    }

    @Override
    public void goMain() {
        updateUI();
    }

    @Override
    public void showError(String error) {
        DialogsUtils.onErrorDialog(this,error);
    }
}

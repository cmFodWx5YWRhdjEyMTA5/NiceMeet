package com.crater.juanfran.nicemeet.ui.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.ui.Main.view.MainActivity;
import com.crater.juanfran.nicemeet.ui.login.view.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       mAuth=FirebaseAuth.getInstance();
       progressBar=findViewById(R.id.marker_progress);
    }

    @Override
    protected void onStart() {
        super.onStart();
     FirebaseUser user = mAuth.getCurrentUser();
     updateUI(user);
    }


    private void updateUI(FirebaseUser user) {
        if(user==null)
        {
          startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }else
        {
          startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    }
}

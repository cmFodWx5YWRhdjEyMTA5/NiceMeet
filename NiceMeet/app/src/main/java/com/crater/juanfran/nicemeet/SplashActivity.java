package com.crater.juanfran.nicemeet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // mAuth=FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
     //   FirebaseUser user = mAuth.getCurrentUser();
     //   updateUI(user);
    }

    private void updateUI(FirebaseUser user) {
        if(user==null)
        {
            //go to login/register
        }else
        {
            //go to main
        }
    }
}

package com.crater.juanfran.nicemeet.utils;

import android.app.Application;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

public class ThisApplication extends Application {
    private static FirebaseAuth mAuth;
   // private static AppPreferencesHelper appPreferencesHelper;
    private static ThisApplication mContext;
   // private static GoogleSignInClient mGoogleSignInClient;
   public ThisApplication(){
       mContext=this;
   }
    public static FirebaseAuth getFirebase() {
        return mAuth;
    }
    /*
    public static GoogleSignInClient getmGoogleSignInClient() {
        return mGoogleSignInClient;
    }*/
    @Override
    public void onCreate() {
        super.onCreate();
       // appPreferencesHelper= AppPreferencesHelper.getInstance();
        mAuth=FirebaseAuth.getInstance();
       /*
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    */
    }
/*
    public static AppPreferencesHelper getAppPreferencesHelper()
    {
        return appPreferencesHelper;
    }
    */

    public static Context getContext() {
        return mContext;
    }
}

package com.crater.juanfran.nicemeet.utils;

import android.app.Application;
import android.content.Context;

import com.crater.juanfran.nicemeet.utils.prefs.AppPreferencesHelper;
import com.google.firebase.auth.FirebaseAuth;

public class ThisApplication extends Application {
    private static FirebaseAuth mAuth;
   private static AppPreferencesHelper appPreferencesHelper;
    private static ThisApplication mContext;
   public ThisApplication(){
       mContext=this;
   }
    public static FirebaseAuth getFirebase() {
        return mAuth;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       appPreferencesHelper= AppPreferencesHelper.getInstance();
        mAuth=FirebaseAuth.getInstance();

    }

    public static AppPreferencesHelper getAppPreferencesHelper()
    {
        return appPreferencesHelper;
    }


    public static Context getContext() {
        return mContext;
    }
}

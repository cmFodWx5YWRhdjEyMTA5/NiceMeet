package com.crater.juanfran.nicemeet.utils.prefs;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.crater.juanfran.nicemeet.utils.ThisApplication;

public class AppPreferencesHelper implements PreferencesHelper.GeneralPreferencesHelper {
    private static final String TAG = "AppPreferencesHelper";

    public interface AppPreferencesListerner
    {
        void onSharedPrerenceChange();
    }


    public static final String PREF_NAME = "NiceMeetPref";

    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;



    private AppPreferencesHelper() {
        this.preferences = (ThisApplication.getContext()).getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        listener= new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            }
        };
    }

    public static AppPreferencesHelper getInstance()
    {
        if(instance==null)
        {
            instance=new AppPreferencesHelper();
        }
        return instance;
    }

    public String getCurrentUserName() {
        String name=preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME,name).apply();
    }
    public Boolean getNewUser() {
        Boolean name=preferences.getBoolean(PREF_KEY_NEW_USER,true);
        return name;
    }

    public void setNewUser(Boolean bool) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_NAME,bool).apply();
    }

}
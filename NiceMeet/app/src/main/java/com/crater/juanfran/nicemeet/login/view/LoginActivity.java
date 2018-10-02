package com.crater.juanfran.nicemeet.login.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.Main.MainActivity;
import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.Register.RegisterActivity;
import com.crater.juanfran.nicemeet.login.contract.LoginContract;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.view {


    @Override
    public void goRegister(String email) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        if(ValidatorsClass.validateEmail(email))
        {
            Bundle bundle = new Bundle();
            bundle.putString("email",email);
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
}


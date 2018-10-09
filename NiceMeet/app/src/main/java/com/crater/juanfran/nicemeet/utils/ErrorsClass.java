package com.crater.juanfran.nicemeet.utils;

import android.content.Context;

import com.crater.juanfran.nicemeet.R;

public class ErrorsClass {
    public static final int EMAILNOTVALID = 1;

    public static final int PASSWORDTOOSHORT =2;
    public static final int PASSWORDNOTCONTAINNUMBER =3;
    public static final int PASSWORDISEMPTY = 4;

    public static final int FIREBASEERROR=500;

    public static String onError(int errorCode,Context context)
    {

        switch (errorCode){
            case EMAILNOTVALID:
                return context.getResources().getString(R.string.emailNotValid).toString();
            case PASSWORDISEMPTY:
                return context.getResources().getString(R.string.passwordEmptyError).toString();
            case PASSWORDNOTCONTAINNUMBER:
                return context.getResources().getString(R.string.passwordNotNumber).toString();
            case PASSWORDTOOSHORT:
                return context.getResources().getString(R.string.passwordTooShort).toString();
            case FIREBASEERROR:
                return context.getResources().getString(R.string.emailNotValid).toString();
            default:
                return "Error";
        }
    }

}

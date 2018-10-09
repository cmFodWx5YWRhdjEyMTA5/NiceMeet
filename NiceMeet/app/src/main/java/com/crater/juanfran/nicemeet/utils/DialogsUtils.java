package com.crater.juanfran.nicemeet.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogsUtils
{
    public static ProgressDialog showProgress(Context context)
    {
        ProgressDialog dialog = ProgressDialog.show(context, "",
                "Loading. Please wait...", true);
        return dialog;
    }

}

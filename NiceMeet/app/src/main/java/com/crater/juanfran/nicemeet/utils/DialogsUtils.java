package com.crater.juanfran.nicemeet.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.crater.juanfran.nicemeet.R;

public class DialogsUtils
{
    public static ProgressDialog showProgress(Context context)
    {
        ProgressDialog dialog = ProgressDialog.show(context, "",
                "Loading. Please wait...", true);
        return dialog;
    }

    public static AlertDialog.Builder onErrorDialog(Context context,String error) {
       AlertDialog.Builder dialogBuilder= new AlertDialog.Builder(context, R.style.CookiesDialogCustom);
        dialogBuilder.setTitle(context.getResources().getString(R.string.errorHappen));
        dialogBuilder.setMessage(error);
        dialogBuilder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return dialogBuilder;
    }
}

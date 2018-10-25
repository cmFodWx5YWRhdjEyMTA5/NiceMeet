package com.crater.juanfran.nicemeet.utils;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.crater.juanfran.nicemeet.R;

public class DialogsUtils
{
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

    public static AlertDialog.Builder onInfoDialog(Context context, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context, R.style.CustomDialogTheme);
        dialog.setMessage(message);
        dialog.setCancelable(true);
        dialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return dialog;
    }
}

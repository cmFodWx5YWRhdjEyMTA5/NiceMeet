package com.crater.juanfran.nicemeet.utils;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;

public class CustomView extends FrameLayout {

    TextView btnTag;

    public CustomView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.custom_view, this);
        btnTag = (TextView) getRootView().findViewById(R.id.btnTag);
    }

    public void display(String text, boolean isSelected) {
        btnTag.setText(text);
        display(isSelected);
    }

    public void display(boolean isSelected) {
      btnTag.setBackground(isSelected? getResources().getDrawable(R.drawable.roundtag):null);
    }
}
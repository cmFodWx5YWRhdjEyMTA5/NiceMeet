package com.crater.juanfran.nicemeet.Main;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.crater.juanfran.nicemeet.R;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.action_people:
                         break;
                     case R.id.action_chats:
                         eliminateNotifications();
                         break;
                     case R.id.action_profile:
                         createFakeNotification();
                         break;
                     case R.id.action_settings:
                         break;
                 }
                 return true;
             }
         });
    }

    private void createFakeNotification() {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(1);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        View badge = LayoutInflater.from(this).inflate(R.layout.notification_badge, bottomNavigationMenuView, false);

        itemView.addView(badge);
    }
    private void eliminateNotifications() {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(1); BottomNavigationItemView itemView = (BottomNavigationItemView) v;
        itemView.removeViewAt(itemView.getChildCount()-1);

    }

}

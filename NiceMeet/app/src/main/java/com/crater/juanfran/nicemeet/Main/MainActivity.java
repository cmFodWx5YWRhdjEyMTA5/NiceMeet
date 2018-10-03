package com.crater.juanfran.nicemeet.Main;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.crater.juanfran.nicemeet.Main.Fragments.profile.ProfileFragment;
import com.crater.juanfran.nicemeet.Main.Fragments.swipe.SwipeFragment;
import com.crater.juanfran.nicemeet.R;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    boolean notifications =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.framelayu);
         bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                 switch (item.getItemId()) {
                     case R.id.action_people:
                         ft.replace(R.id.framelayu, new SwipeFragment());
                         ft.commit();
                         break;
                     case R.id.action_chats:
                         eliminateNotifications();
                        // ft.replace(R.id.framelayu, new ());
                        // ft.commit();
                         break;
                     case R.id.action_profile:
                         createFakeNotification();
                         ft.replace(R.id.framelayu, new ProfileFragment());
                         ft.commit();
                         break;
                     case R.id.action_settings:
                         //ft.replace(R.id.framelayu, new SwipeFragment());
                         //ft.commit();
                         break;
                 }
                 return true;
             }
         });
    }

    private void createFakeNotification() {
        if(!notifications) {
            notifications = true;
            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
            View v = bottomNavigationMenuView.getChildAt(1);
            BottomNavigationItemView itemView = (BottomNavigationItemView) v;

            View badge = LayoutInflater.from(this).inflate(R.layout.notification_badge, bottomNavigationMenuView, false);

            itemView.addView(badge);
        }
    }
    private void eliminateNotifications() {
        if(notifications) {
            notifications=false;
            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
            View v = bottomNavigationMenuView.getChildAt(1);
            BottomNavigationItemView itemView = (BottomNavigationItemView) v;
            itemView.removeViewAt(itemView.getChildCount() - 1);
        }
        }

    }

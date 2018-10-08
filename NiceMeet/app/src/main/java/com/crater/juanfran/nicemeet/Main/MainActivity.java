package com.crater.juanfran.nicemeet.Main;

import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
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

public class MainActivity extends AppCompatActivity implements SwipeFragment.SwipeFragmentInteractionListener {
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
                 Fragment fragment = null;
                 switch (item.getItemId()) {
                     case R.id.action_people:
                         fragment= new SwipeFragment();
                         break;
                     case R.id.action_chats:
                         eliminateNotifications();

                         break;
                     case R.id.action_profile:
                         createFakeNotification();
                        fragment= new ProfileFragment();
                         break;
                     case R.id.action_settings:
                         
                         break;
                 }
                 return loadFragment(fragment);
             }
         });
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayu, fragment)
                    .commit();
            return true;
        }
        return false;
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

//SwipeMethods
    @Override
    public void onSwipe(String uid) {

    }

    @Override
    public void onClickProfile(String uid) {

    }


}

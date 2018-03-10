package com.app.minato.roolya;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.minato.roolya.fragment.MedicineFragment;
import com.app.minato.roolya.fragment.PagerContainerFragment;
import com.app.minato.roolya.fragment.TakePhotoFragment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView navigation;
    Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        medicine();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    medicine();
                    return true;
                case R.id.navigation_dashboard:
                    medicine();
                    return true;
                case R.id.navigation_notifications:
                    photopager();
                    return true;
            }
            return false;
        }
    };

    private void findview() {
        navigation =  findViewById(R.id.navigation);
    }

    private void photopager(){
        currentFragment = new PagerContainerFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container,currentFragment);
        transaction.commit();
    }

    private void medicine(){
        currentFragment = new MedicineFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container,currentFragment);
        transaction.commit();
    }




}

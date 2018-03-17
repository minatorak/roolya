package com.app.minato.roolya;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.minato.roolya.fragment.DiseaseFragment;
import com.app.minato.roolya.fragment.MedicineFragment;
import com.app.minato.roolya.fragment.PagerContainerFragment;

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
                    disease();
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

    private void disease(){
        currentFragment = new DiseaseFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container,currentFragment);
        transaction.commit();
    }

}

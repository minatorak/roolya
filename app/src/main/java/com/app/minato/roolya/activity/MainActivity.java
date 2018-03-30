package com.app.minato.roolya.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.minato.roolya.R;
import com.app.minato.roolya.fragment.DiseaseFragment;
import com.app.minato.roolya.fragment.MedicineFragment;
import com.app.minato.roolya.fragment.PagerContainerFragment;
import com.app.minato.roolya.model.MedicineModel;

public class MainActivity extends AppCompatActivity implements DiseaseFragment.DiseaseFragmentListener,
        MedicineFragment.MedicineFragmentListener {

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
        navigation = findViewById(R.id.navigation);
    }

    private void photopager() {
        currentFragment = new PagerContainerFragment();
        switchingFragment(currentFragment);
    }

    private void medicine() {
        currentFragment = new MedicineFragment();
        switchingFragment(currentFragment);
    }

    private void disease() {
        currentFragment = new DiseaseFragment();
        switchingFragment(currentFragment);
    }

    private void switchingFragment(Fragment currentFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container, currentFragment);
        transaction.commit();
    }

    @Override
    public void diseaseListener(MedicineModel medicineModel) {
    }

    @Override
    public void mdicineListener(MedicineModel medicineModel) {

    }
}

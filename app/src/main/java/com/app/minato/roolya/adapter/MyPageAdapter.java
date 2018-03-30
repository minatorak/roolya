package com.app.minato.roolya.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.minato.roolya.fragment.PhotoFragment;
import com.app.minato.roolya.fragment.TakePhotoFragment;


public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem มีไว้กำหนด Fragment ที่จะแสดงใน View Pager โดยมี Parameter เป็น Integer เพื่อระบุว่าเป็นของ Fragment ลำดับที่เท่าไรใน View Pager
        Fragment fragment = null;
        switch (position){
            case 0:fragment = new TakePhotoFragment();
            break;
            case 1:fragment = new PhotoFragment();
            break;
        };
        return fragment;
    }

    @Override
    public int getCount() {
        // getCount จะมีไว้กำหนดว่าจะให้แสดง Fragment ใน View Pager กี่ตัว
        return 2;
    }

}

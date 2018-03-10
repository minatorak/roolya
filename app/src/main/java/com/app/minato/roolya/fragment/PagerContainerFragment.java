package com.app.minato.roolya.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.minato.roolya.MyPageAdapter;
import com.app.minato.roolya.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerContainerFragment extends Fragment {
    private ViewPager pager;
    MyPageAdapter adapter;
    public PagerContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager_container, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager =  getView().findViewById(R.id.pager);
        adapter = new MyPageAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

    }


}

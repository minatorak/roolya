package com.app.minato.roolya.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.minato.roolya.R;
import com.app.minato.roolya.adapter.MedicineAdapter;
import com.app.minato.roolya.model.MedicineModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MedicineFragment extends Fragment implements MedicineAdapter.listenerRe {

    private View view;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MedicineAdapter mAdapter;
    private ArrayList<MedicineModel> mDataset;

    private MedicineFragmentListener listener;

    public interface MedicineFragmentListener{
        void mdicineListener(MedicineModel medicineModel);
    }
    public MedicineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataset = new ArrayList<>();
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
        mDataset.add(new MedicineModel("Para"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_medicine, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MedicineAdapter(mDataset);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onclickitem(MedicineModel medicineModel) {
        if (listener!= null) listener.mdicineListener(medicineModel);
    }
}

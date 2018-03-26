package com.app.minato.roolya.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.minato.roolya.R;

import com.app.minato.roolya.adapter.DiseaseAdapter;
import com.app.minato.roolya.model.MedicineModel;


import java.util.ArrayList;

public class DiseaseFragment extends Fragment implements DiseaseAdapter.ClickItem {

    private View view;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private DiseaseAdapter mAdapter;
    private ArrayList<MedicineModel> mDataset;

    private DiseaseFragmentListener mListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataset = new ArrayList<>();
        mDataset.add(new MedicineModel("Para1"));
        mDataset.add(new MedicineModel("Para2"));
        mDataset.add(new MedicineModel("Para3"));
        mDataset.add(new MedicineModel("Para4"));
        mDataset.add(new MedicineModel("Para5"));
        mDataset.add(new MedicineModel("Para6"));
        mDataset.add(new MedicineModel("Para7"));
        mDataset.add(new MedicineModel("Para8"));
        mDataset.add(new MedicineModel("Para9"));
    }

    public DiseaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_disease, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DiseaseAdapter(mDataset);
        mAdapter.setlistener(this);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DiseaseFragmentListener) {
            mListener = (DiseaseFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface DiseaseFragmentListener{
        void diseaseListener(MedicineModel medicineModel);
    }

    @Override
    public void onClicklist(MedicineModel medicineModel) {
        if (mListener != null) {
            mListener.diseaseListener(medicineModel);
        }
    }
}

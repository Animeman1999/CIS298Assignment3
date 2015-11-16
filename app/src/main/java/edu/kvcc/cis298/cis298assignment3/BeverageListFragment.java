package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public class BeverageListFragment extends Fragment{
    private RecyclerView mBeverageRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_beverage_list, container, false);
        mBeverageRecyclerView = (RecyclerView) view.findViewById(R.id.beverage_recycler_view);
        mBeverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        return view;
    }
}

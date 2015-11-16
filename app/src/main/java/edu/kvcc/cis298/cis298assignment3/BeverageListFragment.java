package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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

    private class BeverageHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public BeverageHolder (View itemView){
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<BeverageHolder>{

        private List<Beverage> mBeverages;

        public CrimeAdapter(List<Beverage> beverages){
            mBeverages = beverages;
        }

        @Override
        public BeverageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
            return new BeverageHolder(view);
        }

        @Override
        public void onBindViewHolder(BeverageHolder holder, int position){
            Beverage beverage = mBeverages.get(position);
            holder.mTextView.setText(beverage.getId());
        }

        @Override
        public int getItemCount() {
            return mBeverages.size();
        }
    }
}

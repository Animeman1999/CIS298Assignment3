package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public class BeverageListFragment extends Fragment{
    private RecyclerView mBeverageRecyclerView;
    private BeverageAdapter mBeverageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_beverage_list, container, false);

        mBeverageRecyclerView = (RecyclerView) view.findViewById(R.id.beverage_recycler_view);
        mBeverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        BeverageData beverageData = BeverageData.get(getActivity());
        List<Beverage> beverages = beverageData.getBeverages();

     //   mBeverageAdapter = new BeverageAdapter(beverages);
     //   mBeverageRecyclerView.setAdapter(mBeverageAdapter);

        if (mBeverageAdapter == null){
            mBeverageAdapter = new BeverageAdapter(beverages);
            mBeverageRecyclerView.setAdapter(mBeverageAdapter);
        } else {
            mBeverageAdapter.notifyDataSetChanged();

        }
    }

    private class BeverageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mIdNumTextView;
        private TextView mListPriceTextView;

        private Beverage mBeverage;

        public void bindBeverage (Beverage beverage){
            mBeverage = beverage;
            mTitleTextView.setText(mBeverage.getName());
            mIdNumTextView.setText(Integer.toString(mBeverage.getId()));
            mListPriceTextView.setText(mBeverage.getPrice().toString());
        }

        public BeverageHolder (View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView)itemView.findViewById(R.id.list_beverage_title);
            mIdNumTextView = (TextView)itemView.findViewById(R.id.list_id_num);
            mListPriceTextView = (TextView)itemView.findViewById(R.id.list_price);
        }
        @Override
        public void onClick(View v){
            Intent intent = BeveragePagerActivity.newIntent(getActivity(),mBeverage.getId());
            startActivity(intent);
        }
    }

    private class BeverageAdapter extends RecyclerView.Adapter<BeverageHolder>{

        private List<Beverage> mBeverages;

        public BeverageAdapter(List<Beverage> beverages){
            mBeverages = beverages;
        }

        @Override
        public BeverageHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_beverage, parent, false);
            return new BeverageHolder(view);
        }

        @Override
        public void onBindViewHolder(BeverageHolder holder, int position){
            Beverage beverage = mBeverages.get(position);
            holder.bindBeverage(beverage);
        }

        @Override
        public int getItemCount() {
            return mBeverages.size();
        }
    }
}

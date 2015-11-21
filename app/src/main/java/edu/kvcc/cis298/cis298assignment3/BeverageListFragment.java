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

import java.util.List;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public class BeverageListFragment extends Fragment{// Controller class to create the RecylerView and Beverage Adapter and BeveragHolder

    private RecyclerView mBeverageRecyclerView; //Class level variable to hold the RecyclerView
    private BeverageAdapter mBeverageAdapter; // Class level variable to hold the BeverageAdapter


    @Override
    //Inflate the layout that will be viewed
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_beverage_list, container, false);

        //Create a RecyclerView and tie it to beverage_recycler_view
        mBeverageRecyclerView = (RecyclerView) view.findViewById(R.id.beverage_recycler_view);

        //Create a LayoutManager for the RecyclerView and pass in the context it need through the getActivity Method.
        mBeverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI(); // Call the updateUI method to get the data from the BeverageData and set it up with the adapter and then adding the adapter to the recycler view.

        return view; //Return the created view.
    }

    @Override
    public void onResume() {// Update the UI when the Fragment resumes so it has the current data.
        super.onResume();
        updateUI();
    }

    private void updateUI(){ //Update the fragment view with the current data

        //Get the singleton BeverageData
        BeverageData beverageData = BeverageData.get(getActivity());

        //Get the list of Beverages out of the singleton BeverageData.
        List<Beverage> beverages = beverageData.getBeverages();

        //If the Adapter has not been created, create it.
        if (mBeverageAdapter == null){
            mBeverageAdapter = new BeverageAdapter(beverages);// Create the Adapter and load it with the list of beverages.

            mBeverageRecyclerView.setAdapter(mBeverageAdapter);// Set the Adapter just created to the RecyclerView

        } else {//The adapter all ready exist.

            mBeverageAdapter.notifyDataSetChanged(); //Automatically update the data.

        }
    }
    // A CLASS TO HOLD THE VIEW FOR BEVERAGE HOLDER
    private class BeverageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //The three variables that will hold the data to displayed
        private TextView mTitleTextView;
        private TextView mIdNumTextView;
        private TextView mListPriceTextView;

        private Beverage mBeverage; // A single Beverage

        public BeverageHolder (View itemView){//Constructor that takes the View passed in and assigns it to a Class lever Version.
            super(itemView);

            itemView.setOnClickListener(this);//Create an onClickListener interface.

            //Tie the TextViewers to their view controls
            mTitleTextView = (TextView)itemView.findViewById(R.id.list_beverage_title);
            mIdNumTextView = (TextView)itemView.findViewById(R.id.list_id_num);
            mListPriceTextView = (TextView)itemView.findViewById(R.id.list_price);
        }

        public void bindBeverage (Beverage beverage){//Method that takes an instance of Beverage and assigns it to a class level version. The class level is used pass its properties to various view controls.
            mBeverage = beverage;

            //Set the data from the beverage into each TextView
            mTitleTextView.setText(mBeverage.getName());
            mIdNumTextView.setText(Integer.toString(mBeverage.getId()));
            mListPriceTextView.setText("$ "+mBeverage.getPrice().toString());
        }

        @Override
        public void onClick(View v){
            //Create the new intent of BeveragePagerActivity.
            Intent intent = BeveragePagerActivity.newIntent(getActivity(),mBeverage.getId());

            startActivity(intent);//Start the new intent.
        }
    }

    private class BeverageAdapter extends RecyclerView.Adapter<BeverageHolder>{

        private List<Beverage> mBeverages; //Class Level variable to hold the list of beverages.

        public BeverageAdapter(List<Beverage> beverages){//Constructor that takes in the list of beverages and assing them to the class level variable.
            mBeverages = beverages;
        }

        @Override
        public BeverageHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity()); //Create a LayoutInflator

            View view = layoutInflater.inflate(R.layout.fragment_beverage, parent, false);//Inflate the view of the fragment_beverage,

            return new BeverageHolder(view); //Return the BeverageHolder with the view passed as a parameter.
        }

        @Override
        public void onBindViewHolder(BeverageHolder holder, int position){

            Beverage beverage = mBeverages.get(position);// Get the Beverage that is at the index declared by the variable position and assign to the local beverage variable.

            holder.bindBeverage(beverage);//Send the Beverage to the bindBeverage method.
        }

        @Override
        public int getItemCount() {//Return the size of the Beverage Lists
            return mBeverages.size();
        }
    }
}

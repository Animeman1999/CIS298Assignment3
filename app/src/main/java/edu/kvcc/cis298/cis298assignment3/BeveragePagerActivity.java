package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Jeffrey on 11/17/2015.
 */
public class BeveragePagerActivity extends FragmentActivity {

    //String to hld the constant key for the Extra
    private static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.assignmnet3.jeff.beverage_id";

    private ViewPager mViewPager;// Variable to give access to ViewPager while in the view

    private List<Beverage> mBeverages;// Variable to hold the list of beverages the ViewPager will need.

    public static Intent newIntent(Context packageContext, int beverageId){//Method that will start the Activity if properly formated.

        Intent intent = new Intent(packageContext, BeveragePagerActivity.class);// Make the new intent

        intent.putExtra(EXTRA_BEVERAGE_ID, beverageId); //Put in the beverageId using the key

        return intent; //Return the intent.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beverage_pager);//Set the content of this Activity to the beverage pager layout.

        int beverageId = (int) getIntent().getSerializableExtra(EXTRA_BEVERAGE_ID); //Get the beverage Id from the Extras for the activity.

        mViewPager = (ViewPager)findViewById(R.id.activity_beverage_pager_view_pager);//Get the view from the layout

        mBeverages = BeverageData.get(this).getBeverages();//Returns the single instance of Beverage that we want to use.

        FragmentManager fragmentManager = getSupportFragmentManager();// Create a new Fragment Manager.

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {//Set the adapter and wire up the fragment manager.
            @Override
            public Fragment getItem(int position) {

                Beverage beverage = mBeverages.get(position);//Get a specific item from the Beverages list.

                return BeverageFragment.newInstance(beverage.getId());//Return a new instance of the beverage fragment specified by the id.
            }

            @Override
            public int getCount() {//Get the count for the size of the Beverages list.
                return mBeverages.size();
            }
        });

        for (int i = 0; i < mBeverages.size(); i++){ //For each beverage in the beverage list

            //Check to see if the id of the current beverage matches the one that was sent in from the BeverageListActivity that was started in this activity.
            if (Integer.valueOf(mBeverages.get(i).getId()).equals(beverageId)){

                mViewPager.setCurrentItem(i);//See the current item of the viewPager to the one sent from the view.

                i = mBeverages.size(); //Since we found our match, stop looping.
            }
        }
    }


}

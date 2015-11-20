package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Jeffrey on 11/16/2015.
 */
public class BeverageDetailsFragment extends Fragment {
 /*     private Beverage mBeverage;
    private EditText mBeverageTitle;
    private EditText mIdNum;
    private EditText mPack;
    private EditText mPrice;
    private CheckBox mActive;

    private static final String ARG_BEVERAGE_ID = "beverage_id";

    public static BeverageDetailsFragment newInstance(int idNum){

        Bundle args = new Bundle();

        args.putSerializable(ARG_BEVERAGE_ID, idNum);

        BeverageDetailsFragment detailsFragment = new BeverageDetailsFragment();

        detailsFragment.setArguments(args);

        return detailsFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer beverageID = (Integer) getArguments().getSerializable(ARG_BEVERAGE_ID);

        mBeverage = BeverageData.get(getActivity()).getBeverage(beverageID);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beverage_details, container, false);

        mBeverageTitle = (EditText)v.findViewById(R.id.beverage_title);
        mBeverageTitle.setText(mBeverage.getName());

        mIdNum= (EditText)v.findViewById(R.id.id_num);
        mIdNum.setText(Integer.toString(mBeverage.getId()));

        mPack = (EditText)v.findViewById(R.id.pack);
        mPack.setText(mBeverage.getPack());

        mPrice = (EditText)v.findViewById(R.id.price);
        mPrice.setText(String.valueOf(mBeverage.getPrice()));

        mActive = (CheckBox)v.findViewById(R.id.active);
        mActive.setChecked(mBeverage.getActive());


        return v;
    }
*/
}

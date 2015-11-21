package edu.kvcc.cis298.cis298assignment3;



import android.os.Bundle;
import android.support.v4.app.Fragment;  // MUST BE ADDED TO USE FRAGMENTS
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CompoundButton;


/**
 * Created by jmartin5229 on 11/12/2015.
 */
public class BeverageFragment extends Fragment {

    private Beverage mBeverage;// Used to make an Instance of a Beverage

    // The following variables are all used to hold the information needed for output.
    private EditText mBeverageTitle;
    private EditText mIdNum;
    private EditText mPack;
    private EditText mPrice;
    private CheckBox mActive;

    private static final String ARG_BEVERAGE_ID = "beverage_id";// Static String to be used as the key for parameters we set and retrieve from the bundle.

    //This is a static method that is used to create a new instance of BeverageFragment. It uses idNum to pass in the correct information of a Beverage. Any Activity can call this method and get a properly created BeverageFragment.
    public static BeverageFragment newInstance(int idNum){

        //Create an arguments bundle.
        Bundle args = new Bundle();

        //Put the value of idNum into the bundle.
        args.putSerializable(ARG_BEVERAGE_ID, idNum);

        //Create a new instance of BeverageFragment.
        BeverageFragment beverageFragment = new BeverageFragment();

        //Sets the arguments for the fragment with in the bundle.
        beverageFragment.setArguments(args);

        //Return the beverageFragment that was created.
        return beverageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the beverageId from the bundle as a serializable that is cast as an integer.
        Integer beverageID = (Integer) getArguments().getSerializable(ARG_BEVERAGE_ID);

        //From the singleton BeverageData we retrieve the specific Beverage we want based on its beverageID
        mBeverage = BeverageData.get(getActivity()).getBeverage(beverageID);
    }
    @Override
    //  THIS METHOD INFLATES THE VIEW AND PLACES CONTENT ON THE SCREEN.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_beverage_details, container, false); //Inflate a fragment to create a view.

        //Ties BeverageTitle together and when it is changed, updates that particular beverage's Name.
        mBeverageTitle = (EditText)v.findViewById(R.id.beverage_title);
        mBeverageTitle.setText(mBeverage.getName());
        mBeverageTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

        //Ties IdNums together and updates the Id when it is changed.
        mIdNum= (EditText)v.findViewById(R.id.id_num);
        mIdNum.setText(Integer.toString(mBeverage.getId()));
        mIdNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // When the value entered is out side of range set it to zero.
                try {
                    mBeverage.setId(Integer.parseInt(s.toString()));
                } catch (Exception e) {
                    mBeverage.setId(0);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

        //Ties the Packs together ane updates the Pack when changed.
        mPack = (EditText)v.findViewById(R.id.pack);
        mPack.setText(mBeverage.getPack());
        mPack.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setPack(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

        //Ties the Price together and updates the price when changed.
        mPrice = (EditText)v.findViewById(R.id.price);
        mPrice.setText(String.valueOf(mBeverage.getPrice()));
        mPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // When the value entered is out side of range set it to zero.
                try {
                    mBeverage.setPrice(Double.parseDouble(s.toString()));
                } catch (Exception e) {
                    mBeverage.setPrice(0.0);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

        //Ties Active together and saves the state it is changed to when changed.
        mActive = (CheckBox)v.findViewById(R.id.active);
        mActive.setChecked(mBeverage.getActive());
        mActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBeverage.setActive(isChecked);
            }
        });


        return v;
    }


}

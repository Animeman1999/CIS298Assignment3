package edu.kvcc.cis298.cis298assignment3;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton;


/**
 * Created by jmartin5229 on 11/12/2015.
 */
public class BeverageFragment extends Fragment {
 /*   private Beverage mBeverage; // To hold a single Beverage class
    private TextView mListBeverageTitle;
    private TextView mListIdNum;
    private TextView mListPrice;
    private static final String ARG_BEVERAGE_ID = "beverage_id";

    public static BeverageFragment newInstance(int beverageId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_BEVERAGE_ID, beverageId);
        BeverageFragment fragment = new BeverageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Integer beverageID = (Integer) getArguments().getSerializable(ARG_BEVERAGE_ID);

        mBeverage = BeverageData.get(getActivity()).getBeverage(beverageID);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_beverage, container, false);


        mListBeverageTitle = (TextView)v.findViewById(R.id.list_beverage_title);
        mListBeverageTitle.setText(mBeverage.getName());

        mListIdNum = (TextView)v.findViewById(R.id.list_id_num);
        mListIdNum.setText(Integer.toString(mBeverage.getId()));

        mListPrice = (TextView)v.findViewById(R.id.list_price);
        mListPrice.setText("$" + mBeverage.getPrice().toString());


        return v;
    }
*/

    private Beverage mBeverage;
    private EditText mBeverageTitle;
    private EditText mIdNum;
    private EditText mPack;
    private EditText mPrice;
    private CheckBox mActive;

    private static final String ARG_BEVERAGE_ID = "beverage_id";

    public static BeverageFragment newInstance(int idNum){

        Bundle args = new Bundle();

        args.putSerializable(ARG_BEVERAGE_ID, idNum);

        BeverageFragment beverageFragment = new BeverageFragment();

        beverageFragment.setArguments(args);

        return beverageFragment;

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

        mIdNum= (EditText)v.findViewById(R.id.id_num);
        mIdNum.setText(Integer.toString(mBeverage.getId()));
        mIdNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setId(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

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

        mPrice = (EditText)v.findViewById(R.id.price);
        mPrice.setText(String.valueOf(mBeverage.getPrice()));
        mPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Space left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setPrice(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Space left intentionally blank
            }
        });

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

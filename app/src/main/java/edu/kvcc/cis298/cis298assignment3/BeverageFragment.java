package edu.kvcc.cis298.cis298assignment3;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jmartin5229 on 11/12/2015.
 */
public class BeverageFragment extends Fragment {
    private Beverage mBeverage; // To hold a single Beverage class
    private TextView mTitlefield;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeverage = new Beverage();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_wine, container, false);
        mTitlefield = (TextView)v.findViewById(R.id.list_beverage_title);
        mTitlefield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setName(s.toString());//      This needs more data added to the mBeverage
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }



}

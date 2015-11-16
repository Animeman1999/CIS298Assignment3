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
    private TextView mListBeverageTitle;
    private TextView mListIdNum;
    private TextView mListPrice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeverage = new Beverage();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_wine, container, false);


        mListBeverageTitle = (TextView)v.findViewById(R.id.list_beverage_title);
        mListBeverageTitle.setText(mBeverage.getName());

        mListIdNum = (TextView)v.findViewById(R.id.list_id_num);
        mListIdNum.setText(Integer.toString(mBeverage.getId()));

        mListPrice = (TextView)v.findViewById(R.id.list_price);
        mListPrice.setText("$" + mBeverage.getPrice().toString());


        return v;
    }



}

package edu.kvcc.cis298.cis298assignment3;



import android.os.Bundle;
import android.support.v4.app.Fragment;
/**
 * Created by jmartin5229 on 11/12/2015.
 */
public class BeverageFragment extends Fragment {
    private Beverage mBeverage; // To hold a single Beverage class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeverage = new Beverage();
  }


}

package edu.kvcc.cis298.cis298assignment3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeverageActivity extends SingleFragmentActivity {

   @Override
    protected android.support.v4.app.Fragment createFragment() {
       return new BeverageFragment();
   }
}

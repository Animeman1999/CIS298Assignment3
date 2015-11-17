package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by Jeffrey on 11/16/2015.
 */
public class BeverageDetailActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BeverageDetailsFragment();
    }
}


package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public class BeverageListActivity extends SingleFragmentActivity{//An abstract Activity for hosting the BeverageListFragment.
    @Override
    protected Fragment createFragment(){
        return new BeverageListFragment();
    }
}

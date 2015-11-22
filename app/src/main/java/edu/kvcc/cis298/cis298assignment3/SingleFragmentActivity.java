package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();//A method which every activity created can implement.

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);//Inflates an Activity to create the view.

        FragmentManager fm = getSupportFragmentManager();//Create a Fragment Manager

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);// Use the fragment manger to get the fragment and tie it to the fragment_container.

        if (fragment == null){//Check to see if the fragment is null as it will be on start up.

            fragment = createFragment(); //Create a new instance of the fragment, since it does not exist.

            fm.beginTransaction() //Start the transaction by adding the fragment to the frame and then committing the changes.
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}

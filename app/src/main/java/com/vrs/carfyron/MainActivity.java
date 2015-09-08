package com.vrs.carfyron;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.vrs.android.fyreon.FyreonWidget;
import com.vrs.android.fyreon.ui.SocialLoginActivity;
import com.vrs.carfyron.fragment.ModelFragment;
import com.vrs.carfyron.iface.NavigationDrawerCallbacks;
import com.vrs.carfyron.fragment.NavigationDrawerFragment;
import com.vrs.carfyron.utils.Helper;
import com.vrs.carfyron.R;

import java.util.Arrays;


/**
 * ----------------------------------------------------------------------------
 * Class Name : MainActivity
 * Description : This is a base activity for application
 * Date of Creation : 24/03/2015
 * Extends : ActionBarActivity
 * ----------------------------------------------------------------------------
 *
 * @author vrs
 */

public class MainActivity extends ActionBarActivity implements
        NavigationDrawerCallbacks {

    private Toolbar mToolbar;

    public Helper.CAR mSelectedCar;

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private ModelFragment mCarDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer,
                (DrawerLayout) findViewById(R.id.drawer), mToolbar);


    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                mSelectedCar = Helper.CAR.AUDI;
                break;
            case 1:
                mSelectedCar = Helper.CAR.BMW;
                break;
            case 2:
                mSelectedCar = Helper.CAR.CHEVROLET;
                break;
            case 3:
                mSelectedCar = Helper.CAR.HONDA;
                break;
            case 4:
                mSelectedCar = Helper.CAR.HYUNDAI;
                break;
            case 5:
                mSelectedCar = Helper.CAR.JAGUAR;
                break;
            case 6:
                mSelectedCar = Helper.CAR.MERCEDES;
                break;
            case 7:
                mSelectedCar = Helper.CAR.PORSCHE;
                break;
            case 8:
                mSelectedCar = Helper.CAR.SKODA;
                break;
            case 9:
                mSelectedCar = Helper.CAR.MARUTISUZUKI;
                break;
        }

        setUpCarDetailsFragment();
    }

    /**
     * Method Name : setUpCarDetailsFragment
     * Description : Used to replace details fragment
     * Created by vrs on 01/04/15.
     */
    public void setUpCarDetailsFragment() {
        mCarDetailFragment = new ModelFragment();
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();

        mFragmentTransaction.replace(R.id.container, mCarDetailFragment);
        mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }


}

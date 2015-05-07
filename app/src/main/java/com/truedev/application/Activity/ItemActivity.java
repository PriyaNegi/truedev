package com.truedev.application.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraHostProvider;
import com.commonsware.cwac.camera.SimpleCameraHost;
import com.truedev.application.Fragment.AnalyticsFragment;
import com.truedev.application.Fragment.CameraItemsFragment;
import com.truedev.application.Fragment.InfosFragment;
import com.truedev.application.Fragment.MapsFragment;
import com.truedev.application.R;
import com.truedev.application.Utils.Constants;

import static com.truedev.application.Utils.Constants.OPEN_FRAGMENT;
import com.facebook.Session;

import java.util.ArrayList;

public class ItemActivity extends Activity implements CameraHostProvider {

    private static final String TAG = "ItemActivity";
//    private PhotosListener photosListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);
        if (savedInstanceState == null) {
            String openFragment = (String) getIntent().getExtras().get(OPEN_FRAGMENT);
            Log.e(TAG,"Fragment to open :: "+ openFragment);
            initializeFragment(openFragment);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeFragment(String openFragment) {

        switch (openFragment)
        {
            case Constants.ANALYTICS:
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new AnalyticsFragment()).commit();
                break;

            case Constants.CAMERA_ITEMS:
                CameraItemsFragment cameraItemsFragment = new CameraItemsFragment();
                getFragmentManager().beginTransaction()
                        .add(R.id.container, cameraItemsFragment).commit();
                break;

            case Constants.MAPS:
                Log.e(TAG,"Maps fragment");
                getFragmentManager().beginTransaction().add(R.id.container,new MapsFragment()).commit();
                break;

            case Constants.TOOL_BAR:
                InfosFragment fragment = InfosFragment.newInstance(Constants.TOOL_BAR);
                getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
                break;

            case Constants.LISTVIEWS:
                InfosFragment fragment1 = InfosFragment.newInstance(Constants.LISTVIEWS);
                getFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
                break;

            case Constants.NAVIGATION_DRAWER:
                InfosFragment fragment2 = InfosFragment.newInstance(Constants.LISTVIEWS);
                getFragmentManager().beginTransaction().add(R.id.container, fragment2).commit();
                break;

            case Constants.NOTIFICATIONS:
                InfosFragment fragment3 = InfosFragment.newInstance(Constants.LISTVIEWS);
                getFragmentManager().beginTransaction().add(R.id.container, fragment3).commit();
                break;

            case Constants.MEDIA_STORE:
                InfosFragment fragment4 = InfosFragment.newInstance(Constants.MEDIA_STORE);
                getFragmentManager().beginTransaction().add(R.id.container, fragment4).commit();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public CameraHost getCameraHost() {
        SimpleCameraHost cameraHost = new SimpleCameraHost(this);
//        cameraHost.
        return cameraHost;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_item, container, false);
            return rootView;
        }
    }
}

package com.example.android.quakereport;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EarthquakeActivity extends AppCompatActivity implements LoaderCallbacks<List<Earthquake>> {

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;


    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    /** Adapter for the list of earthquakes */
    private EarthquakeAdapter mAdapter;



    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "Test: earthquake activity onCreate called");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

//        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("7.1","San Francisco","Feb 2, 2016"));
//        earthquakes.add(new Earthquake("5.2","New York ","jan 24, 2016"));
//        earthquakes.add(new Earthquake("3.4","Tokyo","Sept 11, 2016"));
//        earthquakes.add(new Earthquake("4.9","Myanmar","Nov 6, 2016"));
//        earthquakes.add(new Earthquake("5.0","Goa","April 9, 2016"));
//        earthquakes.add(new Earthquake("6.5","Mexico City","March 12, 2016"));




        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        mAdapter  = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);





        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {

                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);


                } else if (position == 1) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 2) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 3) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 4) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 5) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 6) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 7) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 8) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 9) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }else if (position == 10) {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                } else {
                    Earthquake earthquake =  mAdapter.getItem(position);
                    String url =  earthquake.getURL();

                    Intent myIntent = new Intent(getApplicationContext(), webview.class);
                    myIntent.putExtra("url",url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        Log.i(LOG_TAG, "Test: init loader called");

    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "Test: Loader onCreate called");
        // Create a new loader for the given URL
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        Log.i(LOG_TAG, "Test: Loader onLoad called");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.i(LOG_TAG, "Test: loader onLaderReset called");
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

}

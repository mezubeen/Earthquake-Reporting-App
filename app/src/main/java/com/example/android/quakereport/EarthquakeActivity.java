/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {
    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    /** Adapter for the list of earthquakes */
    private EarthquakeAdapter mAdapter;

    private WebView webview;
    private ProgressDialog progressBar;

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        // Start the AsyncTask to fetch the earthquake data
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);



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
    }

    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {

        @Override
        protected List<Earthquake> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;

        }

        @Override
        protected void onPostExecute(List<Earthquake> data) {

            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }
}

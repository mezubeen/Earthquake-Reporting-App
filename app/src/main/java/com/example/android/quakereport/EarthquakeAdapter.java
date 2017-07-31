package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Babar on 7/27/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        //find the earthquake at the given position in the list of earthquake
        Earthquake currentEarthquake = getItem(position);

        //Find the textview with view id
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        //display the magnitude of current earthquake in that view
        magnitudeView.setText(currentEarthquake.getMagnitude());

        //Find the textview with view id location
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        //display the location of current earthquake in that view
        locationView.setText(currentEarthquake.getLocation());


        //Find the textview with view id location
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //display the location of current earthquake in that view
        dateView.setText(currentEarthquake.getDate());


        //returning the list item view to return data
        return listItemView;







    }
}

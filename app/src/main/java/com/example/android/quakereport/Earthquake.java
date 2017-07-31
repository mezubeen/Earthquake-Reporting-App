package com.example.android.quakereport;

/**
 * Created by Babar on 7/27/2017.
 */

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private String mDate;


    public Earthquake(String Magnitude, String location, String Date){

        mMagnitude = Magnitude;
        mLocation = location;
        mDate = Date;
    }

    public String getMagnitude(){ return mMagnitude; }

    public String getLocation(){ return mLocation; }

    public String getDate() { return mDate; }
}

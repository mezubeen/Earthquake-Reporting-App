package com.example.android.quakereport;

/**
 * Created by Babar on 7/27/2017.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private String mDate;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;
    private String murl;


    public Earthquake(double Magnitude, String location, long timeInMilliseconds, String url){

        mMagnitude = Magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        murl = url;
    }

    public double getMagnitude(){ return mMagnitude; }

    public String getLocation(){ return mLocation; }


    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
    public String getURL(){ return murl; }
}

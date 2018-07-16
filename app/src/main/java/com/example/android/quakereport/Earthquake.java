package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private String mLocation;
    private String mMagnitude;
    private String mDate;

    public Earthquake(String location, String magnitue, String date) {
        mLocation = location;
        mMagnitude = magnitue;
        mDate = date;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getDate() {
        return mDate;
    }
}

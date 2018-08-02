package com.example.android.quakereport;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Earthquake {

    private String mLocation;
    private String mUrl;
    private double mMagnitude;
    private long mUnixTime;

    private final String LOCATION_SEPARATOR = " of ";

    public Earthquake(String location, double magnitude, long unixTime, String url) {
        mLocation = location;
        mMagnitude = magnitude;
        mUnixTime = unixTime;
        mUrl = url;
    }

    public String getLocation() {
        String location = mLocation;

        if (mLocation.contains(LOCATION_SEPARATOR)) {
            location = mLocation.substring(mLocation.indexOf("of ") + 3, mLocation.length());
        }

        return location;
    }

    public String getLocationOffset() {
        String locationOffset = null;

        if (mLocation.contains(LOCATION_SEPARATOR)) {
           locationOffset = mLocation.substring(0, mLocation.indexOf("of ") + 3).trim();
        }
        return locationOffset;
    }

    public String getMagnitude() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(mMagnitude);
    }

    public String getFormatDate() {
        return new SimpleDateFormat("MMM dd, yyyy", Locale.US).format(new Date(mUnixTime));
    }

    public String getFormatTime() {
        return new SimpleDateFormat("HH:mm a", Locale.US).format(new Date(mUnixTime));
    }

    public String getUrl() {
        return mUrl;
    }

    public int getMagnitudeColor() {
        int magnitudeColor;

        switch ((int) Math.floor(mMagnitude)) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;
        }

        return magnitudeColor;
    }
}

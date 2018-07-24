package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (TextUtils.isEmpty(mUrl)) {
            return null;
        }

        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}

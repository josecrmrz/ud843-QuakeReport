package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeArrayAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);


        ((TextView)view.findViewById(R.id.tvMagnitude)).setText(earthquake.getMagnitude());
        ((TextView)view.findViewById(R.id.tvLocationOffset)).setText(earthquake.getLocationOffset());
        ((TextView)view.findViewById(R.id.tvLocation)).setText(earthquake.getLocation());
        ((TextView)view.findViewById(R.id.tvDate)).setText(earthquake.getFormatDate());
        ((TextView)view.findViewById(R.id.tvTime)).setText(earthquake.getFormatTime());

        GradientDrawable magnitudeCircle = (GradientDrawable) view.findViewById(R.id.tvMagnitude).getBackground();
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(), earthquake.getMagnitudeColor()));

        return view;
    }
}

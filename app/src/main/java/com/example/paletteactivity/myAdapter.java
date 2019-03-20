package com.example.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class myAdapter extends ArrayAdapter<String> {
    private int resource;
    private Context context;
    private String[] colors;
    private String[] colorValues;
    private LayoutInflater mInflater ;

    public myAdapter(Context context, int resource, String[] colors, String[] colorValues) {
        super(context, resource, colors);
        this.resource = resource;
        this.context = context;
        this.colors = colors;
        this.colorValues = colorValues;
       mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public View getView(int position, @Nullable View convertView,   @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){

        final View view = mInflater.inflate(R.layout.spinner_layout, parent, false);

        TextView text = view.findViewById(R.id.color_name);

        text.setText(colors[position]);

        view.findViewById(R.id.base_color).setBackgroundColor(Color.parseColor(colorValues[position]));

        return view;

    }

}



package com.example.paletteactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.color_spinner);

        //Resource res =[]
        String[] view_colors = getResources().getStringArray(R.array.view_colors);
        final String[] value_colors = getResources().getStringArray(R.array.value_colors);

        myAdapter colorAdapter = new myAdapter(this,R.layout.spinner_layout,view_colors, value_colors);

        spinner.setAdapter(colorAdapter);

        final Intent myIntent = new Intent(this  , PaletteActivity.class);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                myIntent.putExtra("color", value_colors[position]);
                startActivity(myIntent);

               /* ConstraintLayout base = findViewById(R.id.base_color);
                base.setBackgroundColor(Color.WHITE);*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

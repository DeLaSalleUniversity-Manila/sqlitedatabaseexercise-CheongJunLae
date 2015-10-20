package com.example.student.teaapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeaActivity extends Activity {

    public static final String EXTRA_TEANO = "TeaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        //Get the drink from the intent
        int teaNo = (Integer)getIntent().getExtras().get(EXTRA_TEANO);
        Tea tea = Tea.teas[teaNo];


        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(tea.getImageResourceId());
        photo.setContentDescription(tea.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(tea.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(tea.getDescription());
    }
}
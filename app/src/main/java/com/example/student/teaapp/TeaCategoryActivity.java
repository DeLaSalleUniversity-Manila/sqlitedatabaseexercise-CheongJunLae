package com.example.student.teaapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

public class TeaCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listTeas = getListView();
        ArrayAdapter<Tea> listAdapter = new ArrayAdapter<Tea>(this,
                android.R.layout.simple_list_item_1,
                Tea.teas);
        listTeas.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(TeaCategoryActivity.this, TeaActivity.class);
        intent.putExtra(TeaActivity.EXTRA_TEANO, (int) id);
        startActivity(intent);
    }
}
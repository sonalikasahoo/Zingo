package com.example.zingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public  class cart_view extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);
        ArrayList<cart_item_info> info = new ArrayList<cart_item_info>();
        cart_item_info_adapter infoAdapter = new cart_item_info_adapter(this, info);
        ListView listView = (ListView) findViewById(R.id.items);
        listView.setAdapter(infoAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

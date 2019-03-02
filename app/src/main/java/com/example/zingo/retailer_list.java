package com.example.zingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class retailer_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_list);

        ArrayList<reatiler_info> info = new ArrayList<reatiler_info>();
        retailer_info_adapter infoAdapter = new retailer_info_adapter(this, info);
        ListView listView = (ListView) findViewById(R.id.all_retail);
        listView.setAdapter(infoAdapter);
    }
}

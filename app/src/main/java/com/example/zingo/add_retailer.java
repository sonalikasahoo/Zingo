package com.example.zingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_retailer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_retailer);

        EditText name,uid,number,address;

        name = (EditText)findViewById(R.id.name_retail);
        uid = (EditText)findViewById(R.id.id_retail);
        number = (EditText)findViewById(R.id.number_retail);
        address = (EditText)findViewById(R.id.address_retail);

        Button retailer = (Button)findViewById(R.id.retailer_add);
        retailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retailer;
                retailer= new Intent(getApplicationContext(),home_page.class);
                startActivity(retailer);
            }
        });
    }
}

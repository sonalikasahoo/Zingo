package com.example.zingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class account_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        final Button change_pass,cart,retail_view,waste;

        change_pass = (Button)findViewById(R.id.change_pass);
        cart = (Button)findViewById(R.id.add_cart);
        waste = (Button)findViewById(R.id.ewaste_policy);
        retail_view = (Button)findViewById(R.id.view_retailer);

        waste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ewastepolicy;
                ewastepolicy = new Intent(getApplicationContext(),e_waste.class);
                startActivity(ewastepolicy);
            }
        });


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewcart;
                viewcart = new Intent(getApplicationContext(),cart_view.class);
                startActivity(viewcart);

            }
        });

        retail_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retailer = new Intent(getApplicationContext(),retailer_list.class);
                startActivity(retailer);
            }
        });
    }
}

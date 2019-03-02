package com.example.zingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartScreen extends AppCompatActivity {

    LinearLayout L1,L2,L3,L4,L5;
    TextView e1,e2,e3,e4,e5,e6,e7,e8,e9;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screen);

        RecyclerView rvCart = findViewById(R.id.rvCart);
    }
}

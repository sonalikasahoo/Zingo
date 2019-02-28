package com.example.zingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Button b1=findViewById(R.id.addmoreorders);
        L1=findViewById(R.id.linearlayout1);
        L2=findViewById(R.id.linearlayout2);
        L3=findViewById(R.id.linearlayout3);
        L4=findViewById(R.id.linearlayout4);
        L5=findViewById(R.id.linearlayout5);
        e1=findViewById(R.id.retailer_id1);
        e2=findViewById(R.id.barcode1);
        e3=findViewById(R.id.product_code1);
        e4=findViewById(R.id.brand1);
        e5=findViewById(R.id.packing_type1);
        e6=findViewById(R.id.weight1);
        e7=findViewById(R.id.mrp1);
        e8=findViewById(R.id.quantity1);
        e9=findViewById(R.id.total1);


        //TODO : fetch count value from database
        //TODO : for this cart fetch all the returns from retailers and show them to the Linear Layouts
        //TODO : set Data of the textViews as data fetched from database (for return 1 only)

        if(count==0)
        {
            L1.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L4.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
        }
        if(count==1)
        {
            L1.setVisibility(View.VISIBLE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L4.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
        }
        if(count==2)
        {
            L1.setVisibility(View.VISIBLE);
            L2.setVisibility(View.VISIBLE);
            L3.setVisibility(View.GONE);
            L4.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
        }
        if(count==3)
        {
            L1.setVisibility(View.VISIBLE);
            L2.setVisibility(View.VISIBLE);
            L3.setVisibility(View.VISIBLE);
            L4.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
        }
        if(count==4)
        {
            L1.setVisibility(View.VISIBLE);
            L2.setVisibility(View.VISIBLE);
            L3.setVisibility(View.VISIBLE);
            L4.setVisibility(View.VISIBLE);
            L5.setVisibility(View.GONE);
        }
        if(count==5)
        {
            L1.setVisibility(View.VISIBLE);
            L2.setVisibility(View.VISIBLE);
            L3.setVisibility(View.VISIBLE);
            L4.setVisibility(View.VISIBLE);
            L5.setVisibility(View.VISIBLE);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                //TODO : push count value to database
//                if(count==1)
//                {
//                    L1.setVisibility(View.VISIBLE);
//                    L2.setVisibility(View.GONE);
//                    L3.setVisibility(View.GONE);
//                }
//                if(count==2)
//                {
//                    L1.setVisibility(View.VISIBLE);
//                    L2.setVisibility(View.VISIBLE);
//                    L3.setVisibility(View.GONE);
//                }
//                if(count==3)
//                {
//                    L1.setVisibility(View.VISIBLE);
//                    L2.setVisibility(View.VISIBLE);
//                    L3.setVisibility(View.VISIBLE);
//                }
            }
        });
    }
}

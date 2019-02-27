package com.example.zingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextView name,licence,phone,email,region,address;
        name = (TextView)findViewById(R.id.wh_name);
        licence = (TextView)findViewById(R.id.license_no);
        phone = (TextView)findViewById(R.id.wh_number);
        email = (TextView)findViewById(R.id.wh_mail);
        address = (TextView)findViewById(R.id.address);

        TextView return1,date1,time1,product1,status1;
        TextView return2,date2,time2,product2,status2;
        TextView return3,date3,time3,product3,status3;

        return1 = (TextView)findViewById(R.id.return_1);
        return2 = (TextView)findViewById(R.id.return_2);
        return3 = (TextView)findViewById(R.id.return_3);

        date1 = (TextView)findViewById(R.id.date_1);
        date2 = (TextView)findViewById(R.id.date_2);
        date3 = (TextView)findViewById(R.id.date_3);

        time1 = (TextView)findViewById(R.id.time_1);
        time2 = (TextView)findViewById(R.id.time_2);
        time3 = (TextView)findViewById(R.id.time_3);

        product1 = (TextView)findViewById(R.id.product);
        product2 = (TextView)findViewById(R.id.product2);
        product3 = (TextView)findViewById(R.id.product3);

        status1 = (TextView)findViewById(R.id.state);
        status2 = (TextView)findViewById(R.id.stat2);
        status3 = (TextView)findViewById(R.id.stats3);

        Button addRetailer = (Button)findViewById(R.id.retailer_add);

        addRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page;
               home_page = new Intent(getApplicationContext(),add_retailer.class);
                  startActivity(home_page);
            }
        });

    }
}

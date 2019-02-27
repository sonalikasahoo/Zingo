package com.example.zingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home_page extends AppCompatActivity {

    public static final String TAG = "pikachu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent receivedIntent = getIntent();
        final String phNumber = receivedIntent.getStringExtra("phNumber");

        final TextView name, licence, phone, email, region, address;
        name = (TextView) findViewById(R.id.wh_name);
        licence = (TextView) findViewById(R.id.license_no);
        phone = (TextView) findViewById(R.id.wh_number);
        email = (TextView) findViewById(R.id.wh_mail);
        address = (TextView) findViewById(R.id.address);


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("Distributors").child(phNumber);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name.setText(dataSnapshot.child("name").getValue().toString());
                licence.setText(dataSnapshot.child("license").getValue().toString());
                phone.setText(phNumber);
                email.setText(dataSnapshot.child("email").getValue().toString());
                address.setText(dataSnapshot.child("address1").getValue().toString()
                        + ", " + dataSnapshot.child("city").getValue().toString() + ", "
                        + dataSnapshot.child("state").getValue().toString() + ", " +
                        dataSnapshot.child("pincode").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        TextView return1, date1, time1, product1, status1;
        TextView return2, date2, time2, product2, status2;
        TextView return3, date3, time3, product3, status3;

        return1 = (TextView) findViewById(R.id.return_1);
        return2 = (TextView) findViewById(R.id.return_2);
        return3 = (TextView) findViewById(R.id.return_3);

        date1 = (TextView) findViewById(R.id.date_1);
        date2 = (TextView) findViewById(R.id.date_2);
        date3 = (TextView) findViewById(R.id.date_3);

        time1 = (TextView) findViewById(R.id.time_1);
        time2 = (TextView) findViewById(R.id.time_2);
        time3 = (TextView) findViewById(R.id.time_3);

        product1 = (TextView) findViewById(R.id.product);
        product2 = (TextView) findViewById(R.id.product2);
        product3 = (TextView) findViewById(R.id.product3);

        status1 = (TextView) findViewById(R.id.state);
        status2 = (TextView) findViewById(R.id.stat2);
        status3 = (TextView) findViewById(R.id.stats3);

        Button addRetailer = (Button) findViewById(R.id.retailer_add);

        addRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page;
                home_page = new Intent(getApplicationContext(), add_retailer.class);
                startActivity(home_page);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_from_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, add_retailer.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

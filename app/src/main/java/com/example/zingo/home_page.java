package com.example.zingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;

import Adapters.RetailersAdapter;
import POJOs.RetailerElements;

public class home_page extends AppCompatActivity {

    public static final String TAG = "pikachu";

    ArrayList<RetailerElements> rtList = new ArrayList<>();
    RetailersAdapter retailersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        final TextView name, license, phone, email, region, address;
        license = (TextView) findViewById(R.id.license_no);
        phone = (TextView) findViewById(R.id.wh_number);
        email = (TextView) findViewById(R.id.wh_mail);
        address = (TextView) findViewById(R.id.address);
        region = findViewById(R.id.region);

        RecyclerView rvRetailers = findViewById(R.id.rvRetailers);
        rvRetailers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        retailersAdapter = new RetailersAdapter(rtList);
        rvRetailers.setAdapter(retailersAdapter);

        refreshRV();
        retailersAdapter.notifyDataSetChanged();


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("distributors").child("d1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                license.setText("License No.: " + dataSnapshot.child("licenseno").getValue().toString());
                phone.setText("Phone No.: " + dataSnapshot.child("contact").getValue().toString());
                email.setText("Email Id: "+dataSnapshot.child("email").getValue().toString());
                address.setText("Address: "+dataSnapshot.child("address").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Button addRetailer = (Button) findViewById(R.id.retailer_add);
        Button seeCart = findViewById(R.id.btSeeCart);

        addRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(getApplicationContext(), add_retailer.class);
                startActivity(i);
            }
        });

        seeCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewCart.class);
                startActivity(i);
            }
        });

    }


    private void refreshRV() {
        Log.d(TAG, "refreshRV: Refreshing Recycler view");
        rtList.clear();
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("distributors").child("d1").child("retailers");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    RetailerElements temp = new RetailerElements();
                    temp.setRtId(dataSnapshot1.getKey());
                    temp.setRtName(dataSnapshot1.child("name").getValue().toString());
                    temp.setRtContact(dataSnapshot1.child("contact").getValue().toString());
                    temp.setRtAddress(dataSnapshot1.child("address").getValue().toString());
                    rtList.add(temp);
                }
                retailersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
//            Intent settingsIntent = new Intent(this, add_retailer.class);
//            startActivity(settingsIntent);
            //TODO : implement change password
            return true;
        }
        else if(id==R.id.action_viewRetailers)
        {
            //TODO : Send intent to retailer
            return true;
        }
        else if(id==R.id.action_goto_policies)
        {
            Intent settingsIntent = new Intent(this, e_waste.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

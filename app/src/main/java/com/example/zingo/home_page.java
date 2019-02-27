package com.example.zingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    String phNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent receivedIntent = getIntent();
        phNumber = receivedIntent.getStringExtra("phNumber");

        final TextView name,licence,phone,email,region,address;
        name = (TextView)findViewById(R.id.wh_name);
        licence = (TextView)findViewById(R.id.license_no);
        phone = (TextView)findViewById(R.id.wh_number);
        email = (TextView)findViewById(R.id.wh_mail);
        address = (TextView)findViewById(R.id.address);
        region = findViewById(R.id.region);

        RecyclerView rvRetailers = findViewById(R.id.rvRetailers);
        rvRetailers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        retailersAdapter = new RetailersAdapter(rtList);
        rvRetailers.setAdapter(retailersAdapter);

        refreshRV();
        retailersAdapter.notifyDataSetChanged();


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
                +", "+dataSnapshot.child("city").getValue().toString() + ", "
                +dataSnapshot.child("state").getValue().toString() + ", "+
                        dataSnapshot.child("pincode").getValue().toString());
                region.setText(dataSnapshot.child("region").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button addRetailer = (Button)findViewById(R.id.retailer_add);

        addRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page;
               home_page = new Intent(getApplicationContext(),add_retailer.class);
               home_page.putExtra("phNumber", phNumber);
                  startActivity(home_page);
            }
        });

    }

    private void refreshRV() {
        rtList.clear();
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("Distributors").child(phNumber).child("Retailers");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    RetailerElements temp = new RetailerElements();
                    temp.setRtId(dataSnapshot1.getKey());
                    temp.setRtName(dataSnapshot1.child("rtName").getValue().toString());
                    temp.setRtContact(dataSnapshot1.child("rtContact").getValue().toString());
                    temp.setRtAddress(dataSnapshot1.child("rtAddress").getValue().toString());
                    rtList.add(temp);
                }
                retailersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

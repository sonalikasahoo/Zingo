package com.example.zingo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import POJOs.RetailerDetails;

public class add_retailer extends AppCompatActivity {

    public static final String TAG = "pikachu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_retailer);

        Intent receivedIntent = getIntent();

        final EditText name,number,address,uid;
        uid = (EditText)findViewById(R.id.retailer_id);
        name = (EditText)findViewById(R.id.name_retail);
        number = (EditText)findViewById(R.id.number_retail);
        address = (EditText)findViewById(R.id.address_retail);

        Button retailer = (Button)findViewById(R.id.retailer_add);
        retailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: add retailer in addretailer");
                final String rtId = name.getText().toString();
                final String rtName = name.getText().toString();
                final String rtContact = number.getText().toString();
                final String rtAddress = address.getText().toString();

                final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference().child("Distributors").child("d1");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        RetailerDetails rd = new RetailerDetails();
                        rd.setName(rtName);
                        rd.setContact(rtContact);
                        rd.setAddress(rtAddress);
                        Log.d(TAG, "onDataChange: Adding Retailer");
                        databaseReference.child("Retailers").child(rtId)
                                .setValue(rd);
                        Toast.makeText(add_retailer.this, "Retailer details addded!",
                                Toast.LENGTH_SHORT).show();

                        Intent retailer;
                        retailer= new Intent(getApplicationContext(),home_page.class);
                        startActivity(retailer);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
    }
}

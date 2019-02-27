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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import POJOs.DistributorDetails;

public class signup extends AppCompatActivity {

    public static final String TAG = "pikachu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        final EditText etName, etContact, etEmail, etRegion, etAddress1, etPincode, etCity;
        final EditText etState, etLicense;
        Button btSubmit;
        etName = findViewById(R.id.name);
        etContact = findViewById(R.id.contact);
        etEmail = findViewById(R.id.email);
        etRegion = findViewById(R.id.region);
        etAddress1 = findViewById(R.id.address1);
        etPincode = findViewById(R.id.pincode);
        etCity = findViewById(R.id.city);
        etState = findViewById(R.id.state);
        etLicense = findViewById(R.id.license);
        btSubmit = findViewById(R.id.submit);



        final FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();



        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                final String contact = etContact.getText().toString();
                final String email = etEmail.getText().toString();
                final String region = etRegion.getText().toString();
                final String address1 = etRegion.getText().toString();
                final String pincode = etPincode.getText().toString();
                final String city = etCity.getText().toString();
                final String state = etState.getText().toString();
                final String license = etLicense.getText().toString();


                Log.d(TAG, "onClick: submit");
                final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference().child("Distributors");





                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d(TAG, "onDataChange: ");
                        if(dataSnapshot.child("Distributors").hasChild("+91"+contact)) {
                            etContact.setText("");
                            Toast.makeText(signup.this, "Number already registered", Toast.LENGTH_SHORT).show();
                        } else {

                            Log.d(TAG, "onDataChange: else part");
                            boolean empty = false;

                            if((name.equals("")) || (contact.equals("")) || (region.equals(""))
                                    || (email.equals("")) || (address1.equals(""))
                                    || pincode.equals("") || city.equals("") || state.equals("")
                                    || license.equals("")) {
                                Toast.makeText(signup.this, "One or More fields are empty", Toast.LENGTH_SHORT).show();
                                empty = true;
                            }

                            //TODO : push the details to firebase clouds;

                            Log.d(TAG, "onDataChange: "+empty);
                            if(empty==false)
                            {
                                DistributorDetails dd = new DistributorDetails();
                                dd.setName(name);
                                dd.setEmail(email);
                                dd.setRegion(region);
                                dd.setAddress1(address1);
                                dd.setPincode(pincode);
                                dd.setCity(city);
                                dd.setState(state);
                                dd.setLicense(license);
                                databaseReference.child("+91"+contact).setValue(dd);

                                Toast.makeText(signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();


                                Intent i = new Intent(signup.this, MainActivity.class);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });


    }
}

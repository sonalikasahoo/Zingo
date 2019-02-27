package com.example.zingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        EditText etName, etContact, etEmail, etRegion, etAddress1, etPincode, etCity;
        EditText etState, etLicense;
        Button btSubmit;
        etName = findViewById(R.id.name);
        etContact = findViewById(R.id.contact);
        etEmail = findViewById(R.id.email);
        etRegion = findViewById(R.id.address1);
        etPincode = findViewById(R.id.pincode);
        etCity = findViewById(R.id.city);
        etState = findViewById(R.id.state);
        etLicense = findViewById(R.id.license);
        btSubmit = findViewById(R.id.submit);



    }
}

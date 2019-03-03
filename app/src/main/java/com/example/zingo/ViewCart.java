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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapters.CartAdapter;
import POJOs.CartElements;

public class ViewCart extends AppCompatActivity {


    ArrayList<CartElements> cartList = new ArrayList<>();
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        Log.d("abc", "onCreate: cart started");

        RecyclerView rvCart = findViewById(R.id.rvCart);
        rvCart.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        cartAdapter = new CartAdapter(cartList);
        rvCart.setAdapter(cartAdapter);

        refreshRV();
        cartAdapter.notifyDataSetChanged();

        Button btInitiate = findViewById(R.id.initiate);
        btInitiate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewCart.this, "Return Request Initiated",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ViewCart.this, home_page.class);
                startActivity(i);
            }
        });
    }
    private void refreshRV() {
        Log.d("abc", "refreshRV: Refreshing cart Recycler view");
        cartList.clear();
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("Returns");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CartElements temp = new CartElements();
                    Log.d("abc", "onDataChange: "+dataSnapshot1.getValue());
                    Log.d("abc", "onDataChange: "+dataSnapshot1.child("ret1").getValue().toString().equals(""));
                    if(dataSnapshot1.child("ret1").getValue().toString().equals("")) {
                        Log.d("abc", "onDataChange: list add");
                        if(dataSnapshot1.child("barcode").getValue().equals(null) ||
                                dataSnapshot1.child("batchno").getValue().equals(null) ||
                                dataSnapshot1.child("exp").getValue().equals(null) ||
                                dataSnapshot1.child("mfg").getValue().equals(null) ||
                                dataSnapshot1.child("mrp").getValue().equals(null) ||
                                dataSnapshot1.child("pname").getValue().equals(null))
                            break;
                        temp.setBarcode("Barcode: " + dataSnapshot1.child("barcode").getValue().toString());
                        temp.setBatchno("Batch Number: " + dataSnapshot1.child("batchno").getValue().toString());
                        temp.setExp("Expiry Date: " + dataSnapshot1.child("exp").getValue().toString());
                        temp.setMfg("Manufacture Date: " + dataSnapshot1.child("mfg").getValue().toString());
                        temp.setMrp("MRP: " + dataSnapshot1.child("mrp").getValue().toString());
                        temp.setPname("Product Name: " + dataSnapshot1.child("pname").getValue().toString());
                        temp.setReturnId("Return Id: "+dataSnapshot1.getKey());
                        cartList.add(temp);
                    }
                }
                cartAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

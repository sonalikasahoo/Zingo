package com.example.zingo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapters.CartAdapter;
import Adapters.RetailersAdapter;
import POJOs.CartElements;
import POJOs.RetailerElements;

public  class cart_view extends AppCompatActivity {

    ArrayList<CartElements> cartList = new ArrayList<>();
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        Log.d("abc", "onCreate: cart started");

        RecyclerView rvCart = findViewById(R.id.rvCart);
        rvCart.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        cartAdapter = new CartAdapter(cartList);
        rvCart.setAdapter(cartAdapter);

        refreshRV();
        cartAdapter.notifyDataSetChanged();

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
                    if(dataSnapshot1.child("ret1").getValue().equals("")) {
                        temp.setBarcode(dataSnapshot1.child("barcode").getValue().toString());
                        temp.setBatchno(dataSnapshot1.child("batchno").getValue().toString());
                        temp.setExp(dataSnapshot1.child("exp").getValue().toString());
                        temp.setMfg(dataSnapshot1.child("mfg").getValue().toString());
                        temp.setMrp(dataSnapshot1.child("mrp").getValue().toString());
                        temp.setPname(dataSnapshot1.child("pname").getValue().toString());
                        temp.setReturnId(dataSnapshot1.child("returnId").getValue().toString());
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

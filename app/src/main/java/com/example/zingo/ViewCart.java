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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import Adapters.CartAdapter;
import POJOs.CartElements;

public class ViewCart extends AppCompatActivity {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
              //  urlParameters.put("phone", "7503917865");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by distributor D1 to Hindustan Unilever limited, on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
                //  Log.d("xyz", "run: message1");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
               // urlParameters.put("phone", "8375860629");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by distributor D1 to Hindustan Unilever limited on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
                //  Log.d("xyz", "run : A Return with Return ID______, is initiated by retailer _______, to distributor __________, on Date_______.\nFor more information contact 9561278478");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });
    Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
              //  urlParameters.put("phone", "9560213528");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by distributor D1 to Hindustan Unilever limited on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
                Log.d("xyz", "run: message3");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });


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
                t1.start();
                Log.d("abc", "onClick: thread1");
                t2.start();
                Log.d("abc", "onClick: thread2");
                t3.start();
                Log.d("abc", "onClick: thread3");
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

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

import com.google.android.gms.common.oob.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText etPhNum, etVeriCode;
    Button btGetCode, btLogin, btSignUp;

    FirebaseAuth mAuth;

    String codeSent;
    public static final String TAG = "pikachu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: MainActivity started");

        mAuth = FirebaseAuth.getInstance();

        etPhNum = findViewById(R.id.etphNum);
        etVeriCode = findViewById(R.id.etVeriCode);
        btGetCode = findViewById(R.id.btGetCode);
        btLogin = findViewById(R.id.btLogin);
        btSignUp = findViewById(R.id.btSignup);


        /*btGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference().child("Distributors");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.hasChild("+91"+etPhNum.getText().toString())) {
                            Toast.makeText(MainActivity.this, "Phone number not registered",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            sendVerificationCode();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });*/

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifySignInCode();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference().child("Distributors");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.hasChild("+91"+etPhNum.getText().toString())) {
                            Toast.makeText(MainActivity.this, "Phone number not registered",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //sendVerificationCode();
                            Intent i = new Intent(MainActivity.this, home_page.class);
                            i.putExtra("phNumber", "+91"+etPhNum.getText().toString());
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, signup.class);
                startActivity(i);
            }
        });

    }

    private void verifySignInCode() {
        String code = etVeriCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "Successfully Logged In!",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = task.getResult().getUser();
                            FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
                            Log.d(TAG, "onComplete: "+user);
                            Log.d(TAG, "onComplete: display name "+user1.getDisplayName());
                            Log.d(TAG, "onComplete: email "+user1.getEmail());
                            Log.d(TAG, "onComplete: phone number "+user1.getPhoneNumber());
                            Log.d(TAG, "onComplete: provider id "+user1.getProviderId());
                            Log.d(TAG, "onComplete: uid "+user1.getUid());
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(), "Could not Log In",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void sendVerificationCode() {
        String phoneNumber = "+91"+etPhNum.getText().toString();
        Log.d(TAG, "sendVerificationCode: sent");
        if(phoneNumber.isEmpty()) {
            etPhNum.setError("Phone number is required");
            etPhNum.requestFocus();
            return;
        }

        if(phoneNumber.length() < 10) {
            etPhNum.setError("Enter valid phone number");
            etPhNum.requestFocus();
            return;
        }
        Log.d(TAG, "sendVerificationCode: "+phoneNumber);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber,
                60, TimeUnit.SECONDS, this, mCallbacks);
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            Log.d(TAG, "onVerificationCompleted: "+"completed");
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
            Log.d(TAG, "onCodeSent: "+codeSent);
        }
    };
}
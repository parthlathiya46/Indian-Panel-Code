package com.example.admin.calendarview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Database extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mFirebaseAuth;

    TextView mTextView1;
    TextView mTextView2;

    public Database() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        mTextView1.setText("Maruti Suzuki Baleno");
        mTextView2.setText("Price for 1 Day is : 1500₹");
        String s1= "Maruti suzuki Baleno";
        String s2 = "Payment :1500";
        mFirebaseAuth = FirebaseAuth.getInstance();
        if (mFirebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser User = mFirebaseAuth.getCurrentUser();
        info i = new info(s1,s2);
        mDatabaseReference.child(User.getUid()).setValue(i);
    }
}

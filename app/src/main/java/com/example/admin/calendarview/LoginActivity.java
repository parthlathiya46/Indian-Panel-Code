package com.example.admin.calendarview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText memail, mpass;
    private Button mlogin;
    private TextView malready;
    private ProgressDialog mProgressDialog;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        if(null != mFirebaseAuth.getCurrentUser())
        {
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }
        memail = (EditText) findViewById(R.id.Email);
        mProgressDialog = new ProgressDialog(this);
        mpass = (EditText) findViewById(R.id.pass);
        mlogin = (Button) findViewById(R.id.Loginbutton);
        malready = (TextView) findViewById(R.id.Signin);

        mlogin.setOnClickListener(v -> {
            userSignin();
        });
        malready.setOnClickListener(view -> {
            finish();
            startActivity(new Intent(this,SignUp.class));
        });

    }

    private void userSignin() {
        String mEmailOfUser = memail.getText().toString();
        String mPassOfUser = mpass.getText().toString();
        if (TextUtils.isEmpty(mEmailOfUser)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(mPassOfUser)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }

        mProgressDialog.setMessage("Login User...");
        mProgressDialog.show();

        mFirebaseAuth.signInWithEmailAndPassword(mEmailOfUser,mPassOfUser).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mProgressDialog.dismiss();
                if(task.isComplete()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
            }
        });



    }
}

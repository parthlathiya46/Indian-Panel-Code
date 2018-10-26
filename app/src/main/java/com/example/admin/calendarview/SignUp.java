package com.example.admin.calendarview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email, pass;
    Button sign;
    TextView signin;
    ProgressDialog mProgressDialog;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        if (mFirebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
        email = (EditText) findViewById(R.id.Email);
        pass = (EditText) findViewById(R.id.pass);
        sign = (Button) findViewById(R.id.button);
        signin = (TextView) findViewById(R.id.Signin);
        mProgressDialog = new ProgressDialog(this);

        sign.setOnClickListener(v -> {
            RegisterUser();
        });

        signin.setOnClickListener(view -> {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        });
    }

    private void RegisterUser() {
        String Email = email.getText().toString();
        String Pass = pass.getText().toString();
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(Pass)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }

        mProgressDialog.setMessage("Registering User...");
        mProgressDialog.show();

        mFirebaseAuth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(this, task -> {
            mProgressDialog.dismiss();
            if (task.isComplete()) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            } else {
                Toast.makeText(SignUp.this, "Could Not Registered... Please Try Again", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


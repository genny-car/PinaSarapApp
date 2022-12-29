package com.app.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.appdevproject.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    //initialization
    Button btnsignup, btnreg;
    EditText txtfname,txtlname,txtuser, txtemail, txtpass, txtconpass;

    //initialization authentication
    FirebaseAuth mAuth;
    //intialization database
    ActivityMainBinding binding;
    String fname,lname,username,email,password;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtfname = findViewById(R.id.txtfname);
        txtlname = findViewById(R.id.txtlname);
        txtuser = findViewById(R.id.txtuser);
        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpass);
        txtconpass = findViewById(R.id.txtconpass);

        mAuth =FirebaseAuth.getInstance();
        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnreg = (Button) findViewById(R.id.btnreg);

        btnsignup.setOnClickListener(view -> {
            createUser();
        });


        btnreg.setOnClickListener(view ->{
            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
        });


    }
    private void createUser(){
        String fname = txtfname.getText().toString();
        String lname = txtlname.getText().toString();
        String username = txtuser.getText().toString();
        String email = txtemail.getText().toString();
        String password = txtpass.getText().toString();
        String confirmpass = txtconpass.getText().toString();

        if(TextUtils.isEmpty(email)){
            txtemail.setError("No Email Found");
            txtemail.requestFocus();
        }else if(TextUtils.isEmpty(password)) {
            txtpass.setError("No Password Found");
            txtpass.requestFocus();
        }else if (TextUtils.isEmpty(username)){
            txtuser.setError("No Username Found");
            txtuser.requestFocus();
        }else if (TextUtils.isEmpty(fname)){
            txtuser.setError("No First Name Found");
            txtuser.requestFocus();
        }else if (TextUtils.isEmpty(lname)){
            txtuser.setError("No Last Name Found");
            txtuser.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
                    }else{
                        Toast.makeText(SignUpActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
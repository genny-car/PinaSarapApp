package com.app.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    //initialization
    Button btnsignup;
    EditText txtfname,txtlname,txtuser, txtemail, txtpass;

    FirebaseUser user;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtfname = findViewById(R.id.txtfname);
        txtlname = findViewById(R.id.txtlname);
        txtuser = findViewById(R.id.txtuser);
        txtemail = findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpass);

        mAuth = FirebaseAuth.getInstance();
        btnsignup = (Button) findViewById(R.id.btnsignup);



        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fnametxt = txtfname.getText().toString();
                String lnametxt= txtlname.getText().toString();
                String usernametxt = txtuser.getText().toString();
                String emailtxt = txtemail.getText().toString();
                String passwordtxt = txtpass.getText().toString();

                if (TextUtils.isEmpty(emailtxt)) {
                    txtemail.setError("No Email Found");
                    txtemail.requestFocus();
                } else if (TextUtils.isEmpty(passwordtxt)) {
                    txtpass.setError("No Password Found");
                    txtpass.requestFocus();
                } else if (TextUtils.isEmpty(usernametxt)) {
                    txtuser.setError("No Username Found");
                    txtuser.requestFocus();
                } else if (TextUtils.isEmpty(fnametxt)) {
                    txtuser.setError("No First Name Found");
                    txtuser.requestFocus();
                } else if (TextUtils.isEmpty(lnametxt)) {
                    txtuser.setError("No Last Name Found");
                    txtuser.requestFocus();
                }else {
                    mAuth.createUserWithEmailAndPassword(emailtxt,passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){ user = FirebaseAuth.getInstance().getCurrentUser();
                               profdata prof = new profdata(fnametxt,lnametxt,usernametxt,emailtxt,passwordtxt);
                               db.getInstance().getReference("profdata").child(user.getUid())
                                       .setValue(prof).addOnCompleteListener(new OnCompleteListener<Void>() {
                                           @Override
                                           public void onComplete(@NonNull Task<Void> task) {
                                               Toast.makeText(SignUpActivity.this, "Regisetered Successfully", Toast.LENGTH_SHORT).show();
                                               startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                                           }
                                       });
                            }else{
                                Toast.makeText(SignUpActivity.this, "Error has Occurred", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

        }
});
}
}



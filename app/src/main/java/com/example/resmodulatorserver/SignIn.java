package com.example.resmodulatorserver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import Common.Common;
import Model.User;
import info.hoang8f.widget.FButton;

public class SignIn extends AppCompatActivity {
    EditText edtStaffNo,edtPassword;
    Button btnSignIn;

    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);
        edtStaffNo=(MaterialEditText)findViewById(R.id.edtStaffNo);

        btnSignIn=(FButton)findViewById(R.id.btnSignIn);
        db=FirebaseDatabase.getInstance();
        users=db.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser(edtStaffNo.getText().toString(),edtPassword.getText().toString());
            }
        });
    }

    private void signInUser(String staffNo, String password) {
        ProgressDialog mDialog = new ProgressDialog(SignIn.this);
        mDialog.setMessage("Please wait...");
        mDialog.show();

        final String localstaffNo=staffNo;
        final String localPassword=password;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(localstaffNo).exists())
                {
                    mDialog.dismiss();
                    User user =dataSnapshot.child(localstaffNo).getValue(User.class);
                    user.setStaffNo(localstaffNo);
                        if(Boolean.parseBoolean(user.getIsStaff())) //if is staff is true
                        {
                            if(user.getPassword().equals(localPassword))
                            {
                                Intent login = new Intent(SignIn.this,Home.class);
                                Common.currentUser=user;
                                startActivity(login);
                                finish();

                            }
                            else Toast.makeText(SignIn.this, "Wrong password!", Toast.LENGTH_SHORT).show();



                        }
                        else Toast.makeText(SignIn.this, "Not Authorized .Please Login with Staff Account", Toast.LENGTH_SHORT).show();
                }

                else
                    mDialog.dismiss();
                    Toast.makeText(SignIn.this, "Welcome ", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
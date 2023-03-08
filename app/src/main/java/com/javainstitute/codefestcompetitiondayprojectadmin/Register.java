package com.javainstitute.codefestcompetitiondayprojectadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.javainstitute.codefestcompetitiondayprojectadmin.model.Admin;

public class Register extends AppCompatActivity {

    Button registerButton;
    EditText email,name,mobile,address,shopName;

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseFirestore = FirebaseFirestore.getInstance();

        registerButton = findViewById(R.id.registerButton);
        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        mobile = findViewById(R.id.editTextPhone);
        address = findViewById(R.id.editTextTextMultiLine);
        shopName = findViewById(R.id.editTextTextShopName);

        Bundle bundle = getIntent().getExtras();
        String nameValue =bundle.getString("name");
        String emailValue = bundle.getString("email");
        String authID = bundle.getString("UID");

        name.setText(nameValue);
        email.setText(emailValue);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePara = name.getText().toString();
                String emailPara = email.getText().toString();
                String mobilePara = mobile.getText().toString();
                String addressPara = address.getText().toString();
                String shopNamePara = shopName.getText().toString();

                Admin admin = new Admin();
                admin.setAdminName(namePara);
                admin.setEmail(emailPara);
                admin.setTelephone(mobilePara);
                admin.setAddress(addressPara);
                admin.setGoogleId(authID);
                admin.setShopName(shopNamePara);
                admin.setStatus(1);

                firebaseFirestore.collection("Admin").add(admin).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        String customerId = documentReference.getId();
                        Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Register.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this,"Registered Unsuccessfully",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
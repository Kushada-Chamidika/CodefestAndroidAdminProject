package com.javainstitute.codefestcompetitiondayprojectadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.javainstitute.codefestcompetitiondayprojectadmin.model.eventModel;

import java.util.Date;

public class newsFeed extends AppCompatActivity {

    private static final int NUMBER_ICON = 100;
    Button selectFile, addEvent;

    EditText title, Description;
    RadioButton option1, option2, option3;
    private String result;
    private Uri fileURI;

    StorageReference storageRef;
    private String email;
    private String mobile;
    private String shopName;

    FirebaseFirestore firebaseFirestore;
    private String fileURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageRef = FirebaseStorage.getInstance().getReference();

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        shopName = intent.getStringExtra("shopName");
        mobile = intent.getStringExtra("mobile");

        selectFile = findViewById(R.id.addProductImageButton);


        addEvent = findViewById(R.id.addProductButton);

        option1 = findViewById(R.id.radioButton);
        option2 = findViewById(R.id.radioButton2);
        option3 = findViewById(R.id.radioButton3);

        title = findViewById(R.id.textViewProName);
        Description = findViewById(R.id.editTextTextMultiLine2);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        result = "Information";
                        break;
                    case R.id.radioButton2:
                        result = "Offer";
                        break;
                    case R.id.radioButton3:
                        result = "Sale";
                        break;
                }
            }
        });

        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Product's Photo"), NUMBER_ICON);
            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleVal = title.getText().toString();
                String descVal = Description.getText().toString();

                 fileURL = "ProductImage_" + new Date() + ".png";
                if(fileURI!=null){

                    storageRef.child("Files/" + fileURL).putFile(fileURI).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Toast.makeText(Home.this, "Product Image Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Home.this, "Product Image Upload Fail", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        }
                    });

                }


                eventModel eventModel = new eventModel();
                eventModel.setDescription(descVal);
                eventModel.setTitle(titleVal);
                eventModel.setCreatedDate(new Date());
                eventModel.setEmail(email);
                eventModel.setMobile(mobile);
                eventModel.setShopName(shopName);
                eventModel.setImagePath(fileURL);
                eventModel.setStatus("News");
                eventModel.setType(result);

                firebaseFirestore.collection("Events").add(eventModel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(newsFeed.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                        title.setText("");
                        Description.setText("");
                        fileURL = "";

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(newsFeed.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                        title.setText("");
                        Description.setText("");
                        fileURL = "";
                    }
                });


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NUMBER_ICON) {

            if (resultCode == RESULT_OK) {

                fileURI = data.getData();

            } else {
                Toast.makeText(newsFeed.this, "Image Cannot Load", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
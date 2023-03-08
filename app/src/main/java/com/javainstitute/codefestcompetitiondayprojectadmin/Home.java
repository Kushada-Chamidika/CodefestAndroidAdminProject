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
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.javainstitute.codefestcompetitiondayprojectadmin.model.Product;
import com.squareup.picasso.Picasso;

import java.util.Date;

public class Home extends AppCompatActivity {

    private static final int PRODUCT_IMAGE = 100;

    TextView shopNameText, emailtext, userNametext;
    EditText productName, productPrice;
    ImageView productimage;
    Button logOutButton, addNewsFeed, viewTicekts, selectProductImage, addProduct;

    FirebaseFirestore firebaseFirestore;

    private Uri productImageUri;

    StorageReference storageRef;

    String googleId;
    private String namePara;
    private String emailPara;
    private String shopName;
    private String userDocId;
    private String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        selectProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Product's Photo"), PRODUCT_IMAGE);
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        viewTicekts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ViewTickets.class);
                startActivity(intent);
            }
        });

        addNewsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, AddNewsFeed.class);
                intent.putExtra("email",emailtext.getText().toString());
                intent.putExtra("shopName",shopNameText.getText().toString());
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });

        viewTicekts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, checkNews.class);
                intent.putExtra("email",emailtext.getText().toString());
                intent.putExtra("shopName",shopNameText.getText().toString());
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductMeth();
            }
        });

    }

    private void addProductMeth() {

        String productNameValue = productName.getText().toString();
        double productPriceValue = Double.parseDouble(productPrice.getText().toString());
        String shopOwnerNameValue = userNametext.getText().toString();
        String shopNameValue = shopNameText.getText().toString();
        String emailValue = emailtext.getText().toString();
        String telephoneValue = mobile;
        Date dateValue = new Date();


        String imageProductUrl = "ProductImage_" + dateValue + ".png";
        storageRef.child("ProductImages/" + imageProductUrl).putFile(productImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
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

        Product product = new Product();
        product.setProductName(productNameValue);
        product.setCreatedDate(dateValue);
        product.setEmail(emailValue);
        product.setMobile(telephoneValue);
        product.setOwnerName(shopOwnerNameValue);
        product.setProductImagePath(imageProductUrl);
        product.setProductPrice(productPriceValue);
        product.setShopName(shopNameValue);
        product.setStatus("Product_Placed");

        firebaseFirestore.collection("Products").add(product).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Home.this, "Product Registered Successfully", Toast.LENGTH_SHORT).show();

                productimage.setImageDrawable(null);
                productName.setText("");
                productPrice.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Home.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                productimage.setImageResource(ImageView.NO_ID);
                productName.setText("");
                productPrice.setText("");
            }
        });

    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(Home.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

    private void init() {

        Intent intent = getIntent();
        namePara = intent.getStringExtra("name");
        emailPara = intent.getStringExtra("email");
        shopName = intent.getStringExtra("shopName");
        userDocId = intent.getStringExtra("userId");
        googleId = intent.getStringExtra("UID");
        mobile = intent.getStringExtra("mobile");

        System.out.println(shopName);

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageRef = FirebaseStorage.getInstance().getReference();

        productimage = findViewById(R.id.productImage);
        productName = findViewById(R.id.textViewProName);
        productPrice = findViewById(R.id.pricetTextFeild);

        logOutButton = findViewById(R.id.logOutButton);
        addNewsFeed = findViewById(R.id.addNewsFeedButton);
        viewTicekts = findViewById(R.id.viewTicketsButton);
        selectProductImage = findViewById(R.id.addProductImageButton);
        addProduct = findViewById(R.id.addProductButton);

        shopNameText = findViewById(R.id.homeShopNameTextView);
        emailtext = findViewById(R.id.homeEmailTextView);
        userNametext = findViewById(R.id.homeAdminNameTextView);

        shopNameText.setText(shopName);
        emailtext.setText(emailPara);
        userNametext.setText(namePara);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PRODUCT_IMAGE) {

            if (resultCode == RESULT_OK) {

                productImageUri = data.getData();

                Picasso.get().load(productImageUri).into(productimage);
            } else {
                Toast.makeText(Home.this, "Image Cannot Load", Toast.LENGTH_SHORT).show();
            }

        }

    }

}
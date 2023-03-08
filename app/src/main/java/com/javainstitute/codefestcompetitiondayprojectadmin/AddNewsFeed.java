package com.javainstitute.codefestcompetitiondayprojectadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewsFeed extends AppCompatActivity {

    Button addNewsfeed,addEvent;
    private String mobile;
    private String shopName;
    private String emailPara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news_feed);

        addEvent = findViewById(R.id.addEventButton);
        addNewsfeed = findViewById(R.id.addNormalNewsFeed);

        Intent intent = getIntent();
        emailPara = intent.getStringExtra("email");
        shopName = intent.getStringExtra("shopName");
        mobile = intent.getStringExtra("mobile");

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddNewsFeed.this,Event.class);
                intent.putExtra("email",emailPara);
                intent.putExtra("shopName",shopName);
                intent.putExtra("mobile",mobile);
                startActivity(intent);

            }
        });

        addNewsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddNewsFeed.this,newsFeed.class);
                intent.putExtra("email",emailPara);
                intent.putExtra("shopName",shopName);
                intent.putExtra("mobile",mobile);
                startActivity(intent);

            }
        });

    }
}
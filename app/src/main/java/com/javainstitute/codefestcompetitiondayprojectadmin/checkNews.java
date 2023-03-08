package com.javainstitute.codefestcompetitiondayprojectadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;
import com.javainstitute.codefestcompetitiondayprojectadmin.adapters.jobHolder;
import com.javainstitute.codefestcompetitiondayprojectadmin.model.ticket;

public class checkNews extends AppCompatActivity {

    RecyclerView recyclerView;

    FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter<ticket, jobHolder> recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_news);

        firebaseFirestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recView);

        Query query = firebaseFirestore.collection("Tickets");
        FirestoreRecyclerOptions firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<ticket>().setQuery(query, ticket.class).build();

        recyclerAdapter = new FirestoreRecyclerAdapter<ticket, jobHolder>(firestoreRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull jobHolder holder, int position, @NonNull ticket model) {
                holder.title.setText(model.getTitle());
                holder.date.setText(model.getCreatedDate().toString());
                holder.desc.setText(model.getDescription());
                holder.type.setText(model.getType());
                holder.mobile.setText(model.getMobile());
                holder.email.setText(model.getEmail());
            }

            @NonNull
            @Override
            public jobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item, parent, false);
                return new jobHolder(view);
            }

        };

        recyclerView.setLayoutManager(new LinearLayoutManager(checkNews.this));
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerAdapter.stopListening();
    }

}
package com.javainstitute.codefestcompetitiondayprojectadmin.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javainstitute.codefestcompetitiondayprojectadmin.R;


public class jobHolder extends RecyclerView.ViewHolder {

    public final TextView title,date,desc,type,mobile,email;

    public jobHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleText);
        date = itemView.findViewById(R.id.dateText);
        desc = itemView.findViewById(R.id.descText);
        type = itemView.findViewById(R.id.typeText);
        mobile = itemView.findViewById(R.id.mobileText);
        email = itemView.findViewById(R.id.emailText);

    }
}

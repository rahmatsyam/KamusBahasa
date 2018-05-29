package com.example.user.kamusbahasa;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.TextView;

public class Toast {

    Context context;

    public void showToast() {


        //LayoutInflater inflater = getLayoutInflater();
        //View layout = inflater.inflate(R.layout.custom_toast,
          //      (ViewGroup) findViewById(R.id.custom_toast_container));
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
        TextView text = layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(android.widget.Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}


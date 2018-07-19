package com.example.user.kamusbahasa.utils;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.user.kamusbahasa.MainActivity;
import com.example.user.kamusbahasa.R;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    LayoutInflater inflater;
    AlertDialog.Builder Builder;
    View dialogView;

    public void hiddenKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @SuppressLint("InflateParams")
    public void DialogForm() {

        Builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_about, null);
        Builder.setView(dialogView);
        Builder.setCancelable(true);
        Builder.setIcon(R.mipmap.ic_launcher);
        Builder.show();


    }

}

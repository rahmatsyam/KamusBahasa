package com.example.user.kamusbahasa;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.user.kamusbahasa.helper.DatabaseHelper;
import com.mancj.materialsearchbar.MaterialSearchBar;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    public EditText txtInggris, txtArab;
    String inputan;
    private MaterialSearchBar txtIndonesia;

    LayoutInflater inflater;
    AlertDialog.Builder Builder;
    View dialogView;

    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";

    Button btnTerjemahan;
    com.example.user.kamusbahasa.Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper dataKamus = new DatabaseHelper(this);
        db = dataKamus.getWritableDatabase();
        dataKamus.createTable(db);
        dataKamus.generateData(db);

        setContentView(R.layout.activity_main);


        txtIndonesia = findViewById(R.id.txtIndonesia);
        txtInggris = findViewById(R.id.txtInggris);
        txtArab = findViewById(R.id.txtArab);

        btnTerjemahan = findViewById(R.id.btnTerjemah);
        btnTerjemahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTerjemahan();
            }
        });


    }

    public void getTerjemahan() {
        inputan = txtIndonesia.getText();
        if (inputan.equals("")) {
            Toast.makeText(getBaseContext(), "Masukkan kata terlebih dahulu", Toast.LENGTH_SHORT).show();
        } else {

            String bhsinggris = "";
            String bhsarab = "";
            String indonesiaword = txtIndonesia.getText();

            kamusCursor = db.rawQuery("SELECT kamus_id, INDONESIA, INGGRIS, ARAB FROM kamus where INDONESIA='"
                    + indonesiaword
                    + "' ORDER BY INDONESIA", null);

            if (kamusCursor.moveToFirst()) {
                for (; !kamusCursor.isAfterLast();
                     kamusCursor.moveToNext()) {
                    bhsinggris = kamusCursor.getString(2);
                    bhsarab = kamusCursor.getString(3);
                }
            } else {
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtInggris.setText(bhsinggris);
            txtArab.setText(bhsarab);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_filter:
                DialogForm();
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            kamusCursor.close();
            db.close();
        } catch (Exception ignored) {

        }
    }

    @SuppressLint("InflateParams")
    private void DialogForm() {

        Builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_about, null);
        Builder.setView(dialogView);
        Builder.setCancelable(true);
        Builder.setIcon(R.mipmap.ic_launcher);
        Builder.show();


    }


}

package com.example.user.kamusbahasa;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.kamusbahasa.helper.DatabaseHelper;

public class TambahKata extends AppCompatActivity {

    private SQLiteDatabase db = null;
    DatabaseHelper dataKamus = null;

    private EditText ETindonesia;
    private EditText ETinggris;
    private EditText ETarab;

    public static final String INDONESIA = "indonesia";
    public static final String INGGRIS = "inggris";
    public static final String ARAB = "arab";

    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataKamus = new DatabaseHelper(this);
        db = dataKamus.getWritableDatabase();
        setContentView(R.layout.activity_tambah_kata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ETindonesia = findViewById(R.id.txtIndonesia);
        ETinggris = findViewById(R.id.txtInggris);
        ETarab = findViewById(R.id.txtArab);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanKata();
            }
        });


    }

    public void simpanKata() {

        String bhsindonesia = ETindonesia.getText().toString();
        String bhsinggris = ETinggris.getText().toString();
        String bhsarab = ETarab.getText().toString();
        if (bhsindonesia.equals("") || bhsinggris.equals("") || bhsarab.equals("")) {
            Toast.makeText(getBaseContext(), "Silahkan isi terlebih dahulu", Toast.LENGTH_LONG).show();
        } else {

            ContentValues cv = new ContentValues();
            cv.put(INDONESIA, bhsindonesia);
            cv.put(INGGRIS, bhsinggris);
            cv.put(ARAB, bhsarab);
            if (db.insert("kamus", INDONESIA, cv) > 0 && db.insert("kamus", INGGRIS, cv) > 0 &&
                    db.insert("kamus", ARAB, cv) > 0) {
                Toast.makeText(getBaseContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Data gagal tersimpan", Toast.LENGTH_LONG).show();
            }

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            finish();
        }
        return true;


    }


}

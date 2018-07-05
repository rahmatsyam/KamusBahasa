package com.example.user.kamusbahasa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.user.kamusbahasa.helper.DatabaseHelper;
import com.mancj.materialsearchbar.MaterialSearchBar;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;

    private DatabaseHelper dataKamus;

    private EditText txtInggris, txtArab;
    private EditText txtIndonesia2, txtArab2;
    private EditText txtIndonesia3, txtInggris3;

    String inputan, inputan2, inputan3;

    private MaterialSearchBar txtIndonesia, txtInggris2, txtArab3;

    LayoutInflater inflater;
    AlertDialog.Builder Builder;
    View dialogView;
    DrawerLayout drawerLayout;

    FrameLayout frameLayout, frameLayout2, frameLayout3;

    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String ARAB = "arab";

    Button btnTerjemahan;
    Button btnTranslate;
    Button btnTarjama;

    Toolbar toolbar;
    com.example.user.kamusbahasa.Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dataKamus = new DatabaseHelper(this);
        db = dataKamus.getWritableDatabase();

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kamusku");


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {


                    case R.id.nav_indonesia:


                        frameLayout2.setVisibility(View.GONE);
                        frameLayout3.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        setIndonesia();
                        return true;
                    case R.id.nav_inggris:
                        frameLayout.setVisibility(View.GONE);
                        frameLayout3.setVisibility(View.GONE);
                        frameLayout2.setVisibility(View.VISIBLE);
                        setInggris();
                        return true;
                    case R.id.nav_arab:
                        frameLayout.setVisibility(View.GONE);
                        frameLayout2.setVisibility(View.GONE);
                        frameLayout3.setVisibility(View.VISIBLE);
                        setArab();
                        return true;
                    case R.id.nav_tambahkata:
                        Intent intent = new Intent(MainActivity.this, TambahKata.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_bookmark:

                        return true;
                    case R.id.nav_about:
                        DialogForm();
                        return true;

                    default:
                        Toast.makeText(getBaseContext(), "Kesalahan Terjadi ", Toast.LENGTH_SHORT).show();
                        return true;

                }

            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();


        txtIndonesia = findViewById(R.id.txtIndonesia);
        txtInggris = findViewById(R.id.txtInggris);
        txtArab = findViewById(R.id.txtArab);

        txtInggris2 = findViewById(R.id.txtInggris2);
        txtArab2 = findViewById(R.id.txtArab2);
        txtIndonesia2 = findViewById(R.id.txtIndonesia2);

        txtArab3 = findViewById(R.id.txtArab3);
        txtIndonesia3 = findViewById(R.id.txtIndonesia3);
        txtInggris3 = findViewById(R.id.txtInggris3);

        btnTerjemahan = findViewById(R.id.btnTerjemah);
        btnTerjemahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTerjemahan();

            }
        });

        btnTranslate = findViewById(R.id.btnTranslate);
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTranslate();
            }
        });

        btnTarjama = findViewById(R.id.btnTarjama);
        btnTarjama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTarjama();
            }
        });

        frameLayout = findViewById(R.id.frame1);
        frameLayout2 = findViewById(R.id.frame2);
        frameLayout3 = findViewById(R.id.frame3);


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

    private void setIndonesia() {
        txtIndonesia.setText(null);
        txtInggris.setText(null);
        txtArab.setText(null);
    }

    private void setInggris() {
        txtInggris2.setText(null);
        txtIndonesia2.setText(null);
        txtArab2.setText(null);
    }

    private void setArab() {
        txtArab3.setText(null);
        txtIndonesia3.setText(null);
        txtInggris3.setText(null);
    }


    public void getTranslate() {

        inputan2 = txtInggris2.getText();
        if (inputan2.equals("")) {
            Toast.makeText(getBaseContext(), "Please input word", Toast.LENGTH_SHORT).show();
        } else {

            String bhsindonesia = "";
            String bhsarab = "";
            String englishword = txtInggris2.getText();

            kamusCursor = db.rawQuery("SELECT kamus_id, INGGRIS, INDONESIA, ARAB FROM kamus where INGGRIS='"
                    + englishword
                    + "' ORDER BY INGGRIS", null);

            if (kamusCursor.moveToFirst()) {
                for (; !kamusCursor.isAfterLast();
                     kamusCursor.moveToNext()) {
                    bhsindonesia = kamusCursor.getString(2);
                    bhsarab = kamusCursor.getString(3);
                }
            } else {
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtIndonesia2.setText(bhsindonesia);
            txtArab2.setText(bhsarab);

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            // finish();
        }
    }

    public void getTarjama() {

        inputan3 = txtArab3.getText();
        if (inputan3.equals("")) {
            Toast.makeText(getBaseContext(), "Please input word", Toast.LENGTH_SHORT).show();
        } else {

            String bhsindonesia = "";
            String bhsinggris = "";
            String arabword = txtArab3.getText();

            kamusCursor = db.rawQuery("SELECT kamus_id, ARAB, INDONESIA, INGGRIS FROM kamus where ARAB='"
                    + arabword
                    + "' ORDER BY ARAB", null);

            if (kamusCursor.moveToFirst()) {
                for (; !kamusCursor.isAfterLast();
                     kamusCursor.moveToNext()) {
                    bhsindonesia = kamusCursor.getString(2);
                    bhsinggris = kamusCursor.getString(3);
                }
            } else {
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtIndonesia3.setText(bhsindonesia);
            txtInggris3.setText(bhsinggris);

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

 /* @Override
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

           case R.id.selectIndonesia:
                frameLayout2.setVisibility(View.GONE);
                frameLayout3.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                setIndonesia();
                return true;
            case R.id.selectInggris:
                frameLayout.setVisibility(View.GONE);
                frameLayout3.setVisibility(View.GONE);
                frameLayout2.setVisibility(View.VISIBLE);
                setInggris();
                return true;
            case R.id.selectArab:
                frameLayout.setVisibility(View.GONE);
                frameLayout2.setVisibility(View.GONE);
                frameLayout3.setVisibility(View.VISIBLE);
                setArab();
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/


    /*@Override
    public void onDestroy() {
        super.onDestroy();
        try {
            kamusCursor.close();
            db.close();
        } catch (Exception ignored) {

        }
    } */

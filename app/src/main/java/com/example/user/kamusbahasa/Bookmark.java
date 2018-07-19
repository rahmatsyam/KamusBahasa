package com.example.user.kamusbahasa;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.example.user.kamusbahasa.helper.DatabaseHelper;


public class Bookmark extends AppCompatActivity {

    private SQLiteDatabase db = null;
    DatabaseHelper dataKamus = null;
    Cursor kamusCursor = null;

    TextView TVfavindo;
    TextView TVfaveng;
    TextView TVfavarab;
    TextView TVnodata;

    FrameLayout frameBookmark;


    public static final String FAVORITEINDO = "favoriteindo";
    public static final String FAVORITEING = "favoriteing";
    public static final String FAVORITEARAB = "favoritearab";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataKamus = new DatabaseHelper(this);
        db = dataKamus.getWritableDatabase();
        setContentView(R.layout.activity_bookmark);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVfavindo = findViewById(R.id.txt_favindo);
        TVfaveng = findViewById(R.id.txt_faveng);
        TVfavarab = findViewById(R.id.txt_favarab);
        TVnodata = findViewById(R.id.txt_nodata);

        frameBookmark = findViewById(R.id.frame4);
        showBookmarkData();


    }

    @SuppressLint("SetTextI18n")
    public void showBookmarkData() {


        String bhsindo = "";
        String bhsing = "";
        String bhsarab = "";
        kamusCursor = db.rawQuery("SELECT kamus_id, FAVORITEINDO, FAVORITEING, FAVORITEARAB FROM kamus ", null);
        if (kamusCursor.moveToFirst()) {

            for (; !kamusCursor.isAfterLast();
                 kamusCursor.moveToNext()) {
                bhsindo = kamusCursor.getString(1);
                bhsing = kamusCursor.getString(2);
                bhsarab = kamusCursor.getString(3);


            }


        }
        if (bhsindo == null || bhsing == null || bhsarab == null) {
            frameBookmark.setVisibility(View.GONE);
            TVnodata.setVisibility(View.VISIBLE);
            TVnodata.setText("Belum Ada Bookmark Tersimpan");
        } else {
            frameBookmark.setVisibility(View.VISIBLE);
            TVfavindo.setText(bhsindo);
            TVfaveng.setText(bhsing);
            TVfavarab.setText(bhsarab);
            TVnodata.setVisibility(View.GONE);
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

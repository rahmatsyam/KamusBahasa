package com.example.user.kamusbahasa;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.user.kamusbahasa.helper.DatabaseHelper;
import com.example.user.kamusbahasa.utils.BaseActivity;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.mancj.materialsearchbar.MaterialSearchBar;


import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;

    DatabaseHelper dataKamus;

    @BindView(R.id.frame1)
    FrameLayout frameLayout;
    @BindView(R.id.frame2)
    FrameLayout frameLayout2;
    @BindView(R.id.frame3)
    FrameLayout frameLayout3;

    @BindView(R.id.txtInggris)
    EditText txtInggris;
    @BindView(R.id.txtArab)
    EditText txtArab;

    @BindView(R.id.txtIndonesia2)
    EditText txtIndonesia2;
    @BindView(R.id.txtArab2)
    EditText txtArab2;
    @BindView(R.id.txtIndonesia3)
    EditText txtIndonesia3;
    @BindView(R.id.txtInggris3)
    EditText txtInggris3;

    @BindView(R.id.txtIndonesia)
    MaterialSearchBar txtIndonesia;
    @BindView(R.id.txtInggris2)
    MaterialSearchBar txtInggris2;
    @BindView(R.id.txtArab3)
    MaterialSearchBar txtArab3;

    @BindView(R.id.btnTerjemah)
    Button btnTerjemahan;
    @BindView(R.id.btnTranslate)
    Button btnTranslate;
    @BindView(R.id.btnTarjama)
    Button btnTarjama;

    @BindView(R.id.icon_fav)
    MaterialFavoriteButton favoriteButtonIndo;
    @BindView(R.id.icon_fav2)
    MaterialFavoriteButton favoriteButtonEng;
    @BindView(R.id.icon_fav3)
    MaterialFavoriteButton favoriteButtonArab;

    @BindView(R.id.ic_refresh)
    ImageView imgRefresh;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    String inputan, inputan2, inputan3;

    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String ARAB = "arab";

    public static final String FAVORITEINDO = "favoriteindo";
    public static final String FAVORITEING = "favoriteing";
    public static final String FAVORITEARAB = "favoritearab";

    public String goi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataKamus = new DatabaseHelper(this);
        db = dataKamus.getWritableDatabase();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kamus Aneka");

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

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
                        Intent bookmark = new Intent(MainActivity.this, Bookmark.class);
                        startActivity(bookmark);
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
                hiddenKeyboard();


            }

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
                hiddenKeyboard();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        //Button yg berfungsi mengeksekusi terjemahan dari bahasa Indonesia
        btnTerjemahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTerjemahan();

            }
        });

        //Button yg berfungsi mengeksekusi terjemahan dari bahasa Inggris
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTranslate();
            }
        });

        ////Button yg berfungsi mengeksekusi terjemahan dari bahasa Arab
        btnTarjama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTarjama();

            }
        });

        setFavoriteBtnIndo();
        setFavoriteBtnIng();
        setFavoriteBtnArab();

        //Button untuk refresh
        imgRefresh = findViewById(R.id.ic_refresh);
        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIndonesia();
                setArab();
                setInggris();
                favoriteButtonIndo.setVisibility(View.GONE);
                favoriteButtonEng.setVisibility(View.GONE);
                favoriteButtonArab.setVisibility(View.GONE);
            }
        });




    }

    //method untuk menjalankan fungsi terjemahan dari kata yang di-inputkan(bahasa Indonesia)

    public void getTerjemahan() {
        inputan = txtIndonesia.getText();
        if (inputan.equals("")) {
            Toast.makeText(getBaseContext(), "Masukkan kata terlebih dahulu", Toast.LENGTH_SHORT).show();
            setIndonesia();
        } else {

            String bhsinggris = "";
            String bhsarab = "";
            String indonesiaword = txtIndonesia.getText();
            favoriteButtonIndo.setVisibility(View.VISIBLE);
            favoriteButtonIndo.setFavorite(false);

            //memeriksa kata yang diinput lalu di proses di database
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
                favoriteButtonIndo.setFavorite(false);
                favoriteButtonIndo.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtInggris.setText(bhsinggris);
            txtArab.setText(bhsarab);


            hiddenKeyboard();

        }


    }


    public void getTranslate() {

        inputan2 = txtInggris2.getText();
        if (inputan2.equals("")) {
            Toast.makeText(getBaseContext(), "Please input word", Toast.LENGTH_SHORT).show();
        } else {

            String bhsindonesia = "";
            String bhsarab = "";
            String englishword = txtInggris2.getText();
            favoriteButtonEng.setFavorite(false);
            favoriteButtonEng.setVisibility(View.VISIBLE);

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
                favoriteButtonEng.setFavorite(false);
                favoriteButtonEng.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtIndonesia2.setText(bhsindonesia);
            txtArab2.setText(bhsarab);
            hiddenKeyboard();

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
            favoriteButtonArab.setVisibility(View.VISIBLE);
            favoriteButtonArab.setFavorite(false);

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
                favoriteButtonArab.setFavorite(false);
                favoriteButtonArab.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Kata belum ada di database", Toast.LENGTH_SHORT).show();
            }

            txtIndonesia3.setText(bhsindonesia);
            txtInggris3.setText(bhsinggris);
            hiddenKeyboard();

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

    public void setFavoriteBtnIndo() {
        favoriteButtonIndo.setFavorite(false, true);
        favoriteButtonIndo.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            dataFavoriteIndo();
                        }


                    }
                }
        );
    }

    public void setFavoriteBtnIng() {
        favoriteButtonEng.setFavorite(false, true);
        favoriteButtonEng.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            dataFavoriteIng();
                        }
                    }
                }
        );
    }

    public void setFavoriteBtnArab() {
        favoriteButtonArab.setFavorite(false, true);
        favoriteButtonArab.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            dataFavoriteArab();
                        }
                    }
                }
        );
    }

    private void dataFavoriteIndo() {
        String bhsindonesia = txtIndonesia.getText();
        String bhsinggris = txtInggris.getText().toString();
        String bhsarab = txtArab.getText().toString();


        ContentValues cv = new ContentValues();
        cv.put(FAVORITEINDO, bhsindonesia);
        cv.put(FAVORITEING, bhsinggris);
        cv.put(FAVORITEARAB, bhsarab);
        /*  Log.i("data", "dada" + bhsindonesia);*/
        if (db.insert("kamus", FAVORITEINDO, cv) > 0 && db.insert("kamus", FAVORITEING, cv) > 0 &&
                db.insert("kamus", FAVORITEARAB, cv) > 0) {
            Toast.makeText(getBaseContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Data gagal tersimpan", Toast.LENGTH_LONG).show();
        }


    }

    private void dataFavoriteIng() {
        String bhsindonesia = txtIndonesia2.getText().toString();
        String bhsinggris = txtInggris2.getText();
        String bhsarab = txtArab2.getText().toString();
        if (bhsindonesia.equals("") || bhsinggris.equals("") || bhsarab.equals("")) {
            Toast.makeText(getBaseContext(), "Silahkan isi terlebih dahulu", Toast.LENGTH_LONG).show();
        } else {

            ContentValues cv = new ContentValues();
            cv.put(FAVORITEINDO, bhsindonesia);
            cv.put(FAVORITEING, bhsinggris);
            cv.put(FAVORITEARAB, bhsarab);
            Log.i("data", "dada" + bhsindonesia);
            if (db.insert("kamus", FAVORITEINDO, cv) > 0 && db.insert("kamus", FAVORITEING, cv) > 0 &&
                    db.insert("kamus", FAVORITEARAB, cv) > 0) {
                Toast.makeText(getBaseContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Data gagal tersimpan", Toast.LENGTH_LONG).show();
            }

        }
    }

    private void dataFavoriteArab() {
        String bhsindonesia = txtIndonesia3.getText().toString();
        String bhsinggris = txtInggris3.getText().toString();
        String bhsarab = txtArab3.getText();
        if (bhsindonesia.equals("") || bhsinggris.equals("") || bhsarab.equals("")) {
            Toast.makeText(getBaseContext(), "Silahkan isi terlebih dahulu", Toast.LENGTH_LONG).show();
        } else {

            ContentValues cv = new ContentValues();
            cv.put(FAVORITEINDO, bhsindonesia);
            cv.put(FAVORITEING, bhsinggris);
            cv.put(FAVORITEARAB, bhsarab);

            if (db.insert("kamus", FAVORITEINDO, cv) > 0 && db.insert("kamus", FAVORITEING, cv) > 0 &&
                    db.insert("kamus", FAVORITEARAB, cv) > 0) {
                Toast.makeText(getBaseContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Data gagal tersimpan", Toast.LENGTH_LONG).show();
            }

        }
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

}


package com.example.user.kamusbahasa.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbkamus";
    private static final int DATABASE_VERSION = 1;
    private static final String INGGRIS = "inggris";
    private static final String INDONESIA = "indonesia";
    private static final String ARAB = "arab";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //method createTable untuk membuat table kamus
    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists  kamus( kamus_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " +
                "indonesia TEXT, inggris TEXT, arab TEXT);"
        );
    }


    public void generateData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(INDONESIA, "ajaran");
        cv.put(INGGRIS, "teaching");
        cv.put(ARAB, "\tتعاليم ,  \ndibaca : taklim");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "ayah");
        cv.put(INGGRIS, "father");
        cv.put(ARAB, "\tالأب" + "\nal'ab");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "rajin");
        cv.put(INGGRIS, "diligent");
        cv.put(ARAB, "\tكادح,  \nkadih");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "senyum");
        cv.put(INGGRIS, "smile");
        cv.put(ARAB, "\tابتسامة, \naibtisama");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "matahari");
        cv.put(INGGRIS, "sun");
        cv.put(ARAB, "\tالشمس , \nalshams");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "bulan");
        cv.put(INGGRIS, "moon, month");
        cv.put(ARAB, "\tشهر , \nshahr");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "puasa");
        cv.put(INGGRIS, "fasting");
        cv.put(ARAB, "\tصيام , \nsiam");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "solat");
        cv.put(INGGRIS, "\t(Islam) ritual prayers and action performed fivetimes daily\t");
        cv.put(ARAB, "\tصلاة, \nsala'");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "zakat");
        cv.put(INGGRIS, "\t(Islam) tithe in rice or money paid on last day of fasting month");
        cv.put(ARAB, "\tعشر , \nashr");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "maaf");
        cv.put(INGGRIS, "forgive, sorry");
        cv.put(ARAB, "\tغفر , \nghafar");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "bahagia");
        cv.put(INGGRIS, "happy");
        cv.put(ARAB, "\tسعيد , \nsaid");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "indah ");
        cv.put(INGGRIS, "beautiful");
        cv.put(ARAB, "\tجميل , \njamil");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "mata");
        cv.put(INGGRIS, "eye");
        cv.put(ARAB, "\tعين , ayan");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "berani");
        cv.put(INGGRIS, "audaciuos, brave");
        cv.put(ARAB, "\tشجاع , \nshuja");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "membeli");
        cv.put(INGGRIS, "buy, purchase");
        cv.put(ARAB, "\tشراء , \nshira");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "membela");
        cv.put(INGGRIS, "defend");
        cv.put(ARAB, "\tالدفاع , \naldifa");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "melarang");
        cv.put(INGGRIS, "forbid");
        cv.put(ARAB, "\tحظر, \nhazr");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "bahaya");
        cv.put(INGGRIS, "danger");
        cv.put(ARAB, "\tخطر , \nkhatar");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "mana");
        cv.put(INGGRIS, "where");
        cv.put(ARAB, "\tأين , \n'ayn");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "ibu");
        cv.put(INGGRIS, "mother");
        cv.put(ARAB, "\tأم , \n'umi");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "melalui");
        cv.put(INGGRIS, "through");
        cv.put(ARAB, "\tمن خلال , \nmin khilal");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "pengusaha");
        cv.put(INGGRIS, "entrepreneur");
        cv.put(ARAB, "\tرجل اعمال , \nrajul 'aemal");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "mengherankan");
        cv.put(INGGRIS, "asthonishing");
        cv.put(ARAB, "\tمفاجأة , \nmufaja'a");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "cara");
        cv.put(INGGRIS, "mannner");
        cv.put(ARAB, "\tأسلوب , \n'uslub");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "ad hoc");
        cv.put(INGGRIS, "for that purpose");
        cv.put(ARAB, "\tمخصصة , \nmukhasasa");
        db.insert("kamus", INDONESIA, cv);


        cv.put(INDONESIA, "melebih-lebihkan");
        cv.put(INGGRIS, "exaggerate");
        cv.put(ARAB, "\tمبالغة , \nmubalagha");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "mimpi");
        cv.put(INGGRIS, "dream");
        cv.put(ARAB, "\tحلم , \nhulm");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "harum");
        cv.put(INGGRIS, "fragnant, aromatic");
        cv.put(ARAB, "\tعبق , \neabaq");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "putih");
        cv.put(INGGRIS, "white");
        cv.put(ARAB, "\tأبيض , \nabyad");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "dahi");
        cv.put(INGGRIS, "forehead");
        cv.put(ARAB, "\tجبين , \njabiyn");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "beasiswa");
        cv.put(INGGRIS, "schoolarship");
        cv.put(ARAB, "\tمنحة دراسية , \nminhat dirasia");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "alumni");
        cv.put(INGGRIS, "alumnus");
        cv.put(ARAB, "\tالخريجين , \nalkharijin");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "jakun");
        cv.put(INGGRIS, "Adam's apple");
        cv.put(ARAB, "\tتفاحة آدم , \ntafahat adam");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "harapan");
        cv.put(INGGRIS, "hope");
        cv.put(ARAB, "\tأمل , \n'amal");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "baik");
        cv.put(INGGRIS, "good");
        cv.put(ARAB, "\tخير , \nkhayr");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "gurun");
        cv.put(INGGRIS, "wasteland, desert");
        cv.put(ARAB, "\tبرية , \nbariya");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "pulau");
        cv.put(INGGRIS, "island");
        cv.put(ARAB, "\t\tجزيرة , jazira");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "melihat");
        cv.put(INGGRIS, "see");
        cv.put(ARAB, "\tرأي , \nray");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "berawan");
        cv.put(INGGRIS, "cloudy");
        cv.put(ARAB, "\tغائم , \nghayim");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "membaca");
        cv.put(INGGRIS, "read");
        cv.put(ARAB, "\tقرأ, \nqara");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "bersinar");
        cv.put(INGGRIS, "shine");
        cv.put(ARAB, "\tتألق , \ntalaq");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "menjual");
        cv.put(INGGRIS, "sell");
        cv.put(ARAB, "\tبيع , \nbay");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "menulis");
        cv.put(INGGRIS, "write");
        cv.put(ARAB, "\tإرسال , \n'iirsal");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "berpikir");
        cv.put(INGGRIS, "think");
        cv.put(ARAB, "\tاعتقد , \n'aataqid");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "cerdas");
        cv.put(INGGRIS, "intelligent,");
        cv.put(ARAB, "\tذكي , \ndhuki");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "kurma");
        cv.put(INGGRIS, "date palm");
        cv.put(ARAB, "\tتاريخ , \ntarikh");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "air");
        cv.put(INGGRIS, "water");
        cv.put(ARAB, "\tماء , \nma'an");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "dingin");
        cv.put(INGGRIS, "cold");
        cv.put(ARAB, "\tبرد , \nbard");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "manis");
        cv.put(INGGRIS, "sweet");
        cv.put(ARAB, "\tحلو , \nhalu");
        db.insert("kamus", INDONESIA, cv);

        cv.put(INDONESIA, "salju");
        cv.put(INGGRIS, "snow");
        cv.put(ARAB, "\tثلج , \nthalaj");
        db.insert("kamus", INDONESIA, cv);

        //==========================================================================================//
        cv.put(INGGRIS, "teaching");
        cv.put(INDONESIA, "ajaran");
        cv.put(ARAB, "\tتعاليم ,  \ndibaca : taklim");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "father");
        cv.put(INDONESIA, "ayah");
        cv.put(ARAB, "\tالأب" + "\nal'ab");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "diligent");
        cv.put(INDONESIA, "rajin");
        cv.put(ARAB, "\tكادح,  \nkadih");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "smile");
        cv.put(INDONESIA, "senyum");
        cv.put(ARAB, "\tابتسامة, \naibtisama");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "sun");
        cv.put(INDONESIA, "matahari");
        cv.put(ARAB, "\tالشمس , \nalshams");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "moon, month");
        cv.put(INDONESIA, "bulan");
        cv.put(ARAB, "\tشهر , \nshahr");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "fasting");
        cv.put(INDONESIA, "puasa");
        cv.put(ARAB, "\tصيام , \nsiam");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "\t(Islam) ritual prayers and action performed fivetimes daily\t");
        cv.put(INDONESIA, "solat");
        cv.put(ARAB, "\tصلاة, \nsala'");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "\t(Islam) tithe in rice or money paid on last day of fasting month");
        cv.put(INDONESIA, "zakat");
        cv.put(ARAB, "\tعشر , \nashr");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "forgive" + "sorry");
        cv.put(INDONESIA, "maaf");
        cv.put(ARAB, "\tغفر , \nghafar");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "happy");
        cv.put(INDONESIA, "bahagia");
        cv.put(ARAB, "\tسعيد , \nsaid");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "beautiful");
        cv.put(INDONESIA, "indah");
        cv.put(ARAB, "\tجميل , \njamil");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "eye");
        cv.put(INDONESIA, "mata");
        cv.put(ARAB, "\tعين , ayan");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "audaciuos" + "brave");
        cv.put(INDONESIA, "berani");
        cv.put(ARAB, "\tشجاع , \nshuja");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "buy");
        cv.put(INDONESIA, "membeli");
        cv.put(ARAB, "\tشراء , \nshira");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "defend");
        cv.put(INDONESIA, "membela");
        cv.put(ARAB, "\tالدفاع , \naldifa");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "forbid");
        cv.put(INDONESIA, "melarang");
        cv.put(ARAB, "\tحظر, \nhazr");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "danger");
        cv.put(INDONESIA, "bahaya");
        cv.put(ARAB, "\tخطر , \nkhatar");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "where");
        cv.put(INDONESIA, "dimana");
        cv.put(ARAB, "\tأين , \n'ayn");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "mother");
        cv.put(INDONESIA, "ibu");
        cv.put(ARAB, "\tأم , \n'umi");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "through");
        cv.put(INDONESIA, "melalui");
        cv.put(ARAB, "\tمن خلال , \nmin khilal");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "entrepreneur");
        cv.put(INDONESIA, "pengusaha");
        cv.put(ARAB, "\tرجل اعمال , \nrajul 'aemal");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "asthonishing");
        cv.put(INDONESIA, "mengherankan");
        cv.put(ARAB, "\tمفاجأة , \nmufaja'a");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "mannner");
        cv.put(INDONESIA, "cara");
        cv.put(ARAB, "\tأسلوب , \n'uslub");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "ad hoc");
        cv.put(INDONESIA, "maksud tertentu");
        cv.put(ARAB, "\tمخصصة , \nmukhasasa");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "exaggerate");
        cv.put(INDONESIA, "melebih-lebihkan");
        cv.put(ARAB, "\tمبالغة , \nmubalagha");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "dream");
        cv.put(INDONESIA, "mimpi");
        cv.put(ARAB, "\tحلم , \nhulm");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "aromatic");
        cv.put(INDONESIA, "harum");
        cv.put(ARAB, "\tعبق , \neabaq");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "white");
        cv.put(INDONESIA, "putih");
        cv.put(ARAB, "\tأبيض , \nabyad");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "forehead");
        cv.put(INDONESIA, "dahi");
        cv.put(ARAB, "\tجبين , \njabiyn");
        db.insert("kamus", INGGRIS, cv);


        cv.put(INGGRIS, "schoolarship");
        cv.put(INDONESIA, "beasiswa");
        cv.put(ARAB, "\tمنحة دراسية , \nminhat dirasia");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "alumnus");
        cv.put(INDONESIA, "alumni");
        cv.put(ARAB, "\tالخريجين , \nalkharijin");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "Adam's apple");
        cv.put(INDONESIA, "jakun");
        cv.put(ARAB, "\tتفاحة آدم , \ntafahat adam");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "hope");
        cv.put(INDONESIA, "harapan");
        cv.put(ARAB, "\tأمل , \n'amal");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "good");
        cv.put(INDONESIA, "baik");
        cv.put(ARAB, "\tخير , \nkhayr");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "wasteland");
        cv.put(INDONESIA, "gurun");
        cv.put(ARAB, "\tبرية , \nbariya");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "island");
        cv.put(INDONESIA, "pulau");
        cv.put(ARAB, "\t\tجزيرة , jazira");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "see");
        cv.put(INDONESIA, "melihat");
        cv.put(ARAB, "\tرأي , \nray");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "cloudy");
        cv.put(INDONESIA, "berawan");
        cv.put(ARAB, "\tغائم , \nghayim");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "read");
        cv.put(INDONESIA, "membaca");
        cv.put(ARAB, "\tقرأ, \nqara");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "shine");
        cv.put(INDONESIA, "bersinar");
        cv.put(ARAB, "\tتألق , \ntalaq");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "sell");
        cv.put(INDONESIA, "menjual");
        cv.put(ARAB, "\tبيع , \nbay");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "write");
        cv.put(INDONESIA, "menulis");
        cv.put(ARAB, "\tإرسال , \n'iirsal");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "think");
        cv.put(INDONESIA, "berpikir");
        cv.put(ARAB, "\tاعتقد , \n'aataqid");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "intelligent,");
        cv.put(INDONESIA, "cerdas");
        cv.put(ARAB, "\tذكي , \ndhuki");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "date palm");
        cv.put(INDONESIA, "kurma");
        cv.put(ARAB, "\tتاريخ , \ntarikh");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "water");
        cv.put(INDONESIA, "air");
        cv.put(ARAB, "\tماء , \nma'an");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "cold");
        cv.put(INDONESIA, "dingin");
        cv.put(ARAB, "\tبرد , \nbard");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "sweet");
        cv.put(INDONESIA, "manis");
        cv.put(ARAB, "\tحلو , \nhalu");
        db.insert("kamus", INGGRIS, cv);

        cv.put(INGGRIS, "snow");
        cv.put(INDONESIA, "salju");
        cv.put(ARAB, "\tثلج , \nthalaj");
        db.insert("kamus", INGGRIS, cv);

        //=====================================================
        cv.put(ARAB, "halu");
        cv.put(INGGRIS, "sweet");
        cv.put(INDONESIA, "manis");
        db.insert("kamus", ARAB, cv);

        cv.put(ARAB, "thalaj");
        cv.put(INGGRIS, "snow");
        cv.put(INDONESIA, "salju");
        db.insert("kamus", ARAB, cv);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        createTable(db);
        generateData(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
        generateData(db);

    }


}

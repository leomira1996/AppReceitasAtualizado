package com.example.miranda.appreceitas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Miranda on 27/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "receitas";
    public static final String ID = "_id";
    public static final String RECEITAS = "receitas";
    public static final String INGREDIENTES = "ingredientes";
    public static final String MODO_DE_PREPARO = "modo_de_preparo";
    public static final String SERVE = "serve";
    public static final String TEMPO = "tempo";
    public static final int VERSAO = 5;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + RECEITAS + " text,"
                + INGREDIENTES + " text,"
                + MODO_DE_PREPARO + " text,"
                + SERVE + " text"
                + TEMPO + " text"
                +")";
        Log.i("banco",sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}

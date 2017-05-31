package com.example.miranda.appreceitas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Miranda on 27/05/2017.
 */


public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String receitas, String ingredientes, String modo_de_preparo, String serve, String tempo){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.RECEITAS, receitas);
        valores.put(CriaBanco.INGREDIENTES, ingredientes);
        valores.put(CriaBanco.MODO_DE_PREPARO, modo_de_preparo);
        valores.put(CriaBanco.SERVE, serve);
        valores.put(CriaBanco.TEMPO, tempo);


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.RECEITAS};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.RECEITAS,banco.INGREDIENTES,banco.MODO_DE_PREPARO,banco.SERVE,banco.TEMPO};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String receitas, String ingredientes, String modo_de_preparo, String serve, String tempo){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.RECEITAS, receitas);
        valores.put(CriaBanco.INGREDIENTES, ingredientes);
        valores.put(CriaBanco.MODO_DE_PREPARO, modo_de_preparo);
        valores.put(CriaBanco.SERVE, serve);
        valores.put(CriaBanco.TEMPO, tempo);

        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }
}

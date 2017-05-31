package com.example.miranda.appreceitas;

/**
 * Created by Miranda on 27/05/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText receita;
    EditText ingredientes;
    EditText modo_de_preparo;
    EditText serve;
    EditText tempo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        receita = (EditText)findViewById(R.id.editText);
        ingredientes = (EditText)findViewById(R.id.editText2);
        modo_de_preparo = (EditText)findViewById(R.id.editText3);
        serve = (EditText)findViewById(R.id.editText4);
        tempo = (EditText)findViewById(R.id.editText5);
        deletar = (Button)findViewById(R.id.button3);
        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        receita.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.RECEITAS)));
        ingredientes.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INGREDIENTES)));
        modo_de_preparo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.MODO_DE_PREPARO)));
        serve.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SERVE)));
        tempo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TEMPO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), receita.getText().toString(),ingredientes.getText().toString(),modo_de_preparo.getText().toString(),serve.getText().toString(),tempo.getText().toString());
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

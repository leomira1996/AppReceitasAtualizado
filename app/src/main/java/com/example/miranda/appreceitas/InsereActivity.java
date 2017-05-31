package com.example.miranda.appreceitas;

/**
 * Created by Miranda on 27/05/2017.
 */

import android.app.Activity;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsereActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText receita = (EditText)findViewById(R.id.editText);
                EditText ingredientes = (EditText)findViewById((R.id.editText2));
                EditText modo_de_preparo = (EditText)findViewById(R.id.editText3);
                EditText serve = (EditText)findViewById(R.id.editText4);
                EditText tempo = (EditText)findViewById(R.id.editText5);

                String receitaString = receita.getText().toString();
                String ingredientesrString = ingredientes.getText().toString();
                String modo_de_preparoString = modo_de_preparo.getText().toString();
                String serveString = serve.getText().toString();
                String tempoString = tempo.getText().toString();
                String resultado;

                resultado = crud.insereDado(receitaString,ingredientesrString,modo_de_preparoString,serveString,tempoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.miranda.appreceitas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void inserir(View v){
        Intent intent = new Intent(MainActivity.this,InsereActivity.class);
        startActivity(intent);
    }
    public void listar(View v){
        Intent intent = new Intent(MainActivity.this,InsereActivity.class);
        startActivity(intent);
    }
}

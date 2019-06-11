package br.edu.ifsp.fuelprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addUsuario(View v){
        Intent intent = new Intent(this, CadUsuario.class);
        startActivity(intent);
    }

    public void addVeiculo(View v){
        Intent intent = new Intent(this, CadVeiculo.class);
        startActivity(intent);
    }

    public void addPosto(View v){
        Intent intent = new Intent(this, CadPosto.class);
        startActivity(intent);
    }

    public void toHistoric(View v){
        Intent intent = new Intent(this, CadHistorico.class);
        startActivity(intent);
    }
}

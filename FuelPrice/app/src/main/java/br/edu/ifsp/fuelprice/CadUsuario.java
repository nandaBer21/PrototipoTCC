package br.edu.ifsp.fuelprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CadUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void toHome(View v){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }

    public void addVeiculo(View v){
        Intent intent = new Intent(this, CadVeiculo.class);
        startActivity(intent);
    }
    //TODO: Fazer override onPause e onResume
}

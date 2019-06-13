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
    }

    public void addUsuario(View v){
        Navigation navigation = new Navigation();
        navigation.addUsuario(this);
    }

    public void addVeiculo(View v){
        Navigation navigation = new Navigation();
        navigation.addVeiculo(this);
    }

    public void addPosto(View v){
        Navigation navigation = new Navigation();
        navigation.addPosto(this);
    }

    public void toHistoric(View v){
        Navigation navigation = new Navigation();
        navigation.toHistoric(this);
    }
}

package br.edu.ifsp.fuelprice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class CadPosto extends AppCompatActivity {

    public static final String PREF_NAME =
            "br.edu.ifsp.fuelprice.PREF_NAME";

    public static final String KEY_POSTO =
            "br.edu.ifsp.fuelprice.KEY_POSTO";
    public static final String KEY_ENDERECO =
            "br.edu.ifsp.fuelprice.KEY_ENDERECO";
    public static final String KEY_LOCAL =
            "br.edu.ifsp.fuelprice.KEY_LOCAL";
    public static final String KEY_DATA =
            "br.edu.ifsp.fuelprice.KEY_DATA";
    public static final String KEY_ETANOL =
            "br.edu.ifsp.fuelprice.KEY_ETANOL";
    public static final String KEY_GASOLINA =
            "br.edu.ifsp.fuelprice.KEY_GASOLINA";
    public static final String KEY_DISEL =
            "br.edu.ifsp.fuelprice.KEY_DISEL";

    public static final String PARAMETER_POSTO =
            "br.edu.ifsp.fuelprice.PARAMETER_POSTO";
    public static final String PARAMETER_ENDERECO =
            "br.edu.ifsp.fuelprice.PARAMETER_ENDERECO";
    public static final String PARAMETER_LOCAL =
            "br.edu.ifsp.fuelprice.PARAMETER_LOCAL";
    public static final String PARAMETER_DATA =
            "br.edu.ifsp.fuelprice.PARAMETER_DATA";
    public static final String PARAMETER_ETANOL =
            "br.edu.ifsp.fuelprice.PARAMETER_ETANOL";
    public static final String PARAMETER_GASOLINA =
            "br.edu.ifsp.fuelprice.PARAMETER_GASOLINA";
    public static final String PARAMETER_DIESEL =
            "br.edu.ifsp.fuelprice.PARAMETER_DIESEL";

    EditText etPosto, etEndereco, etLocal, etData, etEtanol, etGasolina, etDiesel;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_posto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        etPosto = findViewById(R.id.etPosto);
        String posto = etPosto.getText().toString();
        editor.putString(KEY_POSTO, posto);

        etEndereco = findViewById(R.id.etEndereco);
        String endereco = etEndereco.getText().toString();
        editor.putString(KEY_ENDERECO, endereco);


        etData = findViewById(R.id.etData);
        String data = etData.getText().toString();
        editor.putString(KEY_DATA, data);

        etEtanol = findViewById(R.id.etEtanol);
        String etanol = etEtanol.getText().toString();
        editor.putString(KEY_ETANOL, etanol);

        etGasolina = findViewById(R.id.etGasolina);
        String gasolina = etGasolina.getText().toString();
        editor.putString(KEY_GASOLINA, gasolina);

        etDiesel = findViewById(R.id.etDiesel);
        String diesel = etDiesel.getText().toString();
        editor.putString(KEY_DISEL, diesel);

        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String posto = preferences.getString
                (KEY_POSTO, "");
        etPosto = findViewById(R.id.etPosto);
        etPosto.setText(posto);

        String endereco = preferences.getString
                (KEY_ENDERECO, "");
        etEndereco = findViewById(R.id.etEndereco);
        etEndereco.setText(endereco);


        String data = preferences.getString
                (KEY_DATA, "");
        etData = findViewById(R.id.etData);
        etData.setText(data);

        String etanol = preferences.getString
                (KEY_ETANOL, "");
        etEtanol = findViewById(R.id.etEtanol);
        etEtanol.setText(etanol);

        String gasolina = preferences.getString
                (KEY_GASOLINA, "");
        etGasolina = findViewById(R.id.etGasolina);
        etGasolina.setText(gasolina);

        String diesel = preferences.getString
                (KEY_DISEL, "");
        etDiesel = findViewById(R.id.etDiesel);
        etDiesel.setText(diesel);
    }

    public void toHome(View v){
        Navigation navigation = new Navigation();
        navigation.toHome(this);
    }

    public void toGoogleMaps(View v){
        Navigation navigation = new Navigation();
        navigation.toGoogleMaps(this);
    }


}

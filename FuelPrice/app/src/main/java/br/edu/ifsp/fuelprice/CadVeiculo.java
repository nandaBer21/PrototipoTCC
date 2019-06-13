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

public class CadVeiculo extends AppCompatActivity {

    public static final String PREF_NAME =
            "br.edu.ifsp.fuelprice.PREF_NAME";

    public static final String KEY_MARCA =
            "br.edu.ifsp.fuelprice.KEY_MARCA";
    public static final String KEY_MODELO =
            "br.edu.ifsp.fuelprice.KEY_MODELO";
    public static final String KEY_ANO =
            "br.edu.ifsp.fuelprice.KEY_ANO";
    public static final String KEY_ETANOL =
            "br.edu.ifsp.fuelprice.KEY_ETANOL";
    public static final String KEY_GASOLINA =
            "br.edu.ifsp.fuelprice.KEY_GASOLINA";
    public static final String KEY_DIESEL =
            "br.edu.ifsp.fuelprice.KEY_DISEL";

    public static final String PARAMETER_MARCA =
            "br.edu.ifsp.fuelprice.PARAMETER_MARCA";
    public static final String PARAMETER_MODELO =
            "br.edu.ifsp.fuelprice.PARAMETER_MODELO";
    public static final String PARAMETER_ANO =
            "br.edu.ifsp.fuelprice.PARAMETER_ANO";
    public static final String PARAMETER_ETANOL =
            "br.edu.ifsp.fuelprice.PARAMETER_ETANOL";
    public static final String PARAMETER_GASOLINA =
            "br.edu.ifsp.fuelprice.PARAMETER_GASOLINA";
    public static final String PARAMETER_DISEL =
            "br.edu.ifsp.fuelprice.PARAMETER_DISEL";

    EditText etMarca,etModelo,etAno,etAutEtanol,etAutGasolina,etAutDiesel;
    SharedPreferences preferences;

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        etMarca = findViewById(R.id.etMarca);
        String marca = etMarca.getText().toString();
        editor.putString(KEY_MARCA, marca);

        etModelo = findViewById(R.id.etModelo);
        String modelo = etModelo.getText().toString();
        editor.putString(KEY_MODELO, modelo);

        etAno = findViewById(R.id.etAno);
        String ano = etAno.getText().toString();
        editor.putString(KEY_ANO, ano);

        etAutEtanol = findViewById(R.id.etAutEtanol);
        String etanol = etAutEtanol.getText().toString();
        editor.putString(KEY_ETANOL, etanol);

        etAutGasolina = findViewById(R.id.etAutGasolina);
        String gasolina = etAutGasolina.getText().toString();
        editor.putString(KEY_GASOLINA, gasolina);

        etAutDiesel = findViewById(R.id.etAutDiesel);
        String diesel = etAutDiesel.getText().toString();
        editor.putString(KEY_DIESEL, diesel);
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String marca = preferences.getString(KEY_MARCA, "");
        etMarca = findViewById(R.id.etMarca);
        etMarca.setText(marca);

        String modelo = preferences.getString(KEY_MODELO, "");
        etModelo = findViewById(R.id.etModelo);
        etModelo.setText(modelo);

        String ano = preferences.getString(KEY_ANO, "");
        etAno = findViewById(R.id.etAno);
        etAno.setText(ano);

        String etanol = preferences.getString(KEY_ETANOL, "");
        etAutEtanol = findViewById(R.id.etAutEtanol);
        etAutEtanol.setText(etanol);

        String gasolina = preferences.getString(KEY_GASOLINA, "");
        etAutGasolina = findViewById(R.id.etAutGasolina);
        etAutGasolina.setText(gasolina);

        String diesel = preferences.getString(KEY_DIESEL, "");
        etAutDiesel = findViewById(R.id.etAutDiesel);
        etAutDiesel.setText(diesel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_veiculo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void toHome(View v){
        Navigation navigation = new Navigation();
        navigation.toHome(this);
    }
}

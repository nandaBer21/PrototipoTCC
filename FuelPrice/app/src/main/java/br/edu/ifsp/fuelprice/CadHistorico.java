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

public class CadHistorico extends AppCompatActivity {

    public static final String PREF_NAME =
            "br.edu.ifsp.fuelprice.PREF_NAME";

    public static final String KEY_VEICULO =
            "br.edu.ifsp.fuelprice.KEY_VEICULO";
    public static final String KEY_DTABASTECIMENTO =
            "br.edu.ifsp.fuelprice.KEY_DTABASTECIMENTO";
    public static final String KEY_DTATUAL =
            "br.edu.ifsp.fuelprice.KEY_DTATUAL";
    public static final String KEY_QTDLITROS =
            "br.edu.ifsp.fuelprice.KEY_QTDLITROS";

    public static final String PARAMETER_VEICULO =
            "br.edu.ifsp.fuelprice.PARAMETER_VEICULO";
    public static final String PARAMETER_DTABASTECIMENTO =
            "br.edu.ifsp.fuelprice.PARAMETER_DTABASTECIMENTO";
    public static final String PARAMETER_DTATUAL =
            "br.edu.ifsp.fuelprice.PARAMETER_DTATUAL";
    public static final String PARAMETER_QTDLITROS =
            "br.edu.ifsp.fuelprice.PARAMETER_QTDLITROS";

    ArrayList<Veiculo> veiculos;
    EditText etDataAbastecimento, etDataAtual, etQtdeLitros;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_historico);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        etDataAbastecimento = findViewById(R.id.etDataAbastecimento);
        String dtAbastecimento = etDataAbastecimento.getText().toString();
        editor.putString(KEY_DTABASTECIMENTO, dtAbastecimento);

        etDataAtual = findViewById(R.id.etDataAtual);
        String dtAtual = etDataAtual.getText().toString();
        editor.putString(KEY_DTATUAL, dtAtual);

        etQtdeLitros = findViewById(R.id.etQtdeLitros);
        String qtdeLitros = etQtdeLitros.getText().toString();
        editor.putString(KEY_DTABASTECIMENTO, qtdeLitros);

        editor.commit();//save
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String dtAbastecimento = preferences.getString
                (KEY_DTABASTECIMENTO, "");
        etDataAbastecimento = findViewById(R.id.etDataAbastecimento);
        etDataAbastecimento.setText(dtAbastecimento);

        String dtAtual = preferences.getString
                (KEY_DTATUAL, "");
        etDataAtual = findViewById(R.id.etDataAtual);
        etDataAtual.setText(dtAbastecimento);

        String qtdeLitros = preferences.getString
                (KEY_QTDLITROS, "");
        etQtdeLitros = findViewById(R.id.etQtdeLitros);
        etQtdeLitros.setText(dtAbastecimento);
    }

    public void toHome(View v){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
}

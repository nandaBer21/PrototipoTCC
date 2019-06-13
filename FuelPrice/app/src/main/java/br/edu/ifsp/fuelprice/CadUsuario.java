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

public class CadUsuario extends AppCompatActivity {

    public static final String PREF_NAME =
            "br.edu.ifsp.fuelprice.PREF_NAME";

    public static final String KEY_NOME =
            "br.edu.ifsp.fuelprice.KEY_NOME";
    public static final String KEY_EMAIL =
            "br.edu.ifsp.fuelprice.KEY_EMAIL";
    public static final String KEY_SENHA =
            "br.edu.ifsp.fuelprice.KEY_SENHA";
    public static final String KEY_SENHA2 =
            "br.edu.ifsp.fuelprice.KEY_SENHA2";
    public static final String KEY_TELEFONE =
            "br.edu.ifsp.fuelprice.KEY_TELEFONE";
    public static final String KEY_VEICULO =
            "br.edu.ifsp.fuelprice.KEY_VEICULO";

    public static final String PARAMETER_NOME =
            "br.edu.ifsp.fuelprice.PARAMETER_NOME";
    public static final String PARAMETER_EMAIL =
            "br.edu.ifsp.fuelprice.PARAMETER_EMAIL";
    public static final String PARAMETER_SENHA =
            "br.edu.ifsp.fuelprice.PARAMETER_SENHA";
    public static final String PARAMETER_SENHA2 =
            "br.edu.ifsp.fuelprice.PARAMETER_SENHA2";
    public static final String PARAMETER_TELEFONE =
            "br.edu.ifsp.fuelprice.PARAMETER_TELEFONE";
    public static final String PARAMETER_VEICULO =
            "br.edu.ifsp.fuelprice.PARAMETER_VEICULO";

    EditText etNome,etEmail,etSenha,etSenha2,etTelefone,etVeiculo;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        etNome = findViewById(R.id.etNome);
        String nome = etNome.getText().toString();
        editor.putString(KEY_NOME, nome);

        etEmail = findViewById(R.id.etEmail);
        String email = etEmail.getText().toString();
        editor.putString(KEY_EMAIL, email);

        etSenha = findViewById(R.id.etSenha);
        String senha = etSenha.getText().toString();
        editor.putString(KEY_SENHA, senha);

        etSenha2 = findViewById(R.id.etSenha2);
        String senha2 = etSenha2.getText().toString();
        editor.putString(KEY_SENHA2, senha2);

        etTelefone = findViewById(R.id.etTelefone);
        String telefone = etTelefone.getText().toString();
        editor.putString(KEY_TELEFONE, telefone);

        etVeiculo = findViewById(R.id.etVeiculo);
        String veiculo = etVeiculo.getText().toString();
        editor.putString(KEY_NOME, veiculo);

        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String nome = preferences.getString(KEY_NOME,"");
        etNome = findViewById(R.id.etNome);
        etNome.setText(nome);

        String email = preferences.getString(KEY_EMAIL,"");
        etEmail = findViewById(R.id.etEmail);
        etEmail.setText(email);

        String senha = preferences.getString(KEY_SENHA,"");
        etSenha = findViewById(R.id.etSenha);
        etSenha.setText(senha);

        String senha2 = preferences.getString(KEY_SENHA2,"");
        etSenha2 = findViewById(R.id.etSenha2);
        etSenha2.setText(senha2);

        String telefone = preferences.getString(KEY_TELEFONE,"");
        etTelefone = findViewById(R.id.etTelefone);
        etTelefone.setText(telefone);

        String veiculo = preferences.getString(KEY_VEICULO,"");
        etVeiculo = findViewById(R.id.etVeiculo);
        etVeiculo.setText(veiculo);
    }

    public void toHome(View v){
        Navigation navigation = new Navigation();
        navigation.toHome(this);
    }

    public void addVeiculo(View v){
        Navigation navigation = new Navigation();
        navigation.addVeiculo(this);
    }
}

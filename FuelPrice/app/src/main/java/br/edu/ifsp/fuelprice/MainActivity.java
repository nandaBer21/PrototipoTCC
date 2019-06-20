package br.edu.ifsp.fuelprice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int RC_CAMARA_FOTO = 1;

    public static final String PREF_NAME =
            "br.edu.ifsp.fuelprice.PREF_NAME";

    public static final String KEY_LOGIN =
            "br.edu.ifsp.fuelprice.KEY_LOGIN";
    public static final String KEY_SENHA =
            "br.edu.ifsp.fuelprice.KEY_SENHA";

    public static final String PARAMETER_LOGIN =
            "br.edu.ifsp.fuelprice.PARAMETER_LOGIN";
    public static final String PARAMETER_SENHA =
            "br.edu.ifsp.fuelprice.PARAMETER_SENHA";

    EditText etLogin,etSenha;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        etLogin = findViewById(R.id.etLogin);
        String login = etLogin.getText().toString();
        editor.putString(KEY_LOGIN, login);

        etSenha = findViewById(R.id.etSenha);
        String senha = etSenha.getText().toString();
        editor.putString(KEY_SENHA, senha);

        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String login = preferences.getString(KEY_LOGIN, "");
        etLogin = findViewById(R.id.etLogin);
        etLogin.setText(login);

        String senha = preferences.getString(KEY_SENHA, "");
        etSenha = findViewById(R.id.etSenha);
        etSenha.setText(senha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addLogin(View v){
        Navigation navigation = new Navigation();
        navigation.addLogin(this);
        //TODO: Configurar para abrir sem o botão de tela inicial e outros acessos
    }
    public void Logar(View v){
        //TODO: Fazer o Metodo para logar
        // verificar o banco e validar login
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            switch (requestCode){

                case RC_CAMARA_FOTO:
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");

                    ImageView imageViewPic = findViewById(R.id.imageViewPic);
                    imageViewPic.setImageBitmap(imageBitmap);

                    break;

                default:
                    break;
            }
        }
    }

    public void takePicture(View v){

        //TODO: Se for Android >= 6. (API 23) , devemos pedir permissão.

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, RC_CAMARA_FOTO);
        }
        else{
            Toast.makeText(this,
                    "Não existe recurso de CAMERA para captura da foto!",
                    Toast.LENGTH_LONG).show();
        }
    }
}

package br.edu.ifsp.fuelprice;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class Navigation {

    public void addLogin(Activity activity){
        Intent intent = new Intent(activity, CadUsuario.class);
        activity.startActivity(intent);
    }

    public void addUsuario(Activity activity){
        Intent intent = new Intent(activity, CadUsuario.class);
        activity.startActivity(intent);
    }

    public void toHome(Activity activity){
        Intent intent = new Intent(activity, TelaInicial.class);
        activity.startActivity(intent);
    }

    public void addVeiculo(Activity activity){
        Intent intent = new Intent(activity, CadVeiculo.class);
        activity.startActivity(intent);
    }

    public void addPosto(Activity activity){
        Intent intent = new Intent(activity, CadPosto.class);
        activity.startActivity(intent);
    }

    public void toHistoric(Activity activity){
        Intent intent = new Intent(activity, CadHistorico.class);
        activity.startActivity(intent);
    }
}

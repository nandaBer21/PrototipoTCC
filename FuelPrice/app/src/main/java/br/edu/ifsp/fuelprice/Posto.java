package br.edu.ifsp.fuelprice;

import android.app.Activity;
import android.content.Intent;

public class Posto {

    public static final String POSTO_ID = "br.edu.ifsp.fuelprice.POSTO_ID";

    private int idPosto;
    private String nomePosto;
    private String endereco;
    private String local;
    private String data;
    private float precoEtanol;
    private float precoGasolina;
    private float precoDisel;

    public Posto(int idPosto, String nomePosto, String endereco, String local, String data,
                 float precoEtanol, float precoGasolina, float precoDisel){
        this.idPosto = idPosto;
        this.nomePosto = nomePosto;
        this.endereco = endereco;
        this.local = local;
        this.data = data;
        this.precoEtanol = precoEtanol;
        this.precoGasolina = precoGasolina;
        this.precoDisel = precoDisel;
    }

    public int getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(int idPosto) {
        this.idPosto = idPosto;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(float precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public float getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(float precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public float getPrecoDisel() {
        return precoDisel;
    }

    public void setPrecoDisel(float precoDisel) {
        this.precoDisel = precoDisel;
    }

    public void enviarWhatsApp(Activity activity){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"O posto "+ nomePosto + " esta vendendo etanol a "
                + precoEtanol + ", gasolina a " + precoGasolina + " e diesel a " + precoDisel + ".");
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");

        if (intent.resolveActivity(activity.getPackageManager()) != null) activity.startActivity(intent);
    }
}

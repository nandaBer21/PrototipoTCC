package br.edu.ifsp.fuelprice;

public class Veiculo {

    public static final String VEICULO_ID = "br.edu.ifsp.fuelprice.VEICULO_ID";

    private int idVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private float autonomiaEtanol;
    private float autonomiaGasolina;
    private float autonomiaDisel;

    public Veiculo(int idVeiculo, String marca, String modelo, int ano, float autonomiaEtanol,
                   float autonomiaGasolina, float autonomiaDisel){
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.autonomiaEtanol = autonomiaEtanol;
        this.autonomiaGasolina = autonomiaGasolina;
        this.autonomiaDisel = autonomiaDisel;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getAutonomiaEtanol() {
        return autonomiaEtanol;
    }

    public void setAutonomiaEtanol(float autonomiaEtanol) {
        this.autonomiaEtanol = autonomiaEtanol;
    }

    public float getAutonomiaGasolina() {
        return autonomiaGasolina;
    }

    public void setAutonomiaGasolina(float autonomiaGasolina) {
        this.autonomiaGasolina = autonomiaGasolina;
    }

    public float getAutonomiaDisel() {
        return autonomiaDisel;
    }

    public void setAutonomiaDisel(float autonomiaDisel) {
        this.autonomiaDisel = autonomiaDisel;
    }
}

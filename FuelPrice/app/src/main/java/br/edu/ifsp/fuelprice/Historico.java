package br.edu.ifsp.fuelprice;

import java.util.ArrayList;

public class Historico {

    public static final String HISTORICO_ID = "br.edu.ifsp.fuelprice.HISTORICO_ID";

    private int idHistorico;
    private ArrayList<Veiculo> veiculos;
    private String dataAbastecimento;
    private String dataAtual;
    private float qtdeLitros;

    public Historico(int idHistorico, ArrayList<Veiculo> veiculos, String dataAbastecimento,
                     String dataAtual, float qtdeLitros){
        this.idHistorico = idHistorico;
        this.veiculos = veiculos;
        this.dataAbastecimento = dataAbastecimento;
        this.dataAtual = dataAtual;
        this.qtdeLitros = qtdeLitros;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public float getQtdeLitros() {
        return qtdeLitros;
    }

    public void setQtdeLitros(float qtdeLitros) {
        this.qtdeLitros = qtdeLitros;
    }
}

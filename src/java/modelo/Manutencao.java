

package modelo;

import java.sql.Date;


public class Manutencao {
    private int pk_manutencao;
    private Date data_entrada;
    private Date data_saida;
    private String tipoManutencao;
    private int fk_equipamento;
    private int fk_motorista;
    private float valorTotal;

    public Manutencao(int pk_manutencao, Date data_entrada, Date data_saida, String tipoManutencao, int fk_equipamento, int fk_motorista, float valorTotal) {
        this.pk_manutencao = pk_manutencao;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tipoManutencao = tipoManutencao;
        this.fk_equipamento = fk_equipamento;
        this.fk_motorista = fk_motorista;
        this.valorTotal = valorTotal;
    }

    public Manutencao(Date data_entrada, Date data_saida, String tipoManutencao, int fk_equipamento, int fk_motorista, float valorTotal) {
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tipoManutencao = tipoManutencao;
        this.fk_equipamento = fk_equipamento;
        this.fk_motorista = fk_motorista;
        this.valorTotal = valorTotal;
    }

    public Manutencao(Date data_entrada, Date data_saida, String tipoManutencao, float valorTotal) {
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tipoManutencao = tipoManutencao;
        this.valorTotal = valorTotal;
    }
    
    

    public int getPk_manutencao() {
        return pk_manutencao;
    }

    public void setPk_manutencao(int pk_manutencao) {
        this.pk_manutencao = pk_manutencao;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public int getFk_equipamento() {
        return fk_equipamento;
    }

    public void setFk_equipamento(int fk_equipamento) {
        this.fk_equipamento = fk_equipamento;
    }

    public int getFk_motorista() {
        return fk_motorista;
    }

    public void setFk_motorista(int fk_motorista) {
        this.fk_motorista = fk_motorista;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "manutencao{" + "pk_manutencao=" + pk_manutencao + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida + ", tipoManutencao=" + tipoManutencao + ", fk_equipamento=" + fk_equipamento + ", fk_motorista=" + fk_motorista + ", valorTotal=" + valorTotal + '}';
    }
    
    
    
}

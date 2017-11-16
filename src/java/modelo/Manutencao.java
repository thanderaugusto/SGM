

package modelo;


public class Manutencao {
    private int pk_manutencao;
    private String data_entrada;
    private String data_saida;
    private String tipoManutencao;
    private String tipoServico;
    private int fk_equipamento;
    private int fk_motorista;
    private double valorTotal;

    public Manutencao() {
    }

    public Manutencao(int pk_manutencao, String data_entrada, String data_saida, String tipoManutencao, int fk_equipamento, int fk_motorista, double valorTotal,String tipoServico) {
        this.pk_manutencao = pk_manutencao;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tipoManutencao = tipoManutencao;
        this.fk_equipamento = fk_equipamento;
        this.fk_motorista = fk_motorista;
        this.valorTotal = valorTotal;
        this.tipoServico = tipoServico;
    }

    public Manutencao(String data_entrada, String data_saida, String tipoManutencao, int fk_equipamento, int fk_motorista, double valorTotal, String tipoServico) {
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.tipoManutencao = tipoManutencao;
        this.fk_equipamento = fk_equipamento;
        this.fk_motorista = fk_motorista;
        this.valorTotal = valorTotal;
        this.tipoServico = tipoServico;
    }

    public int getPk_manutencao() {
        return pk_manutencao;
    }

    public void setPk_manutencao(int pk_manutencao) {
        this.pk_manutencao = pk_manutencao;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    
    
    @Override
    public String toString() {
        return "Manutencao{" + "pk_manutencao=" + pk_manutencao + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida + ", tipoManutencao=" + tipoManutencao + ", fk_equipamento=" + fk_equipamento + ", fk_motorista=" + fk_motorista + ", valorTotal=" + valorTotal + '}';
    }

    
    
    
}

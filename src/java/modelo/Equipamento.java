

package modelo;


public class Equipamento {
    private int pk_equipamento;
    private String frota;
    private String marca;
    private String modelo;
    private String ano;

    public Equipamento() {
    }
    
    

    public Equipamento(int pk_equipamento, String frota, String marca, String modelo, String ano) {
        this.pk_equipamento = pk_equipamento;
        this.frota = frota;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Equipamento(String frota, String marca, String modelo, String ano) {
        this.frota = frota;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Equipamento(int pk_equipamento, String frota) {
        this.pk_equipamento = pk_equipamento;
        this.frota = frota;
    }
    
    
    
    

    public int getPk_equipamento() {
        return pk_equipamento;
    }

    public void setPk_equipamento(int pk_equipamento) {
        this.pk_equipamento = pk_equipamento;
    }

    public String getFrota() {
        return frota;
    }

    public void setFrota(String frota) {
        this.frota = frota;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "equipamento{" + "pk_equipamento=" + pk_equipamento + ", frota=" + frota + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + '}';
    }
    
    
}

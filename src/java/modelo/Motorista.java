

package modelo;

import java.sql.Date;


public class Motorista {
    private int pk_motorista;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Motorista(int pk_motorista, String nome, String dataNascimento, String cpf) {
        this.pk_motorista = pk_motorista;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Motorista(String nome, String dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
    
    

    public int getPk_motorista() {
        return pk_motorista;
    }

    public void setPk_motorista(int pk_motorista) {
        this.pk_motorista = pk_motorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "motorista{" + "pk_motorista=" + pk_motorista + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + '}';
    }
    
    
}

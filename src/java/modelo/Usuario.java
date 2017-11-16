

package modelo;


public class Usuario {
    private int pk_usuario;
    private String nome;
    private String login;
    private String senha;

    public Usuario() {
    }

    
    
    public Usuario(int pk_usuario, String nome, String login, String senha) {
        this.pk_usuario = pk_usuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    
    

    public int getPk_usuario() {
        return pk_usuario;
    }

    public void setPk_usuario(int pk_usuario) {
        this.pk_usuario = pk_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "usuario{" + "pk_usuario=" + pk_usuario + ", nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
    
}

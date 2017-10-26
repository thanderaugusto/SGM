

package DAO;


import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Usuario;


public class UsuarioDAO {
     private final Connection connection;
     
     public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }    
    public  int create(Usuario u) throws SQLException{
      
           
        
         try (PreparedStatement stm = connection.prepareStatement("INSERT INTO usuarios(nome, login, senha) VALUES (?, ?, ?)")) {
             Statement stmt = (Statement) this.connection.createStatement();
             
             stm.setString(1, u.getNome());
             stm.setString(2, u.getLogin());
             stm.setString(3, u.getSenha());
             
             stm.execute();
             
             ResultSet rs = stm.getGeneratedKeys();
             rs.next();
             u.setPk_usuario(rs.getInt(1));
         }
       
        return u.getPk_usuario();
    }
    public  boolean validarAcesso(Usuario u) throws SQLException{
        
      
        
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM usuarios WHERE login = ? and senha = ?");
        Statement stmt = (Statement) this.connection.createStatement();
        
        stm.setString(1, u.getLogin());
        stm.setString(2, u.getSenha());
        
        stm.execute();
        
        ResultSet rs = stm.getResultSet();
        
        if (rs.next()){
            if(u.getLogin().equals(rs.getString("login")) && u.getSenha().equals(rs.getString("senha"))){
                return true;
            }
        }else{
            return false;
        }
        
        return false;
    }
}

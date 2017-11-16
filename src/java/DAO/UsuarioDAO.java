

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
    public boolean adicionar(Usuario u) throws SQLException{
            String sql = "INSERT INTO usuarios(nome, login, senha) VALUES (?, ?, ?)" ;
           
        
         try {
             PreparedStatement stm = connection.prepareStatement(sql);
             Statement stmt = (Statement) this.connection.createStatement();
             
             stm.setString(1, u.getNome());
             stm.setString(2, u.getLogin());
             stm.setString(3, u.getSenha());
             stm.execute();
             stm.close();
             return true;
         }catch (SQLException e) {
			System.out.println(e);
		}
        return false;
    }
    
    public  Usuario validarAcesso(String usuario, String senha) {
        
        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE login = ? and senha = ?";
        
        try {
            
            PreparedStatement stm = connection.prepareStatement(sql);
        
            stm.setString(1, usuario);
            stm.setString(2, senha);
                
            ResultSet rs = stm.executeQuery();
        
            while (rs.next()){
                user = new Usuario(rs.getInt("pk_usuario"), rs.getString("nome"), rs.getString("login"),rs.getString("senha"));
            }

	} catch (SQLException e) {
			System.out.println(e);
	}
    return user;
    }
    
    public Usuario retrieve() throws SQLException {
        String sql = "select nome from usuarios";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            Statement stmt = (Statement) this.connection.createStatement();
            
            stm.execute();

            ResultSet rs = stm.getResultSet();
            
            rs.next();
            
            Usuario u = new Usuario(rs.getString("nome"));
            
            return u;
    }

}


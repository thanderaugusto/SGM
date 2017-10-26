

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

}


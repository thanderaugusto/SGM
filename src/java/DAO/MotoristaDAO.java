

package DAO;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Motorista;


public class MotoristaDAO {
    
    private final Connection connection;
    
    public MotoristaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }    
    public boolean adicionar(Motorista m) throws SQLException{
            String sql = "INSERT INTO motoristas(nome, cpf, data_nascimento) VALUES (?, ?, ?)" ;
          
         try {
             PreparedStatement stm = connection.prepareStatement(sql);
             Statement stmt = (Statement) this.connection.createStatement();
             
             stm.setString(1, m.getNome());
             stm.setString(2, m.getCpf());
             stm.setString(3, m.getDataNascimento());
             stm.execute();
             stm.close();
             return true;
         }catch (SQLException e) {
			System.out.println(e);
		}
        return false;
    }
}



package DAO;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Equipamento;


public class EquipamentoDAO {
    
    private final Connection connection;

    public EquipamentoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    } 
    public boolean adicionar(Equipamento e) throws SQLException{
            String sql = "INSERT INTO equipamentos(frota, marca, modelo, ano) VALUES (?, ?, ?, ?))" ;
          

             PreparedStatement stm = connection.prepareStatement(sql);
             Statement stmt = (Statement) this.connection.createStatement();
             
             stm.setString(1, e.getFrota());
             stm.setString(2, e.getMarca());
             stm.setString(3, e.getModelo());
             stm.setString(4, e.getAno());
             stm.execute();
             stm.close();
             return true;


    }
    
    
    public ArrayList<Equipamento> retrieveAll() throws SQLException {
        String sql = "select * from equipamentos";
        
            PreparedStatement stm = connection.prepareStatement(sql);
            Statement stmt = (Statement) this.connection.createStatement();
            
            stm.execute();

            ResultSet rs = stm.getResultSet();
            
            ArrayList<Equipamento> aux = new ArrayList<>();

            while (rs.next()) {
                Equipamento caux = new Equipamento(rs.getInt("pk_equipamento"),
                                               rs.getString("frota"));
            aux.add(caux);
        }

        return aux;
    }
}

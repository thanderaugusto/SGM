package DAO;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Equipamento;
import modelo.Manutencao;


public class ManutencaoDAO {
    
    private final Connection connection;
    
    public ManutencaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public boolean adicionar(Manutencao m) throws SQLException{
            String sql = "INSERT INTO manutencoes(\n" +
"	data_entrada, data_saida, tipo_manutencao, fk_equipamento, fk_motorista, valor_total, tipo_servico)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?);" ;
          
         try {
             PreparedStatement stm = connection.prepareStatement(sql);
             Statement stmt = (Statement) this.connection.createStatement();
             
             stm.setString(1, m.getData_entrada());
             stm.setString(2, m.getData_saida());
             stm.setString(3, m.getTipoManutencao());
             stm.setInt(4,m.getFk_equipamento());
             stm.setInt(5,m.getFk_motorista());
             stm.setDouble(6, m.getValorTotal());
             stm.setString(7,m.getTipoServico());
             stm.execute();
             stm.close();
             
             return true;
         }catch (SQLException ex) {
			System.out.println(ex);
		}
        return false;
    }
    
    public int relatorioEquipamento(int fk_motorista) throws SQLException{
        String sql = "SELECT m.nome, mt.tipo_manutencao, mt.tipo_servico, mt.valor_total FROM motoristas m JOIN manutencoes mt ON\n" +
"	m.pk_motorista = mt.fk_motorista where = ?\n" +
"	order by pk_motorista ";
        
        PreparedStatement stm = connection.prepareStatement(sql);
        
            Statement stmt = (Statement) this.connection.createStatement();
            stm.setInt(1, fk_motorista);
            stm.execute();

            ResultSet rs = stm.getResultSet();
            
            rs.next();
            String nome = rs.getString("nome");
            String tipoManutencao = rs.getString("tipo_manutenca");
            String tipoServico = rs.getString("tipo_servico");
            double valorTotal = rs.getDouble("valor_total");
           
          System.out.println("\nNome: "+nome+"\n"
          + "Tipo Manutenção: "+tipoManutencao+"\n"
          + "Tipo Serviço :"+tipoServico+"\n"
          + "Valor Total: "+valorTotal);
        return fk_motorista;
    }
}



package validarBO;

import DAO.ManutencaoDAO;
import DAO.MotoristaDAO;
import java.sql.SQLException;
import modelo.Manutencao;
import modelo.Motorista;


public class ManutencaoBO {
    
     public static boolean adicionar(Manutencao manutencao) throws SQLException{
         if (manutencao.getData_entrada() != "" && manutencao.getData_saida() != "" && manutencao.getTipoManutencao() != "" && manutencao.getFk_equipamento() != 0 && manutencao.getFk_motorista() != 0 && manutencao.getValorTotal() != 0){
             ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
             return manutencaoDAO.adicionar(manutencao);
         }else{
             return false;
         }
     }
}

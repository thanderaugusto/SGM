package validarBO;

import DAO.EquipamentoDAO;
import java.sql.SQLException;
import modelo.Equipamento;


public class EquipamentoBO {
    public static boolean adicionar(Equipamento equipamento) throws SQLException{		
	if(equipamento.getFrota()!= "" && equipamento.getMarca()!= "" && equipamento.getModelo()!= "" && equipamento.getAno()!= ""){
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO();			
		return equipamentoDAO.adicionar(equipamento);
	}else{			
            return false;
	}
}
}

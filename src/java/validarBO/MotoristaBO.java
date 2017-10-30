package validarBO;

import DAO.MotoristaDAO;
import java.sql.SQLException;
import modelo.Motorista;

public class MotoristaBO {
    public static boolean adicionar(Motorista motorista) throws SQLException{		
	if(motorista.getNome() != "" && motorista.getDataNascimento()!= "" && motorista.getCpf()!= ""){
            MotoristaDAO motoristaDAO = new MotoristaDAO();			
		return motoristaDAO.adicionar(motorista);
	}else{			
            return false;
	}
}
}

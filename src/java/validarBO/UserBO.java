
package validarBO;

import DAO.UsuarioDAO;
import java.sql.SQLException;
import modelo.Usuario;

public class UserBO {
    public static boolean adicionar(Usuario user) throws SQLException{		
	if(user.getNome() != "" && user.getLogin() != "" && user.getSenha() != ""){
            UsuarioDAO userDao = new UsuarioDAO();			
		return userDao.adicionar(user);
	}else{			
            return false;
	}
}
}

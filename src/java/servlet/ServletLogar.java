/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;


@WebServlet("/Sgm_servlet")
public class ServletLogar extends HttpServlet {

    
    public ServletLogar() {
		super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        
//        boolean acesso = false;
//        String login = request.getParameter("login");
//        String senha = request.getParameter("senha");
//        
//        Usuario u1 = new Usuario();
//        
//        u1.setLogin(login);
//        u1.setSenha(senha);
//        
//        UsuarioDAO dao = new UsuarioDAO();
//        
//        try {
//            acesso = dao.validarAcesso(u1);
//        } catch (SQLException ex) {
//            Logger.getLogger(ServletLogar.class.getName()).log(Level.SEVERE, null, ex);
//            writer.printf("Erro: "+ex);
//        }
//        
//        if (acesso){
//            RequestDispatcher r = request.getRequestDispatcher("logado.jsp");
//            r.forward( request, response );
//        }else {
//            response.sendRedirect("/SGMT/index.jsp?falha=true");
//           
//        }
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario user = userDao.validarAcesso(request.getParameter("login"), request.getParameter("senha"));
        
        if(user != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("logado", "OK");
            session.setAttribute("id", user.getPk_usuario());
            session.setAttribute("nome", user.getNome());
            session.setAttribute("usuario", user.getLogin());
            response.sendRedirect("logado.jsp");
        }else {
                request.setAttribute("erroLogin", "Usuário ou senha incorreto");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp?falha=true");
                rd.forward(request, response);
        }
         
    }

}

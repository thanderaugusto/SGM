/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import validarBO.UserBO;


@WebServlet ("/ServletCadastrar")
public class ServletCadastrar extends HttpServlet {
    
    public ServletCadastrar() {
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Usuario user = new Usuario(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"));

		boolean resultado = false;
        try {
            resultado = UserBO.adicionar(user);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }

		HttpSession session = request.getSession(false);

		if (resultado==true) {
			if (session.getAttribute("logado") == "OK") {
				response.sendRedirect("logado.jsp?sucess=true");
                                
			} else {
				response.sendRedirect("logado.jsp?sucess=true");
			}
		} else {
			request.setAttribute("erroCadastro", "Erro ao cadastrar usuário, tente novamente.");
			RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
			rd.forward(request, response);
                }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.EquipamentoDAO;
import DAO.MotoristaDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.Manutencao;
import validarBO.ManutencaoBO;

/**
 *
 * @author Rharison
 */
@WebServlet(name = "ServletManutencao", urlPatterns = {"/ServletManutencao"})
public class ServletManutencao extends HttpServlet {
    
    public ServletManutencao(){
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
      
        try {
             EquipamentoDAO eqpDAO = new EquipamentoDAO();
             MotoristaDAO mtDAO = new MotoristaDAO();
            Manutencao m = new Manutencao(request.getParameter("dataEntManutencao"), 
                    request.getParameter("dataSaidManutencao"),
                    request.getParameter("tipoManutencao"), 
                    eqpDAO.retrieveFK(request.getParameter("frotaManutencao")), 
                    mtDAO.retrieveFK(request.getParameter("motManutencao")), 
                    Double.parseDouble(request.getParameter("valorManutencao")),
                    request.getParameter("tipoServico"));

            
                    boolean resultado = false;
            
                    resultado = ManutencaoBO.adicionar(m);   
                    
                    HttpSession session = request.getSession(false);

		if (resultado==true) {
			if (session.getAttribute("logado") == "nome") {
				response.sendRedirect("logado.jsp?sucess=true");
                                
			} else {
				response.sendRedirect("logado.jsp?sucess=true");
			}
		} else {
			request.setAttribute("erroCadastro", "Erro ao cadastrar usuário, tente novamente.");
			RequestDispatcher rd = request.getRequestDispatcher("logado.jsp?error=true");
			rd.forward(request, response);
                }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(ServletManutencao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}

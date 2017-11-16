/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.EquipamentoDAO;
import DAO.ManutencaoDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rharison
 */

@WebServlet("/ServletRelEquipamento")
public class ServletRelEquipamento extends HttpServlet {
    
    public ServletRelEquipamento(){
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.sendRedirect("index.jsp");
 EquipamentoDAO eqpDAO = new EquipamentoDAO();
        try {
            int fk = eqpDAO.retrieveFK(request.getParameter("frotaManutencao"));
        } catch (SQLException ex) {
            Logger.getLogger(ServletRelEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
         Document document = new Document();
          try {
             
              PdfWriter.getInstance(document, new FileOutputStream("E://Relatorio1.pdf"));

              document.open();
              ManutencaoDAO d = new ManutencaoDAO();
            
              document.add(new Paragraph("Manutenções por Motorista"));
              document.add(new Paragraph(d.relatorioEquipamento(2)));   
}
          catch(DocumentException | IOException de) {
              System.err.println(de.getMessage());
            
        } catch (SQLException ex) { 
            Logger.getLogger(ServletRelEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          document.close();
        }
           
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html; charset=UTF-8");
       

                
      }   
           
       
         
    }

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ajay
 */
public class ViewConcession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
                Statement stmt=con.createStatement();
                String query="Select * from concession";
                ResultSet rs=stmt.executeQuery(query);
                out.print("<center>");
                    out.print("<h1>Students</h1>");
                    out.print("<table border=1 width=50%>");
                    out.print("<tr>");
                    out.print("<td><center><b><i> Student ID  </i></b></center></td>");
                    out.print("<td><center><b><i> Concession No. </i></b></center></td>");
                    out.print("<td><center><b><i> Source </i></b></center></td>");
                    out.print("<td><center><b><i> Destination </i></b></center></td>");
                    out.print("<td><center><b><i> Class </i></b></center></td>");
                    out.print("<td><center><b><i> No Of Months </i></b></center></td>");
                    out.print("<td><center><b><i> Validity </i></b></center></td>");
                    out.print("<td><center><b><i> Token No </i></b></center></td>");
                    out.print("</tr>");
                while(rs.next()){
                    
                    

                }
                out.print("</table>");
                
                         
                
                
            }
            catch(Exception ex){
                out.println(ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

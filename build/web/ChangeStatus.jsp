<%-- 
    Document   : ChangeStatus
    Created on : Feb 4, 2018, 11:49:01 PM
    Author     : Ajay
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%try{
                int id=Integer.parseInt(request.getParameter("id"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
                PreparedStatement ps=conn.prepareStatement("Update Concession SET Status='Approve' where id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                out.println("<script>alert('Approved')</script>");
                RequestDispatcher rd=request.getRequestDispatcher("/ViewConcessionReq.jsp");
                rd.include(request, response);
            }
            catch(Exception ex)
            {
                out.print(ex);
            }
%>
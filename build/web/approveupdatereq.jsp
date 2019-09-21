<%-- 
    Document   : approveupdatereq
    Created on : Feb 5, 2018, 12:44:46 PM
    Author     : Ajay
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%try{
                String roll=request.getParameter("RollNo");
                String add=request.getParameter("Address");
                String email=request.getParameter("emailid");
                int id=Integer.parseInt(request.getParameter("id"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
                PreparedStatement ps=conn.prepareStatement("Update Requests SET IsApproved='Approved' where id=?");
                ps.setInt(1, id);
                int result=ps.executeUpdate();
                if(result>0){
                    PreparedStatement ps1=conn.prepareStatement("Update Student SET Address=?, emailid=? where RollNo=?");
                    ps1.setString(1, add);
                    ps1.setString(2, email);
                    ps1.setInt(3, Integer.parseInt(roll));
                    ps1.executeUpdate();
             
                }
                
                
                
                out.println("<script>alert('Approved,Details are updated R')</script>");
                RequestDispatcher rd=request.getRequestDispatcher("/UpdateReq.jsp");
                rd.include(request, response);
            }
            catch(Exception ex)
            {
                out.print(ex);
            }
%>
<%-- 
    Document   : feedbackStud
    Created on : Jan 30, 2018, 3:39:31 PM
    Author     : Ajay
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String email,description;
    
try{
    email=request.getParameter("emailid");
    description=request.getParameter("Description");
    JSONObject obj = new JSONObject();
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
    PreparedStatement ps=con.prepareStatement("insert into Feedback(emailid,Description) values(?,?)");
    
    ps.setString(1, email);
    ps.setString(2, description);
    
    int res=ps.executeUpdate();
    
    if (res>0) {
            System.out.println("Entered");
            obj.put("Feed", "Feedback submitted successfully");
            
    }else {
            System.out.println("Entered here");
            obj.put("Feed", "Feedback not submitted");
            
            
        }
        out.println(obj);
    
    
    
}
catch(Exception ex){
    ex.printStackTrace();
}
%>


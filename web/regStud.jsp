<%-- 
    Document   : regStud
    Created on : Jan 20, 2018, 12:30:25 AM
    Author     : Ajay
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
    String fee_reciept,Name,RollNo,DOB,Address,Mobile,email;
    
try{
    
    Name=request.getParameter("Name");
    RollNo=request.getParameter("RollNo");
    DOB= request.getParameter("DOB");
    Address=request.getParameter("Address");
    Mobile=request.getParameter("Mobile");
    email=request.getParameter("emailid");
    fee_reciept=request.getParameter("Fee_reciept_no");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
    PreparedStatement ps=con.prepareStatement("insert into student(Name,RollNo,DOB,Address,Mobile,emailid,Fee_reciept_no) values(?,?,?,?,?,?,?)");
    
    ps.setString(1, Name);
    ps.setInt(2, Integer.parseInt(RollNo));
    ps.setString(3, DOB);
    ps.setString(4, Address);
    ps.setString(5, Mobile);
    ps.setString(6, email);
    ps.setInt(7, Integer.parseInt(fee_reciept));
    
    
    
    int result =ps.executeUpdate();
    
    out.println(result + "");
    
}
catch(Exception ex){
    ex.printStackTrace();
}
%>


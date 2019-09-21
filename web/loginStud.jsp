<%-- 
    Document   : loginStud
    Created on : Jan 23, 2018, 8:13:46 AM
    Author     : Ajay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, org.json.*"%>

<%
    String username,password;
    
    
    try{
        username=request.getParameter("RollNo");
        password=request.getParameter("DOB");
        JSONObject obj = new JSONObject();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps=con.prepareStatement("select Name,emailid,Address from student where RollNo=? and DOB=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
	
	if (result.next()) {    
            System.out.println("Entered");
            obj.put("rollno",username);
            obj.put("name",result.getString(1));
            obj.put("address",result.getString(3));
            obj.put("emailid",result.getString(2));
	}else {
            System.out.println("Entered here");
            obj.put("rollno",0);
            obj.put("name",0);
            obj.put("emailid", 0);
            obj.put("address",0);
        }
        out.println(obj);
    }
    catch(Exception ex){
    ex.printStackTrace();
    }
        
%>
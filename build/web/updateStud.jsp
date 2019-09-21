<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String roll,address,email;
    
    try{
        roll=request.getParameter("RollNo");
        address=request.getParameter("Address");
        email=request.getParameter("emailid");
        JSONObject obj=new JSONObject();


        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps=con.prepareStatement("Insert into Requests(RollNo,Address,emailid) values(?,?,?)");
        ps.setInt(1, Integer.parseInt(roll));
        ps.setString(2, address);
        ps.setString(3, email);
        

        int res=ps.executeUpdate();

        if(res>0){
            System.out.println("Submitted");
            obj.put("Add","Details Updated Successfully");
        }
        else{
            System.out.println("Not Submitted");
            obj.put("Add","Details Not Updated");
        }
        System.out.println(obj);
        out.println(obj);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
%>
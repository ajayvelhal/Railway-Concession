<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String Name,Source,Destination,Clss,noOfMonths,TokenNo,Date;
    int RollNo;

    try{
        RollNo=Integer.parseInt(request.getParameter("RollNo"));    
        JSONArray arr= new JSONArray();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps2=con.prepareStatement("select TokenNo,Date from Schedule where RollNo=? order by id desc LIMIT 1");
        ps2.setInt(1,RollNo);
        ResultSet rs2=ps2.executeQuery();
        if(rs2.next()){
            System.out.println("entered");
            JSONObject obj=new JSONObject();
            TokenNo=rs2.getString(1);
            Date=rs2.getString(2);
            obj.put("token", TokenNo);
            obj.put("date", Date);
            arr.put(obj);
        }
        System.out.println(arr);
        out.println(arr);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
%>

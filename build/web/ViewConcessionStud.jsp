<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String Name,Source,Destination,Clss,noOfMonths,TokenNo;
    int RollNo,id;

    try{
        RollNo=Integer.parseInt(request.getParameter("RollNo"));
        
        JSONArray arr= new JSONArray();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps2=con.prepareStatement("select id,TokenNo from Schedule where RollNo=? order by id desc LIMIT 1");
        ps2.setInt(1,RollNo);
        ResultSet rs2=ps2.executeQuery();
        if(rs2.next()){
            JSONObject obj=new JSONObject();
            TokenNo=rs2.getString(2);
            id=rs2.getInt(1);
            obj.put("TokenNo", TokenNo);
            
            PreparedStatement ps1=con.prepareStatement("Select Source,Destination,Class,NoOfMonths from Concession where id=?");
            ps1.setInt(1, id);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){
                    Source=rs1.getString(1);
                    Destination=rs1.getString(2);
                    Clss=rs1.getString(3);
                    noOfMonths=rs1.getString(4);
                    obj.put("Source",Source);
                    obj.put("Destination",Destination);
                    obj.put("Clss",Clss);
                    obj.put("NoOfMonths",noOfMonths);
                    arr.put(obj);
            }          
        }
        System.out.println(arr);
        out.println(arr);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
%>
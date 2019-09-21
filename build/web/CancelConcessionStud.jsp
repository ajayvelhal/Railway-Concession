<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    int Roll, id;
    try{
        Roll=Integer.parseInt(request.getParameter("RollNo"));
        System.out.println(Roll + "");
        JSONObject obj= new JSONObject();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps=conn.prepareStatement("Select id,date from Schedule where RollNo=? order by id desc LIMIT 1");
        ps.setInt(1, Roll);
        ResultSet rs=ps.executeQuery();
        rs.next();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-mm");
            java.util.Date conn_date = df.parse(rs.getString(2));
            java.util.Date curr_date = new java.util.Date();
            long diff = curr_date.getTime() - conn_date.getTime();
            long elapsedDays = diff / 86400000;
            id=rs.getInt(1);
            System.out.println("Diff Days " + elapsedDays);
            if(elapsedDays<2){
                out.println("0");
            }else{
                PreparedStatement ps1=conn.prepareStatement("Update Schedule set IsCancelled=1 where id=?");
                ps1.setInt(1, id);
                int res=ps1.executeUpdate();
                if(res>0){
                    System.out.println("Deleted");
                    out.println("1");
                }
                else{
                    System.out.println("Not Deleted");
                    out.println("2");
                }
            }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
%>

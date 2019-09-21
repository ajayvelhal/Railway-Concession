<%-- 
    Document   : UpdateReq
    Created on : Feb 5, 2018, 12:08:54 PM
    Author     : Ajay
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession hs=request.getSession();
    if(hs.getAttribute("uname")==null)
    {%>
    <script language=\"javascript\"type=\"text/javascipt\">"+"alert('please login first');" + "</script>
    
    <%
        response.sendRedirect("login.jsp");
        }
%>
<html>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
        body{
            margin: 0px;
            background:  url(white.jpeg);
            
            background-size: cover;
            background-position: center;
        }
         .nav{
            width: 100%;
            background:#1a1400;
            height: 40px;
            margin-top: 50px;
            
        }
        
        ul{
            margin: 0px;
            padding: 0px;
          }
          
          ul li a{
              background: black;
              text-decoration: none;
              color: white;
              display: block;
            
          }
          
          ul li{
              float: left;
              width: 190px;
              height: 40px;
              background-color: #1a1400e;
              font-size: 12px;
              line-height: 40px;
              text-align: center;              
              opacity: .85;           
          }
          
          ul li a:hover{
              text-decoration: none;
              background-color: #ffcc00;
          }
          
          ul li ul li{
              display: none;
          }
          ul li:hover ul li{
              display: block;
          }
          
    </style>
    <body>
         <li style="position:absolute; top: 58px; left: 1180px;color:white;font-size: 14px">Welcome <%=hs.getAttribute("uname")%></li>
        <div class="nav">
            <ul>
                <li><a href="#">HOME</a></li>
                <li><a href="remove.jsp">REMOVE STUDENT </a></li>
                <li><a href="ViewConcessionReq.jsp"> CONCESSION REQUESTS </a></li>
                <li><a href="UpdateReq.jsp"> UPDATE REQUESTS </a></li>                
                <li><a href="ViewFeedback.jsp">FEEDBACK</a></li>
                <li><a href="Logout">LOGOUT</a></li>
            </ul>
                
        </div>
        <h2 align="center"><font><strong>Update Requests</strong></font></h2>
        <table align="center" cellpadding="10" cellspacing="10" border="2">
            <tr>
                <tr bgcolor="#fff">
                    <td><b>ID</b></td>
                    <td><b>Roll No</b></td>
                    <td><b>Address</b></td>
                    <td><b>Email ID</b></td>
                    <td><b>Status</b></td>
                    <td><b>Action</b></td>

                
                <%
                    try{
                        
                        
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
                        
                        String sql="select * from Requests ";
                        Statement stmt=conn.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while(rs.next()){
                           String id=rs.getString("id");
                           String rollno=rs.getString("RollNo");
                           String add=rs.getString("Address");
                           String email=rs.getString("emailid");
                           String approve=rs.getString("IsApproved");
                           if(approve == null){
                               approve = "Pending";
                           }
                           String queryString = "?id=" + id + "&RollNo=" + rollno + "&Address=" +add + "&emailid=" +email+ "&Approved=" + approve;
                %>
                            <tr bgcolor="#fff">
                                <td align="center"><%=id %></td>                                
                                <td align="center"><%=rollno %></td>
                                <td align="center"><%=add %></td>
                                <td align="center"><%=email %></td>
                                <td align="center"><%=approve %></td>
                       
                            <form action="approveupdatereq" method="GET">
                                <%if(!approve.equals("Approved")){%>
                                <td><%out.println("<a href='approveupdatereq.jsp"+ queryString
                                        + "'class='btn btn-primary' role='button'>UPDATE</a>");%></td>
                                <%}else{%>
                                <td></td>
                                <%}%>
                            </form>
                            
                            </tr>
                        
                        <%
                            }
                        }
                        catch(Exception ex){
                            ex.printStackTrace();
                    }
                    
                    %>
        </table>
    </body>
</html>

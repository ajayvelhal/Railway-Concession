<%-- 
    Document   : ViewConcessionReq
    Created on : Jan 20, 2018, 12:26:47 AM
    Author     : Ajay
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <h2 align="center"><font><strong>Concession Requests</strong></font></h2>
        <table align="center" cellpadding="20" cellspacing="3" border="2" style="width: 80%">
            <tr>
                <tr bgcolor="#fff">
                <td align="center"><b>ID</b></td>
                <td align="center"><b>Roll No</b></td>
                <td align="center"><b>Token no</b></td>
                <td align="center"><b>Date</b></td>
                <td align="center"><b>Source</b></td>
                <td align="center"><b>Destination</b></td>
                <td align="center"><b>Class</b></td>
                <td align="center"><b>No of Months</b></td>
                <td align="center"><b>Status</b></td>
                <td align="center"><b>Action</b></td>
                <%
                    try{
                        
                        SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy");
                        String  curr=df.format(new java.util.Date());
                        out.println("Date:"+curr);
                        /*java.util.Date  date=new java.util.Date(curr);
                        
                        java.sql.Date date1=new java.sql.Date(date.getTime());
                        out.println(""+date1);*/
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
                        
                        String sql="select Schedule.id,Schedule.RollNo,Schedule.TokenNo,Schedule.Date,Concession.Source,Concession.Destination,Concession.Class,Concession.NoOfMonths,Concession.Status from Schedule INNER JOIN Concession ON Schedule.ID=Concession.id where Schedule.date like ?";
                        PreparedStatement ps=conn.prepareStatement(sql);
                        ps.setString(1, "%"+curr);
                        ResultSet rs=ps.executeQuery();
                        while(rs.next()){%>
                            <tr bgcolor="#fff">
                            <td align="center"><%=rs.getString("id") %></td>
                            <td align="center"><%=rs.getString("RollNo") %></td>
                            <td align="center"><%=rs.getString("TokenNo") %></td>
                            <td align="center"><%=rs.getString("Date") %></td>
                            <td align="center"><%=rs.getString("Source") %></td>
                            <td align="center"><%=rs.getString("Destination") %></td>
                            <td align="center"><%=rs.getString("Class") %></td>
                            <td align="center"><%=rs.getString("NoOfMonths") %></td>
                            <td align="center"><%=rs.getString("Status")%></td>
                            <form action="ChangeStatus" method="GET">
                                <td align="center"><%out.println("<a href='ChangeStatus.jsp?id="+rs.getString("id")+"' class='btn btn-primary' role='button'>UPDATE</a>");%></td>
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
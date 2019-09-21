<%-- 
    Document   : ViewFeedback
    Created on : Feb 2, 2018, 11:33:47 PM
    Author     : Ajay
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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

        <h2 align="center"><font><strong>FEEDBACK</strong></font></h2>
        <table align="center" cellpadding="20" cellspacing="3" border="2" style="width: 60%;">
            <tr bgcolor="#fff">
            <td align="center"><b>ID</b></td>
            <td align="center"><b>Email-ID</b></td>
            <td align="center"><b>Feedback</b></td>

            </tr>

<%
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        Statement st=conn.createStatement();
        String qry= "Select * from Feedback";
        ResultSet rs=st.executeQuery(qry);
        while(rs.next()){
    %>
<tr bgcolor="#fff">
<td align="center"><%=rs.getString("ID") %></td>
<td align="center"><%=rs.getString("emailid") %></td>
<td align="center"><%=rs.getString("Description") %></td>
</tr> 
<%}
}catch(Exception ex){
        ex.printStackTrace();
    }
    
%>
</table>
    

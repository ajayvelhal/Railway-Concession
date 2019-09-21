<%-- 
    Document   : homepage
    Created on : Jan 20, 2018, 12:11:04 AM
    Author     : Ajay
--%>

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
    <head>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
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
              font-size: 14px;
              line-height: 40px;
              text-align: center;              
              opacity: .85;
              
          }
          
          ul li a:hover{
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
            
      
   
 

        
</body>
</html>

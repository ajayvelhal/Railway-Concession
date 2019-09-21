<%-- 
    Document   : remove
    Created on : Jan 20, 2018, 12:24:36 AM
    Author     : Ajay
--%>

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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
         
        .loginbox{
                width: 320px;
                height: 350px;
                background: #000;
                color: #fff;
                top: 50%;
                left: 50%;
                margin-top: 20px;
                position: absolute;
                transform: translate(-50%,-50%);
                box-sizing: border-box;
                padding: 70px 30px;
            }
            
         .loginbox h1{
                margin: 0;
                padding:0 0 20px;
                text-align: center;
                font-size: 22px;
                font-weight: bold;
            }
            .loginbox p{
                margin: 0;
                margin-top: 5px;
                padding: 0;
                font-weight: bold;
                font-size: 30px;
                position: relative;
                text-align: center;
            }
             .loginbox input{
                width: 100%;
                margin-bottom: 40px;
            }
            .loginbox input[type="text"]{
                border: none;
                margin-top: 40px;
                border-bottom: 1px solid #fff;
                background: transparent;
                outline: none;
                height: 40px;
                font-size: 16px;
                color: #fff;
            }
            .loginbox input[type="submit"]{
                height: 70px;
                border:none;
                outline: none;
                height: 40px;
                background: #fb2525;
                color: #fff;
                font-size: 18px;
                border-radius: 20px;
            }
            
            .loginbox input[type="submit"]:hover{
                cursor: pointer;
                background: #ffc107;
                color:#000;
            }
            h1{
               text-align: center; 
            }
    </style>
    <body>

        
        <li style="position:absolute; top: 58px; left: 1180px;color:white;font-size: 16px">Welcome <%=hs.getAttribute("uname")%></li>
        <div class="nav">
            <ul>
                <li><a href="homepage.jsp">HOME</a></li>
                <li><a href="remove.jsp">REMOVE STUDENT </a></li>
                <li><a href="ViewConcessionReq.jsp"> CONCESSION REQUESTS </a></li>
                <li><a href="UpdateReq.jsp"> UPDATE REQUESTS </a></li>                
                <li><a href="ViewFeedback.jsp">FEEDBACK</a></li>
                <li><a href="Logout">LOGOUT</a></li>
            </ul>        
            </div>
        <h1>Remove Student</h1>
                
                <div class="loginbox">
            <form action="remove" method="POST">
                
                <p>Roll No</p>
                <input type="text" name="Roll" placeholder="Enter Roll No">
                <input type="submit" name="submit" value="Remove">                
            </form>    
            
        </div>
    </body>
</html>

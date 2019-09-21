package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            margin: 0 auto;\n");
      out.write("            padding: 0;\n");
      out.write("            background: url(white.jpeg);\n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("            font-family: sans-serif;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .loginbox{\n");
      out.write("                width: 320px;\n");
      out.write("                height: 420px;\n");
      out.write("                background: #000;\n");
      out.write("                color: #fff;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                position: absolute;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                padding: 70px 30px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .avatar{\n");
      out.write("                width: 100px;\n");
      out.write("                height: 100px;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                position: absolute;\n");
      out.write("                top: -50px;\n");
      out.write("                left: calc(50%,-50px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h1{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0 0 20px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .loginbox p{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .loginbox input{\n");
      out.write("                width: 100%;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .loginbox input[type=\"text\"], input[type=\"password\"]{\n");
      out.write("                border: none;\n");
      out.write("                border-bottom: 1px solid #fff;\n");
      out.write("                background: transparent;\n");
      out.write("                outline: none;\n");
      out.write("                height: 40px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            .loginbox input[type=\"submit\"]{\n");
      out.write("                border:none;\n");
      out.write("                outline: none;\n");
      out.write("                height: 40px;\n");
      out.write("                background: #fb2525;\n");
      out.write("                color: #fff;\n");
      out.write("                font-size: 18px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("            .loginbox input[type=\"submit\"]:hover{\n");
      out.write("                cursor: pointer;\n");
      out.write("                background: #ffc107;\n");
      out.write("                color:#000;\n");
      out.write("            }\n");
      out.write("            .loginbox a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 12px;\n");
      out.write("                line-height: 20px;\n");
      out.write("                color: darkgray;\n");
      out.write("             }\n");
      out.write("             .loginbox a:hover{\n");
      out.write("                 color: #ffc107;\n");
      out.write("             }\n");
      out.write("    \n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"loginbox\">\n");
      out.write("            <img src=\"avatar.png\" class=\"avatar\">\n");
      out.write("            <h1> Login Here </h1>\n");
      out.write("            <form action=\"Login\" method=\"POST\">\n");
      out.write("                <p>Username</p>\n");
      out.write("                <input type=\"text\" name=\"uname\" placeholder=\"Enter Username\">\n");
      out.write("                <p>Password</p>\n");
      out.write("                <input type=\"password\" name=\"pass\" placeholder=\"Enter Password\">\n");
      out.write("                <input type=\"submit\" name=\"submit\" value=\"Login\">\n");
      out.write("                <a href=\"#\">Forgot Password</a>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

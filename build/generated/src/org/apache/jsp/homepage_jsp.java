package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    HttpSession hs=request.getSession();
    if(hs.getAttribute("uname")==null)
    {
      out.write("\n");
      out.write("    <script language=\\\"javascript\\\"type=\\\"text/javascipt\\\">\"+\"alert('please login first');\" + \"</script>\n");
      out.write("    \n");
      out.write("    ");

        response.sendRedirect("login.jsp");
        }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            margin: 0px;\n");
      out.write("            background-image: 4236532-background-images;\n");
      out.write("            \n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("        }\n");
      out.write("         .nav{\n");
      out.write("            width: 100%;\n");
      out.write("            background: gainsboro;\n");
      out.write("            height: 40px;\n");
      out.write("            margin-top: 50px;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        ul{\n");
      out.write("            margin: 0px;\n");
      out.write("            padding: 0px;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          ul li a{\n");
      out.write("              text-decoration: none;\n");
      out.write("              color: black;\n");
      out.write("              display: block;\n");
      out.write("            \n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          ul li{\n");
      out.write("              float: left;\n");
      out.write("              width: 200px;\n");
      out.write("              height: 40px;\n");
      out.write("              background-color: white;\n");
      out.write("              font-size: 16px;\n");
      out.write("              line-height: 40px;\n");
      out.write("              text-align: center;              \n");
      out.write("              opacity: .85;\n");
      out.write("              \n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          ul li a:hover{\n");
      out.write("              background-color: maroon;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          ul li ul li{\n");
      out.write("              display: none;\n");
      out.write("          }\n");
      out.write("          ul li:hover ul li{\n");
      out.write("              display: block;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("    </style>\n");
      out.write("        \n");
      out.write("           \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    <li style=\"position:absolute; top: 58px; left: 1180px;color:#33033;font-size: 20px\">Welcome ");
      out.print(hs.getAttribute("uname"));
      out.write("</li>\n");
      out.write("        <div class=\"nav\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\">HOME</a></li>\n");
      out.write("                <li><a href=\"remove.jsp\">REMOVE STUDENT </a></li>\n");
      out.write("                <li><a href=\"#\"> CONCESSION </a>\n");
      out.write("                \n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"ViewConcessionReq.jsp\"> VIEW CONCESSION </a> </li>\n");
      out.write("                        <li><a href=\"#\">VIEW STATUS </a> </li>\n");
      out.write("                        <li><a href=\"#\">CHANGE STATUS </a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                <li><a href=\"ViewFeedback.jsp\">FEEDBACK</a></li>\n");
      out.write("                <li><a href=\"Logout\">LOGOUT</a></li>\n");
      out.write("            </ul>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("      \n");
      out.write("   \n");
      out.write(" \n");
      out.write("\n");
      out.write("        \n");
      out.write("</body>\n");
      out.write("</html>\n");
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

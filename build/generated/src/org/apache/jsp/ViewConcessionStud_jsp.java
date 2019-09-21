package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class ViewConcessionStud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
 String Name,Source,Destination,Clss,noOfMonths,TokenNo;
    int RollNo,id;

    try{
        RollNo=Integer.parseInt(request.getParameter("RollNo"));
        /*Name=request.getParameter("Name");
        Source=request.getParameter("Source");
        Destination= request.getParameter("Destination");
        Clss=request.getParameter("Class");
        noOfMonths=request.getParameter("NoOfMonths");
        TokenNo=request.getParameter("TokenNo");*/
        
        
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
            out.println(""+TokenNo);
            obj.put("token", TokenNo);
            
            PreparedStatement ps1=con.prepareStatement("Select Source,Destination,Class,NoOfMonths from Concession where id=?");
            ps1.setInt(1, id);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){
                    Source=rs1.getString(1);
                    Destination=rs1.getString(2);
                    Clss=rs1.getString(3);
                    noOfMonths=rs1.getString(4);
                    out.println(Source);
                    obj.put("source",Source);
                    obj.put("dest",Destination);
                    obj.put("Class",Clss);
                    obj.put("nom",noOfMonths);
                    arr.put(obj);
            }          
        }
        out.println(arr);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }

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

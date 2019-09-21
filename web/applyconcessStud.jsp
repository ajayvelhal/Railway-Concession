

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,org.json.*"%>

<%
    String Source,Destination,Clss,noOfMonths;
    String date = null;
    int RollNo = 0;
    JSONObject obj = new JSONObject();
    try{

        RollNo=Integer.parseInt(request.getParameter("RollNo"));
        Source=request.getParameter("Source");
        Destination= request.getParameter("Destination");
        Clss=request.getParameter("Class");
        noOfMonths=request.getParameter("NoOfMonths");
        date=request.getParameter("Date");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajay","root","root");
        PreparedStatement ps=con.prepareStatement("select max(date) from schedule where rollno=?");
        ps.setInt(1,RollNo);
        System.out.println("Roll no -" + RollNo);
        ResultSet rst = ps.executeQuery();
        rst.next();
        if(rst.getString(1) != null){
            SimpleDateFormat df = new SimpleDateFormat("YYYY-DD-MM");
            java.util.Date prev_date = df.parse(rst.getString(1));
            java.util.Date curr_date = df.parse(date);
            long diff = curr_date.getTime() - prev_date.getTime();
            long elapsedDays = diff / 86400000;
            System.out.println("Diff Days " + elapsedDays);
            if(elapsedDays < 87){
                obj.put("message","Last Concession taken before 87 days");
                out.println(obj);
                return;
            }
            
        }
        int token = 0;
        PreparedStatement pstmt = con.prepareStatement("select count(*),count(isCancelled) from schedule where date=?");
        pstmt.setString(1,date);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            int initialToken = rs.getInt(1);
            int cancelled = rs.getInt(2);
            if(cancelled == 0){
                token = initialToken;
            }else{
                PreparedStatement pstmt2 = con.prepareStatement("select tokenNo from schedule where date=? and isCancelled=1");
                pstmt2.setString(1,date);
                ResultSet rs2 = pstmt2.executeQuery();
                rs2.next();
                token = rs.getInt(1);
            }
            if(token >=60){
                Statement stmt = con.createStatement();
                ResultSet rs2 = stmt.executeQuery("select min(distinct date) from schedule where date not in (select date from schedule where count(*)=60)");
                if(rs2.next()){
                    obj.put("message","No token available for this date. Nearest date is " + rs2.getString(1));
                }else{
                    obj.put("message","No token available. Select another date");
                }
                out.println(obj);
                return;
            }else{
                token++;
            }
        }else{
            token = 1;
        }
        PreparedStatement ps2 = con.prepareStatement("insert into schedule(rollno,tokenno,date) values(?,?,?)");
        ps2.setInt(1,RollNo);
        ps2.setInt(2,token);    
        ps2.setString(3, date);
        int result = ps2.executeUpdate();
        ps2.close();
        ps2 = con.prepareStatement("select id from schedule where rollno=? order by id desc limit 1");
        ps2.setInt(1,RollNo);
        ResultSet rs3 = ps2.executeQuery();
        if(rs3.next()){
            PreparedStatement ps4 = con.prepareStatement("insert into concession(id,rollno,source,destination,class,noofmonths) values(?,?,?,?,?,?)");
            ps4.setInt(1,rs3.getInt(1));
            ps4.setInt(2,RollNo);
            ps4.setString(3, Source);
            ps4.setString(4, Destination);
            ps4.setString(5, Clss);
            ps4.setInt(6,Integer.parseInt(noOfMonths));
            int res = ps4.executeUpdate();
            if(res > 0){
                obj.put("message","Applied Successfully. Token No " + token);
            }else{
                obj.put("message","Network Error");
            }
        }
        out.println(obj);
    }
    catch(Exception ex){
        System.out.println("Catch entered");
        ex.printStackTrace();
    }
%>


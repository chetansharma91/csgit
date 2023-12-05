<%@page import="java.sql.DriverManager"%>
<%@include file="info.jsp"%>

<%
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
java.sql.Statement stmt=con.createStatement();
java.sql.ResultSet rs = stmt.executeQuery("select * from productinfo");





%>


<html>
   
    <body>
        <h1>Product-List!</h1>
        <table border="2">
            <tr>
                  <td>pcod</td>
                  <td>ptitle</td>
                  <td>pdesc</td>
                  <td>catagory</td>
                  <td>price</td>
                <td>Tax</td>
                
            </tr>
            <%
            
            while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            String s5=rs.getString(5);
            %>
            <tr>
                <td><%=s1%></td>
                <td><%=s2%></td>
                <td><%=s3%></td>
                <td><%=s4%></td>
                <td><%=s5%></td>
              
            </tr>
            
            <%
            }
            con.close();
            %>
        </table>
    </body>
</html>
<%@include file="footer.jsp" %>
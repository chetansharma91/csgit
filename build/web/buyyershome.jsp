
<%
   int n= session.getMaxInactiveInterval();
   long val = session.getCreationTime();
   java.util.Date dt= new java.util.Date(val);
Cookie ck[]=request.getCookies();
String userchoice="all";
String userName=(String)session.getAttribute("username");
if(userName==null){
    response.sendRedirect("index.jsp");
    
}
for(Cookie c:ck){
    String name=c.getName();
    if(name.equals("choice"))
    {
        userchoice=c.getValue();
    }
}






%>
<html>
    
    <body>
        
        <h1>Buyyer Page!</h1>
        <h2>welcome <%=userName%></h2>
        <h3>you are on this site since<%=dt.toString() %></h3>
        <h4>if you are idle on this site <%=n %>sec your session is expire</h4>
        <hr>
        <a href="ShowCategories"> Explore-Store</a><br>
        <a href="productlist.jsp">View-all-Product</a><br>
        <a href=""> Search-Product</a><br>
        <a href="DisplyCart"> View-Cart</a><br>
        <a href="">Log-Out</a><br>
        
        
        <hr>
    <marquee><h3> Attractive disscount on <%=userchoice%></h3></marquee>
    </body>
</html>

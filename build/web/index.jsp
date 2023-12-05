<%
    session.setMaxInactiveInterval(150);
String v1="",v2="";

Cookie ck[] = request.getCookies();
if(ck!=null){
    for(int i=1;i<ck.length;i++)
    {
        Cookie c= ck[i];
        String name = c.getName();
        if(name.equals("userid")){
            v1=c.getValue();
        }else if(name.equals("password")){
            v2=c.getValue();
        }
    }
}





%> 
<html>
    
    <body>
        <h1>Online Shopping</h1>
        <hr>
        <form action="VerifyUser2 ">
            <pre>
            Userid         <input type="text"name="userid"value="<%=v1%>"/>
            Password       <input type="password"name="password"value="<%=v2%>"/>
            UserType       <select name="usertype">
                           <option> buyyer</option>
                           <option> admin </option>
    
                      </select>
          Save-Password    <input type="checkbox" name="save" value="yes"/>
                           <input type="submit" value="login"/>
              </pre>
            </form>
        <hr>
        <a href="registration.jsp">new user</a>
    </body>
</html>

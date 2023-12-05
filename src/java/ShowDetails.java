

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowDetails extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id =request.getParameter("pid");
        try{
            Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
 String qr="select * from productinfo  where pcod=?";
PreparedStatement ps= con.prepareStatement(qr);
ps.setInt(1, Integer.parseInt(id));
ResultSet rs = ps.executeQuery();
               out.println("<html>");
               out.println("<body>");
        
               out.println("<h3>  select desired product </h3>");
               out.println("<hr>");
               rs.next();
               String s1 =rs.getString(1);
               String s2 =rs.getString(2);
               String s3 =rs.getString(3);
               String s4 =rs.getString(4);
               String s5 =rs.getString(5);
               out.println("<table border=2>");
               out.println("<tr>");
               out.println("<td>pcod </td>");
               out.println("<td>"+s1+" </td>");
                out.println("</tr>");
                out.println("<tr>");
               out.println("<td>ptitle </td>");
               out.println("<td>"+s2+" </td>");
                out.println("</tr>");
                out.println("<tr>");
               out.println("<td>pdesc </td>");
               out.println("<td>"+s3+" </td>");
                out.println("</tr>");
                out.println("<tr>");
               out.println("<td>catagory</td>");
               out.println("<td>"+s4+" </td>");
                out.println("</tr>");
                out.println("<tr>");
               out.println("<td>price </td>");
               out.println("<td>"+s5+" </td>");
                out.println("</tr>");
                
                
                
               out.println("</table>");
               out.println("<a href=CartManager?pid="+s1+">Add-Product-to-cart</a><br>");
                
                out.println("<a href=ShowCategories>Categories-Page</a><br>");
                out.println("<a href=buyyershome.jsp>Buyyer-Home</a>");
               
               out.println("<hr>");
                out.println("</body>");
                out.println("</html>");
        }
catch(Exception e){
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

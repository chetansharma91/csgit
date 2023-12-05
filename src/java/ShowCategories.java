

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShowCategories extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String name=(String)session.getAttribute("username");
        
        if(name==null){
            response.sendRedirect("index.jsp");
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
 String qr="select distinct catagory from productinfo  order by catagory ";
PreparedStatement ps= con.prepareStatement(qr);
ResultSet rs = ps.executeQuery();
 out.println("<html>");
               out.println("<body>");
               out.println("<h2>Welcome  "+name+" </h2>");
               out.println("<h3>  select desired category </h3>");
               out.println("<hr>");
               while(rs.next()){
                   String s= rs.getString(1);
                   out.println("<a href=showitems?cat="+s+">");
                   out.println(s);
                   out.println("</a>");
                    out.println("<br>");
               }
        
              out.println("<hr>");
        out.println("<a href=buyyershome.jsp>Buyyer-Home</a>");
              out.println("</body>");
              out.println("</html>");
 
 
 con.close();
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

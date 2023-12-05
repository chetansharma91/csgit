/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VerifyUser2 extends HttpServlet {

   Connection con; PreparedStatement ps; ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("userid");
       String s2=request.getParameter("password");
       String s3=request.getParameter("usertype");
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
           String qr="select uname from userinfo1 where userid=? and password=?";
            ps= con.prepareStatement(qr);
            
            if(s3.equals("admin"))
            {
                if(s1.equals("admin")&& s2.equals("admin"))
                {
                    //out.println("Welcome Admin");
                    response.sendRedirect("adminhome.jsp");
                }
                else{
                  out.println("Invalid Admin");  
                }
            }
            else{
            
            ps.setString(1, s1);
            ps.setString(2, s2);
          rs=  ps.executeQuery();
          boolean found = rs.next();
          if(found==true){
              // out.println("Welcome buyyer");
              String name=rs.getString(1);
     HttpSession  session   = request.getSession();
     session.setAttribute("username", name);
     
              String sp=request.getParameter("save");
              if(sp!=null){
                  Cookie ck1= new Cookie("userid",s1);
                   Cookie ck2= new Cookie("password",s2);
                   ck1.setMaxAge(60*60*24*7);
                     ck2.setMaxAge(60*60*24*7);
                     response.addCookie(ck1);
                     response.addCookie(ck2);
              }
               
          RequestDispatcher rd =     request.getRequestDispatcher("buyyershome.jsp");
          rd.forward(request, response);
               
          }else{
                  out.println("Invalid buyyer");  
                }
          
          
            }
            
           con.close();
       }catch(Exception e)
       {
           
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveUser2 extends HttpServlet {
Connection con; PreparedStatement ps;
    @Override
    public void init()  {
        try{
               Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
 String qr="insert into userinfo1 values(?,?,?,?,?,?)";
 
 ps= con.prepareStatement(qr);
        }catch(Exception e)
        {
            
        }
        
    }

    @Override
    public void destroy() {
        try{
           con.close();   
        }catch(Exception e){
            
        }
        
    }

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //http://localhost:8084/OnlineShopping/SaveUser2?userid=&password=&uname=&address=&mobile=&email=
        String s1=request.getParameter("userid");
       String s2=request.getParameter("password");
       String s3=request.getParameter("uname");
       String s4=request.getParameter("address");
       String s5=request.getParameter("mobile");
       String s6=request.getParameter("email");
       try
       {
         Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
 String qr="insert into userinfo1 values(?,?,?,?,?,?)";
 
 ps= con.prepareStatement(qr);
ps.setString(1, s1);
ps.setString(2, s2);
ps.setString(3, s3);
ps.setString(4, s4);
ps.setString(5, s5);
ps.setString(6, s6);
ps.executeUpdate();
out.println("registered");


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


package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LeeParametrosGet", urlPatterns = {"/LeeParametrosGet"})
public class LeeParametrosGet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try   (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LeeParametros Get</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LeeParametros GET </h1>");
            String color= request.getParameter("color");
            String numero= request.getParameter("numero");
        
            if(color !=null || numero !=null){
                out.println("su color es: <strong>"+ color + "</strong><br>");
                out.println("su numero es: <strong>"+ numero + "</strong><br>");
            }else {
                out.println("ponga los parametros en  la url ");
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}   
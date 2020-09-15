
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsoCookies", urlPatterns = {"/UsoCookies"})
public class UsoCookies extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoCookies</title>");            
            out.println("</head>");
            out.println("<body>");
           //mostrar todas las cookies
           
           Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                String name =c.getName();
                String value =c.getValue();
                out.println(name + " = "+ value + "<br>");
            } 
           //adicionar cookies
           String name = request.getParameter("nombre");
           if(name != null && name.length() > 0){
               String value =request.getParameter("valor");
               Cookie c =new Cookie(name, value);
               c.setMaxAge(3600);
               response.addCookie(c);
           }
           
            out.println("</body>");
            out.println("</html>");
        }
    }
}

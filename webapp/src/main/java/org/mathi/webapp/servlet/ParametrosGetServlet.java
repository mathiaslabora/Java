package org.mathi.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter out = resp.getWriter();
      String saludo = req.getParameter("saludo");
      String nombre = req.getParameter("nombre");
      out.print("<!DOCTYPE html>");
      out.print("<html>");
      out.print("<head>");
      out.print("         <meta charset=\"UTF-8\">");
      out.print("         <title>Parametro GET de la url</title>");
      out.print("</head>");
      out.print("<body>");
      if (saludo != null && nombre !=  null ){
        out.print("<h1>Parametro get de la url es:" + saludo + nombre + "</h1>");
      }else if (saludo != null ){
        out.print("<h1>Parametro get de la url es:" + saludo + "</h1>");
      }else if (nombre != null) {
        out.print("<h1>Nombre es:" + nombre + "</h1>");
      } else {
        out.print("<h2>No se pasron parametros...</h2>");
      }

      try {
        int codigo = Integer.valueOf(req.getParameter("codigo"));
        out.print("<h3>EL codigo es: "+ codigo +"</h3>");
      }catch (NumberFormatException e){
        out.println("<h3> el codigo de error es: "+ e + "</h3>");
      }
      out.print("</body>");
      out.print("</html>");
      out.close();
    }
}

package mypkg;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<!DOCTYPE HTML>");
            out.println("<html><head>");
            out.println("<title>Hello</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello world</h1>");
            out.println("</body></html");
        }
        finally {
            out.close();
        }
    }
}

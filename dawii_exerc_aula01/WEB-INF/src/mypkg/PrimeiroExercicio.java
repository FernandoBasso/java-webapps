package mypkg;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PrimeiroExercicio extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        try {
            String login = req.getParameter("login");
            String senha = req.getParameter("senha");
            out.println( login );
        }
        finally {
            out.close();
        }
    }
}

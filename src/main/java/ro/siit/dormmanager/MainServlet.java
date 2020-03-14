package ro.siit.dormmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/default"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", new Date());

        String[] names = new String[3];
        names[0] = "Ana";
        names[1] = "Dana";
        names[2] = "Liza";

        req.setAttribute("girls", names);

        req.getRequestDispatcher("/WebContent/main.jsp").forward(req, resp);
    }
}

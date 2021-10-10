import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>tarea de participación Servlets 24 de agosto</title>");   
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link href='css/estilos.css' rel='stylesheet' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<section>");
            out.println("<h1>tarea de participación Servlets 24 de agosto</h1>");
            out.println("<div class='lista-serv'>");
            out.println("<div>");
            out.println("<h3>Ejercicio InfoCabezeras</h3>");
            out.println("<a href='InfoCabezeras'>Ir al ejemplo</a>");
            out.println("</div>");
            out.println("<div>");
            out.println("<h3>Ejercicio UsoCookies</h3>");
            out.println("<a href='UsoCookies'>Ir al ejemplo</a>");
            out.println("</div>");
            out.println("<div>");
            out.println("<h3>Ejercicio UsoSession</h3>");
            out.println("<a href='UsoSession'>Ir al ejemplo</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

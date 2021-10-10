import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/InfoCabezeras"})
public class InfoCabezeras extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Información de Cabezeras</title>");   
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link href='css/estilos.css' rel='stylesheet' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<section>");
            out.println("<h1>Información de Cabezeras</h1>");
            
            Enumeration e = request.getHeaderNames();
            while (e.hasMoreElements()){
                String cabezera = (String)e.nextElement();
                String valor = request.getHeader(cabezera);
                out.println("<p><b class='azul-oscuro'>"+cabezera+"</b> <span class='rojo'>=</span> "+valor+"</p>");
            }
            
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }
    }

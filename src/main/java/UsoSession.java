import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/UsoSession"})
public class UsoSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Uso de Session</title>");   
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link href='css/estilos.css' rel='stylesheet' />");           
            out.println("</head>");
            out.println("<body>");
            out.println("<section>");
            out.println("<h1>Uso se Session</h1>");
            
            HttpSession session = request.getSession(true);
            // Datos de la sesion
            Date creado = new Date(session.getCreationTime());
            Date ultimoAcceso = new Date(session.getLastAccessedTime());
            out.println("<p><b class='azul-oscuro'>ID </b><span class='rojo'>:</span> "+session.getId()+"</p>");
            out.println("<p><b class='azul-oscuro'>Creado </b><span class='rojo'>:</span> "+creado+"</p>");
            out.println("<p><b class='azul-oscuro'>Último Acceso</b><span class='rojo'>:</span> "+ultimoAcceso+"</p>");
            
            // Introducir un datos a una session
            String nomDato = request.getParameter("nomDato");
            if (nomDato!=null && nomDato.length()>0 ){
                String valor = request.getParameter("valor");
                session.setAttribute(nomDato, valor);
            }
            
            // Mostrar todos de la session
            out.println("<hr>");
            Enumeration e = session.getAttributeNames();
            while(e.hasMoreElements()){
                String nombre = (String) e.nextElement();
                String valor = session.getAttribute(nombre).toString();
                out.println("<p><b class='azul-oscuro'>"+nombre+"</b><span class='rojo'>=</span> "+valor+"</p>");
            }
            out.println("");
            out.println("");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UsoCookies"})
public class UsoCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Uso de Cookies</title>");   
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link href='css/estilos.css' rel='stylesheet' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<section>");
            out.println("<h1>Uso de Cookies</h1>");
            
            // Mostrar todas las Cookies
            Cookie[] cookies = request.getCookies();
            for(int i=0; i<cookies.length; i++){
                Cookie cookTemp = cookies[i];
                String nombre = cookTemp.getName();
                String valor = cookTemp.getValue();
                out.println("<p><b class='color-oscuro'>"+nombre+"</b> <span class='rojo'>=</span> "+valor+"</p>");
            }
            
            // Adicionar Cookie
            String nombre = request.getParameter("nombre");
            if(nombre!=null && nombre.length()>0){
                String valor = request.getParameter("valor");
                Cookie cook = new Cookie(nombre, valor);
                cook.setMaxAge(3600);
                response.addCookie(cook);
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

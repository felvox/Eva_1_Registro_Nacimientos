package Controlador;

import Modelo.Nacimiento;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgregarNacimientoServlet", urlPatterns = {"/AgregarNacimientoServlet"})
public class AgregarNacimientoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        List<Nacimiento> listaNacimientos = (List<Nacimiento>) context.getAttribute("listaNacimientos");

        if (listaNacimientos == null) {
            listaNacimientos = new ArrayList<>();
            context.setAttribute("listaNacimientos", listaNacimientos);
        }
     
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int peso = Integer.parseInt(request.getParameter("peso"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = format.parse(request.getParameter("fechaNacimiento"));
            boolean prematuro = "Si".equals(request.getParameter("prematuro"));
            char sexo = request.getParameter("sexo").charAt(0);
            String centro = request.getParameter("centro"); // Tratando centro como String

          
            Nacimiento nacimiento = new Nacimiento(id, nombre, peso, fechaNacimiento, prematuro, sexo, centro);

           
            listaNacimientos.add(nacimiento);

            request.setAttribute("mensaje", "El nacimiento ha sido registrado correctamente.");
        } catch (ParseException e) {
            request.setAttribute("error", "El formato de la fecha de nacimiento no es válido.");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "El ID y el peso deben ser números.");
        } catch (Exception e) {
           request.setAttribute("error", "Se produjo un error al registrar el nacimiento: " + e.getMessage());
        }

       request.getRequestDispatcher("mensaje.jsp").forward(request, response);
    }
}

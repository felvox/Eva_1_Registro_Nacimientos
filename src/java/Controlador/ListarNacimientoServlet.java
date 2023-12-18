package Controlador;

import Modelo.Nacimiento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarNacimientoServlet", urlPatterns = {"/ListarNacimientoServlet"})
public class ListarNacimientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = request.getServletContext();
        List<Nacimiento> listaNacimientos = (List<Nacimiento>) context.getAttribute("listaNacimientos");

        if (listaNacimientos == null) {
            listaNacimientos = new ArrayList<>();
            context.setAttribute("listaNacimientos", listaNacimientos);
        }
        
        request.setAttribute("listaNacimientos", listaNacimientos);
        
        request.getRequestDispatcher("listado.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ListarNacimientoServlet maneja la presentación de registros de nacimientos";
    }
}

package Controlador;

import Modelo.Nacimiento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarNacimientoServlet", urlPatterns = {"/EliminarNacimientoServlet"})
public class EliminarNacimientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        eliminarNacimiento(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        eliminarNacimiento(request, response);
    }

    private void eliminarNacimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        List<Nacimiento> listaNacimientos = (List<Nacimiento>) context.getAttribute("listaNacimientos");

        if (listaNacimientos == null) {
            request.setAttribute("error", "No hay nacimientos registrados.");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            return;
        }
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                boolean eliminado = listaNacimientos.removeIf(nacimiento -> nacimiento.getId() == id);
                
                if (eliminado) {
                    request.setAttribute("mensaje", "El nacimiento ha sido eliminado correctamente.");
                } else {
                    request.setAttribute("error", "No se encontró el nacimiento con el ID proporcionado.");
                }
            } catch (NumberFormatException e) {
               request.setAttribute("error", "El ID proporcionado no es válido.");
            }
        } else {
            request.setAttribute("error", "No se proporcionó un ID para eliminar.");
        }
        
        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "EliminarNacimientoServlet maneja la eliminación de registros de nacimientos";
    }
}

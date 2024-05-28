/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

/**

 */
public class ControCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        switch (menu) {
           case "Libros": 
    LibroDAO dao = new LibroDAO();
    if (accion.equalsIgnoreCase("Listar")) {
        List<LibroDTO> lista = dao.readAll();
        System.out.println("Lista de libros: " + lista); // Agrega este println para verificar que la lista se esté llenando correctamente
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
    } else {
        request.getRequestDispatcher("error.html").forward(request, response);
    }
    break;
                
            
             case "ListarLibros":
            LibroDAO libroDAO = new LibroDAO();
            List<LibroDTO> libros = libroDAO.readAll();
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("libros.jsp").forward(request, response);
            break;
        case "BuscarLibro":
            long isbn = Long.parseLong(request.getParameter("isbn"));
            LibroDAO libroDAO2 = new LibroDAO();
            LibroDTO libro = libroDAO2.read(new LibroDTO(isbn, "", "", "", 0));
            request.setAttribute("libro", libro);
            request.getRequestDispatcher("libro.jsp").forward(request, response);
            break;
        case "BorrarLibro":
            long isbn2 = Long.parseLong(request.getParameter("isbn"));
            LibroDAO libroDAO3 = new LibroDAO();
            libroDAO3.delete(isbn2);
            response.sendRedirect("ValidaCTO?accion=ListarLibros");
            break;
        case "ActualizarLibro":
            long isbn3 = Long.parseLong(request.getParameter("isbn"));
            String nombre = request.getParameter("nombre");
            String autor = request.getParameter("autor");
            String editorial = request.getParameter("editorial");
            int anio = Integer.parseInt(request.getParameter("anio"));
            LibroDAO libroDAO4 = new LibroDAO();
            LibroDTO libro2 = new LibroDTO(isbn3, nombre, autor, editorial, anio);
            libroDAO4.update(libro2);
            response.sendRedirect("ValidaCTO?accion=ListarLibros");
            break;
            default: {
                request.getRequestDispatcher("error.html").forward(request, response);

            }


        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

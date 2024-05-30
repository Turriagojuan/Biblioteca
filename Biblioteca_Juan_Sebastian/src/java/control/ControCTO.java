/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;


public class ControCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        LibroDAO libroDAO = new LibroDAO();

        switch (accion) {
            case "Listar":
                //if (accion.equalsIgnoreCase("Listar")) {
                List<LibroDTO> lista = libroDAO.readAll();
                System.out.println("Lista de libros: " + lista); // Agrega este println para verificar que la lista se esté llenando correctamente
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                /*} else {
                    request.getRequestDispatcher("error.html").forward(request, response);
                }*/
                break;

            case "Agregar":
                long isbn = Long.parseLong(request.getParameter("isbn"));
                String nombre = request.getParameter("nombre");
                String autor = request.getParameter("autor");
                String editorial = request.getParameter("editorial");
                int anio = Integer.parseInt(request.getParameter("anio"));

                if (libroDAO.read(new LibroDTO(isbn, null, null, null, 0)) == null) {
                    LibroDTO libro = new LibroDTO(isbn, nombre, autor, editorial, anio);
                    libroDAO.create(libro);
                    response.sendRedirect("ControCTO?accion=Listar");
                } else {
                    response.sendRedirect("error.html");
                }
                break;
            case "Actualizar":
                long isbn2 = Long.parseLong(request.getParameter("isbn"));
                String nombre2 = request.getParameter("nombre");
                String autor2 = request.getParameter("autor");
                String editorial2 = request.getParameter("editorial");
                int anio2 = Integer.parseInt(request.getParameter("anio"));

                if (libroDAO.read(new LibroDTO(isbn2, null, null, null, 0)) != null) {
                    LibroDTO libro = new LibroDTO(isbn2, nombre2, autor2, editorial2, anio2);
                    libroDAO.update(libro);
                    response.sendRedirect("ControCTO?accion=Listar");
                } else {
                    response.sendRedirect("error.html");
                }
                break;
            case "Eliminar":
                long isbn3 = Long.parseLong(request.getParameter("isbn"));

                if (libroDAO.read(new LibroDTO(isbn3, null, null, null, 0)) != null) {
                    libroDAO.delete(isbn3);
                    response.sendRedirect("ControCTO?accion=Listar");
                } else {
                    response.sendRedirect("error.html");
                }
                break;
            case "Buscar":
                String isbnBuscar = request.getParameter("isbn");
                long isbn4 = Long.parseLong(isbnBuscar);
                LibroDTO libro = libroDAO.read(new LibroDTO(isbn4));
                request.setAttribute("lista", libro != null ? Collections.singletonList(libro) : Collections.emptyList());
                request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                break;
            case "Salir":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("index.jsp");
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

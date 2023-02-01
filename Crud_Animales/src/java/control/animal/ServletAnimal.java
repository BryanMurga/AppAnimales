/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.animal;

import dao.animal.DaoAnimal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.animal.BeanAnimal;

/**
 *
 * @author Kenia
 */
@WebServlet("/")
public class ServletAnimal extends HttpServlet {

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
    }
    private static final long serialVersionUID = 1L;
    private DaoAnimal daoAnimal;

    public void init() {
        daoAnimal = new DaoAnimal();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    mostrarNuevoFormularioAnimal(request, response);
                    break;
                case "/insert":
                    insertarAnimal(request, response);
                    break;
                case "/delete":
                    eliminarAnimal(request, response);
                    break;
                case "/edit":
                    editarAnimal(request, response);
                    break;
                case "/update":
                    modificarAnimal(request, response);
                    break;
                default:
                    ListarAnimales(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void ListarAnimales(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<BeanAnimal> listarAnimales = daoAnimal.consultarAnimales();
        request.setAttribute("listarAnimales", listarAnimales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("animal-listar.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarNuevoFormularioAnimal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("animal-formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void editarAnimal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BeanAnimal existingUser = daoAnimal.consultarAnimal(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("animal-formulario.jsp");
        request.setAttribute("animal", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertarAnimal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
      Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            System.out.println(parameterName);
            System.out.println(request.getParameter(parameterName));
          
        }
        String nombre = request.getParameter("nombre");
        String nombreCientifico = request.getParameter("nombreCientifico");
        String habitad = request.getParameter("habitad");
        String especie = request.getParameter("especie");
        double peso = Double.parseDouble(request.getParameter("peso"));
        String dieta = request.getParameter("dieta");
        byte peligroExtincion = Byte.parseByte(request.getParameter("peligroExtincion"));
        BeanAnimal newAnimal = new BeanAnimal(nombre, nombreCientifico, habitad, especie, peso, dieta, peligroExtincion);
        daoAnimal.registrarAnimal(newAnimal);
        response.sendRedirect("listar");
    }

    private void modificarAnimal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        String nombre = request.getParameter("nombre");
        String nombreCientifico = request.getParameter("nombreCientifico");
        String habitad = request.getParameter("habitad");
        String especie = request.getParameter("especie");
        double peso = Double.parseDouble(request.getParameter("peso"));
        String dieta = request.getParameter("dieta");
        byte peligroExtincion = Byte.parseByte(request.getParameter("peligroExtincion"));

        BeanAnimal editAnimal = new BeanAnimal(id, nombre, nombreCientifico, habitad, especie, peso, dieta, peligroExtincion);
        daoAnimal.modificarAnimal(editAnimal);
        response.sendRedirect("listar");
    }

    private void eliminarAnimal(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        daoAnimal.eliminarAnimal(id);
        response.sendRedirect("listar");

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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

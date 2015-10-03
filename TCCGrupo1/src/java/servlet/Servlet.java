package servlet;

import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("txtObjeto").equals("Usuario")) {
            
            UsuarioFacade usuarioFacade = new UsuarioFacade();
            switch (request.getParameter("txtMetodo")) {
                case "Cadastrar":
                    usuarioFacade.incluir(request, response);
                    break;
                case "Salvar":
                    usuarioFacade.salvar(request, response);
                    break;
                case "Editar":
                    usuarioFacade.editar(request, response);
                    break;
                case "Listar":
                    usuarioFacade.listar(request, response);
                    break;
                case "Excluir":
                    usuarioFacade.excluir(request, response);
                    break;
            }

        }/* fim do objeto Usuario*/
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

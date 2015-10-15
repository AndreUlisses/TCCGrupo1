package facade;

import entidade.Amigo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AmigoFacade {

    private Amigo requestForm(HttpServletRequest request) {

        Amigo retorno = new Amigo();

        if ((request.getParameter("txtIdAmigo") != null) && (!request.getParameter("txtIdAmigo").equals(""))) {
            retorno.setIdAmigo(Integer.SIZE);Integer.parseInt(request.getParameter("txtIdAmigo"));
        }
            
       

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("AmigosIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Amigo amigo = new Amigo();
        // FALTA O DAO
        UsuarioDao amigoDao = new UsuarioDao();

        amigo = requestForm(request);
        // FALTA O DAO
        amigo = usuarioDao.editar(amigo.getIdAmigo());

        if (amigo != null) {
            request.setAttribute("amigo", amigo);
            RequestDispatcher rd = request.getRequestDispatcher("AmigoEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Amigo amigo = new Amigo();
        // FALTA O DAO
        UsuarioDao usuarioDao = new UsuarioDao();

        amigo = requestForm(request);

        if (usuarioDao.salvar(amigo) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Amigo amigo = new Amigo();
        // FALTA O DAO
        UsuarioDao usuarioDao = new UsuarioDao();

        amigo = requestForm(request);
        // FALTA O DAO
        if (usuarioDao.excluir(amigo)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // FALTA O DAO
        UsuarioDao usuarioDao = new UsuarioDao();

        List<Amigo> amigos = new ArrayList<Amigo>();
        // FALTA O DAO
        amigos = usuarioDao.listar();

        if (amigos != null) {
            request.setAttribute("amigos", amigos);
            RequestDispatcher rd = request.getRequestDispatcher("AmigoListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

}

    


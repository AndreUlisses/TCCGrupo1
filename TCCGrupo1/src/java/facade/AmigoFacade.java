package facade;

import dao.AmigoDao;
import entidade.Amigo;
import entidade.Usuario;
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
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtIdAmigo")));
            retorno.setAmigo(usuario);
        }
        if ((request.getParameter("txtIdUsuario") != null) && (!request.getParameter("txtIdUsuario").equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
            retorno.setAmigo(usuario);
        }
        if ((request.getParameter("txtSituacao") != null) && (!request.getParameter("txtSituacao").equals(""))) {
            retorno.setSituacao(request.getParameter("txtSituacao"));
        }

        return retorno;
    };    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("AmigosIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Amigo amigo = new Amigo();
        AmigoDao amigoDao = new AmigoDao();

        amigo = requestForm(request);

        amigo = amigoDao.editar(amigo);

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
        AmigoDao amigoDao = new AmigoDao();

        amigo = requestForm(request);

        if (amigoDao.salvar(amigo) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Amigo amigo = new Amigo();
        AmigoDao amigoDao = new AmigoDao();

        amigo = requestForm(request);

        if (amigoDao.excluir(amigo)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AmigoDao usuarioDao = new AmigoDao();

        List<Amigo> amigos = new ArrayList<Amigo>();
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

    public void listaAmigos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AmigoDao usuarioDao = new AmigoDao();
        Amigo amigo = requestForm(request);

        List<Amigo> amigos = new ArrayList<Amigo>();
        amigos = usuarioDao.listaAmigos(amigo.getUsuario().getId());

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

    


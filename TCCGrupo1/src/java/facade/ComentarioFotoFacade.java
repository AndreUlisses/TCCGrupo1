package facade;

import dao.ComentarioFotoDao;
import entidade.ComentarioFoto;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComentarioFotoFacade {
    
    private ComentarioFoto requestForm(HttpServletRequest request) {

        ComentarioFoto retorno = new ComentarioFoto();

        if ((request.getParameter("txtIdComentario") != null) && (!request.getParameter("txtIdComentario").equals(""))) {
            retorno.setIdComentario(Integer.parseInt(request.getParameter("txtIdComentario")));
        }
        if ((request.getParameter("txtIdFoto") != null) && (!request.getParameter("txtIdFoto").equals(""))) {
            retorno.setIdFoto(Integer.parseInt(request.getParameter("txtIdFoto")));
        }
        if ((request.getParameter("txtIdUsuario") != null) && (!request.getParameter("txtIdUsuario").equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
            retorno.setIdUsuario(usuario);
        }
        if ((request.getParameter("txtTexto") != null) && (!request.getParameter("txtTexto").equals(""))) {
            retorno.setTexto(request.getParameter("txtTexto"));
        }
        if ((request.getParameter("txtDtComentario") != null) && (!request.getParameter("txtDtComentario").equals(""))) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                retorno.setDtComentario(new java.sql.Date(formato.parse(request.getParameter("txtDtNascimento")).getTime()));
            } catch (Exception ex) {
                retorno.setDtComentario(null);
            }

        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("ComentarioFotoIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarioFoto comentariofoto = new ComentarioFoto();
        ComentarioFotoDao comentarioFotoDao = new ComentarioFotoDao();

        comentariofoto = requestForm(request);
        comentariofoto = comentarioFotoDao.editar(comentariofoto.getIdComentario());

        if (comentariofoto != null) {
            request.setAttribute("comentariofoto", comentariofoto);
            RequestDispatcher rd = request.getRequestDispatcher("ComentarioFotoEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarioFoto comentariofoto = new ComentarioFoto();
        ComentarioFotoDao comentarioFotoDao = new ComentarioFotoDao();

        comentariofoto = requestForm(request);

        if (comentarioFotoDao.salvar(comentariofoto) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarioFoto comentariofoto = new ComentarioFoto();
        ComentarioFotoDao comentarioFotoDao = new ComentarioFotoDao();

        comentariofoto = requestForm(request);

        if (comentarioFotoDao.excluir(comentariofoto)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        ComentarioFotoDao comentarioFotoDao = new ComentarioFotoDao();
        List<ComentarioFoto> comentarfoto = new ArrayList<ComentarioFoto>();
        comentarfoto = comentarioFotoDao.listar();

        if (comentarfoto != null) {
            request.setAttribute("comentarfoto", comentarfoto);
            RequestDispatcher rd = request.getRequestDispatcher("ComentarFotoListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    
}

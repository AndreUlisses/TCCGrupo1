package facade;

import dao.ComentarLocalidadeDao;
import entidade.ComentarLocalidade;
import entidade.Localidade;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComentarLocalidadeFacade {
    
       private ComentarLocalidade requestForm(HttpServletRequest request) {

        ComentarLocalidade retorno = new ComentarLocalidade();

        if ((request.getParameter("txtIdComentario_Localidade") != null) && (!request.getParameter("txtIdComentario_Localidade").equals(""))) {
            retorno.setIdComentario_Localidade(Integer.parseInt(request.getParameter("txtIdComentario_Localidade")));
        }
        if ((request.getParameter("txtIdLocalidade") != null) && (!request.getParameter("txtIdLocalidade").equals(""))) {
            Localidade localidade = new Localidade();
            localidade.setIdLocalidade(Integer.parseInt(request.getParameter("txtIdLocalidade")));
            retorno.setIdLocalidade(localidade);
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
        RequestDispatcher rd = request.getRequestDispatcher("ComentarLocalidadeIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarLocalidade comentarlocalidade = new ComentarLocalidade();
        ComentarLocalidadeDao comentarLocalidadeDao = new ComentarLocalidadeDao();

        comentarlocalidade = requestForm(request);
        comentarlocalidade = comentarLocalidadeDao.editar(comentarlocalidade.getIdComentario_Localidade());

        if (comentarlocalidade != null) {
            request.setAttribute("comentarlocalidade", comentarlocalidade);
            RequestDispatcher rd = request.getRequestDispatcher("ComentarLocalidadeEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarLocalidade comentarlocalidade = new ComentarLocalidade();
        ComentarLocalidadeDao comentarLocalidadeDao = new ComentarLocalidadeDao();

        comentarlocalidade = requestForm(request);

        if (comentarLocalidadeDao.salvar(comentarlocalidade) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarLocalidade comentarlocalidade = new ComentarLocalidade();
        ComentarLocalidadeDao comentarLocalidadeDao = new ComentarLocalidadeDao();

        comentarlocalidade = requestForm(request);

        if (comentarLocalidadeDao.excluir(comentarlocalidade)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComentarLocalidadeDao comentarLocalidadeDao = new ComentarLocalidadeDao();

        List<ComentarLocalidade> comentarlocalidade = new ArrayList<ComentarLocalidade>();
        comentarlocalidade = comentarLocalidadeDao.listar();

        if (comentarlocalidade != null) {
            request.setAttribute("amigos", comentarlocalidade);
            RequestDispatcher rd = request.getRequestDispatcher("ComentarLocalidadeListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    
}

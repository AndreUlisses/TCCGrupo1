package facade;

import dao.LocalidadeDao;
import entidade.Categoria;
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

public class LocalidadeFacade {
    
    private Localidade requestForm(HttpServletRequest request) {

        Localidade retorno = new Localidade();

        if ((request.getParameter("txtIdLocalidade") != null) && (!request.getParameter("txtIdLocalidade").equals(""))) {
            retorno.setIdLocalidade(Integer.parseInt(request.getParameter("txtIdLocalidade")));
        }
        if ((request.getParameter("txtIdCategoria") != null) && (!request.getParameter("txtIdCategoria").equals(""))) {
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("txtIdCategoria")));
            retorno.setIdCategoria(categoria);
        }
        if ((request.getParameter("txtIdUsuario") != null) && (!request.getParameter("txtIdUsuario").equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
            retorno.setIdUsuario(usuario);
        }
        if ((request.getParameter("txtDescricao") != null) && (!request.getParameter("txtDescricao").equals(""))) {
            retorno.setDescricao(request.getParameter("txtDescricao"));
        }
        if ((request.getParameter("txtDtLocalidade") != null) && (!request.getParameter("txtDtLocalidade").equals(""))) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                retorno.setDtLocalidade(new java.sql.Date(formato.parse(request.getParameter("txtDtLocalidade")).getTime()));
            } catch (Exception ex) {
                retorno.setDtLocalidade(null);
            }

        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("LocalidadeIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Localidade comentarlocalidade = new Localidade();
        LocalidadeDao comentarLocalidadeDao = new LocalidadeDao();

        comentarlocalidade = requestForm(request);
        comentarlocalidade = comentarLocalidadeDao.editar(comentarlocalidade.getIdLocalidade());

        if (comentarlocalidade != null) {
            request.setAttribute("localidade", comentarlocalidade);
            RequestDispatcher rd = request.getRequestDispatcher("LocalidadeEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Localidade localidade = new Localidade();
        LocalidadeDao LocalidadeDao = new LocalidadeDao();

        localidade = requestForm(request);

        if (LocalidadeDao.salvar(localidade) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Localidade localidade = new Localidade();
        LocalidadeDao LocalidadeDao = new LocalidadeDao();

        localidade = requestForm(request);

        if (LocalidadeDao.excluir(localidade)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalidadeDao LocalidadeDao = new LocalidadeDao();

        List<Localidade> localidade = new ArrayList<Localidade>();
        localidade = LocalidadeDao.listar();

        if (localidade != null) {
            request.setAttribute("localidade", localidade);
            RequestDispatcher rd = request.getRequestDispatcher("LocalidadeListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }
    
}

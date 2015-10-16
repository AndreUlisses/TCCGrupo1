package facade;

import dao.CategoriaDao;
import entidade.Categoria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoriaFacade {
    
    
    private Categoria requestForm(HttpServletRequest request) {

        Categoria retorno = new Categoria();

        if ((request.getParameter("txtNome") != null) && (!request.getParameter("txtNome").equals(""))) {
            retorno.setNome(request.getParameter("txtNome"));
        }
        
        if ((request.getParameter("txtDescrição") != null) && (!request.getParameter("txtDescricao").equals(""))) {
            retorno.setDescricao(request.getParameter("txtDescricao"));
        }

        return retorno;
    };    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("CategoriaIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        CategoriaDao categoriaDao = new CategoriaDao();

        categoria = requestForm(request);
        // Verificar se está certo            \/
        categoria = categoriaDao.editar(categoria.getIdCategoria());

        if (categoria != null) {
            request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getRequestDispatcher("categoriaEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        CategoriaDao categoriaDao = new CategoriaDao();

        categoria = requestForm(request);

        if (categoriaDao.salvar(categoria) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        CategoriaDao categoriaDao = new CategoriaDao();

        categoria = requestForm(request);

        if (categoriaDao.excluir(categoria)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDao categoriaDao = new CategoriaDao();

        List<Categoria> categoria = new ArrayList<Categoria>();
        categoria = categoriaDao.listar();

        if (categoria != null) {
            request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getRequestDispatcher("CategoriaListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }
 
}

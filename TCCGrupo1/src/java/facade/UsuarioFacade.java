package facade;

import dao.UsuarioDao;
import Entidade1.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioFacade {

    private Usuario requestForm(HttpServletRequest request){
        
        Usuario retorno = new Usuario();
        
        if ((request.getParameter("txtId")!=null)&&(!request.getParameter("txtId").equals(""))) {
            retorno.setId(Integer.parseInt(request.getParameter("txtId")));
        }
        if ((request.getParameter("txtNome")!=null)&& (!request.getParameter("txtNome").equals(""))) {
            retorno.setNome(request.getParameter("txtNome"));
        }
        if ((request.getParameter("txtEmail")!=null)&& (!request.getParameter("txtEmail").equals(""))) {
            retorno.setNome(request.getParameter("txtEmail"));
        }
        if ((request.getParameter("txtSenha")!=null)&& (!request.getParameter("txtSenha").equals(""))) {
            retorno.setNome(request.getParameter("txtSenha"));
        }

        return retorno;
    };    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("UsuarioInclur.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario = requestForm(request);

        if (usuarioDao.editar(usuario.getId()) != null) {
            RequestDispatcher rd = request.getRequestDispatcher("UsuarioEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario = requestForm(request);

        if (usuarioDao.salvar(usuario) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario = requestForm(request);

        if (usuarioDao.excluir(usuario)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDao usuarioDao = new UsuarioDao();

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = usuarioDao.listar();

        if (usuarios != null) {
            RequestDispatcher rd = request.getRequestDispatcher("UsuarioListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

}

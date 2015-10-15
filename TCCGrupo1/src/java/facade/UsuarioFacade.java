package facade;

import dao.UsuarioDao;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioFacade {

    private Usuario requestForm(HttpServletRequest request) {

        Usuario retorno = new Usuario();

        if ((request.getParameter("txtIdUsuario") != null) && (!request.getParameter("txtIdUsuario").equals(""))) {
            retorno.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
        }
        if ((request.getParameter("txtNome") != null) && (!request.getParameter("txtNome").equals(""))) {
            retorno.setNome(request.getParameter("txtNome"));
        }
        if ((request.getParameter("txtEmail") != null) && (!request.getParameter("txtEmail").equals(""))) {
            retorno.setEmail(request.getParameter("txtEmail"));
        }
        if ((request.getParameter("txtSenha") != null) && (!request.getParameter("txtSenha").equals(""))) {
            retorno.setSenha(request.getParameter("txtSenha"));
        }
        if ((request.getParameter("txtSexo") != null) && (!request.getParameter("txtSexo").equals(""))) {
            retorno.setSexo(request.getParameter("txtSexo"));
        }
        if ((request.getParameter("txtDtNascimento") != null) && (!request.getParameter("txtDtNascimento").equals(""))) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                retorno.setDtNascimento(new java.sql.Date(formato.parse(request.getParameter("txtDtNascimento")).getTime()));
            } catch (Exception ex) {
                retorno.setDtNascimento(null);
            }

        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("UsuarioIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario = requestForm(request);
        usuario = usuarioDao.editar(usuario.getId());

        if (usuario != null) {
            request.setAttribute("usuario", usuario);
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
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher rd = request.getRequestDispatcher("UsuarioListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

}

package Controller;

import DAO.UsuarioDao;
import Entidade.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioController {

    public void Cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("UsuarioCadastro.jsp");
        rd.forward(request, response);

    }

    public void Salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("aqui");
        
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario.setEmail(request.getParameter("Email"));
        usuario.setSenha(request.getParameter("Senha"));

        if (usuarioDao.salvar(usuario) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }

    }

}

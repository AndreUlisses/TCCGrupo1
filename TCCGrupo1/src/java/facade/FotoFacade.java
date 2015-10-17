package facade;

import dao.FotoDao;
import entidade.Foto;
import entidade.Localidade;
import entidade.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FotoFacade {
    
private Foto requestForm(HttpServletRequest request) {

        Foto retorno = new Foto();

        if ((request.getParameter("txtIdFoto") != null) && (!request.getParameter("txtIdFoto").equals(""))) {
            retorno.setIdFoto(Integer.parseInt(request.getParameter("txtIdFoto")));
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
        if ((request.getParameter("txtDescricao") != null) && (!request.getParameter("txtDescricao").equals(""))) {
            retorno.setDescricao(request.getParameter("txtDescricao"));
        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("FotoIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Foto comentariofoto = new Foto();
        FotoDao comentarioFotoDao = new FotoDao();

        comentariofoto = requestForm(request);
        comentariofoto = comentarioFotoDao.editar(comentariofoto.getIdFoto());

        if (comentariofoto != null) {
            request.setAttribute("foto", comentariofoto);
            RequestDispatcher rd = request.getRequestDispatcher("FotoEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Foto comentariofoto = new Foto();
        FotoDao comentarioFotoDao = new FotoDao();

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
        Foto comentariofoto = new Foto();
        FotoDao comentarioFotoDao = new FotoDao();

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
       
        FotoDao FotoDao = new FotoDao();
        List<Foto> foto = new ArrayList<Foto>();
        foto = FotoDao.listar();

        if (foto != null) {
            request.setAttribute("foto", foto);
            RequestDispatcher rd = request.getRequestDispatcher("FotoListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }
       
}

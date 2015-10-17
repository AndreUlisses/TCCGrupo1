package facade;

import dao.CurtirLocalidadeDao;
import entidade.CurtirLocalidade;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurtirLocalidadeFacade {
        
private CurtirLocalidade requestForm(HttpServletRequest request) {

        CurtirLocalidade retorno = new CurtirLocalidade();

        if ((request.getParameter("txtIdLocalidade") != null) && (!request.getParameter("txtIdLocalidade").equals(""))) {
            retorno.setIdLocalidade(Integer.parseInt(request.getParameter("txtIdLocalidade")));
        }
        if ((request.getParameter("txtIdUsuario") != null) && (!request.getParameter("txtIdUsuario").equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
            retorno.setIdUsuario(usuario);
        }
        if ((request.getParameter("txtDtCurtir") != null) && (!request.getParameter("txtDtCurtir").equals(""))) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                retorno.setDtCurtir(new java.sql.Date(formato.parse(request.getParameter("txtDtCurtir")).getTime()));
            } catch (Exception ex) {
                retorno.setDtCurtir(null);
            }

        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("CurtirLocalidadeIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirLocalidade curtirlocalidade = new CurtirLocalidade();
        CurtirLocalidadeDao curtirLocalidadeDao = new CurtirLocalidadeDao();

        curtirlocalidade = requestForm(request);
        curtirlocalidade = curtirLocalidadeDao.editar(curtirlocalidade.getIdLocalidade());

        if (curtirlocalidade != null) {
            request.setAttribute("curtirlocalidade", curtirlocalidade);
            RequestDispatcher rd = request.getRequestDispatcher("CurtirLocalidadeEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirLocalidade curtirlocalidade = new CurtirLocalidade();
        CurtirLocalidadeDao curtirLocalidadeDao = new CurtirLocalidadeDao();

        curtirlocalidade = requestForm(request);

        if (curtirLocalidadeDao.salvar(curtirlocalidade) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirLocalidade curtirlocalidade = new CurtirLocalidade();
        CurtirLocalidadeDao curtirLocalidadeDao = new CurtirLocalidadeDao();

        curtirlocalidade = requestForm(request);

        if (curtirLocalidadeDao.excluir(curtirlocalidade)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirLocalidadeDao curtirLocalidadeDao = new CurtirLocalidadeDao();

        List<CurtirLocalidade> curtirlocalidade = new ArrayList<CurtirLocalidade>();
        curtirlocalidade = curtirLocalidadeDao.listar();

        if (curtirlocalidade != null) {
            request.setAttribute("curtirlocalidade", curtirlocalidade);
            RequestDispatcher rd = request.getRequestDispatcher("CurtirLocalidadeListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

}

package facade;

import dao.PontoDao;
import entidade.Localidade;
import entidade.Ponto;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PontoFacade {
    
private Ponto requestForm(HttpServletRequest request) {

        Ponto retorno = new Ponto();

        if ((request.getParameter("txtIdPonto") != null) && (!request.getParameter("txtPonto").equals(""))) {
            retorno.setIdPonto(Integer.parseInt(request.getParameter("txtIdPonto")));
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
        if ((request.getParameter("txtLatitude") != null) && (!request.getParameter("txtDescricao").equals(""))) {
            retorno.setLatitude(Integer.parseInt(request.getParameter("txtLatitude")));
        }
        if ((request.getParameter("txtLongitude") != null) && (!request.getParameter("txtLongitude").equals(""))) {
            retorno.setLongitude(Integer.parseInt(request.getParameter("txtLongitude")));
        }
        if ((request.getParameter("txtAltitude") != null) && (!request.getParameter("txtAltitude").equals(""))) {
            retorno.setAltitude(Integer.parseInt(request.getParameter("txtAltitude")));
        }
        if ((request.getParameter("txtDtPonto") != null) && (!request.getParameter("txtDtPonto").equals(""))) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                retorno.setDtPonto(new java.sql.Date(formato.parse(request.getParameter("txtDtPonto")).getTime()));
            } catch (Exception ex) {
                retorno.setDtPonto(null);
            }

        }

        return retorno;
    }

    ;    
    
    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("PontoIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ponto ponto = new Ponto();
        PontoDao pontoDao = new PontoDao();

        ponto = requestForm(request);
        ponto = pontoDao.editar(ponto.getIdPonto());

        if (ponto != null) {
            request.setAttribute("ponto", ponto);
            RequestDispatcher rd = request.getRequestDispatcher("PontoEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ponto ponto = new Ponto();
        PontoDao pontoDao = new PontoDao();

        ponto = requestForm(request);

        if (pontoDao.salvar(ponto) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ponto ponto = new Ponto();
        PontoDao pontoDao = new PontoDao();

        ponto = requestForm(request);

        if (pontoDao.excluir(ponto)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PontoDao pontoDao = new PontoDao();

        List<Ponto> ponto = new ArrayList<Ponto>();
        ponto = pontoDao.listar();

        if (ponto != null) {
            request.setAttribute("ponto", ponto);
            RequestDispatcher rd = request.getRequestDispatcher("PontoListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    
}

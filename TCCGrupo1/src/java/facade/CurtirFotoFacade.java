package facade;

import dao.CurtirFotoDao;
import entidade.CurtirFoto;
import entidade.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurtirFotoFacade {
    
  private CurtirFoto requestForm(HttpServletRequest request) {

        CurtirFoto retorno = new CurtirFoto();

        if ((request.getParameter("txtIdFoto") != null) && (!request.getParameter("txtIdFoto").equals(""))) {
            retorno.setIdFoto(Integer.parseInt(request.getParameter("txtIdFoto")));
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
        RequestDispatcher rd = request.getRequestDispatcher("CurtirFotoIncluir.jsp");
        rd.forward(request, response);
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirFoto curtirfoto = new CurtirFoto();
        CurtirFotoDao curtirFotoDao = new CurtirFotoDao();

        curtirfoto = requestForm(request);
        curtirfoto = curtirFotoDao.editar(curtirfoto.getIdFoto());

        if (curtirfoto != null) {
            request.setAttribute("curtirfoto", curtirfoto);
            RequestDispatcher rd = request.getRequestDispatcher("CurtirFotoEditar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirFoto curtirfoto = new CurtirFoto();
        CurtirFotoDao curtirFotoDao = new CurtirFotoDao();

        curtirfoto = requestForm(request);

        if (curtirFotoDao.salvar(curtirfoto) == -1) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurtirFoto curtirfoto = new CurtirFoto();
        CurtirFotoDao curtirFotoDao = new CurtirFotoDao();

        curtirfoto = requestForm(request);

        if (curtirFotoDao.excluir(curtirfoto)) {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemOk.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        CurtirFotoDao curtirFotoDao = new CurtirFotoDao();
        List<CurtirFoto> curtirfoto = new ArrayList<CurtirFoto>();
        curtirfoto = curtirFotoDao.listar();

        if (curtirfoto != null) {
            request.setAttribute("curtirfoto", curtirfoto);
            RequestDispatcher rd = request.getRequestDispatcher("CurtirFotoListar.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("MensagemErro.jsp");
            rd.forward(request, response);
        }
    }

    
    
}

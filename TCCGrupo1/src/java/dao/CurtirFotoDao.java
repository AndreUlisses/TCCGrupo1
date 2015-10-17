package dao;

import conexao.ConnectionManager;
import entidade.CurtirFoto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurtirFotoDao {
    
           public int salvar(CurtirFoto curtirfoto) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into CURTIR_FOTO (IDFOTO,IDUSUARIO,DT_CURTIR) values (?, ?, ?)";
            String QUERY_UPDATE = "update CURTIR_FOTO set IDFOTO = ?, IDUSUARIO = ?, TEXTO = ?, DT_COMENTARIO = ? where IDCOMENTARIO_FOTO = ? ";

            if ((curtirfoto.getIdUsuario().getId() == null)&&(curtirfoto.getIdUsuario().getId() == null)) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setDate(1, curtirfoto.getDtCurtir());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setDate(1, curtirfoto.getDtCurtir());
                stmt.executeUpdate();
                resultado = curtirfoto.getIdFoto();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(CurtirFoto curtirfoto) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from CURTIR_FOTO where IDFOTO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
                stmt.setDate(1, curtirfoto.getDtCurtir());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public CurtirFoto editar(int id) {

        CurtirFoto curtirfoto = new CurtirFoto();
        
        try {

            String QUERY_DETALHE = "select * from CURTIR_FOTO where IDFOTO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                curtirfoto = new CurtirFoto();
                curtirfoto.setIdFoto(rs.getInt("IDFOTO"));
                curtirfoto.setDtCurtir(rs.getDate("DT_CURTIR"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            curtirfoto = null;
            
        }
        
        return curtirfoto;
    }

    public List<CurtirFoto> listar() {
        List<CurtirFoto> lista = new ArrayList<CurtirFoto>();
        try {
            String QUERY_DETALHE = "select * from CURTIR_FOTO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CurtirFoto curtirfoto = new CurtirFoto();
                curtirfoto.setIdFoto(rs.getInt("IDFOTO"));
                curtirfoto.setDtCurtir(rs.getDate("DT_CURTIR"));
                lista.add(curtirfoto);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
    
}

package dao;

import conexao.ConnectionManager;
import entidade.CurtirLocalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurtirLocalidadeDao {
    
    public int salvar(CurtirLocalidade curtirlocalidade) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into CURTIR_LOCALIDADE (IDLOCALIDADE,IDUSUARIO,DT_CURTIR) values (?, ?, ?)";
            String QUERY_UPDATE = "update CURTIR_LOCALIDADE set IDUSUARIO = ?, DT_CURTIR = ? where IDLOCALIDADE = ? ";

            //verificar comparação
            if (curtirlocalidade.getIdLocalidade()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setDate(1, curtirlocalidade.getDtCurtir());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setDate(1, curtirlocalidade.getDtCurtir());
                
                stmt.executeUpdate();
                resultado = curtirlocalidade.getIdLocalidade();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(CurtirLocalidade curtirlocalidade) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from COMENTAR_LOCALIDADE where IDCOMENTARIO_LOCALIDADE = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, curtirlocalidade.getIdLocalidade());
            stmt.setDate(2, curtirlocalidade.getDtCurtir());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public CurtirLocalidade editar(int id) {

        CurtirLocalidade curtirlocalidade = new CurtirLocalidade();
        
        try {

            String QUERY_DETALHE = "select * from CURTIR_LOCALIDADE where IDLOCALIDADE = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                curtirlocalidade = new CurtirLocalidade();
                curtirlocalidade.setIdLocalidade(rs.getInt("IDLOCALIDADE"));
                curtirlocalidade.setDtCurtir(rs.getDate("DT_CURTIR"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            curtirlocalidade = null;
            
        }
        
        return curtirlocalidade;
    }

    public List<CurtirLocalidade> listar() {
        List<CurtirLocalidade> lista = new ArrayList<CurtirLocalidade>();
        try {
            String QUERY_DETALHE = "select * from CURTIR_LOCALIDADE";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CurtirLocalidade curtirlocalidade = new CurtirLocalidade();
                curtirlocalidade.setIdLocalidade(rs.getInt("IDLOCALIDADE"));
                curtirlocalidade.setDtCurtir(rs.getDate("DT_CURTIR"));
                lista.add(curtirlocalidade);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
}

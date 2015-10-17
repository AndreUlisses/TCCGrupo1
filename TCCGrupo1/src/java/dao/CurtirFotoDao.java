package dao;

import conexao.ConnectionManager;
import entidade.CurtirFoto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CurtirFotoDao {
    
           public int salvar(CurtirFoto curtirfoto) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into CURTIR_FOTO (IDFOTO,IDUSUARIO,DT_CURTIR) values (?, ?, ?)";
            String QUERY_UPDATE = "update COMENTAR_FOTO set IDFOTO = ?, IDUSUARIO = ?, TEXTO = ?, DT_COMENTARIO = ? where IDCOMENTARIO_FOTO = ? ";

            //verificar comparação
            if (curtirfoto.getIdComentario()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, curtirfoto.getTexto());
                stmt.setDate(2, curtirfoto.getDtComentario());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, curtirfoto.getTexto());
                stmt.setDate(2, curtirfoto.getDtComentario());
                stmt.executeUpdate();
                resultado = curtirfoto.getIdComentario();
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

            String QUERY_DELETE = "delete from COMENTARIO_FOTO where IDCOMENTARIO_FOTO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
                stmt.setString(1, curtirfoto.getTexto());
                stmt.setDate(2, curtirfoto.getDtComentario());

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

            String QUERY_DETALHE = "select * from COMENTARIO_FOTO where IDCOMENTARIO_FOTO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                curtirfoto = new CurtirFoto();
                curtirfoto.setIdComentario(rs.getInt("IDCOMENTARIO_FOTO"));
                curtirfoto.setTexto(rs.getString("TEXTO"));
                curtirfoto.setDtComentario(rs.getDate("DT_COMENTARIO"));
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
            String QUERY_DETALHE = "select * from COMENTARIO_FOTO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CurtirFoto curtirfoto = new CurtirFoto();
                curtirfoto.setIdComentario(rs.getInt("IDCOMENTARIO_FOTO"));
                curtirfoto.setTexto(rs.getString("TEXTO"));
                curtirfoto.setDtComentario(rs.getDate("DT_COMENTARIO"));
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

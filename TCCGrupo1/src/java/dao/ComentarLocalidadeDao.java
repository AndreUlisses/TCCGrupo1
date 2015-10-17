package dao;

import conexao.ConnectionManager;
import entidade.ComentarLocalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComentarLocalidadeDao {
    
        public int salvar(ComentarLocalidade comentarlocalidade) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into COMENTAR_LOCALIDADE (IDCOMENTARIO_LOCALIDADE,IDLOCALIDADE,IDUSUARIO,TEXTO,DT_COMENTARIO) values (?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "update COMENTAR_LOCALIDADE set IDLOCALIDADE = ?, IDUSUARIO = ?, TEXTO = ?, DT_COMENTARIO = ? where IDCOMENTARIO_LOCALIDADE = ? ";

            //verificar comparação
            if (comentarlocalidade.getIdComentario_Localidade()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, comentarlocalidade.getTexto());
                stmt.setDate(2, comentarlocalidade.getDtComentario());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, comentarlocalidade.getTexto());
                stmt.setDate(2, comentarlocalidade.getDtComentario());

                stmt.executeUpdate();
                resultado = comentarlocalidade.getIdComentario_Localidade();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(ComentarLocalidade comentarlocalidade) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from COMENTAR_LOCALIDADE where IDCOMENTARIO_LOCALIDADE = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setString(1, comentarlocalidade.getTexto());
            stmt.setDate(2, comentarlocalidade.getDtComentario());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public ComentarLocalidade editar(int id) {

        ComentarLocalidade comentarlocalidade = new ComentarLocalidade();
        
        try {

            String QUERY_DETALHE = "select * from COMENTAR_LOCALIDADE where IDCOMENTARIO_LOCALIDADE = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                comentarlocalidade = new ComentarLocalidade();
                comentarlocalidade.setIdComentario_Localidade(rs.getInt("IDCOMENTARIO_LOCALIDADE"));
                comentarlocalidade.setTexto(rs.getString("TEXTO"));
                comentarlocalidade.setDtComentario(rs.getDate("DT_COMENTARIO"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            comentarlocalidade = null;
            
        }
        
        return comentarlocalidade;
    }

    public List<ComentarLocalidade> listar() {
        List<ComentarLocalidade> lista = new ArrayList<ComentarLocalidade>();
        try {
            String QUERY_DETALHE = "select * from COMENTAR_LOCALIDADE";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ComentarLocalidade comentarlocalidade = new ComentarLocalidade();
                comentarlocalidade.setIdComentario_Localidade(rs.getInt("IDCOMENTARIO_LOCALIDADE"));
                comentarlocalidade.setTexto(rs.getString("TEXTO"));
                comentarlocalidade.setDtComentario(rs.getDate("DT_COMENTARIO"));
                lista.add(comentarlocalidade);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
}

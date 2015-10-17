package dao;

import conexao.ConnectionManager;
import entidade.ComentarioFoto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComentarioFotoDao {
    
       public int salvar(ComentarioFoto comentariofoto) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into COMENTAR_FOTO (IDCOMENTARIO_FOTO,IDFOTO,IDUSUARIO,TEXTO,DT_COMENTARIO) values (?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "update COMENTAR_FOTO set IDFOTO = ?, IDUSUARIO = ?, TEXTO = ?, DT_COMENTARIO = ? where IDCOMENTARIO_FOTO = ? ";

            //verificar comparação
            if (comentariofoto.getIdComentario()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, comentariofoto.getTexto());
                stmt.setDate(2, comentariofoto.getDtComentario());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, comentariofoto.getTexto());
                stmt.setDate(2, comentariofoto.getDtComentario());
                stmt.executeUpdate();
                resultado = comentariofoto.getIdComentario();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(ComentarioFoto comentariofoto) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from COMENTARIO_FOTO where IDCOMENTARIO_FOTO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
                stmt.setString(1, comentariofoto.getTexto());
                stmt.setDate(2, comentariofoto.getDtComentario());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public ComentarioFoto editar(int id) {

        ComentarioFoto comentariofoto = new ComentarioFoto();
        
        try {

            String QUERY_DETALHE = "select * from COMENTARIO_FOTO where IDCOMENTARIO_FOTO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                comentariofoto = new ComentarioFoto();
                comentariofoto.setIdComentario(rs.getInt("IDCOMENTARIO_FOTO"));
                comentariofoto.setTexto(rs.getString("TEXTO"));
                comentariofoto.setDtComentario(rs.getDate("DT_COMENTARIO"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            comentariofoto = null;
            
        }
        
        return comentariofoto;
    }

    public List<ComentarioFoto> listar() {
        List<ComentarioFoto> lista = new ArrayList<ComentarioFoto>();
        try {
            String QUERY_DETALHE = "select * from COMENTARIO_FOTO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ComentarioFoto comentariofoto = new ComentarioFoto();
                comentariofoto.setIdComentario(rs.getInt("IDCOMENTARIO_FOTO"));
                comentariofoto.setTexto(rs.getString("TEXTO"));
                comentariofoto.setDtComentario(rs.getDate("DT_COMENTARIO"));
                lista.add(comentariofoto);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
    
}

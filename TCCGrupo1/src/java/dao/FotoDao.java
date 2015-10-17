package dao;

import conexao.ConnectionManager;
import entidade.Foto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FotoDao {
    
    public int salvar(Foto foto) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into FOTO (IDFOTO,IDLOCALIDADE,IDUSUARIO,DESCRICAO) values (?, ?, ?, ?)";
            String QUERY_UPDATE = "update FOTO set IDLOCALIDADE = ?, IDUSUARIO = ?, DESCRICAO = ?, where IDFOTO = ? ";

            //verificar comparação
            if (foto.getIdFoto()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, foto.getDescricao());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, foto.getDescricao());

                stmt.executeUpdate();
                resultado = foto.getIdFoto();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(Foto foto) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from FOTO where IDFOTO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, foto.getIdFoto());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Foto editar(int id) {

        Foto foto = new Foto();
        
        try {

            String QUERY_DETALHE = "select * from FOTO where IDFOTO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                foto = new Foto();
                foto.setIdFoto(rs.getInt("IDFOTO"));
                foto.setDescricao(rs.getString("DESCRICAO"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            foto = null;
            
        }
        
        return foto;
    }

    public List<Foto> listar() {
        List<Foto> lista = new ArrayList<Foto>();
        try {
            String QUERY_DETALHE = "select * from FOTO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setIdFoto(rs.getInt("IDFOTO"));
                foto.setDescricao(rs.getString("DESCRICAO"));
                lista.add(foto);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
}

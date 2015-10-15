package dao;

import conexao.ConnectionManager;
import entidade.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    
        public int salvar(Categoria categoria) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into CATEGORIA (idCategoria, nome, descricao) values (?, ?, ?)";
            String QUERY_UPDATE = "update CATEGORIA set nome = ?, descricao = ? where idCategoria = ? ";

            if (categoria.getIdCategoria()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, categoria.getNome());
                stmt.setString(2, categoria.getDescricao());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, categoria.getNome());
                stmt.setString(2, categoria.getDescricao());
                stmt.setInt(3, categoria.getIdCategoria());

                stmt.executeUpdate();
                resultado = categoria.getIdCategoria();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(Categoria categoria) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from CATEGORIA where idCategoria = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, categoria.getIdCategoria());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Categoria editar(int id) {

        Categoria categoria = new Categoria();
        
        try {

            String QUERY_DETALHE = "select * from CATEGORIA where idCategoria = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            categoria = null;
            
        }
        
        return categoria;
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            String QUERY_DETALHE = "select * from CATEGORIA";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                lista.add(categoria);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
}

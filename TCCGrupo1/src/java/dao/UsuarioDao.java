package dao;

import conexao.ConnectionManager;
import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public int salvar(Usuario usuario) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, SEXO, DT_NASCIMENTO) values (?, ?, ?)";
            String QUERY_UPDATE = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, SEXO = ?, DT_NASCIMENTO = ? WHERE IDUSUARIO = ? ";

            if (usuario.getId() == null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getSenha());
                stmt.setString(4, usuario.getSexo());
                stmt.setDate(5, usuario.getDtNascimento());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getSenha());
                stmt.setString(4, usuario.getSexo());
                stmt.setDate(5, usuario.getDtNascimento());
                stmt.setInt(6, usuario.getId());

                stmt.executeUpdate();
                resultado = usuario.getId(); // alterei aqui pra ficar igual ao do ProfessorDAO
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;

        }

        return resultado;
    }

    public boolean excluir(Usuario usuario) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "DELETE FRIM USUARIO WHERE IDUSUARIO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, usuario.getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Usuario editar(int id) {

        Usuario usuario = new Usuario();

        try {

            String QUERY_DETALHE = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("IDUSUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setSexo(rs.getString("SEXO"));
                usuario.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            usuario = null;

        }

        return usuario;
    }

    public List<Usuario> listar() {
        
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            String QUERY_DETALHE = "SELECT * FROM USUARIO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("IDUSUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setSexo(rs.getString("SEXO"));
                usuario.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
                lista.add(usuario);
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            return lista;

        }
        
    }

}

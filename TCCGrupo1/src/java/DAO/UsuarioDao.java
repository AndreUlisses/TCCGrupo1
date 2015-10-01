package DAO;

import Conexao.ConnectionManager;
import Entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDao {

    public int salvar(Usuario usuario) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;
        
        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into USUARIO (email, senha) values (?, ?)";
            String QUERY_UPDATE = "update USUARIO set email = ?, senha = ? where idusuario = ? ";

            if (usuario.getId() == null) {

       

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, usuario.getEmail());
                stmt.setString(2, usuario.getSenha());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, usuario.getEmail());
                stmt.setString(2, usuario.getSenha());
                stmt.setInt(3, usuario.getId());

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

}

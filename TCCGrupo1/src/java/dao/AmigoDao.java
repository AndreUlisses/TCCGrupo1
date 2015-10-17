package dao;

import conexao.ConnectionManager;
import entidade.Amigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AmigoDao {

    public int salvar(Amigo amigo) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "INSERT INTO AMIGO (IDAMIGO, IDUSUARIO, SITUACAO) values (?, ?, ?)";
            String QUERY_UPDATE = "UPDATE AMIGO SET SITUACAO = ? WHERE IDAMIGO = ? AND IDUSUARIO = ? ";

            if ((amigo.getAmigo().getId() == null)&&(amigo.getUsuario().getId() == null)) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, amigo.getAmigo().getId());
                stmt.setInt(2, amigo.getUsuario().getId());
                stmt.setString(3, amigo.getSituacao());

                stmt.executeUpdate();
                resultado = 1;                

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, amigo.getSituacao());
                stmt.setInt(2, amigo.getAmigo().getId());
                stmt.setInt(3, amigo.getUsuario().getId());

                stmt.executeUpdate();
                resultado = 1;
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;

        }

        return resultado;
    }

    public boolean excluir(Amigo amigo) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "DELETE FROM AMIGO WHERE IDAMIGO = ? AND IDUSUARIO = ? ";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, amigo.getAmigo().getId());
            stmt.setInt(2, amigo.getUsuario().getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Amigo editar(Amigo amigo) {

        try {

            String QUERY_DETALHE = "SELECT * FROM AMIGO WHERE IDAMIGO = ? AND IDUSUARIO = ? ";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, amigo.getAmigo().getId());
            stmt.setInt(2, amigo.getUsuario().getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                amigo = new Amigo();
                UsuarioDao usuarioDao = new UsuarioDao();
                amigo.setAmigo(usuarioDao.editar(rs.getInt("IDAMIGO")));
                amigo.setUsuario(usuarioDao.editar(rs.getInt("IDUSUARIO")));
                amigo.setSituacao(rs.getString("SITUACAO"));
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            amigo = null;

        }

        return amigo;
    }

    public List<Amigo> listar() {
        
        List<Amigo> lista = new ArrayList<Amigo>();
        try {
            String QUERY_DETALHE = "SELECT * FROM AMIGO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Amigo amigo = new Amigo();
                UsuarioDao usuarioDao = new UsuarioDao();
                amigo.setAmigo(usuarioDao.editar(rs.getInt("IDAMIGO")));
                amigo.setUsuario(usuarioDao.editar(rs.getInt("IDUSUARIO")));
                amigo.setSituacao(rs.getString("SITUACAO"));
                lista.add(amigo);
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            return lista;

        }
        
    }

    public List<Amigo> listaAmigos(int idusuario) {
        
        List<Amigo> lista = new ArrayList<Amigo>();
        try {
            String QUERY_DETALHE = "SELECT * FROM AMIGO WHERE IDUSUARIO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, idusuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Amigo amigo = new Amigo();
                UsuarioDao usuarioDao = new UsuarioDao();
                amigo.setAmigo(usuarioDao.editar(rs.getInt("IDAMIGO")));
                amigo.setUsuario(usuarioDao.editar(rs.getInt("IDUSUARIO")));
                amigo.setSituacao(rs.getString("SITUACAO"));
                lista.add(amigo);
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            return lista;

        }
        
    }

}

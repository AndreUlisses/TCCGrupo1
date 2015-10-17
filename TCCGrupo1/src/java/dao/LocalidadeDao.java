package dao;

import conexao.ConnectionManager;
import entidade.Localidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalidadeDao {
    
    public int salvar(Localidade localidade) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
            
            String QUERY_INSERT = "insert into LOCALIDADE (IDLOCALIDADE,IDCATEGORIA,IDUSUARIO,NOME,DESCRICAO,DT_LOCALIDADE) values (?, ?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "update LOCALIDADE set IDCATEGORIA = ?, IDUSUARIO = ?, NOME = ?, DESCRICAO = ?, DT_LOCALIDADE = ? where IDLOCALIDADE = ? ";

            //verificar comparação
            if (localidade.getIdLocalidade()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, localidade.getNome());
                stmt.setString(2, localidade.getDescricao());
                stmt.setDate(3, localidade.getDtLocalidade());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, localidade.getNome());
                stmt.setString(2, localidade.getDescricao());
                stmt.setDate(3, localidade.getDtLocalidade());

                stmt.executeUpdate();
                resultado = localidade.getIdLocalidade();
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(Localidade localidade) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from LOCALIDADE where IDLOCALIDADE = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, localidade.getIdLocalidade());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Localidade editar(int id) {

        Localidade localidade = new Localidade();
        
        try {

            String QUERY_DETALHE = "select * from LOCALIDADE where IDLOCALIDADE = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                localidade = new Localidade();
                localidade.setIdLocalidade(rs.getInt("IDLOCALIDADE"));
                localidade.setNome(rs.getString("NOME"));
                localidade.setDescricao(rs.getString("DESCRICAO"));
                localidade.setDtLocalidade(rs.getDate("DT_LOCALIDADE"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            localidade = null;
            
        }
        
        return localidade;
    }

    public List<Localidade> listar() {
        List<Localidade> lista = new ArrayList<Localidade>();
        try {
            String QUERY_DETALHE = "select * from LOCALIDADE";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Localidade localidade = new Localidade();
                localidade.setIdLocalidade(rs.getInt("IDLOCALIDADE"));
                localidade.setNome(rs.getString("NOME"));
                localidade.setDescricao(rs.getString("DESCRICAO"));
                localidade.setDtLocalidade(rs.getDate("DT_LOCALIDADE"));
                lista.add(localidade);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
    
}

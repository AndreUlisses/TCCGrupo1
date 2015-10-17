package dao;

import conexao.ConnectionManager;
import entidade.Ponto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PontoDao {

       public int salvar(Ponto ponto) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "INSERT INTO PONTO (IDPONTO,IDLOCALIDADE,IDUSUARIO,DESCRICAO,LATITUDE,LONGITUDE,ALTITUDE,DTPONTO) values (?, ?, ?, ?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "UPDATE PONTO SET IDLOCALIDADE = ?, IDUSUARIO = ?, DESCRICAO = ?, LATITUDE = ?, LONGITUDE = ?,ALTITUDE = ?, DTPONTO = ? WHERE IDPONTO = ? ";

        if (ponto.getIdPonto()== null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, ponto.getIdPonto());
                stmt.setString(2, ponto.getDescricao());
                stmt.setFloat(3, ponto.getLatitude());
                stmt.setFloat(4, ponto.getLongitude());
                stmt.setFloat(5, ponto.getAltitude());
                stmt.setDate(6, ponto.getDtPonto());

                stmt.executeUpdate();
                resultado = 1;                

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setInt(1, ponto.getIdPonto());
                stmt.setString(2, ponto.getDescricao());
                stmt.setFloat(3, ponto.getLatitude());
                stmt.setFloat(4, ponto.getLongitude());
                stmt.setFloat(5, ponto.getAltitude());
                stmt.setDate(6, ponto.getDtPonto());

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

    public boolean excluir(Ponto ponto) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "DELETE FROM PONTO WHERE IDPONTO = ? ";

            stmt = conn.prepareStatement(QUERY_DELETE);
                stmt.setInt(1, ponto.getIdPonto());
                stmt.setString(2, ponto.getDescricao());
                stmt.setFloat(3, ponto.getLatitude());
                stmt.setFloat(4, ponto.getLongitude());
                stmt.setFloat(5, ponto.getAltitude());
                stmt.setDate(6, ponto.getDtPonto());
            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

        public Ponto editar(int id) {

        Ponto ponto = new Ponto();
        
        try {

            String QUERY_DETALHE = "select * from PONTO where IDPONTO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ponto = new Ponto();
                ponto.setIdPonto(rs.getInt("IDPONTO"));
                ponto.setDescricao(rs.getString("DESCRICAO"));
                ponto.setLatitude(rs.getFloat("LATITUDE"));
                ponto.setLongitude(rs.getFloat("LONGITUDE"));
                ponto.setAltitude(rs.getFloat("ALTITUDE"));
                ponto.setDtPonto(rs.getDate("DT_PONTO"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            ponto = null;
            
        }
        
        return ponto;
    }

    public List<Ponto> listar() {
        List<Ponto> lista = new ArrayList<Ponto>();
        try {
            String QUERY_DETALHE = "select * from PONTO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ponto ponto = new Ponto();
                ponto.setIdPonto(rs.getInt("IDPONTO"));
                ponto.setDescricao(rs.getString("DESCRICAO"));
                ponto.setLatitude(rs.getFloat("LATITUDE"));
                ponto.setLongitude(rs.getFloat("LONGITUDE"));
                ponto.setAltitude(rs.getFloat("ALTITUDE"));
                ponto.setDtPonto(rs.getDate("DT_PONTO"));
                
                lista.add(ponto);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }
        
    }    

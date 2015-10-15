package entidade;
import java.sql.Date;


public class Localidade {

    private int idLocalidade;
    private Categoria idCategoria;
    private Usuario idUsuario;
    private String nomeLocalidade;
    private String descricaoLocalidade;
    private Date dtLocalidade;
                    
    //GET&SET

    public int getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(int idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public String getDescricaoLocalidade() {
        return descricaoLocalidade;
    }

    public void setDescricaoLocalidade(String descricaoLocalidade) {
        this.descricaoLocalidade = descricaoLocalidade;
    }

    public Date getDtLocalidade() {
        return dtLocalidade;
    }

    public void setDtLocalidade(Date dtLocalidade) {
        this.dtLocalidade = dtLocalidade;
    }
   
    
}

package entidade;
import java.sql.Date;


public class Localidade {

    private Integer idLocalidade;
    private Categoria idCategoria;
    private Usuario idUsuario;
    private String nome;
    private String descricao;
    private Date dtLocalidade;
                    
    //GET&SET

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtLocalidade() {
        return dtLocalidade;
    }

    public void setDtLocalidade(Date dtLocalidade) {
        this.dtLocalidade = dtLocalidade;
    }

  
}

package entidade;

public class Foto {
    
    //TEM QUE FAZER HERANÇA
    
    private Integer idFoto;
    private Localidade idLocalidade;
    private Usuario idUsuario;
    private String descricao;

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public Localidade getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Localidade idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}

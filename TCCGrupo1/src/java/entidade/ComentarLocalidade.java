package entidade;

import java.sql.Date;

public class ComentarLocalidade {
    
    private Integer idComentario_Localidade;
    private Localidade idLocalidade;
    private Usuario idUsuario;
    private String texto;
    private Date dtComentario;

    public Integer getIdComentario_Localidade() {
        return idComentario_Localidade;
    }

    public void setIdComentario_Localidade(Integer idComentario_Localidade) {
        this.idComentario_Localidade = idComentario_Localidade;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDtComentario() {
        return dtComentario;
    }

    public void setDtComentario(Date dtComentario) {
        this.dtComentario = dtComentario;
    }

   
}

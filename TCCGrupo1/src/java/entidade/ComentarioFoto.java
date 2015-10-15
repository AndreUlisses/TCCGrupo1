package entidade;

import java.sql.Date;

public class ComentarioFoto {
    
    //TEM QUE FAZER HERANÇA
    
    private Integer idComentario;     
    private Integer idFoto;
    private Usuario idUsuario;
    private String texto;
    private Date dtComentario;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
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

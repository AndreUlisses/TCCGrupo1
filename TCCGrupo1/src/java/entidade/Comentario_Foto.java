package entidade;

import java.sql.Date;

public class Comentario_Foto {
    
    //TEM QUE FAZER HERANÇA
    
    private Integer idComentario;     
    private Integer idFoto;
    private Integer idUsuario;
    private String texto;
    private Date dt_Comentario;

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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDt_Comentario() {
        return dt_Comentario;
    }

    public void setDt_Comentario(Date dt_Comentario) {
        this.dt_Comentario = dt_Comentario;
    }

   
}

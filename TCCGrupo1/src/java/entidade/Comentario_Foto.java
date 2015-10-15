package entidade;

import java.sql.Date;

public class Comentario_Foto {
    
    //TEM QUE FAZER HERANÇA
    
    private int idComentario;     
    private int idFoto;
    private int idUsuario;
    private String texto;
    private Date dt_Comentario;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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

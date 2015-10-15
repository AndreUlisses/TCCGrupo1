package entidade;

import java.sql.Date;

public class Comentar_Localidade {
    
    private Integer idComentario_Localidade;
    private Integer idLocalidade;
    private Integer idUsuario;
    private String texto;
    private Date data_Comentario;

    public Integer getIdComentario_Localidade() {
        return idComentario_Localidade;
    }

    public void setIdComentario_Localidade(int idComentario_Localidade) {
        this.idComentario_Localidade = idComentario_Localidade;
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
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

    public Date getData_Comentario() {
        return data_Comentario;
    }

    public void setData_Comentario(Date data_Comentario) {
        this.data_Comentario = data_Comentario;
    }
    
    
}

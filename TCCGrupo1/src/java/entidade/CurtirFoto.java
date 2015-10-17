package entidade;

import java.sql.Date;

public class CurtirFoto {
    
    private Integer idFoto;
    private Usuario idUsuario;
    private Date dtCurtir;

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

    public Date getDtCurtir() {
        return dtCurtir;
    }

    public void setDtCurtir(Date dtCurtir) {
        this.dtCurtir = dtCurtir;
    }

   
  
}

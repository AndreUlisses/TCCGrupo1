package entidade;

import java.sql.Date;

public class Curtir_Foto {
    
    private Integer idFoto;
    private int idUsuario;
    private Date dtCurtir;

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDt_Curtir() {
        return dtCurtir;
    }

    public void setDt_Curtir(Date dt_Curtir) {
        this.dtCurtir = dt_Curtir;
    }

      
    
}

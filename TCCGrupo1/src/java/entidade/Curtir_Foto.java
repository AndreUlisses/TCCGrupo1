package entidade;

import java.sql.Date;

public class Curtir_Foto {
    
    private int idFoto;
    private int idUsuario;
    private Date dt_Curtir;

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

    public Date getDt_Curtir() {
        return dt_Curtir;
    }

    public void setDt_Curtir(Date dt_Curtir) {
        this.dt_Curtir = dt_Curtir;
    }
    
    
    
    
}

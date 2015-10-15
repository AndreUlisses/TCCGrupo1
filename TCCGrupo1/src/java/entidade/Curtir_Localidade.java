package entidade;

import java.sql.Date;

public class Curtir_Localidade {
    
    //TEM QUE FAZER HERANÇA
    
    private int idLocalidade;
    private int idUsuario;
    private Date dt_Curtir;

    public int getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(int idLocalidade) {
        this.idLocalidade = idLocalidade;
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

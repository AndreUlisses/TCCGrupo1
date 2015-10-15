package entidade;

import java.sql.Date;

public class Curtir_Localidade {
    
    //TEM QUE FAZER HERANÇA
    
    private Integer idLocalidade;
    private Usuario idUsuario;
    private Date dtCurtir;

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
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

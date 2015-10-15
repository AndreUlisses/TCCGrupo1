package entidade;

import java.sql.Date;

public class Ponto {
    
    private Integer idPonto;
    private Localidade idLocalidade;
    private Usuario idUsuario;
    private String descricao;
    private float latitude;
    private float longitude;
    private float altitude;
    private Date dtPonto;

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public Date getDtPonto() {
        return dtPonto;
    }

    public void setDtPonto(Date dtPonto) {
        this.dtPonto = dtPonto;
    }

   
}

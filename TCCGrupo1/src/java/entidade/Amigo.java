package entidade;

public class Amigo{
    
   private Integer idAmigo;
   private Integer idUsuario;
   private Enum pendente, confirmado; 

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Enum getPendente() {
        return pendente;
    }

    public void setPendente(Enum pendente) {
        this.pendente = pendente;
    }

    public Enum getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Enum confirmado) {
        this.confirmado = confirmado;
    }
   
   
}

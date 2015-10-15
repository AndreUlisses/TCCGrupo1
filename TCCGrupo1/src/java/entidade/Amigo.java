package entidade;

public class Amigo{
    
   private Integer idAmigo;
   private Usuario idUsuario;
   private Enum pendente, confirmado; 

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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

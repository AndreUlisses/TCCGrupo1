package entidade;

public class Amigo{
    
   private int idAmigo;
   private int idUsuario;
   private Enum pendente, confirmado; 

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
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

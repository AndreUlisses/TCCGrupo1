package entidade;

public class Amigo extends Usuario{
   
   //TEM QUE FAZER HERANÇA
   
   private int idAmigo;
   private int idUsuario;
   private Enum pendente, confirmado; 

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

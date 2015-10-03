package entidade;

import java.util.Date;



public class Usuario {

    private Integer id;
    private String nome;
    private Date dataNascimento;
    private boolean sexo;
    private String user;
    private String email;
    private String senha;
    

        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getUser() {
        return user;
    }

    //Usuário, senha, e-mail, nome, sobrenome, data de nascimento, sexo, foto do perfil.
    public void setUser(String user) {
        this.user = user;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

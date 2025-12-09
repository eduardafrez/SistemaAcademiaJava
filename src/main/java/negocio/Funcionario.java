package negocio;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String usuario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Funcionario(int idFuncionario, String nome, String usuario, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    //getters e setters

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
}
    

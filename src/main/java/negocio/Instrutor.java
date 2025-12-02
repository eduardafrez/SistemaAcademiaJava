package negocio;

public class Instrutor {
    
    private int idInstrutor;
    private String nome;
    private String cpf;
    private String cref; // Registro profissional (Conselho Regional de Ed. Física)
    private String telefone;
    
    // Dados para entrar no sistema (Igual ao slide)
    private String login;
    private String senha;

    public Instrutor() {
    }

    // --- Getters e Setters ---

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Para aparecer o nome bonito nas listas
    @Override
    public String toString() {
        return this.nome;
    }
}
package negocio;

import java.util.Date;

public class Aluno {
    
    private int idAluno;
    private String matricula; // Ex: 2023001
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private String sexo;
    private String plano; // Ex: "Mensal", "Trimestral", "Anual"
    private boolean ativo; // Para saber se a mensalidade está em dia
    private String endereco;
    private String foto;
    // Construtor vazio
    public Aluno() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    // --- GETTERS E SETTERS (Pode gerar automático no NetBeans: Alt+Insert) ---
    
    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }
    
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    // Importante para quando formos criar os ComboBox (listas) nas telas
    @Override
    public String toString() {
        return this.nome;
    }
}
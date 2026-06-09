package negocio;

import java.util.Date;

public class Treino {
    private int idTreino;
    private String aluno;           // Nome do aluno (string)
    private String funcionario;     // Nome do funcionário (string)
    private String treino;          // String com exercícios
    private Date dataInicio;
    private Date dataFim;

    public Treino() {
    }

    public Treino(String aluno, String funcionario, String treino, Date dataInicio, Date dataFim) {
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.treino = treino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Treino(int idTreino, String aluno, String funcionario, String treino, Date dataInicio, Date dataFim) {
        this.idTreino = idTreino;
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.treino = treino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Treino{" + "idTreino=" + idTreino + ", aluno=" + aluno + ", funcionario=" + funcionario + ", treino=" + treino + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
}
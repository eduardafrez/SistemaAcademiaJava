package negocio;

import java.util.Date;

public class Treino {
    private int idTreino;
    private int idAluno;
    private int idFuncionario;    
    private String descricaoTreino;
    private Date dataInicio;
    private Date dataFim;

    //construtores

    public Treino() {
    }

    public Treino(int idAluno, int idFuncionario, String descricaoTreino, Date dataInicio, Date dataFim) {
        this.idAluno = idAluno;
        this.idFuncionario = idFuncionario;
        this.descricaoTreino = descricaoTreino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Treino(int idTreino, int idAluno, int idFuncionario, String descricaoTreino, Date dataInicio, Date dataFim) {
        this.idTreino = idTreino;
        this.idAluno = idAluno;
        this.idFuncionario = idFuncionario;
        this.descricaoTreino = descricaoTreino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    //getters e setters

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getDescricaoTreino() {
        return descricaoTreino;
    }

    public void setDescricaoTreino(String descricaoTreino) {
        this.descricaoTreino = descricaoTreino;
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
        return "Treino{" + "idTreino=" + idTreino + ", idAluno=" + idAluno + ", idFuncionario=" + idFuncionario + ", descricaoTreino=" + descricaoTreino + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
        
}
package negocio;

import java.util.Date;

public class AvaliacaoFisica {
    
    private int idAvaliacao;
    
    // Medidas
    private double peso;
    private double altura;
    private double gorduraCorporal; // % de gordura
    private double massaMuscular;
    private String observacoes; // Lesões, dores, objetivos
    
    private Date dataAvaliacao;
    
    // Relacionamentos (Quem é o aluno e quem avaliou)
    private int idAluno;      
    private int idInstrutor;  

    public AvaliacaoFisica() {
    }

    // --- GETTERS E SETTERS ---
    
    public int getIdAvaliacao() { return idAvaliacao; }
    public void setIdAvaliacao(int idAvaliacao) { this.idAvaliacao = idAvaliacao; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getGorduraCorporal() { return gorduraCorporal; }
    public void setGorduraCorporal(double gorduraCorporal) { this.gorduraCorporal = gorduraCorporal; }
    
    public double getMassaMuscular() { return massaMuscular; }
    public void setMassaMuscular(double massaMuscular) { this.massaMuscular = massaMuscular; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Date getDataAvaliacao() { return dataAvaliacao; }
    public void setDataAvaliacao(Date dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; }

    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public int getIdInstrutor() { return idInstrutor; }
    public void setIdInstrutor(int idInstrutor) { this.idInstrutor = idInstrutor; }
}
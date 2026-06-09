package negocio;

public class Exercicio {
    private int idExercicio;
    private String nome;
    private String descricao;

    public Exercicio() {
    }

    public Exercicio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Exercicio(int idExercicio, String nome, String descricao) {
        this.idExercicio = idExercicio;
        this.nome = nome;
        this.descricao = descricao;
    }


    //getters e setters

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Exercicio{" + "idExercicio=" + idExercicio + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
}
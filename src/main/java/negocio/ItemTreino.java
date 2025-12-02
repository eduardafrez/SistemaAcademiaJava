package negocio;

public class ItemTreino {
    private Exercicio exercicio;
    private int series;
    private int repeticoes;
    private String carga; // Ex: "20kg"

    // Construtor, Getters e Setters (Gere com Alt+Insert)
    public Exercicio getExercicio() { return exercicio; }
    public void setExercicio(Exercicio exercicio) { this.exercicio = exercicio; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }
    
    public String getCarga() { return carga; }
    public void setCarga(String carga) { this.carga = carga; }
}
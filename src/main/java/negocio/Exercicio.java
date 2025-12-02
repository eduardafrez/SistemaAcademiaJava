package negocio;

public class Exercicio {
    private String nome;
    private String grupoMuscular; // Peito, Costas, Pernas...

    public Exercicio(String nome, String grupoMuscular) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
    }

    // Getter e Setter (Gere com Alt+Insert)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }

    @Override
    public String toString() {
        return this.nome; // Para aparecer bonito no ComboBox
    }
}

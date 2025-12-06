/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Treino;

/**
 *
 * @author Eduarda de Oliveira
 */
public interface ITreinoDAO {
    public void adiciona(Treino treino);
    public void altera(Treino treino);
    public void remove(int id);
    public List<Treino> listarTodos();
    public Treino getByID(int id);
}

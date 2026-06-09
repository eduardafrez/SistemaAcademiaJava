/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Exercicio;

/**
 *
 * @author Eduarda de Oliveira
 */
public interface IExercicioDAO {
    public void adiciona(Exercicio exercicio);
    public void altera(Exercicio exercicio);
    public void remove(int id);
    public List<Exercicio> listarTodos();
    public Exercicio getByID(int id);
}

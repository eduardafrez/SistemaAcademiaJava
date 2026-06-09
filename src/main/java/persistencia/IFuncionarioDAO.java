/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Funcionario;

/**
 *
 * @author Eduarda de Oliveira
 */
public interface IFuncionarioDAO {
    public void adiciona(Funcionario funcionario);
    public void altera(Funcionario funcionario);
    public void remove(int id);
    public List<Funcionario> listarTodos();
    public Funcionario getByID(int id);
}
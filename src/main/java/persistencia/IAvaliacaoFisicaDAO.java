/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.AvaliacaoFisica;


/**
 *
 * @author Eduarda de Oliveira
 */
public interface IAvaliacaoFisicaDAO {
    public void adiciona(AvaliacaoFisica avaliacaoFisica);
    public void altera(AvaliacaoFisica avaliacaoFisica);
    public void remove(int id);
    public List<AvaliacaoFisica> listarTodos();
    public AvaliacaoFisica getByID(int id);
}

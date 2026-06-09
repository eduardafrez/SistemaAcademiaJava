/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Pagamento;
/**
 *
 * @author Eduarda de Oliveira
 */
public interface IPagamentoDAO {
    public void adiciona(Pagamento pagamento);
    public void altera(Pagamento pagamento);
    public void remove(int id);
    public List<Pagamento> listarTodos();
    public Pagamento getByID(int id);    
}

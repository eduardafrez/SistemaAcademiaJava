/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private int idAluno;
    private Date dataPagamento;
    private double valor;
    private String formaPagamento;  // Credito, Debito, Pix, Boleto
    private String plano;           // Mensal, Trimestral, Semestral, Anual
    private String statusPagamento;

    public Pagamento() {
    }

    public Pagamento(int idAluno, Date dataPagamento, double valor, String formaPagamento, String plano, String statusPagamento) {
        this.idAluno = idAluno;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.plano = plano;
        this.statusPagamento = statusPagamento;
    }

    public Pagamento(int idPagamento, int idAluno, Date dataPagamento, double valor, String formaPagamento, String plano, String statusPagamento) {
        this.idPagamento = idPagamento;
        this.idAluno = idAluno;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.plano = plano;
        this.statusPagamento = statusPagamento;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getStatus() {
        return statusPagamento;
    }

    public void setStatus(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "idPagamento=" + idPagamento + ", idAluno=" + idAluno + ", dataPagamento=" + dataPagamento + ", valor=" + valor + ", formaPagamento=" + formaPagamento + ", plano=" + plano + ", statusPagamento=" + statusPagamento + '}';
    }
}

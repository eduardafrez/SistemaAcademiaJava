package persistencia;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Pagamento;


public class PagamentoDAO implements IPagamentoDAO {
    private Connection connection;

    public PagamentoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos " +
                    "(idAluno, data_pagamento, valor, forma_pagamento, plano, status_pagamento) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, pagamento.getIdAluno());
            stmt.setString(2, sdf.format(pagamento.getDataPagamento()));
            stmt.setDouble(3, pagamento.getValor());
            stmt.setString(4, pagamento.getFormaPagamento());
            stmt.setString(5, pagamento.getPlano());
            stmt.setString(6, pagamento.getStatus());
            
            stmt.execute();
            
            // Recuperar o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setIdPagamento(rs.getInt(1));
                }
            }
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(Pagamento pagamento) {
        String sql = "UPDATE pagamentos SET " +
                    "idAluno = ?, data_pagamento = ?, valor = ?, " +
                    "forma_pagamento = ?, plano = ?, status_pagamento = ? " +
                    "WHERE idPagamento = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getIdAluno());
            stmt.setString(2, sdf.format(pagamento.getDataPagamento()));
            stmt.setDouble(3, pagamento.getValor());
            stmt.setString(4, pagamento.getFormaPagamento());
            stmt.setString(5, pagamento.getPlano());
            stmt.setString(6, pagamento.getStatus());
            stmt.setInt(7, pagamento.getIdPagamento());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM pagamentos WHERE idPagamento = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Pagamento> listarTodos() {
        try {
            List<Pagamento> pagamentos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM pagamentos ORDER BY data_pagamento DESC");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setIdAluno(rs.getInt("idAluno"));
                
                // Data do pagamento
                Calendar dataPag = Calendar.getInstance();
                dataPag.setTime(rs.getDate("data_pagamento"));
                pagamento.setDataPagamento(dataPag.getTime());
                
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setFormaPagamento(rs.getString("forma_pagamento"));
                pagamento.setPlano(rs.getString("plano"));
                pagamento.setStatus(rs.getString("status_pagamento"));
                
                pagamentos.add(pagamento);
            }
            rs.close();
            stmt.close();
            return pagamentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Pagamento getByID(int id) {
        String sql = "SELECT * FROM pagamentos WHERE idPagamento = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setIdPagamento(rs.getInt("idPagamento"));
                    pagamento.setIdAluno(rs.getInt("idAluno"));
                    
                    // Data do pagamento
                    Calendar dataPag = Calendar.getInstance();
                    dataPag.setTime(rs.getDate("data_pagamento"));
                    pagamento.setDataPagamento(dataPag.getTime());
                    
                    pagamento.setValor(rs.getDouble("valor"));
                    pagamento.setFormaPagamento(rs.getString("forma_pagamento"));
                    pagamento.setPlano(rs.getString("plano"));
                    pagamento.setStatus(rs.getString("status_pagamento"));
                    
                    return pagamento;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    // Métodos adicionais úteis (opcionais, mas recomendados)
    
    public List<Pagamento> listarPorAluno(int idAluno) {
        try {
            List<Pagamento> pagamentos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(
                "SELECT * FROM pagamentos WHERE idAluno = ? ORDER BY data_pagamento DESC"
            );
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setIdAluno(rs.getInt("idAluno"));
                
                Calendar dataPag = Calendar.getInstance();
                dataPag.setTime(rs.getDate("data_pagamento"));
                pagamento.setDataPagamento(dataPag.getTime());
                
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setFormaPagamento(rs.getString("forma_pagamento"));
                pagamento.setPlano(rs.getString("plano"));
                pagamento.setStatus(rs.getString("status_pagamento"));
                
                pagamentos.add(pagamento);
            }
            rs.close();
            stmt.close();
            return pagamentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pagamento> listarPorStatus(String status) {
        try {
            List<Pagamento> pagamentos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(
                "SELECT * FROM pagamentos WHERE status_pagamento = ? ORDER BY data_pagamento DESC"
            );
            stmt.setString(1, status.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setIdAluno(rs.getInt("idAluno"));
                
                Calendar dataPag = Calendar.getInstance();
                dataPag.setTime(rs.getDate("data_pagamento"));
                pagamento.setDataPagamento(dataPag.getTime());
                
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setFormaPagamento(rs.getString("forma_pagamento"));
                pagamento.setPlano(rs.getString("plano"));
                pagamento.setStatus(rs.getString("status_pagamento"));
                
                pagamentos.add(pagamento);
            }
            rs.close();
            stmt.close();
            return pagamentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pagamento> listarPendentes() {
        return listarPorStatus("pendente");
    }
    
    public List<Pagamento> listarPagos() {
        return listarPorStatus("pago");
    }
    
    public boolean alunoTemPagamentoPendente(int idAluno) {
        String sql = "SELECT COUNT(*) as total FROM pagamentos " +
                    "WHERE idAluno = ? AND status_pagamento = 'pendente'";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total") > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
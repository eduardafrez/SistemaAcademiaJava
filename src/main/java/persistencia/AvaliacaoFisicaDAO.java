/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import negocio.AvaliacaoFisica;
/**
 *
 * @author Eduarda de Oliveira
 */
public class AvaliacaoFisicaDAO implements IAvaliacaoFisicaDAO {
    private Connection connection;
    
    public AvaliacaoFisicaDAO(Connection connection) {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(AvaliacaoFisica avaliacao) {
        String sql = "INSERT INTO AvaliacaoFisica (peso, altura, gorduraCorporal, massaMuscular, " +
                    "observacoes, dataAvaliacao, idAluno, idInstrutor) VALUES (?,?,?,?,?,?,?,?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setDouble(1, avaliacao.getPeso());
            stmt.setDouble(2, avaliacao.getAltura());
            stmt.setDouble(3, avaliacao.getGorduraCorporal());
            stmt.setDouble(4, avaliacao.getMassaMuscular());
            stmt.setString(5, avaliacao.getObservacoes());
            stmt.setString(6, sdf.format(avaliacao.getDataAvaliacao()));
            stmt.setInt(7, avaliacao.getIdAluno());
            stmt.setInt(8, avaliacao.getIdInstrutor());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(AvaliacaoFisica avaliacao) {
        String sql = "UPDATE AvaliacaoFisica SET peso = ?, altura = ?, gorduraCorporal = ?, " +
                    "massaMuscular = ?, observacoes = ?, dataAvaliacao = ?, idAluno = ?, " +
                    "idInstrutor = ? WHERE idAvaliacao = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, avaliacao.getPeso());
            stmt.setDouble(2, avaliacao.getAltura());
            stmt.setDouble(3, avaliacao.getGorduraCorporal());
            stmt.setDouble(4, avaliacao.getMassaMuscular());
            stmt.setString(5, avaliacao.getObservacoes());
            stmt.setString(6, sdf.format(avaliacao.getDataAvaliacao()));
            stmt.setInt(7, avaliacao.getIdAluno());
            stmt.setInt(8, avaliacao.getIdInstrutor());
            stmt.setInt(9, avaliacao.getIdAvaliacao());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM AvaliacaoFisica WHERE idAvaliacao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<AvaliacaoFisica> listarTodos() {
        try {
            List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM AvaliacaoFisica");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                AvaliacaoFisica avaliacao = new AvaliacaoFisica();
                avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
                avaliacao.setPeso(rs.getDouble("peso"));
                avaliacao.setAltura(rs.getDouble("altura"));
                avaliacao.setGorduraCorporal(rs.getDouble("gorduraCorporal"));
                avaliacao.setMassaMuscular(rs.getDouble("massaMuscular"));
                avaliacao.setObservacoes(rs.getString("observacoes"));
                avaliacao.setDataAvaliacao(rs.getDate("dataAvaliacao"));
                avaliacao.setIdAluno(rs.getInt("idAluno"));
                avaliacao.setIdInstrutor(rs.getInt("idInstrutor"));
                
                avaliacoes.add(avaliacao);
            }
            rs.close();
            stmt.close();
            return avaliacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public AvaliacaoFisica getByID(int id) {
        String sql = "SELECT * FROM AvaliacaoFisica WHERE idAvaliacao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    AvaliacaoFisica avaliacao = new AvaliacaoFisica();
                    avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
                    avaliacao.setPeso(rs.getDouble("peso"));
                    avaliacao.setAltura(rs.getDouble("altura"));
                    avaliacao.setGorduraCorporal(rs.getDouble("gorduraCorporal"));
                    avaliacao.setMassaMuscular(rs.getDouble("massaMuscular"));
                    avaliacao.setObservacoes(rs.getString("observacoes"));
                    avaliacao.setDataAvaliacao(rs.getDate("dataAvaliacao"));
                    avaliacao.setIdAluno(rs.getInt("idAluno"));
                    avaliacao.setIdInstrutor(rs.getInt("idInstrutor"));
                    
                    return avaliacao;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

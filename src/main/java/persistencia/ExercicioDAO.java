/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import negocio.Exercicio;

/**
 *
 * @author Eduarda de Oliveira
 */
public class ExercicioDAO implements IExercicioDAO {
    private Connection connection;
    
    public ExercicioDAO(Connection connection) {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Exercicio exercicio) {
        String sql = "INSERT INTO Exercicios (nome, descricao) VALUES (?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(Exercicio exercicio) {
        String sql = "UPDATE Exercicios SET nome = ?, descricao = ? WHERE idExercicio = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.setInt(3, exercicio.getIdExercicio());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM Exercicios WHERE idExercicio = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Exercicio> listarTodos() {
        try {
            List<Exercicio> exercicios = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Exercicios");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setIdExercicio(rs.getInt("idExercicio"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setDescricao(rs.getString("descricao"));
                
                exercicios.add(exercicio);
            }
            rs.close();
            stmt.close();
            return exercicios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Exercicio getByID(int id) {
        String sql = "SELECT * FROM Exercicios WHERE idExercicio = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Exercicio exercicio = new Exercicio();
                    exercicio.setIdExercicio(rs.getInt("idExercicio"));
                    exercicio.setNome(rs.getString("nome"));
                    exercicio.setDescricao(rs.getString("descricao"));
                    
                    return exercicio;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
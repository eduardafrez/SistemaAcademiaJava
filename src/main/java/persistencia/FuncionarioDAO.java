/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import negocio.Funcionario;

/**
 *
 * @author Eduarda de Oliveira
 */
public class FuncionarioDAO implements IFuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(){
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionarios (nome, usuario, senha) VALUES (?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(Funcionario funcionario) {
        String sql = "UPDATE Funcionarios SET nome = ?, usuario = ?, senha = ? WHERE idFuncionario = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setInt(4, funcionario.getIdFuncionario());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM Funcionarios WHERE idFuncionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Funcionario> listarTodos() {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Funcionarios");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Funcionario getByID(int id) {
        String sql = "SELECT * FROM Funcionarios WHERE idFuncionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setUsuario(rs.getString("usuario"));
                    funcionario.setSenha(rs.getString("senha"));
                    
                    return funcionario;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
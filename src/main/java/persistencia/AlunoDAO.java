/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Aluno;

/**
 *
 * @author Eduarda de Oliveira
 */
public class AlunoDAO implements IAlunoDAO{
    private Connection connection;
    
    public AlunoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Aluno aluno) {
        String sql = "INSERT INTO Alunos " +
                "(nome, cpf, telefone, email, dataNascimento, sexo, plano, ativo, endereco, foto, dataMatricula) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, sdf.format(aluno.getDataNascimento()));
            stmt.setString(6, aluno.getSexo());
            stmt.setString(7, aluno.getPlano());
            stmt.setBoolean(8, aluno.isAtivo());
            stmt.setString(9, aluno.getEndereco());
            stmt.setString(10, aluno.getFoto());
            stmt.setString(11, sdf.format(aluno.getDataMatricula()));
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(Aluno aluno) {
        String sql = "UPDATE Alunos SET nome = ?, cpf = ?, telefone = ?, email = ?, " +
                "dataNascimento = ?, sexo = ?, plano = ?, ativo = ?, endereco = ?, " +
                "foto = ?, dataMatricula = ? WHERE idAluno = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, sdf.format(aluno.getDataNascimento()));
            stmt.setString(6, aluno.getSexo());
            stmt.setString(7, aluno.getPlano());
            stmt.setBoolean(8, aluno.isAtivo());
            stmt.setString(9, aluno.getEndereco());
            stmt.setString(10, aluno.getFoto());
            stmt.setString(11, sdf.format(aluno.getDataMatricula()));
            stmt.setInt(12, aluno.getIdAluno());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM Alunos WHERE idAluno = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Aluno> listarTodos() {
        try {
            List<Aluno> alunos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Alunos");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEmail(rs.getString("email"));
                
                Calendar dataNasc = Calendar.getInstance();
                dataNasc.setTime(rs.getDate("dataNascimento"));
                aluno.setDataNascimento(dataNasc.getTime());
                
                aluno.setSexo(rs.getString("sexo"));
                aluno.setPlano(rs.getString("plano"));
                aluno.setAtivo(rs.getBoolean("ativo"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setFoto(rs.getString("foto"));
                
                Calendar dataMat = Calendar.getInstance();
                dataMat.setTime(rs.getDate("dataMatricula"));
                aluno.setDataMatricula(dataMat.getTime());
                
                alunos.add(aluno);
            }
            rs.close();
            stmt.close();
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Aluno getByID(int id) {
        String sql = "SELECT * FROM Alunos WHERE idAluno = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setIdAluno(rs.getInt("idAluno"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setEmail(rs.getString("email"));
                    
                    Calendar dataNasc = Calendar.getInstance();
                    dataNasc.setTime(rs.getDate("dataNascimento"));
                    aluno.setDataNascimento(dataNasc.getTime());
                    
                    aluno.setSexo(rs.getString("sexo"));
                    aluno.setPlano(rs.getString("plano"));
                    aluno.setAtivo(rs.getBoolean("ativo"));
                    aluno.setEndereco(rs.getString("endereco"));
                    aluno.setFoto(rs.getString("foto"));
                    
                    Calendar dataMat = Calendar.getInstance();
                    dataMat.setTime(rs.getDate("dataMatricula"));
                    aluno.setDataMatricula(dataMat.getTime());
                    
                    return aluno;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

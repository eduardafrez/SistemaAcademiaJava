/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import negocio.Treino;

public class TreinoDAO implements ITreinoDAO {
    private Connection connection;

    public TreinoDAO(){
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adiciona(Treino treino) {
        String sql = "INSERT INTO Treinos (aluno, funcionario, treino, dataInicio, dataFim) " +
                    "VALUES (?, ?, ?, ?, ?)";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // CORREÇÃO: Mudado para getAluno() e getFuncionario() (nomes em string)
            stmt.setString(1, treino.getAluno());          // Era: getIdAluno()
            stmt.setString(2, treino.getFuncionario());    // Era: getIdFuncionario()
            stmt.setString(3, treino.getTreino());         // Era: getDescricaoTreino()
            stmt.setString(4, sdf.format(treino.getDataInicio()));

            if (treino.getDataFim() != null) {
                stmt.setString(5, sdf.format(treino.getDataFim()));
            } else {
                stmt.setNull(5, Types.DATE);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void altera(Treino treino) {
        String sql = "UPDATE Treinos SET aluno = ?, funcionario = ?, treino = ?, " +
                    "dataInicio = ?, dataFim = ? WHERE idTreino = ?";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // CORREÇÃO: Mudado para getAluno() e getFuncionario()
            stmt.setString(1, treino.getAluno());          // Era: getIdAluno()
            stmt.setString(2, treino.getFuncionario());    // Era: getIdFuncionario()
            stmt.setString(3, treino.getTreino());         // Era: getDescricaoTreino()
            stmt.setString(4, sdf.format(treino.getDataInicio()));

            if (treino.getDataFim() != null) {
                stmt.setString(5, sdf.format(treino.getDataFim()));
            } else {
                stmt.setNull(5, Types.DATE);
            }

            stmt.setInt(6, treino.getIdTreino());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM Treinos WHERE idTreino = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Treino> listarTodos() {
        try {
            List<Treino> treinos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Treinos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Treino treino = new Treino();
                treino.setIdTreino(rs.getInt("idTreino"));

                treino.setAluno(rs.getString("aluno"));              
                treino.setFuncionario(rs.getString("funcionario"));  
                treino.setTreino(rs.getString("treino")); 

                treino.setDataInicio(rs.getDate("dataInicio"));
                treino.setDataFim(rs.getDate("dataFim"));

                treinos.add(treino);
            }
            rs.close();
            stmt.close();
            return treinos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Treino getByID(int id) {
        String sql = "SELECT * FROM Treinos WHERE idTreino = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Treino treino = new Treino();
                    treino.setIdTreino(rs.getInt("idTreino"));

                    // CORREÇÃO: Mudado para colunas de string
                    treino.setAluno(rs.getString("aluno"));              // Era: setIdAluno()
                    treino.setFuncionario(rs.getString("funcionario"));  // Era: setIdFuncionario()
                    treino.setTreino(rs.getString("treino"));            // Era: setDescricaoTreino()

                    treino.setDataInicio(rs.getDate("dataInicio"));
                    treino.setDataFim(rs.getDate("dataFim"));

                    return treino;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
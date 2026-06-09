/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            // AJUSTE AQUI: Coloque seu banco, usuário e senha
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbjavagym", 
                "root", 
                "12345"
            );
            
            System.out.println("✅ Conectado ao MySQL com sucesso!");
            System.out.println("Banco: AcademiaDB");
            
            conn.close();
            
        } catch (Exception e) {
            System.err.println("❌ Falha na conexão!");
            e.printStackTrace();
        }
    }
}

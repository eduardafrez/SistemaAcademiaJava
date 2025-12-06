/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Eduarda de Oliveira
 */
public class ConFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/dbjavagym","root","12345");
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}

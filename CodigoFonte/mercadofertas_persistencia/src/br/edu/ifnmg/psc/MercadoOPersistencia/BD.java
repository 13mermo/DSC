/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author wesley
 */
public class BD {
    
    private static Connection conexao;
    
    public static Connection getConexao() {
        
        InputStream arquivo = null;
        Properties prop = new Properties();
        try {
            arquivo = BD.class.getResourceAsStream("/config.properties"); //new FileInputStream("config.properties");
            
            prop.load(arquivo);
            
            // Se a conexão ainda não estiver iniciada
            if(conexao == null){
                
                // Carrega o driver do MySQL na memória
                Class.forName(prop.getProperty("BDDRIVER"));
                
                // o Gerenciador de Drivers abre uma conexão com o SGBD a partir da connection string
                conexao = DriverManager.getConnection(prop.getProperty("BDURL"), 
                        prop.getProperty("BDUSER"), prop.getProperty("BDPWD"));
            }   
            return conexao;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
         } 
        
        return null;
    }
    
}
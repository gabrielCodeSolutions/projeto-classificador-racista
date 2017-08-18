/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**  
 *
 * @author edson
 */
public class SqliteCon {
    
    public Connection getConnection() throws SQLException
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Desen\\ClassificarTexto.db");
        } catch (SQLException ex) {
            Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    
}

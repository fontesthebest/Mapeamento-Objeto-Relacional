/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naote
 */
public class ConectorBD {
    
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
       return DriverManager.getConnection("jdbc:sqlserver:// localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;","loja","loja"); 
        
    }
    
    public PreparedStatement getPrepared(String sqlcode) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sqlcode);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
        }
    
    public ResultSet getSelect(PreparedStatement ps) throws SQLException {
        ResultSet rt = ps.executeQuery();
        
        return rt;
    }
    
    public void close(PreparedStatement ps){
        try {
            ps.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(ResultSet rs){
        try {
           rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(Connection c){
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

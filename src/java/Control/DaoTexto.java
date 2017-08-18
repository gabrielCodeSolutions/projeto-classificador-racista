/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.MysqlCon;
import Model.Texto;
import java.io.IOException;
import java.sql.PreparedStatement;


/**
 *
 * @author xino
 */
public class DaoTexto 
{ 

    public ArrayList<Texto> ListarTodos() throws SQLException, IOException
    { 
        
        Connection con = new MysqlCon().getConnection();
        Statement stm = null;
        String sql = "SELECT id_texto, texto, teor_racista\n"
                + " from textos "
                + " where teor_racista is null"
                + " order by rand() limit 1"; 
                       
                     
                
        ArrayList<Texto> lista = new ArrayList<>();
        try
        {
            
            stm = con.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next())
            {
                Texto t = new Texto();
                t.setId(res.getInt("id_texto"));
                t.setTexto((res.getString("texto")));
                lista.add(t);
               
                                        
                                       
            }
            return lista;
        }
        catch (SQLException e)
                {
                    e.getMessage();
                }
        finally
        {
            if (stm != null) stm.close();
        }
                    
      return lista; 
    }
    
    public void Classificar(int id_texto, String teor_racista, String emite_opiniao, int id_usuario) throws SQLException
    {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst =  con.prepareStatement("UPDATE textos "
                + "set teor_racista = ?, "
                + "emite_opiniao = ?, "
                + "id_usuario = ?, "
                + "data_validacao = NOW() "
                + "where id_texto = ?");
                
                                                                                  
                pst.setString(1, teor_racista);
                pst.setString(2, emite_opiniao);
                pst.setInt(3, id_usuario);
                pst.setInt(4, id_texto);

        pst.executeUpdate();
        
        
        pst.clearParameters();
        
        pst = con.prepareStatement("Update Usuarios set qtd_validacoes = qtd_validacoes + 1 where id = ?");
        pst.setInt(1, id_usuario);
        pst.executeUpdate();
        pst.clearParameters();
    }
    public String getStatus() throws SQLException
    {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst =  con.prepareStatement("select (select count(id_texto) from textos where emite_opiniao is not null) , (select count(id_texto) from textos);");
        ResultSet res = pst.executeQuery();
        
        while(res.next())
        {
            return res.getString(1)+" / "+res.getString(2);
        }
        return "nada a retornar";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.MysqlCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Usuario;


/**
 *
 * @author edson
 */
public class DaoUsuario {

    public ArrayList<Usuario> ListarTodos() throws SQLException {
        Connection con = new MysqlCon().getConnection();
        Statement stm = null;
        String sql = "Select * from usuarios order by qtd_validacoes desc";
        ArrayList<Usuario> lista = new ArrayList<>();
        try {

            stm = con.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) 
            {
                Usuario u = new Usuario();
                u.setId(res.getInt("id"));
                u.setLogin(res.getString("login"));   
                u.setQtd_validacoes(res.getInt("qtd_validacoes"));  
                lista.add(u);
                
            }
            return lista;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (stm != null) {
                stm.close();
            }
        }

        return lista;
    }

    public int Cadastrar(String login, String senha) throws SQLException {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (login, senha)"
                + "VALUES(?,md5(?))", Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, login);
        pst.setString(2, senha);
        
        pst.executeUpdate();
        int id = -1;
        ResultSet res = pst.getGeneratedKeys();
        if (res.next()) {
            id = res.getInt(1);
        }
        return id;
    }
    
   public int Logar(String login, String senha) throws SQLException
   {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE LOGIN =? AND SENHA = md5(?) ");
        pst.setString(1, login);
        pst.setString(2, senha);
        ResultSet res = pst.executeQuery();
        
        while(res.next())
        {
        if (res.getInt("id") > 0) 
        {
            return res.getInt("id");
        }
        }
        return -1;
   }

//    public int Atualizar(int id, String login, String senha, String email, String tipo) throws SQLException {
//        Connection con = new ConnectFactory().getConnection();
//        PreparedStatement pst = con.prepareStatement("UPDATE usuarios "
//                + "SET login = ? , senha= ? , email = ? , tipo= ?  "
//                + "WHERE id_usuario = ?");
//        pst.setString(1, login);
//        pst.setString(2, senha);
//        pst.setString(3, email);
//        pst.setString(4, tipo);
//        pst.setInt(5, id);
//        int linhasAfetadas = pst.executeUpdate();
//        pst.clearParameters();
//        con.close();
//        return linhasAfetadas;
//
//    }

    public Usuario Selecionar(int id) throws SQLException {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios where ID = ? ");

        pst.setInt(1, id);

        ResultSet res = pst.executeQuery();
        while (res.next()) {
            Usuario u = new Usuario();
                u.setId(res.getInt("id_usuario"));
                u.setLogin(res.getString("login"));   
                u.setQtd_validacoes(res.getInt("qtd_validacoes"));  
                return u;
        }
        return null;

    }
    
    
    public String GetNome(int id) throws SQLException
    {
        Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT login from usuarios where ID = ? ");

        pst.setInt(1, id);

        ResultSet res = pst.executeQuery();
        while (res.next()) {
           return res.getString("login");
        }
        return "Inexistente";
    }

    public int Deletar(int id) throws SQLException {
         Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("DELETE FROM usuarios WHERE ID = ?");

        pst.setInt(1, id);
        int linhasAfetadas = pst.executeUpdate();
        pst.clearParameters();

        return linhasAfetadas;

    }

    public boolean LoginJaExiste(String login) throws SQLException {
         Connection con = new MysqlCon().getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT login from usuarios where login = ? ");
        pst.setString(1, login);

        ResultSet res = pst.executeQuery();
        while (res.next()) {
            if (login.toUpperCase().equals(res.getString(login))) {
                return true;
            }

        }
        return false;
    }
    
    

}

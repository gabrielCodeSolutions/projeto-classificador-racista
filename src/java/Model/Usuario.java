/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author edson
 */
public class Usuario 
{
    
    int id;
    String login;
    String senha;
    int qtd_validacoes;
   
    

 
    @Override
    public String toString()
            {
                return "\nid: "+id+
                        "\nlogin: "+login+
                        "\nsenha: "+senha+
                        "\nqtd_validacoes: "+qtd_validacoes;
                        
            }
 
public Usuario(){}    

    public Usuario(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQtd_validacoes() {
        return qtd_validacoes;
    }

    public void setQtd_validacoes(int qtd_validacoes) {
        this.qtd_validacoes = qtd_validacoes;
    }
    
}


   
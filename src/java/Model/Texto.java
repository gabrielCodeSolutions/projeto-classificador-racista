/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author xino
 */
public class Texto {
    int id;
    String texto;
    String teor_racista;
    String emite_opiniao;
    int id_usuario;
    Date data_validacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTeor_racista() {
        return teor_racista;
    }

    public void setTeor_racista(String teor_racista) {
        this.teor_racista = teor_racista;
    }

    public String getEmite_opiniao() {
        return emite_opiniao;
    }

    public void setEmite_opiniao(String emite_opiniao) {
        this.emite_opiniao = emite_opiniao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getData_validacao() {
        return data_validacao;
    }

    public void setData_validacao(Date data_validacao) {
        this.data_validacao = data_validacao;
    }

}
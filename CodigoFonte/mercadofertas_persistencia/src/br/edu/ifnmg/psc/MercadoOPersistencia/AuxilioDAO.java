/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;

import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Auxilio;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.AuxilioRepositorio;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wesley
 */
public class AuxilioDAO extends DAOGenerico<Auxilio> implements AuxilioRepositorio{

    @Override
    protected String consultaAbrir() {
         return "select * from Auxilio where id = ?";
    }

    @Override
    protected String consultaInsert() {
       return "insert into Auxilio (nome, edital, qtd, descricao) values(?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
      return "update Auxilio nome=?, edital=?, qtd=?, descricao=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
      return "delete from Auxilio where id = ?";
    }

    @Override
    protected String consultaBuscar() {
       return "select * from Axilio "; 
    }

    @Override
    protected void carregaParametros(Auxilio obj, PreparedStatement consulta) {
        try {
          consulta.setString(1, obj.getNome());
          consulta.setString(2, obj.getEdital());
          consulta.setInt(3, obj.getQtd());
          consulta.setString(4, obj.getDescricao());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Auxilio obj) {
            String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());     
        
        return sql;
    }

    @Override
    protected Auxilio carregaObjeto(ResultSet dados) {
           Auxilio obj = new Auxilio();
        try {
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setEdital(dados.getString(3));
            obj.setQtd(dados.getInt(4));
            obj.setDescricao(dados.getString(5));
            
            return obj;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    }
    
}

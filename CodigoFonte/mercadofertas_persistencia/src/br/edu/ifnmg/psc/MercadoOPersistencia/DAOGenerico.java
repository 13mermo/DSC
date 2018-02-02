/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;

import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Entidade;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Repositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wesley
 */
public abstract class DAOGenerico<T extends Entidade > implements Repositorio<T>{

    protected abstract String consultaAbrir();
    protected abstract String consultaInsert();
    protected abstract String consultaUpdate();
    protected abstract String consultaDelete();
    protected abstract String consultaBuscar();
    
    protected abstract void carregaParametros(T obj, PreparedStatement consulta);
    protected abstract String carregaParametrosBusca(T obj);
    protected abstract T carregaObjeto(ResultSet dados);
    
    @Override
    public boolean Salvar(T obj) {
        try {
            String sql = "";
            
            // Verifica se o objeto jÃ¡ foi salvo no BD
            if(obj.getId() == 0) {
                
                //Se o id == 0 entÃ£o pega a consulta de inserÃ§Ã£o
                sql = this.consultaInsert();
                
            } else {
                
                //Se o id > 0 entÃ£o pega a consulta de atualizaÃ§Ã£o
                sql = this.consultaUpdate();
            }
            
            // Utilizando a conexÃ£o existente cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            
            // Carrega os parÃ¢metros da consulta
            this.carregaParametros(obj, consulta);
            
            // Executa a consulta
            boolean resultado = consulta.executeUpdate() > 0;
            
            // Se a consulta obteve Ãªxito e o objeto acabou de ser inserido
            // if(resultado && obj.getId() == 0){
                
            //} else 
            return resultado;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public T Abrir(long id) {
        try {
            // Pega a consulta para abrir (select)
            String sql = this.consultaAbrir();
            
            // Utilizando a conexÃ£o aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            
            // Coloca o parÃ¢metro da consulta (id)
            consulta.setLong(1, id);
            
            // Executa a consulta select e recebe os dados de retorno
            ResultSet dados = consulta.executeQuery();
            
            // Se houverem registros
            if(dados.next())
                return this.carregaObjeto(dados); // Carrega o objeto com os dados retornados
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean Apagar(T obj) {
        try {
            // Pega a consulta para abrir (select)
            String sql = this.consultaDelete();
            
            // Utilizando a conexÃ£o aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
            
            // Coloca o parÃ¢metro da consulta (id)
            consulta.setLong(1, obj.getId());
            
            // Executa a consulta
            return consulta.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    protected String filtrarPor(String sql, String campo, String valor){
        if(valor != null && valor.length() > 0){

            if(sql.length() > 0)
                sql = sql + " and ";
            
            sql = sql + campo + " = '" + valor + "'";
        }
        return sql;       
        
    }

    @Override
    public List<T> Buscar(T filtro) {
        // Cria a lista que conterÃ¡ o resultado da busca
        List<T> resultado = new ArrayList<>();
        
        try {
            
            // Pega a consulta select da busca
            String sql = this.consultaBuscar();
            
            
            // Acrescenta os filtros where da busca
            String where = "";
            if(filtro != null)
                where = this.carregaParametrosBusca(filtro);
            
            if(!where.isEmpty())
                sql += " where " + where;
            
            // Utilizando a conexÃ£o aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(sql);    
            
            // Executa a consulta select e recebe os dados de retorno
            ResultSet dados = consulta.executeQuery();
            
            // Enquanto houverem registros
            while(dados.next()){
                
                // Converte os dados dos registros em objetos
                T obj = this.carregaObjeto(dados);
                
                // Adiciona o objeto na lista de retorno
                resultado.add(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
}

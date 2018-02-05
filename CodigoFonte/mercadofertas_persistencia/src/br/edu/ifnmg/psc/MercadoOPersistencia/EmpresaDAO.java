/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;

import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Empresa;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.EmpresaRepositorio;
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
public class EmpresaDAO extends DAOGenerico<Empresa> implements EmpresaRepositorio {

    @Override
    protected String consultaAbrir() {
         return "select * from Empresa where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into Empresa (nome, telefone, cep, bairro, rua, numero, cnpj) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Empresa nome=?, telefone=?, cep=?, bairro=?, rua=?, numero=?, cnpj=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
          return "delete from Empresa where id = ?";
    }

    @Override
    protected String consultaBuscar() {
         return "select * from Pessoa "; 
    }

    @Override
    protected void carregaParametros(Empresa obj, PreparedStatement consulta) {
       try {
          consulta.setString(1, obj.getNome());
          consulta.setInt(2, obj.getTelefone());
          consulta.setString(3, obj.getCnpj());
          consulta.setString(4, obj.getBairro());
          consulta.setString(5, obj.getRua());
          consulta.setInt(6, obj.getNumero());
          consulta.setString(7, obj.getCnpj());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String carregaParametrosBusca(Empresa obj) {
           String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCnpj() != null && !obj.getCnpj().isEmpty())
            sql = this.filtrarPor(sql, "cnpj", obj.getCnpj());        
        
        return sql;
    }

    @Override
    protected Empresa carregaObjeto(ResultSet dados) {
         Empresa obj = new Empresa();
        try {
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setTelefone(dados.getInt(3));
            obj.setCep(dados.getString(4));
            obj.setBairro(dados.getString(5));
            obj.setRua(dados.getString(6));
            obj.setNumero(dados.getInt(7));
            obj.setCnpj(dados.getString(8));
            return obj;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

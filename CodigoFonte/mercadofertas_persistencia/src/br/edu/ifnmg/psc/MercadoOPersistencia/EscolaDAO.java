/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;


import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Escola;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.EscolaRepositorio;
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
public class EscolaDAO extends DAOGenerico<Escola> implements EscolaRepositorio {

    @Override
    protected String consultaAbrir() {
         return "select * from Escola where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into Escola (nome, telefone, cep, bairro, rua, numero, cnpj) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Escola nome=?, telefone=?, cep=?, bairro=?, rua=?, numero=?, cnpj=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
          return "delete from Escola where id = ?";
    }

    @Override
    protected String consultaBuscar() {
         return "select * from Escola "; 
    }
@Override
    protected String carregaParametrosBusca(Escola obj) {
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
    protected void carregaParametros(Escola obj, PreparedStatement consulta) {
       try {
          consulta.setString(1, obj.getNome());
          consulta.setString(2, obj.getTelefone());
          consulta.setString(3, obj.getCep());
          consulta.setString(4, obj.getBairro());
          consulta.setString(5, obj.getRua());
          consulta.setString(6, obj.getNumero());
          consulta.setString(7, obj.getCnpj());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @Override
    protected Escola carregaObjeto(ResultSet dados) {
       Escola obj = new Escola();
        try {
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setTelefone(dados.getString(3));
            obj.setCep(dados.getString(4));
            obj.setBairro(dados.getString(5));
            obj.setRua(dados.getString(6));
            obj.setNumero(dados.getString(7));
            obj.setCnpj(dados.getString(8));
            return obj;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}

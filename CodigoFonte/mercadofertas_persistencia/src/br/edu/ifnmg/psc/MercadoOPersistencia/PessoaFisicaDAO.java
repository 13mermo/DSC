/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;



import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Pessoa;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.PessoaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class PessoaFisicaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    
    
    
    @Override
    protected String consultaAbrir() {
        return "select * from clientes where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into clientes (nome, cpf, rg, nascimento, sexo, email, endereco_fk, telefone, limite) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update clientes nome=?, cpf=?, rg=?, nascimento=?, sexo=?, email=?, endereco_fk=?, telefone=?, limite=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from clientes "; 
    }
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    protected String carregaParametrosBusca(Pessoa obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    
    @Override
    protected void carregaParametros(Pessoa obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getNome());
             consulta.setInt(2, obj.getTelefone());
          consulta.setString(3, obj.getCep());
          consulta.setString(4, obj.getBairro());
          consulta.setString(5, obj.getRua());
          consulta.setInt(6, obj.getNumero());
         consulta.setString(7, obj.getCpf().replace(".", "").replace("-", ""));
          consulta.setString(8, obj.getNacionalidade());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
    }

   
    @Override
    protected Pessoa carregaObjeto(ResultSet dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}

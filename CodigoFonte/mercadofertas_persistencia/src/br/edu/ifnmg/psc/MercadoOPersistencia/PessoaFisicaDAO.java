/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOPersistencia;



import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Pessoa;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.PessoaRepositorio;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesley
 */
public class PessoaFisicaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    
    
    
    @Override
    protected String consultaAbrir() {
        return "select * from Pessoa where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into Pessoa (nome, telefone, cep, bairro, rua, numero, cpf, nacionalidade) values(?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Pessoa nome=?, telefone=?, cep=?, bairro=?, rua=?, numero=?, cpf=?, nacionalidade=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from Pessoa where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from Pessoa "; 
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
          consulta.setString(2, obj.getTelefone());
          consulta.setString(3, obj.getCep());
          consulta.setString(4, obj.getBairro());
          consulta.setString(5, obj.getRua());
          consulta.setString(6, obj.getNumero());
          consulta.setString(7, obj.getCpf().replace(".", "").replace("-", ""));
          consulta.setString(8, obj.getNacionalidade());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
    }

   
    @Override
    protected Pessoa carregaObjeto(ResultSet dados) {
        Pessoa obj = new Pessoa();
        try {
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setTelefone(dados.getString(3));
            obj.setCep(dados.getString(4));
            obj.setBairro(dados.getString(5));
            obj.setRua(dados.getString(6));
            obj.setNumero(dados.getString(7));
            obj.setCpf(dados.getString(8));
            obj.setNacionalidade(dados.getString(9));
            return obj;
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Aplicacao;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Wesley
 */
public class DadosGenericos implements Entidade{
 protected long id;
 protected String nome;
 protected int telefone;
 protected String cep;
 protected String bairro;
 protected String rua;
 protected int numero;
 
 public DadosGenericos(){
 }

    public DadosGenericos(long id, String nome, int telefone, String cep, String bairro, String rua, int numero) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

  

 @Override
    public long getId() {
        return id;
    }

 @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ViolacaoRegraNegocioException {
        if(nome == null || nome.isEmpty() || nome.length() < 3 || nome.length() > 200)
            throw new ViolacaoRegraNegocioException("O nome deve conter entre 3 e 200 caracteres!");
        this.nome = nome;
    }

 

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep)throws ViolacaoRegraNegocioException {
        if(cep == null || cep.isEmpty() || cep.length() < 3 || cep.length() > 200)
            throw new ViolacaoRegraNegocioException("O Cep deve ser preenchido"); 
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro)throws ViolacaoRegraNegocioException {
        if(bairro == null || bairro.isEmpty() || bairro.length() < 3 || bairro.length() > 200)
            throw new ViolacaoRegraNegocioException("O bairro deve conter entre 3 e 200 caracteres!"); 
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua)throws ViolacaoRegraNegocioException {
        if(rua == null || rua.isEmpty() || rua.length() < 3 || rua.length() > 200)
            throw new ViolacaoRegraNegocioException("A rua deve conter entre 3 e 200 caracteres!"); 
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + this.telefone;
        hash = 59 * hash + Objects.hashCode(this.cep);
        hash = 59 * hash + Objects.hashCode(this.bairro);
        hash = 59 * hash + Objects.hashCode(this.rua);
        hash = 59 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DadosGenericos other = (DadosGenericos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        return true;
    }

    public Object getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}

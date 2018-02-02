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
public class Pessoa extends Cliente implements Entidade{
    
    private int idade;
    private String cpf;
    private String nacionalidade;
    private static Pattern regex_cpf = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
    Curriculo curriculo;

    public Pessoa(int idade, String cpf, String nacionalidade, Curriculo curriculo) {
        this.idade = idade;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.curriculo = curriculo;
    }

    public Pessoa() {
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade)throws ViolacaoRegraDeNegocio {
        if(idade == 0 || idade < 5)
            throw new ViolacaoRegraDeNegocio("A idade nao pode ser 0 ou menor que 16 anos !");
        this.idade = idade;
    }
      public String getCpf() {
        if(cpf != null)
            return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
        return cpf;
    }

    public void setCpf(String cpf) throws ViolacaoRegraDeNegocio {
        Matcher verificador = regex_cpf.matcher(cpf);
        if(cpf == null || cpf.isEmpty() || ! verificador.matches())
            throw new ViolacaoRegraDeNegocio("O CPF deve estar no formato ###.###.###-##!");
        this.cpf = cpf.replace(".", "").replace("-", "");
    }  

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) throws ViolacaoRegraDeNegocio {
        if(nacionalidade == null || nacionalidade.isEmpty() || nacionalidade.length() < 3 || nacionalidade.length() > 200)
            throw new ViolacaoRegraDeNegocio("A nacionalidade deve conter entre 3 e 200 caracteres!");
        this.nacionalidade = nacionalidade;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idade;
        hash = 29 * hash + Objects.hashCode(this.cpf);
        hash = 29 * hash + Objects.hashCode(this.nacionalidade);
        hash = 29 * hash + Objects.hashCode(this.curriculo);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.curriculo, other.curriculo)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return nome;
    }
  
}

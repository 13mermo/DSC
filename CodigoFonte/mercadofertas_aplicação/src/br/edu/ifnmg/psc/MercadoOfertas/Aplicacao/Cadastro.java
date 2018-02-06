/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Aplicacao;
import java.util.Objects;
/**
 *
 * @author Wesley
 */
public abstract class Cadastro {
   protected long id;
   protected String nome;
   protected String edital;
   protected String qtd;
   protected String descricao;
   
    public Cadastro(){
    }
    public Cadastro(long id, String nome, String edital, String qtd, String descricao) {
        this.id = id;
        this.nome = nome;
        this.edital = edital;
        this.qtd = qtd;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

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

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital)  throws ViolacaoRegraNegocioException {
        if(edital == null || edital.isEmpty() || edital.length() < 5 || edital.length() > 20000)
            throw new ViolacaoRegraNegocioException("O edital deve conter entre 50 e 20000 caracteres!");
        this.edital = edital;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) throws ViolacaoRegraNegocioException {
        if(qtd == null )
            throw new ViolacaoRegraNegocioException("Quantidade nao deve ser vazio!");
        this.qtd = qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao)throws ViolacaoRegraNegocioException {
        if(descricao == null || descricao.isEmpty() || descricao.length() < 5 || descricao.length() > 200)
            throw new ViolacaoRegraNegocioException("Descrição nao pode conter menos de 5 caracteres ou mais que 200!");
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.edital);
        hash = 43 * hash + Objects.hashCode(this.qtd);
        hash = 43 * hash + Objects.hashCode(this.descricao);
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
        final Cadastro other = (Cadastro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.edital, other.edital)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
   
   
}

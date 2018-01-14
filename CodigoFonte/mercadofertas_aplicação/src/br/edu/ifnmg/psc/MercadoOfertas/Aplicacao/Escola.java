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
public class Escola extends Cliente{
    private String cnpj;
    private OfertaEmprego ofertaemprego;
    private Concurso concurso;
    private Estagio estagio;

    public Escola(String cnpj, OfertaEmprego ofertaemprego, Concurso concurso, Estagio estagio) {
        this.cnpj = cnpj;
        this.ofertaemprego = ofertaemprego;
        this.concurso = concurso;
        this.estagio = estagio;
    }

    public Escola() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public OfertaEmprego getOfertaemprego() {
        return ofertaemprego;
    }

    public void setOfertaemprego(OfertaEmprego ofertaemprego) {
        this.ofertaemprego = ofertaemprego;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.cnpj);
        hash = 13 * hash + Objects.hashCode(this.ofertaemprego);
        hash = 13 * hash + Objects.hashCode(this.concurso);
        hash = 13 * hash + Objects.hashCode(this.estagio);
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
        final Escola other = (Escola) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.ofertaemprego, other.ofertaemprego)) {
            return false;
        }
        if (!Objects.equals(this.concurso, other.concurso)) {
            return false;
        }
        if (!Objects.equals(this.estagio, other.estagio)) {
            return false;
        }
        return true;
    }
     @Override
    public String toString() {
        return nome;
    }
    
    
}

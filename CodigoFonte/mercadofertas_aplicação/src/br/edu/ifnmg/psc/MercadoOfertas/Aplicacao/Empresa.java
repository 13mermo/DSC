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
public class Empresa extends Cliente{
    private String cnpj;
    private OfertaEmprego ofertaemprego;
    private Concurso concurso;
    private Estagio estagio;

    public Empresa(String cnpj, OfertaEmprego ofertaemprego, Concurso concurso, Estagio estagio) {
        this.cnpj = cnpj;
        this.ofertaemprego = ofertaemprego;
        this.concurso = concurso;
        this.estagio = estagio;
    }

    public Empresa() {
    }
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setOfertaemprego(OfertaEmprego ofertaemprego) {
        this.ofertaemprego = ofertaemprego;
    }


    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }


    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.cnpj);
        hash = 67 * hash + Objects.hashCode(this.ofertaemprego);
        hash = 67 * hash + Objects.hashCode(this.concurso);
        hash = 67 * hash + Objects.hashCode(this.estagio);
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
        final Empresa other = (Empresa) obj;
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

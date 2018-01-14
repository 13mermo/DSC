/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Aplicacao;

/**
 *
 * @author Wesley
 */
public class ViolacaoRegraDeNegocio extends Exception{
    
     public ViolacaoRegraDeNegocio(String message) {
        super(message);
    }
}

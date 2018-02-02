/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Aplicacao;

/**
 *
 * @author Aluno
 */
import java.util.*;
public class Test {
    public static void main (String[] args) throws ViolacaoRegraDeNegocio {
     
    Curriculo curriculo = new Curriculo();
    curriculo.setId(1);
    curriculo.setDescricao("Quero imprego");
    
    Pessoa pessoa = new Pessoa();
    
    pessoa.setId(1);
    pessoa.setNome("wesley");
    pessoa.setIdade(5);
    pessoa.setTelefone(992061600);
    pessoa.setCep("39480-000");
    pessoa.setBairro("jussara");
    pessoa.setRua("rua 7");
    pessoa.setNumero(546);
    pessoa.setCpf("999.999.999-50");
    pessoa.setNacionalidade("brasil");
    pessoa.setCurriculo(curriculo);
    
    System.out.printf("Nome:%s\n",pessoa.getNome());
    System.out.printf("Idade:%d\n",pessoa.getIdade());
    System.out.printf("Telefone: %d\n",pessoa.getTelefone());
    System.out.printf("Cep: %s\n",pessoa.getCep(),"\n");
    System.out.printf("Bairro: %s\n",pessoa.getBairro(),"\n");
    System.out.printf("Rua:%s \n",pessoa.getRua(),"\n");
    System.out.printf("Numero:%d \n",pessoa.getNumero());
    System.out.printf("Cpf: %s\n",pessoa.getCpf(),"\n");
    System.out.printf("Nacionalidade:%s \n",pessoa.getNacionalidade(),"\n");
    System.out.printf("Curriculo: %s\n",pessoa.curriculo.toString(),"\n");
    }
 
   
}

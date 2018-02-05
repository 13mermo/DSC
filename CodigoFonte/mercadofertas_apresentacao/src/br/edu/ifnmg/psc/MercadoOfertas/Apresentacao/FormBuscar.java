/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Apresentacao;


import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Entidade;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Repositorio;
import java.util.List;

/**
 *
 * @author petronio
 */
public abstract class FormBuscar<T extends Entidade> extends javax.swing.JInternalFrame {
    
    private T filtro;
    private FormEditar editar;
    private Repositorio<T> repositorio;

    public T getFiltro() {
        return filtro;
    }

    public void setFiltro(T filtro) {
        this.filtro = filtro;
    }

    public FormEditar getEditar() {
        return editar;
    }

    public void setEditar(FormEditar editar) {
        this.editar = editar;
    }
    
    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    protected abstract void preencherTabela(List<T> dados);
    protected abstract T carregaFiltro();
    protected abstract T novaEntidade();
    
    protected void novo() {
        editar.setEntidade(novaEntidade());
        editar.setBuscar(this);
        
        this.getParent().add(editar);
        editar.setVisible(true);
        this.setVisible(false);
    }
    
    protected void buscar() {
        filtro = carregaFiltro();

        List<T> resultado = getRepositorio().Buscar(filtro);

        preencherTabela(resultado);
            
    }
    
    protected void editar(long id) {
        T obj = getRepositorio().Abrir(id);
        
        this.getParent().add(editar);
        editar.setVisible(true);
        this.setVisible(false);
        
        editar.setEntidade(obj);
        
        editar.setBuscar(this);
    }
    
}

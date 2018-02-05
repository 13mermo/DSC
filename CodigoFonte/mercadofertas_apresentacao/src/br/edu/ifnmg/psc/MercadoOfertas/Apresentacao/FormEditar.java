/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.MercadoOfertas.Apresentacao;


import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Entidade;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.Repositorio;
import br.edu.ifnmg.psc.MercadoOfertas.Aplicacao.ViolacaoRegraNegocioException;
import javax.swing.JOptionPane;

/**
 *
 * @author petronio
 */
public abstract class FormEditar<T extends Entidade> extends javax.swing.JInternalFrame{
    
    private FormBuscar buscar;
    
    protected T entidade;
    
    private Repositorio<T> repositorio;

    public FormBuscar getBuscar() {
        return buscar;
    }

    public void setBuscar(FormBuscar buscar) {
        this.buscar = buscar;
    }

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
        
        carregaCampos();
    }

    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    protected abstract void carregaObjeto() throws ViolacaoRegraNegocioException;
    
    protected abstract void carregaCampos();
    
    protected void cancelar(){
        this.getBuscar().setVisible(true);
        this.setVisible(false);
    }
    
    protected void salvar() {
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente salvar os dados?","Confirmação",
                JOptionPane.YES_NO_OPTION) == 0) {
            
            try {
                carregaObjeto();
                
                if(getRepositorio().Salvar(entidade))            
                    JOptionPane.showMessageDialog(rootPane, "Dados salvos com sucesso!");
                else
                    JOptionPane.showMessageDialog(rootPane, "Falha ao salvar!");
            } catch (ViolacaoRegraNegocioException ex) {
                
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                
            }
        }
    }
    
    protected void apagar() {                                          
        if(entidade.getId() == 0){
            JOptionPane.showMessageDialog(rootPane, "Os dados ainda não estão salvos");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente salvar os dados?","Confirmação",
                JOptionPane.YES_NO_OPTION) == 0) {
            
            if(getRepositorio().Apagar(entidade))  {          
                JOptionPane.showMessageDialog(rootPane, "Dados removidos com sucesso!");
                this.setVisible(false);
                this.getBuscar().setVisible(true);
            } else
                JOptionPane.showMessageDialog(rootPane, "Falha ao apagar os dados!");

        } 
    }    
}

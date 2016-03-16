/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Contato;

/**
 * @author alan_curtindoafesta
 *
 */
public interface ContatoFacade {

	public void inserir(Contato contato);
	
	public void remover(Contato contato);
	
	public List<Contato> listar();

	public Contato buscar(Contato contato);
}

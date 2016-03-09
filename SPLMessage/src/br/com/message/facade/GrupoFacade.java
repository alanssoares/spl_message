/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public interface GrupoFacade {

	public void inserir(Grupo grupo);
	
	public Grupo buscar(Grupo grupo);
	
	public void remover(Grupo grupo);
	
	public List<Grupo> listar();
}

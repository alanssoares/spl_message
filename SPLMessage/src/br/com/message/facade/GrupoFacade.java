//#if ${Grupo} == "T"
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
	
	/**
	 * Método responsável por inserir um novo grupo
	 * @param grupo
	 * @return
	 */
	public Grupo inserir(Grupo grupo);
	
	/**
	 * Método responsável por remover um grupo
	 * @param grupo
	 */
	public void remover(Grupo grupo);
	
	/**
	 * Método responsável por buscar um grupo
	 * @param grupo
	 * @return
	 */
	public Grupo buscar(Grupo grupo);
	
	/**
	 * Método responsável por buscar por descrição
	 * @param descricao
	 * @return
	 */
	public Grupo buscar(String descricao);
	
	/**
	 * Método responsável por listar todos os grupos
	 * @return
	 */
	public List<Grupo> listar();
}
//#endif
//#if ${Grupo} == "T"
/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public interface GrupoDao {

	/**
	 * Método responsável por inserir um novo grupo
	 * @param grupo
	 * @return
	 */
	Grupo inserir(Grupo grupo);
	
	/**
	 * Método responsável por remover grupo 
	 * @param grupo
	 */
	void remover(Grupo grupo);
	
	/**
	 * Método responsável por buscar um grupo
	 * @param grupo
	 * @return
	 */
	Grupo buscar(Grupo grupo);

	/**
	 * Método responsável por buscar um grupo por descricao
	 * @param grupo
	 * @return
	 */
	Grupo buscar(String descricao);
	
	/**
	 * Método responsável por listar todos os grupos
	 * @param email do usuário
	 * @return List<Grupo>
	 */
	List<Grupo> listar(String email);
}
//#endif
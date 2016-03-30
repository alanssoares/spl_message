/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Contato;

/**
 * @author alsoares
 *
 */
public interface ContatoDao {

	/**
	 * Método responsável por listar os contatos
	 * @param email usado para busca de contatos
	 * @return List<Contato>
	 */
	List<Contato> listar(String email);

	/**
	 * Método responsável por remover um contato
	 * @param contato a ser removido
	 */
	void remover(Contato contato);

	/**
	 * Método responsável por inserir um contato
	 * @param contato a ser inserido
	 */
	void inserir(Contato contato);

	/**
	 * Método responsável por buscar um contato
	 * @param contato a ser buscado
	 * @return Contato
	 */
	Contato buscar(Contato contato);
}

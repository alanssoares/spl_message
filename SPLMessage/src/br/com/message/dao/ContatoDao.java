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

	List<Contato> listar();

	void remover(Contato contato);

	void inserir(Contato contato);

}

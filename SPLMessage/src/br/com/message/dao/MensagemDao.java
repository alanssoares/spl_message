/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.Mensagem;

/**
 * @author alsoares
 *
 */
public interface MensagemDao {

	/**
	 * Método responsável por inserir nova mensagem
	 * @param mensagem
	 */
	void inserir(Mensagem mensagem);

	/**
	 * Método responsável por remover uma mensagem
	 * @param mensagem
	 */
	void removeMensagem(Mensagem mensagem);

	/**
	 * Método responsável por buscar uma mensagem
	 * @param mensagem
	 * @return
	 */
	Mensagem buscar(Mensagem mensagem);

	/**
	 * Método responsável por listar todos as mensagens do contato
	 * @param contato
	 * @return
	 */
	List<Mensagem> listar(Contato contato);
}

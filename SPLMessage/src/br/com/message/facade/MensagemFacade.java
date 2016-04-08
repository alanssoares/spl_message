/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.Mensagem;

/**
 * @author alsoares
 *
 */
public interface MensagemFacade {

	/**
	 * Método responsável por inserir uma nova mensagem
	 * @param mensagem
	 */
	public void inserir(Mensagem mensagem);
	
	/**
	 * Método responsável por limptar o histórico de mensagens do contato
	 * @param contato
	 */
	public void limparHistorico(Contato contato);
	
	/**
	 * Método responsável por buscar uma nova mensagem
	 * @param mensagem
	 * @return
	 */
	public Mensagem buscar(Mensagem mensagem);
	
	/**
	 * Método responsável por listar todas as mensagens do contato
	 * @param contato
	 * @return
	 */
	public List<Mensagem> listar(Contato contato);
}

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

	void inserir(Mensagem mensagem);

	void limparHistorico(Contato contato);

	Mensagem buscar(Mensagem mensagem);

	List<Mensagem> listar(Contato contato);

}

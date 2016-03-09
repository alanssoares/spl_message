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

	public void inserir(Mensagem mensagem);
	
	public void limparHistorico(Contato contato);
	
	public Mensagem buscar(Mensagem mensagem);
	
	public List<Mensagem> listar(Contato contato);
}

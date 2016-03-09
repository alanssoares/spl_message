/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.MensagemDao;
import br.com.message.dao.MensagemDaoImpl;
import br.com.message.model.Contato;
import br.com.message.model.Mensagem;

/**
 * @author alsoares
 *
 */
public class MensagemFacadeImpl implements MensagemFacade {

	private MensagemDao mensagemDao = new MensagemDaoImpl();

	@Override
	public void inserir(Mensagem mensagem) {
		this.mensagemDao.inserir(mensagem);
	}

	@Override
	public void limparHistorico(Contato contato) {
		this.mensagemDao.limparHistorico(contato);
	}

	@Override
	public Mensagem buscar(Mensagem mensagem) {
		return this.mensagemDao.buscar(mensagem);
	}

	@Override
	public List<Mensagem> listar(Contato contato) {
		return this.mensagemDao.listar(contato);
	}
}

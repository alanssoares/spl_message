/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.ContatoDao;
import br.com.message.dao.ContatoDaoImpl;
import br.com.message.model.Contato;

/**
 * @author alsoares
 *
 */
public class ContatoFacadeImpl implements ContatoFacade {

	private ContatoDao contatoDao = new ContatoDaoImpl();

	@Override
	public void inserir(Contato contato) {
		this.contatoDao.inserir(contato);
	}

	@Override
	public void remover(Contato contato) {
		this.contatoDao.remover(contato);
	}

	@Override
	public List<Contato> listar() {
		return this.contatoDao.listar();
	}
}

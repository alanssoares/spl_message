/**
 * 
 */
package br.com.message.facade;

import java.util.Date;
import java.util.List;

import br.com.message.dao.ContatoDao;
import br.com.message.dao.ContatoDaoImpl;
import br.com.message.model.Contato;

/**
 * @author alsoares
 *
 */
public class ContatoFacadeImpl implements ContatoFacade {

	private static final Integer ID_GRUPO_DEFAULT = 0;
	
	private ContatoDao contatoDao = new ContatoDaoImpl();

	@Override
	public void inserir(Contato contato) {
		contato.setIdGrupo(ID_GRUPO_DEFAULT);
		contato.setDataInclusao(new Date());
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

	@Override
	public Contato buscar(Contato contato) {
		return this.contatoDao.buscar(contato);
	}
}

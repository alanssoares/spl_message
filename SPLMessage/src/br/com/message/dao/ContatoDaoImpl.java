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
public class ContatoDaoImpl extends GenericDao<Contato, Integer> implements ContatoDao {

	public ContatoDaoImpl() {
		super(Contato.class);
	}

	@Override
	public List<Contato> listar() {
		return getList();
	}

	@Override
	public void remover(Contato contato) {
		remove(contato.getId());
	}

	@Override
	public void inserir(Contato contato) {
		inserir(contato);
	}
}
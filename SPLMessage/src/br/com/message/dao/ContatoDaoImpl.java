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
@SuppressWarnings("unchecked")
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
		insert(contato);
	}

	@Override
	public Contato buscar(Contato contato) {
		List<Contato> lista = this.entityManager.createQuery(
				"FROM contato c WHERE c.id_contato = :idContato AND c.id_usuario = :idUsuario")
				.setParameter("idContato", contato.getIdContato())
				.setParameter("idUsuario", contato.getIdUsuario())
				.getResultList();
		if(lista.isEmpty()){
			return null;
		}
		return lista.get(0);
	}
}
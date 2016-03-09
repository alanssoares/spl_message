/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public class GrupoDaoImpl extends GenericDao<Grupo, Integer> implements GrupoDao {

	public GrupoDaoImpl() {
		super(Grupo.class);
	}

	@Override
	public void inserir(Grupo grupo) {
		inserir(grupo);
	}

	@Override
	public Grupo buscar(Grupo grupo) {
		return find(grupo.getId());
	}

	@Override
	public void remover(Grupo grupo) {
		remove(grupo.getId());
	}

	@Override
	public List<Grupo> listar() {
		return getList();
	}
}

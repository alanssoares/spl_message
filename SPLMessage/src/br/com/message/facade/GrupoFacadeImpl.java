/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.GrupoDao;
import br.com.message.dao.GrupoDaoImpl;
import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public class GrupoFacadeImpl implements GrupoFacade {

	private GrupoDao grupoDao = new GrupoDaoImpl();

	@Override
	public void inserir(Grupo grupo) {
		this.grupoDao.inserir(grupo);
	}

	@Override
	public Grupo buscar(Grupo grupo) {
		return this.grupoDao.buscar(grupo);
	}

	@Override
	public void remover(Grupo grupo) {
		this.grupoDao.remover(grupo);
	}

	@Override
	public List<Grupo> listar() {
		return this.grupoDao.listar();
	}
}

/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.ComentarioDao;
import br.com.message.dao.ComentarioDaoImpl;
import br.com.message.model.Comentario;

/**
 * @author alan_curtindoafesta
 *
 */
public class ComentarioFacadeImpl implements ComentarioFacade {

	private ComentarioDao comentarioDao = new ComentarioDaoImpl();

	@Override
	public void inserir(Comentario comentario) {
		this.comentarioDao.inserir(comentario);
	}

	@Override
	public List<Comentario> listar() {
		return this.comentarioDao.listar();
	}
	
}

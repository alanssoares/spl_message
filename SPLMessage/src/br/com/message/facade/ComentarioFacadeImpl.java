/**
 * 
 */
package br.com.message.facade;

import java.util.Date;
import java.util.List;

import br.com.message.dao.ComentarioDao;
import br.com.message.dao.ComentarioDaoImpl;
import br.com.message.model.Comentario;
import br.com.message.util.DataStore;

/**
 * @author alan_curtindoafesta
 *
 */
public class ComentarioFacadeImpl implements ComentarioFacade {

	private ComentarioDao comentarioDao = new ComentarioDaoImpl();

	@Override
	public void inserir(Comentario comentario) {
		comentario.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		comentario.setDataInclusao(new Date());
		this.comentarioDao.inserir(comentario);
	}

	@Override
	public List<Comentario> listar() {
		return this.comentarioDao.listar();
	}
	
}

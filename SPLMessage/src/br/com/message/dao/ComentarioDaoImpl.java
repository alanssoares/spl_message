//#if ${EnviaComentario} == "T" or ${ListaComentario} == "T"
/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Comentario;

/**
 * @author alsoares
 *
 */
public class ComentarioDaoImpl extends GenericDao<Comentario, Integer> implements ComentarioDao {

	public ComentarioDaoImpl() {
		super(Comentario.class);
	}

	//#if ${EnviaComentario} == "T"
	@Override
	public void inserir(Comentario comentario) {
		insert(comentario);
	}
	//#endif
	
	//#if ${ListaComentario} == "T"
	@Override
	public List<Comentario> listar() {
		return getList();
	}
	//#endif
}
//#endif
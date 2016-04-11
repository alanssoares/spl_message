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
public interface ComentarioDao {

	//#if ${EnviaComentario} == "T"
	/**
	 * Método responsável por inserir um novo comentário
	 * @param comentario
	 */
	void inserir(Comentario comentario);
	//#endif
	
	//#if ${ListaComentario} == "T"
	/**
	 * Método responsável por listar todos os comentários
	 * @return
	 */
	List<Comentario> listar();
	//#endif
}
//#endif
//#if ${EnviaComentario} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Comentario;

/**
 * @author alan_curtindoafesta
 *
 */
public interface ComentarioFacade {
	
	/**
	 * Insere um novo comentário
	 * @param comentario
	 */
	public void inserir(Comentario comentario);
	
	/**
	 * Lista todos os comentarios
	 * @return List<Comentario>
	 */
	public List<Comentario> listar();
}
//#endif
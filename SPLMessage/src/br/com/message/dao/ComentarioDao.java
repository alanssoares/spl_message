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

	void inserir(Comentario comentario);
	
	List<Comentario> listar();
}

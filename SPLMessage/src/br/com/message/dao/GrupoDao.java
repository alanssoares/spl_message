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
public interface GrupoDao {

	void inserir(Grupo grupo);

	Grupo buscar(Grupo grupo);

	void remover(Grupo grupo);

	List<Grupo> listar();

}

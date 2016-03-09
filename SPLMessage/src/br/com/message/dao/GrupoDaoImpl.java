/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public class GrupoDaoImpl extends GenericDao<Grupo, Integer> implements GrupoDao {

	public GrupoDaoImpl() {
		super(Grupo.class);
	}
}

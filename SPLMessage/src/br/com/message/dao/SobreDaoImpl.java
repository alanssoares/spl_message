/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public class SobreDaoImpl extends GenericDao<Sobre, Integer> implements SobreDao {

	public SobreDaoImpl() {
		super(Sobre.class);
	}
}

/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.PoliticaPrivacidade;

/**
 * @author alsoares
 *
 */
public class PoliticaPrivacidadeDaoImpl extends GenericDao<PoliticaPrivacidade, Integer> implements PoliticaPrivacidadeDao {

	public PoliticaPrivacidadeDaoImpl() {
		super(PoliticaPrivacidade.class);
	}
}
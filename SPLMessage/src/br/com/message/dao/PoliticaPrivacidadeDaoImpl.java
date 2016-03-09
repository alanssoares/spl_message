/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.PoliticaPrivacidade;

/**
 * @author alsoares
 *
 */
public class PoliticaPrivacidadeDaoImpl extends GenericDao<PoliticaPrivacidade, Integer> implements PoliticaPrivacidadeDao {

	public PoliticaPrivacidadeDaoImpl() {
		super(PoliticaPrivacidade.class);
	}

	@Override
	public PoliticaPrivacidade buscar() {
		List<PoliticaPrivacidade> lista = getList();
		if(lista.isEmpty()) return null;
		return lista.get(lista.size() - 1);
	}
}

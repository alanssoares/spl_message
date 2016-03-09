/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public class SobreDaoImpl extends GenericDao<Sobre, Integer> implements SobreDao {

	public SobreDaoImpl() {
		super(Sobre.class);
	}

	@Override
	public Sobre buscar() {
		List<Sobre> lista = getList();
		if(lista.isEmpty()) return null;
		return lista.get(lista.size() - 1);
	}
}

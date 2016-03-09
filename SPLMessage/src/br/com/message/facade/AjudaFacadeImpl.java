/**
 * 
 */
package br.com.message.facade;

import br.com.message.dao.PoliticaPrivacidadeDao;
import br.com.message.dao.PoliticaPrivacidadeDaoImpl;
import br.com.message.dao.SobreDao;
import br.com.message.dao.SobreDaoImpl;
import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public class AjudaFacadeImpl implements AjudaFacade {

	private SobreDao sobreDao = new SobreDaoImpl();
	private PoliticaPrivacidadeDao politicaPrivacidadeDao = new PoliticaPrivacidadeDaoImpl();
	
	@Override
	public Sobre buscarSobre() {
		return this.sobreDao.buscar();
	}
	
	@Override
	public PoliticaPrivacidade buscarPolitica() {
		return this.politicaPrivacidadeDao.buscar();
	}
}

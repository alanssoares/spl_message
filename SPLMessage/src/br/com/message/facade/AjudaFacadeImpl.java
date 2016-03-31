//#if ${Ajuda} == "T" or ${Sobre} == "T" or ${PoliticaPrivacidade} == "T"
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
	
	//#if ${PoliticaPrivacidade} == "T"
	private PoliticaPrivacidadeDao politicaPrivacidadeDao = new PoliticaPrivacidadeDaoImpl();
	//#endif
	
	//#if ${Sobre} == "T"
	private SobreDao sobreDao = new SobreDaoImpl();
	//#endif
	
	//#if ${Sobre} == "T"
	@Override
	public Sobre buscarSobre() {
		return this.sobreDao.buscar();
	}
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	@Override
	public PoliticaPrivacidade buscarPolitica() {
		return this.politicaPrivacidadeDao.buscar();
	}
	//#endif
}
//#endif
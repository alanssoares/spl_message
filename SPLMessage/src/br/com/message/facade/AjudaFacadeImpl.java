/**
 * 
 */
package br.com.message.facade;

import br.com.message.dao.ComentarioDao;
import br.com.message.dao.ComentarioDaoImpl;
import br.com.message.dao.PoliticaPrivacidadeDao;
import br.com.message.dao.PoliticaPrivacidadeDaoImpl;
import br.com.message.dao.SobreDao;
import br.com.message.dao.SobreDaoImpl;

/**
 * @author alsoares
 *
 */
public class AjudaFacadeImpl implements AjudaFacade {

	private SobreDao sobreDao = new SobreDaoImpl();
	private PoliticaPrivacidadeDao politicaPrivacidadeDao = new PoliticaPrivacidadeDaoImpl();
	private ComentarioDao comentarioDao = new ComentarioDaoImpl();
}

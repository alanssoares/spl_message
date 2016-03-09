/**
 * 
 */
package br.com.message.facade;

import br.com.message.dao.GrupoDao;
import br.com.message.dao.GrupoDaoImpl;

/**
 * @author alsoares
 *
 */
public class GrupoFacadeImpl implements GrupoFacade {

	private GrupoDao grupoDao = new GrupoDaoImpl();
}

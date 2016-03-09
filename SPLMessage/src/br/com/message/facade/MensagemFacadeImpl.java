/**
 * 
 */
package br.com.message.facade;

import br.com.message.dao.MensagemDao;
import br.com.message.dao.MensagemDaoImpl;

/**
 * @author alsoares
 *
 */
public class MensagemFacadeImpl implements MensagemFacade {

	private MensagemDao mensagemDao = new MensagemDaoImpl();
}

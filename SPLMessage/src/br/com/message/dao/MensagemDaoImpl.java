/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Mensagem;

/**
 * @author alsoares
 *
 */
public class MensagemDaoImpl extends GenericDao<Mensagem, Integer> implements MensagemDao {

	public MensagemDaoImpl() {
		super(Mensagem.class);
	}
}

/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.Mensagem;

/**
 * @author alsoares
 *
 */
public class MensagemDaoImpl extends GenericDao<Mensagem, Integer> implements MensagemDao {

	public MensagemDaoImpl() {
		super(Mensagem.class);
	}

	@Override
	public void inserir(Mensagem mensagem) {
		inserir(mensagem);
	}

	@Override
	public void limparHistorico(Contato contato) {
		// TODO Auto-generated method stub
	}

	@Override
	public Mensagem buscar(Mensagem mensagem) {
		return find(mensagem.getId());
	}

	@Override
	public List<Mensagem> listar(Contato contato) {
		// TODO Auto-generated method stub
		return null;
	}
}

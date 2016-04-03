/**
 * 
 */
package br.com.message.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.Mensagem;
import br.com.message.model.MensagemPK;

/**
 * @author alsoares
 *
 */
public class MensagemDaoImpl extends GenericDao<Mensagem, MensagemPK> implements MensagemDao {

	public MensagemDaoImpl() {
		super(Mensagem.class);
	}

	@Override
	public void inserir(Mensagem mensagem) {
		insert(mensagem);
	}

	@Override
	public void limparHistorico(Contato contato) {
		// TODO Auto-generated method stub
	}

	@Override
	public Mensagem buscar(Mensagem mensagem) {
		return find(mensagem.getMensagemPK());
	}
	
	@Override
	public List<Mensagem> listar(Contato contato) {
		List<Mensagem> list = getList();
		List<Mensagem> listReturn = new ArrayList<Mensagem>(); 
		for(Mensagem m : list){
			if(m.getEmailContato().equals(contato.getEmailContato())){
				listReturn.add(m);
			}
		}
		return listReturn;
	}
}

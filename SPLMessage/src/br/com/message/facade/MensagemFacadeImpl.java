/**
 * 
 */
package br.com.message.facade;

import java.util.Date;
import java.util.List;

import br.com.message.dao.MensagemDao;
import br.com.message.dao.MensagemDaoImpl;
import br.com.message.model.Contato;
import br.com.message.model.Mensagem;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class MensagemFacadeImpl implements MensagemFacade {

	private MensagemDao mensagemDao = new MensagemDaoImpl();

	@Override
	public void inserir(Mensagem enviada) {
		enviada.setDataInclusao(new Date());
		enviada.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		enviada.setEnviada(Constantes.MSG_ENVIADA);
		enviada.setLida(Constantes.MSG_LIDA);
		this.mensagemDao.inserir(enviada);
		
		Mensagem recebida = new Mensagem();
		recebida.setDescricao(enviada.getDescricao());
		recebida.setEmailUsuario(enviada.getEmailContato());
		recebida.setEmailContato(enviada.getEmailUsuario());
		recebida.setDataInclusao(enviada.getDataInclusao());
		recebida.setEnviada(Constantes.MSG_RECEBIDA);
		recebida.setLida(Constantes.MSG_NAO_LIDA);
		this.mensagemDao.inserir(recebida);
	}

	@Override
	public void limparHistorico(Contato contato) {
		List<Mensagem> mensagens = listar(contato);
		for(Mensagem mensagem : mensagens){
			this.mensagemDao.removeMensagem(mensagem);	
		}
	}

	@Override
	public Mensagem buscar(Mensagem mensagem) {
		return this.mensagemDao.buscar(mensagem);
	}

	@Override
	public List<Mensagem> listar(Contato contato) {
		return this.mensagemDao.listar(contato);
	}
}

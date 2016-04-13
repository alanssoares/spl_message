/**
 * 
 */
package br.com.message.facade;

import java.util.Date;
import java.util.List;

import org.hibernate.cfg.beanvalidation.IntegrationException;

import br.com.message.dao.ContatoDao;
import br.com.message.dao.ContatoDaoImpl;
import br.com.message.model.Contato;
import br.com.message.model.Usuario;
import br.com.message.util.DataStore;
import br.com.message.util.LanguageUtil;

/**
 * @author alsoares
 *
 */
public class ContatoFacadeImpl implements ContatoFacade {

	private static final Integer ID_GRUPO_DEFAULT = 1;
	
	private ContatoDao contatoDao = new ContatoDaoImpl();
	private UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	
	@Override
	public void inserir(Contato contato) {
		Usuario c = usuarioFacade.findByEmail(contato.setEmailContato());
		
		//Valida se é um contato válido
		if(c == null){
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_NOT_FOUND));
		} else if(c.getEmail().equals(DataStore.getInstance().getUsuario().getEmail())){
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_INVALID));
		}
		
		//#if ${Grupo} == "T"
		//#if ${AlterarGrupo} == "T" or ${AdicionarGrupo} == "T"
		if(contato.getIdGrupo() == null){
			contato.setIdGrupo(ID_GRUPO_DEFAULT);
		}
		//#endif
		//#endif
		
		contato.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		if(buscar(contato) != null){
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_REGISTRED));
		}
		
		contato.setDataInclusao(new Date());
		this.contatoDao.inserir(contato);
	}
	
	@Override
	public Usuario remover(Contato contato) {
		Usuario c = usuarioFacade.findByEmail(contato.setEmailContato());
		
		//Valida se é um contato válido
		if(c == null){
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_NOT_FOUND));
		}
		
		if(buscar(contato) != null){
			this.contatoDao.remover(contato);
		} else {
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_NOT_FOUND));
		}
		
		return c;
	}
	
	//#if ${AlterarContato} == "T"
	@Override
	public void update(Contato contato) {
		Contato c = buscar(contato);
		
		//Valida se é um contato válido
		if(c == null){
			throw new IntegrationException(LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CONTACT_NOT_FOUND));
		}
		
		//#if ${Grupo} == "T"
		//#if ${AlterarGrupo} == "T" or ${AdicionarGrupo} == "T"
		if(contato.getIdGrupo() == null){
			c.setIdGrupo(ID_GRUPO_DEFAULT);
		} else {
			c.setIdGrupo(contato.getIdGrupo());
		}
		//#endif
		//#endif
		
		this.contatoDao.alterar(c);
	}
	//#endif
	
	@Override
	public List<Contato> listar(String email) {
		return this.contatoDao.listar(email);
	}

	@Override
	public Contato buscar(Contato contato) {
		return this.contatoDao.buscar(contato);
	}

	@Override
	public List<Contato> listar(String email, String parteEmailContato) {
		return this.contatoDao.listar(email, parteEmailContato);
	}
}
//#if ${Contato} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.com.message.facade.ContatoFacade;
import br.com.message.facade.ContatoFacadeImpl;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Contato;
import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public class FContato {

	private Component parent;
	private ContatoFacade contatoFacade;
	
	public FContato(Component parent) {
		this.parent = parent;
		this.contatoFacade = new ContatoFacadeImpl();
	}

	//#if ${RemoverContato} == "T"
	/**
	 * Método responsável por remover um contato
	 */
	public Usuario removerContato() {
		Usuario c = null;
		Object res = JOptionPane.showInputDialog(this.parent, "Email do Contato", "Remover Contato", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			c = new UsuarioFacadeImpl().findByEmail(res.toString());
			if(c != null ){
				Contato contato = new Contato();
				contato.setEmailContato(c.getEmail());
				contato = contatoFacade.buscar(contato);
				if(contato != null){
					this.contatoFacade.remover(contato);
					JOptionPane.showMessageDialog(this.parent, "Contato removido com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);	
				} else {
					JOptionPane.showMessageDialog(this.parent, "Não foi possível localizar o contato", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this.parent, "Não foi possível localizar o contato", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
		}
		return c;
	}
	//#endif
	
	//#if ${AdicionarContato} == "T"
	/**
	 * Método responsável por adicionar um novo contato
	 * @return Usuario
	 */
	public Usuario adicionarContato() {
		Usuario user = null;
		Object res = JOptionPane.showInputDialog(this.parent, "Email do Contato", "Adicionar Contato", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			user = new UsuarioFacadeImpl().findByEmail(res.toString());
			if(user != null){
				Contato contato = new Contato();
				contato.setEmailContato(user.getEmail());
				this.contatoFacade.inserir(contato);
				JOptionPane.showMessageDialog(this.parent, "Contato adicionado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.parent, "Não foi possível localizar o contato", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
		}
		return user;
	}
	//#endif
	
	//#if ${AlterarContato} == "T"
	/**
	 * Método responsável por alterar os dados de um contato
	 */
	public void alterarContato(){
		
	}
	//#endif
}
//#endif
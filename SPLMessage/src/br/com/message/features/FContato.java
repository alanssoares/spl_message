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
import br.com.message.util.DataStore;

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
	public void removerContato() {
		Object res = JOptionPane.showInputDialog(this.parent, "Email do Contato", "Remover Contato", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			Usuario c = new UsuarioFacadeImpl().findByEmail(res.toString());
			if(c != null ){
				Contato contato = new Contato();
				contato.getChaveComposta().setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
				contato.getChaveComposta().setEmailContato(c.getEmail());
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
	}
	//#endif
	
	//#if ${AdicionarContato} == "T"
	/**
	 * Método responsável por adicionar um novo contato
	 */
	public void adicionarContato() {
		Object res = JOptionPane.showInputDialog(this.parent, "Email do Contato", "Adicionar Contato", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			Usuario user = new UsuarioFacadeImpl().findByEmail(res.toString());
			if(user != null){
				Contato contato = new Contato();
				contato.getChaveComposta().setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
				contato.getChaveComposta().setEmailContato(user.getEmail());
				this.contatoFacade.inserir(contato);
				JOptionPane.showMessageDialog(this.parent, "Contato adicionado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.parent, "Não foi possível localizar o contato", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	//#endif
	
	//#if ${AlterarContato} == "T"
	/**
	 * Método responsável por alterar os dados de um contato
	 */
	public void alterarContato(){
		
	}
	//#endif
	
	//#if ${VisualizarCartaoVisita} == "T"
	public void visualizarCartaoVisita(){
		// TODO Auto-generated method stub
	}
	//#endif
}
//#endif
//#if ${Ajuda} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.com.message.facade.AjudaFacade;
import br.com.message.facade.AjudaFacadeImpl;
import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public class FAjuda {

	private Component parent;
	private AjudaFacade ajudaFacade;
	
	public FAjuda(Component parent) {
		this.parent = parent;
		this.ajudaFacade = new AjudaFacadeImpl();
	}

	//#if ${Sobre} == "T"
	public void sobre() {
		Sobre sobre = ajudaFacade.buscarSobre();
		JOptionPane.showMessageDialog(this.parent, 
			sobre.getDescricao(), 
			"Sobre o SPLMessage",
			JOptionPane.PLAIN_MESSAGE);
	}
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	public void politicaPrivacidade() {
		PoliticaPrivacidade politica = ajudaFacade.buscarPolitica();
		JOptionPane.showMessageDialog(this.parent, 
				politica.getDescricao(), 
				"Política de Privacidade",
				JOptionPane.PLAIN_MESSAGE);
	}
	//#endif
	
	//#if ${EnviaComentario} == "T"
	public void comentario() {
		new FComentario(this.parent);
	}
	//#endif
	
}
//#endif
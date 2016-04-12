//#if ${Ajuda} == "T" and ${PoliticaPrivacidade} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.com.message.facade.AjudaFacade;
import br.com.message.facade.AjudaFacadeImpl;
import br.com.message.model.PoliticaPrivacidade;
import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class FPoliticaPrivacidade extends JFrame {
	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea tPolitica;
	private JButton btnOk;
	private Component parent;
	private AjudaFacade ajudaFacade;
	private PoliticaPrivacidade politica;
	
	public FPoliticaPrivacidade(Component parent) {
		super(Constantes.FEATURE_POLITICA_PRIVACIDADE);
		this.ajudaFacade = new AjudaFacadeImpl();
		this.politica = ajudaFacade.buscarPolitica();
		this.parent = parent;
		
		tPolitica = new JTextArea(this.politica.getDescricao(), 20, 20);
		tPolitica.setEditable(false);
		tPolitica.setLineWrap(true);
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				dispose();
	        }
	    });
	    
		JPanel cp = new JPanel();
		cp.add(tPolitica);
	    getContentPane().add(cp, BorderLayout.CENTER);
		
	    JPanel bp = new JPanel();
		bp.add(btnOk);
	    getContentPane().add(bp, BorderLayout.PAGE_END);
	    
		setSize(600, 400);
		setVisible(true);
	}
	
	/**
	 * Return the parent component
	 * @return
	 */
	public Component getParentFrame() {
		return parent;
	}
}
//#endif
/**
 * 
 */
package br.com.message.features;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.message.facade.ContatoFacade;
import br.com.message.facade.ContatoFacadeImpl;

//#if ${Grupo} == "T"
//#if ${AlterarGrupo} == "T" or ${AdicionarGrupo} == "T"
import br.com.message.facade.GrupoFacade;
import br.com.message.facade.GrupoFacadeImpl;
//#endif
//#endif

import br.com.message.model.Contato;
import br.com.message.model.Grupo;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
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
	
	/**
	 * Método responsável por remover um contato
	 */
	public Usuario removerContato() {
		Usuario c = null;
		Object res = JOptionPane.showInputDialog(this.parent, "Email do Contato", "Remover Contato", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			Contato contato = new Contato();
			contato.setEmailContato(res.toString());
			try {
				c = this.contatoFacade.remover(contato);
				JOptionPane.showMessageDialog(this.parent, "Contato removido com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this.parent, e.getMessage(), "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
		}
		return c;
	}
	
	private JFrame frameNewContact;
	private JLabel lbEmail;
	private JTextField tfEmail;
	private JButton btnAdicionar;
	private JButton btnCancelar;
	
	//#if ${AlterarContato} == "T"
	private JButton btnAlterar;
	//#endif
	
	//#if ${Grupo} == "T"
	//#if ${AlterarGrupo} == "T" or ${AdicionarGrupo} == "T"
	private JLabel lbGrupo;
	private JComboBox<Grupo> cGrupo;
	private GrupoFacade grupoFacade;
	//#endif
	//#endif
	
	public void createFrameAdicionarAlterar(String tipoOperacao){
		JPanel bp = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		lbEmail = new JLabel("Email: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbEmail, cs);
		
		tfEmail = new JTextField(20);
		cs.gridx = 2;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfEmail, cs);
		
		if(Constantes.FEATURE_ADICIONAR_CONTATO.equals(tipoOperacao)){
			
			//#if ${Grupo} == "T" and ${AdicionarGrupo} == "T"
			lbGrupo = new JLabel("Grupo: ");
			cs.gridx = 0;
			cs.gridy = 1;
			cs.gridwidth = 1;
			panel.add(lbGrupo, cs);
			
			grupoFacade = new GrupoFacadeImpl();
			cGrupo = new JComboBox<Grupo>();
			for(Grupo grupo : grupoFacade.listar()){
				cGrupo.addItem(grupo);
			}
			
			cs.gridx = 2;
			cs.gridy = 1;
			cs.gridwidth = 2;
			panel.add(cGrupo, cs);
			//#endif
			
			btnAdicionar = new JButton("Adicionar");
		    btnAdicionar.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						contatoFacade.inserir(getNovoContato());
						JOptionPane.showMessageDialog(frameNewContact, "Contato adicionado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frameNewContact, ex.getMessage(), "Mensagem", JOptionPane.PLAIN_MESSAGE);
					}
		    		frameNewContact.dispose();
		    	}
		    });
		    bp.add(btnAdicionar);
			frameNewContact = new JFrame(Constantes.FEATURE_ADICIONAR_CONTATO);
		}
		
		//#if ${AlterarContato} == "T"
		if(Constantes.FEATURE_ALTERAR_CONTATO.equals(tipoOperacao)){
			
			//#if ${Grupo} == "T" and ${AlterarGrupo} == "T"		
			lbGrupo = new JLabel("Grupo: ");
			cs.gridx = 0;
			cs.gridy = 1;
			cs.gridwidth = 1;
			panel.add(lbGrupo, cs);
			
			grupoFacade = new GrupoFacadeImpl();
			cGrupo = new JComboBox<Grupo>();
			for(Grupo grupo : grupoFacade.listar()){
				cGrupo.addItem(grupo);
			}
			
			cs.gridx = 2;
			cs.gridy = 1;
			cs.gridwidth = 2;
			panel.add(cGrupo, cs);
			//#endif
			
			btnAlterar = new JButton("Alterar");
		    btnAlterar.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						contatoFacade.update(getNovoContato());
						JOptionPane.showMessageDialog(frameNewContact, "Contato alterado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frameNewContact, ex.getMessage(), "Mensagem", JOptionPane.PLAIN_MESSAGE);
					}
		    		frameNewContact.dispose();
		    	}
		    });
		    bp.add(btnAlterar);
			frameNewContact = new JFrame(Constantes.FEATURE_ALTERAR_CONTATO);
		}
		//#endif
		
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frameNewContact.dispose();
	        }
	    });
	    
	    bp.add(btnCancelar);
	    
	    frameNewContact.getContentPane().add(panel, BorderLayout.CENTER);
	    frameNewContact.getContentPane().add(bp, BorderLayout.PAGE_END);
	    
	    frameNewContact.setSize(350, 200);
	    frameNewContact.setLocationRelativeTo(this.parent);
	    frameNewContact.setVisible(true);
	}
	
	/**
	 * Retorna o contato a ser cadastrado
	 * @return Contato
	 */
	public Contato getNovoContato(){
		Contato contato = new Contato();
		contato.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		contato.setEmailContato(tfEmail.getText());
		//#if ${Grupo} == "T"
		//#if ${AlterarGrupo} == "T" or ${AdicionarGrupo} == "T"
		Grupo grupo = (Grupo) cGrupo.getSelectedItem();
		contato.setIdGrupo(grupo.getId());
		//#endif
		//#endif
		return contato;
	}
}
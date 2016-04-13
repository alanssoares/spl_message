/**
 * 
 */
package br.com.message.features;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.Email;
import br.com.message.util.LanguageUtil;
import br.com.message.util.SendEmail;

/**
 * @author alsoares
 *
 */
@SuppressWarnings("serial")
public class FRecuperarSenha extends JFrame {

	private JTextField tfEmail;
	private JLabel lbEmail;
	private JButton btnEnviar;
	
	//#if ${VisualizarSenhaTela} == "T"
	private JButton btnVisualizarTela;
	//#endif
	
	private JButton btnCancelar;
	private UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	private Container parent;
	
	public FRecuperarSenha(Container parent) {
		super(Constantes.FEATURE_RECUPERACAO_SENHA);
		this.parent = parent;
		
		JPanel panel = new JPanel(new GridBagLayout());
		JPanel borderPanel = new JPanel();
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		lbEmail = new JLabel(LanguageUtil.getInstance().getMessage(LanguageUtil.LB_EMAIL));
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbEmail, cs);
		
		tfEmail = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfEmail, cs);
		
		panel.setBorder(new LineBorder(Color.GRAY));
		
	    btnEnviar = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_SEND));
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Usuario usuario = new Usuario();
	    		usuario.setEmail(getEmail());
	    		usuario = usuarioFacade.findByEmail(usuario.getEmail());
	    		
	    		if(usuario == null){
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_EMAIL_NOT_REG));
	    		} else {
	    			SendEmail sendEmail = new SendEmail();
	    			Email email = new Email();
	    			email.setTo(usuario.getEmail());
	    			email.setSubject(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_RECOVERY_PASSWORD));
	    			email.setText("Sua senha é : " + usuario.getSenha());
	    			if(sendEmail.send(email)){
	    				JOptionPane.showMessageDialog(FRecuperarSenha.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_EMAIL_SEND_SUCCESS));
	    			} else {
	    				JOptionPane.showMessageDialog(FRecuperarSenha.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_EMAIL_SEND_ERROR));
	    			}
	    		}
	    		
	    		getParent().setVisible(true);
				dispose();
	        }
	    });
	    borderPanel.add(btnEnviar);
	    
	    //#if ${VisualizarSenhaTela} == "T"
	    btnVisualizarTela = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_VISUALIZE_SCREEN));
	    btnVisualizarTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	    		Usuario usuario = new Usuario();
	    		usuario.setEmail(getEmail());
	    		usuario = usuarioFacade.findByEmail(usuario.getEmail());
	    		if(usuario == null){
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_EMAIL_NOT_REG));
	    		} else {
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, LanguageUtil.getInstance().getMessage(LanguageUtil.LB_YOUR_PASSOWORD_IS) + usuario.getSenha());
	    		}
			}
		});
	    borderPanel.add(btnVisualizarTela);
	    //#endif
	    
	    btnCancelar = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_CANCEL));
	    btnCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		getParent().setVisible(true);
				dispose();
	        }
	    });
	    borderPanel.add(btnCancelar);
	    
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().add(borderPanel, BorderLayout.PAGE_END);
	    
		setSize(Constantes.WIDTH_APPLICATION, Constantes.HEIGHT_APPLICATION);
		setLocationRelativeTo(this.parent);
		setVisible(true);
	}
	
	public String getEmail(){
		return tfEmail.getText();
	}
	
	public Container getParent(){
		return parent;
	}
}
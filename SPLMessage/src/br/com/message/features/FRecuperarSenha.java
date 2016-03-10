//#if ${RecuperarSenha} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private JButton btnCancelar;
	private UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	
	public FRecuperarSenha() {
		super(Constantes.FEATURE_RECUPERACAO_SENHA);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		lbEmail = new JLabel("Email: ");
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
		
	    btnEnviar = new JButton("Enviar");
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Usuario usuario = new Usuario();
	    		usuario.setEmail(getEmail());
	    		usuario = usuarioFacade.recuperarSenha(usuario);
	    		if(usuario == null){
	    			JOptionPane.showMessageDialog(null, "Email não cadastrado!");
	    		} else {
	    			SendEmail sendEmail = new SendEmail();
	    			Email email = new Email();
	    			email.setFrom("alansansoa@gmail.com");
	    			email.setTo(usuario.getEmail());
	    			email.setSubject("Recuperação de Senha");
	    			email.setText("Sua senha é : " + usuario.getSenha());
	    			sendEmail.send(email);
	    			JOptionPane.showMessageDialog(null, "Senha enviada");
	    		}
	        }
	    });
	    
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	        }
	    });
	    
	    JPanel bp = new JPanel();
	    
	    bp.add(btnEnviar);
	    bp.add(btnCancelar);
	    
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().add(bp, BorderLayout.PAGE_END);
	    
		setSize(600, 400);
		setVisible(true);
	}
	
	public String getEmail(){
		return tfEmail.getText();
	}
}
//#endif
/**
 * 
 */
package br.com.message.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.message.features.FCadastroUsuario;
import br.com.message.features.FRecuperarSenha;
import br.com.message.features.Login;
import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class LoginScreen extends JFrame {

	/**
	 * Version id 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField tfEmail;
	private JPasswordField pfPassword;
	private JLabel lbEmail;
	private JLabel lbPassword;
	private JButton btnLogin;
	
	//#if ${CadastrarUsuario} == "T"
	private JButton btnNovo;
	//#endif
	
	//#if ${RecuperarSenha} == "T"
	private JButton btnRecuperarSenha;
	//#endif
	
	public LoginScreen() {
		super(Constantes.APPLICATION_NAME);
		
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
		
		lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);
		
		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		
		panel.setBorder(new LineBorder(Color.GRAY));
		
	    btnLogin = new JButton("Entrar");
	    btnLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		boolean isLogged = Login.authenticate(getEmail(), getPassword());
	    		if(isLogged){
	    			System.out.println("Usuário logado!");
	    		} else {
	    			System.out.println("Login ou senha inválido!");
	    		}
	        }
	    });
	    
	    //#if ${CadastrarUsuario} == "T"
		btnNovo = new JButton("Novo Cadastro");
		btnNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FCadastroUsuario();
			}
		});
		//#endif
		
		//#if ${RecuperarSenha} == "T"
		btnRecuperarSenha = new JButton("Recuperar Senha");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FRecuperarSenha();
			}
		});
		//#endif
		
	    JPanel bp = new JPanel();
	    
	    bp.add(btnLogin);
	    //#if ${CadastrarUsuario} == "T"
	    bp.add(btnNovo);
	    //#endif
	    //#if ${RecuperarSenha} == "T"
	    bp.add(btnRecuperarSenha);
	    //#endif
	    
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().add(bp, BorderLayout.PAGE_END);
	    
		setSize(600, 400);
		setVisible(true);
	}
	
	public String getEmail(){
		return tfEmail.getText().trim();
	}
	
	public String getPassword(){
		return new String(pfPassword.getPassword());
	}
}

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class FLoginScreen extends JFrame {

	/**
	 * Version id 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	
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
	
	public FLoginScreen() {
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
	    		if(isFieldsValid()){
		    		try {
						Usuario usuario = authenticate(getEmail(), getPassword());
						if(usuario != null){
							DataStore.getInstance().setUsuario(usuario);
							new FMenuPrincipal();
						} else {
							JOptionPane.showMessageDialog(FLoginScreen.this, "Login ou senha inválido!");
						}
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(FLoginScreen.this, "Ocorreu um erro ao realizar o login");
					}
	    		} else {
	    			JOptionPane.showMessageDialog(FLoginScreen.this, "Preencha os campos corretamente");
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
	    
		setSize(Constantes.WIDTH_APPLICATION, Constantes.HEIGHT_APPLICATION);
		setVisible(true);
	}
	
	public String getEmail(){
		return tfEmail.getText().trim();
	}
	
	public String getPassword(){
		return new String(pfPassword.getPassword());
	}
	
	public boolean isFieldsValid() {
		String password = new String(pfPassword.getPassword());
		if(tfEmail.getText().trim().isEmpty() || password.isEmpty()){
			return false;
		}
		return true;
	}
	
	public Usuario authenticate(String email, String password){
		return usuarioFacade.authenticate(email, password);
	}
}

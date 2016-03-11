//#if ${CadastrarUsuario} == "T"
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

/**
 * @author alsoares
 *
 */
@SuppressWarnings("serial")
public class FCadastroUsuario extends JFrame {

	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbEmail;
	private JTextField tfEmail;
	private JLabel lbPassword;
	private JPasswordField pfPassword;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	
	public FCadastroUsuario() {
		super(Constantes.FEATURE_CADASTRO_USUARIO);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;

		lbNome = new JLabel("Nome: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbNome, cs);
		
		tfNome = new JTextField(20);
		cs.gridx = 2;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfNome, cs);
		
		lbEmail = new JLabel("Email: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbEmail, cs);
		
		tfEmail = new JTextField(20);
		cs.gridx = 2;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfEmail, cs);
		
		lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(lbPassword, cs);
		
		pfPassword = new JPasswordField(20);
		cs.gridx = 2;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		
		panel.setBorder(new LineBorder(Color.GRAY));
		
	    btnCadastrar = new JButton("Cadastrar");
	    btnCadastrar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(isFieldsValid()){
		    		try {
						usuarioFacade.inserir(getUsuario());
						JOptionPane.showMessageDialog(FCadastroUsuario.this, "Cadastro realizado com sucesso");
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(FCadastroUsuario.this, "Ocorreu um erro ao realizar o cadastro");
					} finally {
						dispose();
					}
	    		} else {
	    			JOptionPane.showMessageDialog(FCadastroUsuario.this, "Preencha os campos corretamente");
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
	    bp.add(btnCadastrar);
	    bp.add(btnCancelar);
	    
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().add(bp, BorderLayout.PAGE_END);
	    
		setSize(600, 400);
		setVisible(true);
	}
	
	public Usuario getUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome(getNome());
		usuario.setEmail(getEmail());
		usuario.setSenha(getPassword());
		return usuario;
	}
	
	public String getEmail(){
		return tfEmail.getText().trim();
	}
	
	public String getPassword(){
		return new String(pfPassword.getPassword());
	}
	
	public String getNome(){
		return tfNome.getText();
	}
	
	public boolean isFieldsValid() {
		String password = new String(pfPassword.getPassword());
		if(tfEmail.getText().trim().isEmpty() || password.isEmpty() || tfNome.getText().trim().isEmpty()){
			return false;
		}
		return true;
	}
}
//#endif
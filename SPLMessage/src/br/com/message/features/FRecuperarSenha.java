//#if ${RecuperarSenha} == "T"
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
import br.com.message.util.SendEmail;

/**
 * @author alsoares
 *
 */
@SuppressWarnings("serial")
public class FRecuperarSenha extends JFrame {

	private JTextField tfEmail;
	private JLabel lbEmail;
	
	//#if ${EnviarSenhaEmail} == "T"
	private JButton btnEnviar;
	//#endif
	
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
		
		//#if ${EnviarSenhaEmail} == "T"
	    btnEnviar = new JButton("Enviar Email");
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Usuario usuario = new Usuario();
	    		usuario.setEmail(getEmail());
	    		usuario = usuarioFacade.findByEmail(usuario.getEmail());
	    		
	    		if(usuario == null){
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, "Email não cadastrado!");
	    		} else {
	    			SendEmail sendEmail = new SendEmail();
	    			Email email = new Email();
	    			email.setTo(usuario.getEmail());
	    			email.setSubject("Recuperação de Senha");
	    			email.setText("Sua senha é : " + usuario.getSenha());
	    			if(sendEmail.send(email)){
	    				JOptionPane.showMessageDialog(FRecuperarSenha.this, "Senha enviada com sucesso");
	    			} else {
	    				JOptionPane.showMessageDialog(FRecuperarSenha.this, "Ocorreu um erro ao enviar a senha");
	    			}
	    		}
	    		
	    		getParent().setVisible(true);
				dispose();
	        }
	    });
	    //#endif
	    
	    //#if ${VisualizarSenhaTela} == "T"
	    btnVisualizarTela = new JButton("Visualizar na Tela");
	    btnVisualizarTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	    		Usuario usuario = new Usuario();
	    		usuario.setEmail(getEmail());
	    		usuario = usuarioFacade.findByEmail(usuario.getEmail());
	    		if(usuario == null){
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, "Email não cadastrado!");
	    		} else {
	    			JOptionPane.showMessageDialog(FRecuperarSenha.this, "Sua senha é : " + usuario.getSenha());
	    		}
			}
		});
	    //#endif
	    
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		getParent().setVisible(true);
				dispose();
	        }
	    });
	    
	    JPanel bp = new JPanel();
	    
	    //#if ${EnviarSenhaEmail} == "T"
	    bp.add(btnEnviar);
	    //#endif
	    
	    //#if ${VisualizarSenhaTela} == "T"
	    bp.add(btnVisualizarTela);
	    //#endif
	    
	    bp.add(btnCancelar);
	    
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().add(bp, BorderLayout.PAGE_END);
	    
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
//#endif
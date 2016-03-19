//#if ${EnviaComentario} == "T"
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.message.enums.EnumTipoComentario;
import br.com.message.facade.ComentarioFacadeImpl;
import br.com.message.model.Comentario;
import br.com.message.util.Constantes;

/**
 * Classe criada para inclusão de comentários
 * @author alsoares
 *
 */
public class FComentario extends JFrame {
	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfAssunto;
	private JLabel lbAssunto;
	private JLabel lbTipoComentario;
	private JLabel lbMensagem;
	private JTextArea tfMensagem;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private Component parent;
	private JComboBox<String> cTipoComentario;
	
	public FComentario(Component parent) {
		super(Constantes.FEATURE_SEND_COMMENT);
		this.parent = parent;
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		lbAssunto = new JLabel("Assunto: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbAssunto, cs);
		
		tfAssunto = new JTextField(20);
		cs.gridx = 2;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfAssunto, cs);
		
		lbTipoComentario = new JLabel("Tipo Comentário: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbTipoComentario, cs);
		
		cTipoComentario = new JComboBox<String>();
		for(EnumTipoComentario item : EnumTipoComentario.values()){
			cTipoComentario.addItem(item.getDescricao());
		}
		cs.gridx = 2;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(cTipoComentario, cs);
		
		lbMensagem = new JLabel("Mensagem: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(lbMensagem, cs);
		
		tfMensagem = new JTextArea(8, 15);
		cs.gridx = 2;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfMensagem, cs);
		
	    btnEnviar = new JButton("Enviar");
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Comentario comentario = getComentario();
				new ComentarioFacadeImpl().inserir(comentario);
				JOptionPane.showMessageDialog(FComentario.this, 
						"Comentário enviado com sucesso", 
						"Mensagem Confirmação", JOptionPane.PLAIN_MESSAGE);
				clearFields();
	    	}
	    });
	    
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		getParentFrame().setVisible(true);
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
	
	public Comentario getComentario() {
		Comentario comentario = new Comentario();
		comentario.setAssunto(tfAssunto.getText());
		comentario.setDescricao(tfMensagem.getText());
		comentario.setTipo(EnumTipoComentario.getIdByDescricao(cTipoComentario.getSelectedItem().toString()));
		return comentario;
	}
	
	/**
	 * Limpa todos os campos da tela 
	 */
	public void clearFields(){
		tfAssunto.setText("");
		tfMensagem.setText("");
		cTipoComentario.setSelectedIndex(0);
	}
	
	/**
	 * Retorna o parent
	 */
	public Component getParentFrame(){
		return parent;
	}
}
//#endif
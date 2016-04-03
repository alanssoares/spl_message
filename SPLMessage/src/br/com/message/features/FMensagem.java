/**
 * 
 */
package br.com.message.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.message.enums.EnumStatusUsuario;
import br.com.message.facade.MensagemFacade;
import br.com.message.facade.MensagemFacadeImpl;
import br.com.message.model.Contato;
import br.com.message.model.Mensagem;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class FMensagem extends JFrame {
	/**
	 * Default version
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel lbStatus;
	private JTextField tfMensagem;
	private JButton btnEnviar;
	private JButton btnEmoction;
	private JButton btnAnexar;
	private Usuario contato;
	private JTextArea chatHistory;
	private MensagemFacade mensagemFacade;
	
	public FMensagem(Usuario contato) {
		super(Constantes.APP_NAME + " - " + contato.getNome());
		//Init messageFacade
		this.mensagemFacade = new MensagemFacadeImpl();
		//Contact chat
		this.contato = contato;
		//Initialize the components
		initComponents();
	}

	private void initComponents() {
		String pathImages = getClass().getResource("/").getPath().replace("bin/", "imgs/");
		panel = new JPanel();
		
		//Create panel
		panel.setLayout(null);
		this.add(panel);
		
		//Add label Status
		lbStatus = new JLabel("Status - " + EnumStatusUsuario.getStatusById(contato.getIdStatus()).getDescricao());
		lbStatus.setBounds(20, 25, 450, 20);
		panel.add(lbStatus);
		
		//Add chatHistory to panel
		chatHistory = new JTextArea();
		chatHistory.setBounds(20, 50, 450, 300);
		chatHistory.setEnabled(false);
		panel.add(chatHistory);
		
		//Add the new message input to panel
		tfMensagem = new JTextField();
		tfMensagem.setBounds(20, 375, 340, 30);
		panel.add(tfMensagem);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(360, 375, 80, 30);
		panel.add(btnEnviar);
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					mensagemFacade.inserir(getMessage());
					addMessageToHistory(tfMensagem.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    	}
	    });
	    
	    btnEmoction = new JButton(new ImageIcon(pathImages + Constantes.IMG_EMOCTION));
	    btnEmoction.setBounds(445, 375, 30, 28);
	    panel.add(btnEmoction);
	    btnEmoction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	    
	    btnAnexar = new JButton("Anexar");
	    btnAnexar.setBounds(20, 420, 80, 30);
	    panel.add(btnAnexar);
	    btnAnexar.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	    
	    //Carrega as mensagens anteriores
	    loadChatHistory();
	    
		setSize(500, 500);
		setVisible(true);
	}
	
	/**
	 * Return the message that will be sent
	 * @return String
	 */
	public Mensagem getMessage(){
		Mensagem m = new Mensagem();
		m.setDescricao(tfMensagem.getText());
		m.setEmailContato(contato.getEmail());
		return m;
	}
	
	/**
	 * Add new message to history
	 */
	public void addMessageToHistory(String message){
		String newMessage = contato.getNome() + ": ";
		newMessage += message + "\n";
		chatHistory.setText(chatHistory.getText() + newMessage);
		tfMensagem.setText("");
	}
	
	/**
	 * Load previous messages
	 */
	public void loadChatHistory(){
		Contato c = new Contato(DataStore.getInstance().getUsuario().getEmail(), contato.getEmail());
		List<Mensagem> mensagens = mensagemFacade.listar(c);
		for(Mensagem m : mensagens){
			addMessageToHistory(m.getDescricao());
		}
	}
}

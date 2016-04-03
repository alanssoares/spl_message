/**
 * 
 */
package br.com.message.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.message.enums.EnumEmoction;
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
	//if ${Emoction} == "T"
	private JButton btnEmoction;
	//#endif
	//if ${Anexar} == "T"
	private JButton btnAnexar;
	//#endif
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
					addMessageToHistory(tfMensagem.getText(), DataStore.getInstance().getUsuario().getNome());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    	}
	    });
	    
	    //if ${Emoction} == "T"
	    String pathImages = getClass().getResource("/").getPath().replace("bin/", "imgs/");
	    btnEmoction = new JButton(new ImageIcon(pathImages + Constantes.IMG_EMOCTION));
	    btnEmoction.setBounds(445, 375, 30, 28);
	    panel.add(btnEmoction);
	    btnEmoction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showEmoctions();
			}
		});
	    //#endif
	    
	    //if ${Anexar} == "T"
	    btnAnexar = new JButton("Anexar");
	    btnAnexar.setBounds(20, 420, 80, 30);
	    panel.add(btnAnexar);
	    btnAnexar.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	    //#endif
	    
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
	public void addMessageToHistory(String message, String name){
		String newMessage = name + ": ";
		newMessage += message + "\n";
		chatHistory.setText(chatHistory.getText() + newMessage);
		tfMensagem.setText("");
	}
	
	/**
	 * Load previous messages
	 */
	public void loadChatHistory(){
		final Usuario user = DataStore.getInstance().getUsuario();
		Contato cSend = new Contato(user.getEmail(), contato.getEmail());
		Contato cRecv = new Contato(contato.getEmail(), user.getEmail());
		List<Mensagem> allMessages = new ArrayList<Mensagem>(); 
		allMessages.addAll(mensagemFacade.listar(cSend));
		allMessages.addAll(mensagemFacade.listar(cRecv));
		
		Collections.sort(allMessages, new Comparator<Mensagem>() {
			public int compare(Mensagem o1, Mensagem o2) {
			      return o1.getDataInclusao().compareTo(o2.getDataInclusao());
			  }
		});
		
		for(Mensagem m : allMessages){
			if(m.getEmailUsuario().equals(cSend.getEmailUsuario())){
				addMessageToHistory(m.getDescricao(), user.getNome());
			} else {
				addMessageToHistory(m.getDescricao(), contato.getNome());
			}
		}
	}
	
	//if ${Emoction} == "T"
	/**
	 * Load all emoctions to user selects
	 */
	public void showEmoctions(){
		Object selected = null;
		Object[] options = new Object[EnumEmoction.values().length];
		int i = 0;
		for(EnumEmoction item : EnumEmoction.values()){
			options[i++] = item.getEmoction();
		}
		Object res = JOptionPane.showInputDialog(this, "Escolha o Emoction", "Emoctions", 
				JOptionPane.PLAIN_MESSAGE, null, options, selected);
		if(res != null){
			tfMensagem.setText(tfMensagem.getText() + res.toString());
		}
	}
	//#endif
}

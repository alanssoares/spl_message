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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import br.com.message.util.FileUtil;
import br.com.message.util.LanguageUtil;

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
	
	//#if ${Emoction} == "T"
	private JButton btnEmoction;
	//#endif
	
	//#if ${Anexar} == "T"
	private JButton btnAnexar;
	//#endif
	
	//#if ${LimparHistorico} == "T"
	private JButton btnLimparHistorico;
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
		//Create panel
		panel = new JPanel();
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
		
		btnEnviar = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_SEND));
		btnEnviar.setBounds(360, 375, 80, 30);
		panel.add(btnEnviar);
	    btnEnviar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					mensagemFacade.inserir(getMessage());
					addMessageToHistory(tfMensagem.getText(), DataStore.getInstance().getUsuario().getNome());
					clearMessage();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    	}
	    });
	    
	    //#if ${Emoction} == "T"
	    btnEmoction = new JButton(new ImageIcon(Constantes.IMG_EMOCTION));
	    btnEmoction.setBounds(445, 375, 30, 28);
	    panel.add(btnEmoction);
	    btnEmoction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showEmoctions();
			}
		});
	    //#endif
	    
	    //#if ${Anexar} == "T"
	    btnAnexar = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_ATTACH));
	    btnAnexar.setBounds(20, 420, 80, 30);
	    panel.add(btnAnexar);
	    btnAnexar.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int rVal = fileChooser.showOpenDialog(FMensagem.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					Mensagem msg = new Mensagem();
					FileUtil fileUtil = new FileUtil();
					Usuario user = DataStore.getInstance().getUsuario();
					try {
						//Faz o upload do arquivo
						fileUtil.uploadFile(fileChooser.getSelectedFile());
						//Preenche os dados da mensagem do anexo
						msg.setEmailContato(contato.getEmail());
						msg.setDescricao(fileChooser.getSelectedFile().getName());
						//Insere a mensagem
						mensagemFacade.inserir(msg);
						//Adiciona a mensagem ao histórico
						addMessageToHistory(fileChooser.getSelectedFile().getName(), user.getNome());
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(FMensagem.this,
							LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_SEND_FILE_ERROR));
					}
				}
			}
		});
	    //#endif
	    
	    //#if ${LimparHistorico} == "T"
	    btnLimparHistorico = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_CLEAR));
	    btnLimparHistorico.setBounds(105, 420, 80, 30);
	    panel.add(btnLimparHistorico);
	    btnLimparHistorico.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final Usuario user = DataStore.getInstance().getUsuario();
				Contato c = new Contato(user.getEmail(), contato.getEmail());
				try {
					mensagemFacade.limparHistorico(c);
					chatHistory.setText("");
					JOptionPane.showMessageDialog(FMensagem.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CLEAR_HISTORY_SUCCESS));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(FMensagem.this, LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_CLEAR_HISTORY_ERROR));
				}
			}
		});
	    //#endif
	    
	    //Carrega as mensagens anteriores
	    loadChatHistory();
	    createThread();
		setSize(500, 500);
		setVisible(true);
	}
	
	/**
	 * Create thread to load chat history
	 */
	private void createThread() {
		Timer timer = new Timer();
		//Atualiza a cada 5 segundos
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				loadChatHistory();
			}
		}, 0, 1000 * 5);
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
	}
	
	/**
	 * Clear the field message
	 */
	private void clearMessage(){
		tfMensagem.setText("");
	}
	
	/**
	 * Load previous messages
	 */
	public void loadChatHistory(){
		chatHistory.setText("");
		final Usuario user = DataStore.getInstance().getUsuario();
		Contato c = new Contato(user.getEmail(), contato.getEmail());
		List<Mensagem> allMessages = new ArrayList<Mensagem>(); 
		allMessages.addAll(mensagemFacade.listar(c));
		
		Collections.sort(allMessages, new Comparator<Mensagem>() {
			public int compare(Mensagem o1, Mensagem o2) {
			      return o1.getDataInclusao().compareTo(o2.getDataInclusao());
			 }
		});
		
		for(Mensagem m : allMessages){
			if(Constantes.MSG_ENVIADA.equals(m.getEnviada())){
				addMessageToHistory(m.getDescricao(), user.getNome());
			} else {
				addMessageToHistory(m.getDescricao(), contato.getNome());
			}
		}
	}
	
	//#if ${Emoction} == "T"
	/**
	 * Load all emoctions to user selects
	 */
	public void showEmoctions(){
		int i = 0;
		Object[] options = new Object[EnumEmoction.values().length];
		for(EnumEmoction item : EnumEmoction.values()){
			options[i++] = item.getEmoction();
		}
		Object res = JOptionPane.showInputDialog(this, 
			LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_CHOOSE_EMOCTION),
			LanguageUtil.getInstance().getMessage(LanguageUtil.LB_EMOCTION),
				JOptionPane.PLAIN_MESSAGE, null, options, null);
		if(res != null){
			tfMensagem.setText(tfMensagem.getText() + res.toString());
		}
	}
	//#endif
}
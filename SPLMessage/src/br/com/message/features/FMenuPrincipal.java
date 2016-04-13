/**
 * 
 */
package br.com.message.features;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import br.com.message.enums.EnumOrdenacao;
import br.com.message.facade.ContatoFacade;
import br.com.message.facade.ContatoFacadeImpl;
import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Contato;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;
import br.com.message.util.LanguageUtil;

/**
 * @author alsoares
 *
 */
public class FMenuPrincipal extends JDialog {

	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;

	private JMenu jMenuInicio;
	private JMenuBar jMenu;
	private JMenuItem btnSair;
	private List<Contato> contacts;
	private JList<Usuario> jListConcatcs;
	private DefaultListModel<Usuario> dfListContact;
	private JScrollPane jScrollPaneContact;
	private UsuarioFacade userFacade;
	private ContatoFacade contactFacade;
	private JMenuItem btnAdicionarContato;
	private JMenuItem btnRemoverContato;
	
	//#if ${Grupo} == "T"
	private JMenuItem btnAdicionarGrupo;
	private JMenuItem btnRemoverGrupo;
	//#endif
	
	//#if ${Status} == "T"
	private JMenu jMenuStatus;
	private JMenuItem btnAlterarStatus;
	private JMenuItem btnVisualizarStatus;
	//#endif
	
	//#if ${AlterarContato} == "T"
	private JMenuItem btnAlterarContato;
	//#endif
	
	//#if ${EnviaComentario} == "T"
	private JMenuItem btnEnviarComentario;
	//#endif
	
	//#if ${ListaComentario} == "T"
	private JMenuItem btnListaComentario;
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	private JMenuItem btnPoliticaPrivacidade;
	//#endif
	
	//#if ${OrdenarContatos} == "T"
	private JMenuItem btnOrdenarContatos;
	//#endif
	
	//#if ${Sobre} == "T"
	private JMenuItem btnSobre;
	//#endif
	
	//#if ${Ajuda} == "T"
	private JMenu jMenuAjuda;
	//#endif
	
	private JMenu jMenuContato;
	
	//#if ${Grupo} == "T"
	private JMenu jMenuGrupo;
	//#endif
	
	//#if ${PesquisaContato} == "T"
	private JPanel buscaPanel;
	private JButton btnBuscarContato;
	private JLabel lbEmailContato;
	private JTextField tfEmailContato;
	//#endif
	
	public FMenuPrincipal(JFrame parent) {
		super(parent, Constantes.APPLICATION_NAME);

		userFacade = new UsuarioFacadeImpl();
		contactFacade = new ContatoFacadeImpl();
		
		initComponents();

		setSize(Constantes.WIDTH_APPLICATION, Constantes.HEIGHT_APPLICATION);
		setVisible(true);
	}

	private void initComponents() {
		
		//#if ${PesquisaContato} == "T"
		buscaPanel = new JPanel();
		buscaPanel.setBounds(0, 0, 200, 100);
		
		lbEmailContato = new JLabel(LanguageUtil.getInstance().getMessage(LanguageUtil.LB_EMAIL));
		lbEmailContato.setBounds(0, 20, 80, 20);
		buscaPanel.add(lbEmailContato);
		
		tfEmailContato = new JTextField(20);
		tfEmailContato.setBounds(85, 20, 100, 20);
		buscaPanel.add(tfEmailContato);
		
		btnBuscarContato = new JButton(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_SEARCH));
		btnBuscarContato.setBounds(190, 20, 80, 20);
		btnBuscarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfEmailContato.getText().isEmpty()){
					contacts = contactFacade.listar(DataStore.getInstance().getUsuario().getEmail());
				} else {
					contacts = contactFacade.listar(DataStore.getInstance().getUsuario().getEmail(), tfEmailContato.getText());	
				}
				updateStatus();
			}
		});
		buscaPanel.add(btnBuscarContato);
		getContentPane().add(buscaPanel, BorderLayout.PAGE_START);
		//#endif
		
		jMenu = new JMenuBar();

		createMenuInicio();

		//#if ${Status} == "T"
		createMenuStatus();
		//#endif

		//#if ${Grupo} == "T"
		createMenuGrupo();
		//#endif

		createMenuContato();

		//#if ${Ajuda} == "T"
		createMenuAjuda();
		//#endif
		
		createThreadUpdateContacts();

		setJMenuBar(jMenu);
		
		pack();
	}

	private void createMenuInicio() {
		jMenuInicio = new JMenu(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_BEGIN_));

		btnSair = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_OUT));
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataStore.getInstance().logout();
				getParent().setVisible(true);
				dispose();
			}
		});
		jMenuInicio.add(btnSair);

		jMenu.add(jMenuInicio);
	}

	//#if ${Ajuda} == "T"
	private void createMenuAjuda() {
		jMenuAjuda = new JMenu(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_HELP));

		//#if ${EnviaComentario} == "T"
		btnEnviarComentario = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_SEND_COMMENT));
		btnEnviarComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).comentario();
			}
		});
		jMenuAjuda.add(btnEnviarComentario);
		//#endif
		
		//#if ${ListaComentario} == "T"
		btnListaComentario = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_LIST_COMMENTS));
		btnListaComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).listaComentarios();
			}
		});
		jMenuAjuda.add(btnListaComentario);
		//#endif
		
		
		//#if ${PoliticaPrivacidade} == "T"
		btnPoliticaPrivacidade = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_POLICY));
		btnPoliticaPrivacidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).politicaPrivacidade();
			}
		});
		jMenuAjuda.add(btnPoliticaPrivacidade);
		//#endif

		//#if ${Sobre} == "T"
		btnSobre = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ABOUT));
		btnSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).sobre();
			}
		});
		jMenuAjuda.add(btnSobre);
		//#endif

		jMenu.add(jMenuAjuda);
	}
	//#endif
	
	private void createMenuContato() {
		jMenuContato = new JMenu(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_CONTACT));

		btnAdicionarContato = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ADD));
		btnAdicionarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FContato(FMenuPrincipal.this).createFrameAdicionarAlterar(Constantes.FEATURE_ADICIONAR_CONTATO);
				updateContacts();
			}
		});
		jMenuContato.add(btnAdicionarContato);

		//#if ${AlterarContato} == "T"
		btnAlterarContato = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ALTER));
		btnAlterarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FContato(FMenuPrincipal.this).createFrameAdicionarAlterar(Constantes.FEATURE_ALTERAR_CONTATO);
				updateContacts();
			}
		});
		jMenuContato.add(btnAlterarContato);
		//#endif
		
		btnRemoverContato = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_REMOVE));
		btnRemoverContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario contato = new FContato(FMenuPrincipal.this).removerContato();
				if(contato != null){
					dfListContact.removeElementAt(getContact(contato));
				}
				updateContacts();
			}
		});
		jMenuContato.add(btnRemoverContato);
		
		//#if ${OrdenarContatos} == "T"
		btnOrdenarContatos = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.BTN_SORT));
		btnOrdenarContatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object res = JOptionPane.showInputDialog(FMenuPrincipal.this, 
						LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ORDENATION_TYPE), 
						LanguageUtil.getInstance().getMessage(LanguageUtil.LB_TYPE), 
						JOptionPane.PLAIN_MESSAGE, null, EnumOrdenacao.getList().toArray(), null);
				if(res != null){
					sortContacts(res.toString());
				}
			}
		});
		jMenuContato.add(btnOrdenarContatos);
		//#endif
		
		jMenu.add(jMenuContato);
	}

	//#if ${Grupo} == "T"
	private void createMenuGrupo() {
		jMenuGrupo = new JMenu(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_GROUP));
		
		btnAdicionarGrupo = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ADD));
		btnAdicionarGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FGrupo(FMenuPrincipal.this).adicionarGrupo();
			}
		});
		jMenuGrupo.add(btnAdicionarGrupo);
		
		btnRemoverGrupo = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_REMOVE));
		btnRemoverGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FGrupo(FMenuPrincipal.this).removerGrupo();
			}
		});
		jMenuGrupo.add(btnRemoverGrupo);

		jMenu.add(jMenuGrupo);
	}
	//#endif

	//#if ${Status} == "T"
	private void createMenuStatus() {
		jMenuStatus = new JMenu(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_STATUS));

		btnVisualizarStatus = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_VISUALIZE));
		btnVisualizarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FStatus(FMenuPrincipal.this).mostrarStatus();
			}
		});
		jMenuStatus.add(btnVisualizarStatus);
		
		btnAlterarStatus = new JMenuItem(LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_ALTER));
		btnAlterarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FStatus(FMenuPrincipal.this).alterarStatus();
			}
		});
		jMenuStatus.add(btnAlterarStatus);

		jMenu.add(jMenuStatus);
	}
	//#endif

	/**
	 * Cria a lista de contatos do usuário
	 */
	private void createThreadUpdateContacts() {
		Timer timer = new Timer();
		
		contacts = new ContatoFacadeImpl().listar(DataStore.getInstance().getUsuario().getEmail());
		dfListContact = new DefaultListModel<Usuario>();
		
		for (Contato c : contacts) {
			Usuario contato = new UsuarioFacadeImpl().findByEmail(c.getContatoPK().getEmailContato());
			dfListContact.addElement(contato);
		}
		
		jListConcatcs = new JList<Usuario>(dfListContact);
		jListConcatcs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListConcatcs.setSelectedIndex(0);
		jListConcatcs.setVisibleRowCount(contacts.size());
		jScrollPaneContact = new JScrollPane(jListConcatcs);
		
		jListConcatcs.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
		        	if(jListConcatcs.getSelectedValue() != null){
		        		new FMensagem(jListConcatcs.getSelectedValue());
		        	}
		        }
		   }
		});
		
		getContentPane().add(jScrollPaneContact);
		
		//Atualiza a cada 5 segundos
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				updateStatus();
			}
		}, 0, 1000 * 10);
	}

	/**
	 * Método responsável por atualizar a lista de contatos
	 */
	private void updateContacts() {
		contacts = contactFacade.listar(DataStore.getInstance().getUsuario().getEmail());
	}
	
	/**
	 * Método responsável por atualizar o status
	 * dos contatos
	 */
	private void updateStatus(){
		dfListContact.removeAllElements();
		if(contacts != null && !contacts.isEmpty()){
			for (Contato c : contacts) {
				Usuario contato = userFacade.findByEmail(c.getContatoPK().getEmailContato());
				int index = getContact(contato);
				if(index >= 0){
					dfListContact.set(index, contato);
				} else {
					dfListContact.addElement(contato);
				}
			}
		}
	}
	
	/**
	 * Obtém o indice do contato para atualizar o status
	 * @param u
	 * @return
	 */
	private Integer getContact(Usuario u){
		Enumeration<Usuario> contacts = dfListContact.elements();
		while(contacts.hasMoreElements()){
			Usuario c = contacts.nextElement();
			if(c.getEmail().equals(u.getEmail())){
				return dfListContact.indexOf(c);
			}
		}
		return -1;
	}
	
	//#if ${OrdenarContatos} == "T"
	/**
	 * Método responsável por ordenar a lista de contatos de acordo
	 * com o tipo de ordenação especificado
	 * @param by
	 */
	private void sortContacts(String by){
		Enumeration<Usuario> elements = dfListContact.elements();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		while (elements.hasMoreElements()) {
			usuarios.add((Usuario) elements.nextElement());
		}
		
		if(EnumOrdenacao.EMAIL.getDescricao().equals(by)){
			Collections.sort(usuarios, new Comparator<Usuario>() {
				@Override
				public int compare(Usuario o1, Usuario o2) {
					return o1.getEmail().compareTo(o2.getEmail());
				}
			});
		}
		
		//#if ${Status} == "T" and ${OrdenarStatus} == "T"
		if(EnumOrdenacao.STATUS.getDescricao().equals(by)){
			Collections.sort(usuarios, new Comparator<Usuario>() {
				@Override
				public int compare(Usuario o1, Usuario o2) {
					return o1.getIdStatus().compareTo(o2.getIdStatus());
				}
			});
		}
		//#endif
		
		//#if ${Grupo} == "T" and ${OrdenarGrupo} == "T"
		if(EnumOrdenacao.GRUPO.getDescricao().equals(by)) {
			Collections.sort(contacts, new Comparator<Contato>() {
				@Override
				public int compare(Contato o1, Contato o2) {
					return o1.getIdGrupo().compareTo(o2.getIdGrupo());
				}
			});
			usuarios.clear();
			for (Contato c : contacts) {
				Usuario contato = userFacade.findByEmail(c.getContatoPK().getEmailContato());
				usuarios.add(contato);
			}
		}
		//#endif
		
		dfListContact.removeAllElements();
		for(Usuario usuario : usuarios){
			dfListContact.addElement(usuario);
		}
	}
	//#endif
}
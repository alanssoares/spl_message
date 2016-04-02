/**
 * 
 */
package br.com.message.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import br.com.message.facade.ContatoFacade;
import br.com.message.facade.ContatoFacadeImpl;
import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Contato;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class FMenuPrincipal extends JDialog {

	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar jMenu;
	//if ${AdicionarContato} == "T"
	private JMenuItem btnAdicionarContato;
	//#endif
	//if ${AdicionarGrupo} == "T"
	private JMenuItem btnAdicionarGrupo;
	//#endif
	//if ${AlterarStatus} == "T"
	private JMenuItem btnAlterarStatus;
	//#endif
	//if ${AlterarContato} == "T"
	private JMenuItem btnAlterarContato;
	//#endif
	//if ${EnviaComentario} == "T"
	private JMenuItem btnEnviarComentario;
	//#endif
	//if ${PoliticaPrivacidade} == "T"
	private JMenuItem btnPoliticaPrivacidade;
	//#endif
	//if ${RemoverContato} == "T"
	private JMenuItem btnRemoverContato;
	//#endif
	//if ${RemoverGrupo} == "T"
	private JMenuItem btnRemoverGrupo;
	//#endif
	//if ${Sobre} == "T"
	private JMenuItem btnSobre;
	//#endif
	//if ${VisualizarStatus} == "T"
	private JMenuItem btnVisualizarStatus;
	//#endif
	private JMenuItem btnSair;
	//#if ${Ajuda} == "T" or ${EnviaComentario} == "T" or ${PoliticaPrivacidade} == "T" or ${Sobre} == "T"
	private JMenu jMenuAjuda;
	//#endif
	//#if ${Contato} == "T" or ${AdicionarContato} == "T" or ${RemoverContato} == "T" or ${AlterarContato} == "T"
	private JMenu jMenuContato;
	//#endif
	//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
	private JMenu jMenuGrupo;
	//#endif
	//#if ${Status} == "T" or ${VisualizarStatus} == "T" or ${AlterarStatus} == "T"
	private JMenu jMenuStatus;
	//#endif
	private JMenu jMenuInicio;
	//private JButton btnBuscarContato;
	//private JLabel lbEmailContato;
	//private JTextField tfEmailContato;
	private JList<Usuario> jListConcatcs;
	private DefaultListModel<Usuario> dfListContact;

	private JScrollPane jScrollPaneContact;

	private UsuarioFacade userFacade;
	private ContatoFacade contactFacade;
	
	public FMenuPrincipal(JFrame parent) {
		super(parent, Constantes.APPLICATION_NAME);

		userFacade = new UsuarioFacadeImpl();
		contactFacade = new ContatoFacadeImpl();
		
		initComponents();

		setSize(Constantes.WIDTH_APPLICATION, Constantes.HEIGHT_APPLICATION);
		setVisible(true);
	}

	private void initComponents() {
		//tfEmailContato = new JTextField();
		//lbEmailContato = new JLabel("Email");
		//btnBuscarContato = new JButton("Buscar");

		jMenu = new JMenuBar();

		createMenuInicio();

		//#if ${Status} == "T" or ${VisualizarStatus} == "T" or ${AlterarStatus} == "T"
		createMenuStatus();
		//#endif

		//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
		createMenuGrupo();
		//#endif

		//#if ${Contato} == "T" or ${AdicionarContato} == "T" or ${RemoverContato} == "T"
		createMenuContato();
		//#endif

		//#if ${Ajuda} == "T" or ${EnviaComentario} == "T" or ${PoliticaPrivacidade} == "T" or ${Sobre} == "T"
		createMenuAjuda();
		//#endif

		createThreadUpdateContacts();

		setJMenuBar(jMenu);

		/*
		 * GroupLayout layout = new GroupLayout(getContentPane());
		 * 
		 * getContentPane().setLayout(layout);
		 * 
		 * layout.setHorizontalGroup(
		 * layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(GroupLayout.Alignment.TRAILING,
		 * layout.createSequentialGroup() .addContainerGap()
		 * .addComponent(lbEmailContato)
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		 * .addComponent(tfEmailContato, GroupLayout.DEFAULT_SIZE, 460,
		 * Short.MAX_VALUE)
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		 * .addComponent(btnBuscarContato, GroupLayout.PREFERRED_SIZE, 83,
		 * GroupLayout.PREFERRED_SIZE) .addContainerGap()) );
		 * 
		 * layout.setVerticalGroup(
		 * layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup() .addContainerGap()
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(tfEmailContato, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 * .addComponent(lbEmailContato) .addComponent(btnBuscarContato))
		 * .addContainerGap(345, Short.MAX_VALUE)) );
		 */
		pack();
	}

	private void createMenuInicio() {
		jMenuInicio = new JMenu("Inicio");

		btnSair = new JMenuItem("Sair");
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

	//#if ${Ajuda} == "T" or ${EnviaComentario} == "T" or ${PoliticaPrivacidade} == "T" or ${Sobre} == "T"
	private void createMenuAjuda() {
		jMenuAjuda = new JMenu("Ajuda");

		//#if ${EnviaComentario} == "T"
		btnEnviarComentario = new JMenuItem("Enviar Comentário");
		btnEnviarComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).comentario();
			}
		});
		jMenuAjuda.add(btnEnviarComentario);
		//#endif

		//#if ${PoliticaPrivacidade} == "T"
		btnPoliticaPrivacidade = new JMenuItem("Política de Privacidade");
		btnPoliticaPrivacidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FAjuda(FMenuPrincipal.this).politicaPrivacidade();
			}
		});
		jMenuAjuda.add(btnPoliticaPrivacidade);
		//#endif

		//#if ${Sobre} == "T"
		btnSobre = new JMenuItem("Sobre");
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

	//#if ${Contato} == "T" or ${RemoverContato} == "T" or ${AdicionarContato} == "T"
	private void createMenuContato() {
		jMenuContato = new JMenu("Contato");

		//#if ${AdicionarContato} == "T"
		btnAdicionarContato = new JMenuItem("Adicionar");
		btnAdicionarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FContato(FMenuPrincipal.this).createFrameAdicionarAlterar(Constantes.FEATURE_ADICIONAR_CONTATO);
				updateContacts();
			}
		});
		jMenuContato.add(btnAdicionarContato);
		//#endif

		//#if ${AlterarContato} == "T"
		btnAlterarContato = new JMenuItem("Alterar");
		btnAlterarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FContato(FMenuPrincipal.this).createFrameAdicionarAlterar(Constantes.FEATURE_ALTERAR_CONTATO);
				updateContacts();
			}
		});
		jMenuContato.add(btnAlterarContato);
		//#endif
		
		//#if ${RemoverContato} == "T"
		btnRemoverContato = new JMenuItem("Remover");
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
		//#endif

		jMenu.add(jMenuContato);
	}

	//#endif

	//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
	private void createMenuGrupo() {
		jMenuGrupo = new JMenu("Grupo");

		//#if ${CadastrarGrupo} == "T"
		btnAdicionarGrupo = new JMenuItem("Adicionar");
		btnAdicionarGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FGrupo(FMenuPrincipal.this).adicionarGrupo();
			}
		});
		jMenuGrupo.add(btnAdicionarGrupo);
		//#endif

		//#if ${RemoverGrupo} == "T"
		btnRemoverGrupo = new JMenuItem("Remover");
		btnRemoverGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FGrupo(FMenuPrincipal.this).removerGrupo();
			}
		});
		jMenuGrupo.add(btnRemoverGrupo);
		//#endif

		jMenu.add(jMenuGrupo);
	}

	//#endif

	//#if ${Status} == "T" or ${VisualizarStatus} == "T" or ${AlterarStatus} == "T"
	private void createMenuStatus() {
		jMenuStatus = new JMenu("Status");

		//#if ${VisualizarStatus} == "T"
		btnVisualizarStatus = new JMenuItem("Visualizar");
		btnVisualizarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FStatus(FMenuPrincipal.this).mostrarStatus();
			}
		});
		jMenuStatus.add(btnVisualizarStatus);
		//#endif

		//#if ${AlterarStatus} == "T"
		btnAlterarStatus = new JMenuItem("Alterar");
		btnAlterarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FStatus(FMenuPrincipal.this).alterarStatus();
			}
		});
		jMenuStatus.add(btnAlterarStatus);
		//#endif

		jMenu.add(jMenuStatus);
	}
	//#endif

	private void createThreadUpdateContacts() {
		Timer timer = new Timer();
		
		List<Contato> contacts = new ContatoFacadeImpl().listar(DataStore.getInstance().getUsuario().getEmail());
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
		
		getContentPane().add(jScrollPaneContact);
		
		//Atualiza a cada 5 segundos
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				updateContacts();
			}
		}, 0, 1000 * 5);
	}

	/**
	 * Método responsável por atualizar a lista de contatos
	 */
	private void updateContacts() {
		List<Contato> contacts = contactFacade.listar(DataStore.getInstance().getUsuario().getEmail());
		for (Contato c : contacts) {
			Usuario contato = userFacade.findByEmail(c.getContatoPK().getEmailContato());
			int index = getContact(contato);
			if(index >= 0){
				dfListContact.set(index, contato);
			} else if(contato != null){
				dfListContact.addElement(contato);
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
}
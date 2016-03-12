/**
 * 
 */
package br.com.message.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import br.com.message.enums.EnumStatusUsuario;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class FMenuPrincipal extends JFrame {

	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;	
	                  
    private JMenuItem btnAdicionarContato;
    private JMenuItem btnAdicionarGrupo;
    private JMenuItem btnAlterarStatus;
    private JMenuItem btnEnviarComentario;
    private JMenuItem btnPoliticaPrivacidade;
    private JMenuItem btnRemoverContato;
    private JMenuItem btnRemoverGrupo;
    private JMenuItem btnSobre;
    private JMenuItem btnVisualizarStatus;
    private JButton btnBuscarContato;
    private JLabel lbNomeContato;
    private JMenuBar jMenu;
    private JMenu jMenuAjuda;
    private JMenu jMenuContato;
    private JMenu jMenuGrupo;
    private JMenu jMenuSair;
    private JMenu jMenuStatus;
    private JTextField tfNomeContato;
    
	public FMenuPrincipal() {
		super(Constantes.APPLICATION_NAME);
		
		initComponents();
		
		setSize(Constantes.WIDTH_APPLICATION, Constantes.HEIGHT_APPLICATION);
		setVisible(true);
	}
	
    private void initComponents() {
    	
        tfNomeContato = new JTextField();
        lbNomeContato = new JLabel("Nome");
        btnBuscarContato = new JButton("Buscar");
        
        jMenu = new JMenuBar();
        
        //#if ${Status} == "T"
        createMenuStatus();
        //#endif
        
        //#if ${Grupo} == "T"
        createMenuGrupo();
        //#endif
        
        //#if ${Contato} == "T"
        createMenuContato();
        //#endif
        
        //#if ${Ajuda} == "T"
        createMenuAjuda();
        //#endif
        
        createMenuSair();
        
        setJMenuBar(jMenu);

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeContato)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeContato, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarContato, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNomeContato)
                    .addComponent(btnBuscarContato))
                .addContainerGap(345, Short.MAX_VALUE))
        );

        pack();
    }

	private void createMenuSair() {
        jMenuSair = new JMenu("Sair");
        jMenuSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenu.add(jMenuSair);
	}

	//#if ${Ajuda} == "T"
	private void createMenuAjuda() {
        jMenuAjuda = new JMenu("Ajuda");
        
        //#if ${EnviaComentario} == "T"
        btnEnviarComentario = new JMenuItem("Enviar Comentário");
        btnEnviarComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuAjuda.add(btnEnviarComentario);
        //#endif
        
        //#if ${PoliticaPrivacidade} == "T"
        btnPoliticaPrivacidade = new JMenuItem("Política de Privacidade");
        btnPoliticaPrivacidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuAjuda.add(btnPoliticaPrivacidade);
        //#endif
        
        //#if ${Sobre} == "T"
        btnSobre = new JMenuItem("Sobre");
        btnSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuAjuda.add(btnSobre);
        //#endif
        
        jMenu.add(jMenuAjuda);
	}
	//#endif
	
	//#if ${Contato} == "T"
	private void createMenuContato() {
        jMenuContato = new JMenu("Contato");
        
        //#if ${AdicionarContato} == "T"
        btnAdicionarContato = new JMenuItem("Adicionar");
        btnAdicionarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuContato.add(btnAdicionarContato);
        //#endif
        
        //#if ${RemoverContato} == "T"
        btnRemoverContato = new JMenuItem("Remover");
        btnRemoverContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuContato.add(btnRemoverContato);
        //#endif
        
        jMenu.add(jMenuContato);
	}
	//#endif
	
	//#if ${Grupo} == "T"
	private void createMenuGrupo() {
        jMenuGrupo = new JMenu("Grupo");
        
        //#if ${AdicionarGrupo} == "T"
        btnAdicionarGrupo = new JMenuItem("Adicionar");
        btnAdicionarGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuGrupo.add(btnAdicionarGrupo);
        //#endif
        
        //#if ${RemoverGrupo} == "T"
        btnRemoverGrupo = new JMenuItem("Remover");
        btnRemoverGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuGrupo.add(btnRemoverGrupo);
        //#endif
        
        jMenu.add(jMenuGrupo);
	}
	//#endif
	
	//#if ${Status} == "T"
	private void createMenuStatus() {
        jMenuStatus = new JMenu("Status");
        
        //#if ${VisualizarStatus} == "T"
        btnVisualizarStatus = new JMenuItem("Visualizar");
        btnVisualizarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showStatus();
			}
		});
        jMenuStatus.add(btnVisualizarStatus);
        //#endif
        
        //#if ${AlterarStatus} == "T"
        btnAlterarStatus = new JMenuItem("Alterar");
        btnAlterarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        jMenuStatus.add(btnAlterarStatus);
        //#endif
        
        jMenu.add(jMenuStatus);
	}
	//#endif
	
	//#if ${VisualizarStatus} == "T"
	private void showStatus() {
		Usuario usuario = DataStore.getInstance().getUsuario();
		String status = EnumStatusUsuario.getStatusById(usuario.getIdStatus()).getDescricao();
		JOptionPane.showMessageDialog(FMenuPrincipal.this, "Status - " + status);
	}
	//#endif
}

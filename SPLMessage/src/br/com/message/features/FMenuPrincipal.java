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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import br.com.message.util.Constantes;

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
        
        createMenuStatus();
        createMenuGrupo();
        createMenuContato();
        createMenuAjuda();
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

	private void createMenuAjuda() {
        jMenuAjuda = new JMenu("Ajuda");
        
        btnEnviarComentario = new JMenuItem("Enviar Comentário");
        btnPoliticaPrivacidade = new JMenuItem("Política de Privacidade");
        btnSobre = new JMenuItem("Sobre");
        
        btnEnviarComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        btnPoliticaPrivacidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        btnSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        jMenuAjuda.add(btnEnviarComentario);
        jMenuAjuda.add(btnPoliticaPrivacidade);
        jMenuAjuda.add(btnSobre);
        
        jMenu.add(jMenuAjuda);
	}

	private void createMenuContato() {
        jMenuContato = new JMenu("Contato");
        
        btnAdicionarContato = new JMenuItem("Adicionar");
        btnRemoverContato = new JMenuItem("Remover");
        
        btnAdicionarContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        btnRemoverContato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        jMenuContato.add(btnAdicionarContato);
        jMenuContato.add(btnRemoverContato);
        
        jMenu.add(jMenuContato);
	}

	private void createMenuGrupo() {
        jMenuGrupo = new JMenu("Grupo");
        
        btnAdicionarGrupo = new JMenuItem("Adicionar");
        btnRemoverGrupo = new JMenuItem("Remover");
        
        btnAdicionarGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        btnRemoverGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        jMenuGrupo.add(btnAdicionarGrupo);
        jMenuGrupo.add(btnRemoverGrupo);
        
        jMenu.add(jMenuGrupo);
	}

	private void createMenuStatus() {
        jMenuStatus = new JMenu("Status");
        
        btnVisualizarStatus = new JMenuItem("Visualizar");
        btnAlterarStatus = new JMenuItem("Alterar");
        
        btnVisualizarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        btnAlterarStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
        jMenuStatus.add(btnVisualizarStatus);
        jMenuStatus.add(btnAlterarStatus);
        
        jMenu.add(jMenuStatus);
	}
}

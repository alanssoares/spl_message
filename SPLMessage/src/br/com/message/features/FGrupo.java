//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T" 
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.message.facade.GrupoFacade;
import br.com.message.facade.GrupoFacadeImpl;
import br.com.message.model.Grupo;
import br.com.message.util.Constantes;

/**
 * Feature grupo
 * @author alsoares
 *
 */
public class FGrupo {

	private Component parent;
	private GrupoFacade grupoFacade;
	
	public FGrupo(Component parent) {
		this.parent = parent;
		this.grupoFacade = new GrupoFacadeImpl();
	}
	
	//#if ${CadastrarGrupo} == "T"
	/**
	 * Responsável por adicionar um novo grupo
	 */
	public void adicionarGrupo() {
		Grupo novoGrupo = new Grupo();
		Object res = JOptionPane.showInputDialog(this.parent, "Nome do Grupo", "Adicionar Grupo", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			novoGrupo.setDescricao(res.toString());
			Grupo grupo = grupoFacade.inserir(novoGrupo);
			if(grupo != null){
				JOptionPane.showMessageDialog(this.parent, "Grupo cadastrado com sucesso", Constantes.MENSAGEM_DEFAULT, JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.parent, "Este grupo já está cadastrado", Constantes.MENSAGEM_DEFAULT, JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	//#endif
	
	//#if ${RemoverGrupo} == "T"
	/**
	 * Responsável por remover um grupo. Quando um
	 * grupo do usuário é removido, todos os seus contatos
	 * são atualizados para um grupo default.
	 */
	public void removerGrupo() {
		GrupoFacadeImpl grupoFacade = new GrupoFacadeImpl();
		List<Grupo> grupos = grupoFacade.listar();
		Object res = JOptionPane.showInputDialog(this.parent, "Escolha o Grupo", "Remover Grupo", 
				JOptionPane.PLAIN_MESSAGE, null, grupos.toArray(), null);
		if(res != null){
			for(int i = 0; i < grupos.size(); i++){
				if(grupos.get(i).getDescricao().equals(res.toString())){
					grupoFacade.remover(grupos.get(i));
					JOptionPane.showMessageDialog(this.parent, "Grupo removido com sucesso", Constantes.MENSAGEM_DEFAULT, JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
		}
	}
	//#endif
}
//#endif
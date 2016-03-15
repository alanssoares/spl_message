//#if ${Grupo} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.message.facade.GrupoFacadeImpl;
import br.com.message.model.Grupo;

/**
 * Feature grupo
 * @author alsoares
 *
 */
public class FGrupo {

	private Component parent;
	
	public FGrupo(Component parent) {
		this.parent = parent;
	}
	
	//#if ${AdicionarGrupo} == "T"
	/**
	 * Responsável por adicionar um novo grupo
	 */
	public void adicionarGrupo() {
		Grupo grupo = new Grupo();
		Object res = JOptionPane.showInputDialog(this.parent, "Nome do grupo", "Adicionar Grupo", JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			grupo.setDescricao(res.toString());
			new GrupoFacadeImpl().inserir(grupo);
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
		Object res = JOptionPane.showInputDialog(this.parent, "Escolha o Grupo", "Remoção de Grupo", 
				JOptionPane.PLAIN_MESSAGE, null, grupos.toArray(), null);
		if(res != null){
			for(int i = 0; i < grupos.size(); i++){
				if(grupos.get(i).getDescricao().equals(res.toString())){
					grupoFacade.remover(grupos.get(i));		
				}
			}
		}
	}
	//#endif
}
//#endif
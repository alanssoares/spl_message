//#if ${Grupo} == "T" 
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
import br.com.message.util.LanguageUtil;

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
	
	/**
	 * Responsável por adicionar um novo grupo
	 */
	public void adicionarGrupo() {
		Grupo novoGrupo = new Grupo();
		Object res = JOptionPane.showInputDialog(this.parent, 
				LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_NAME_GROUP), 
				LanguageUtil.getInstance().getMessage(LanguageUtil.LB_ADD_GROUP), JOptionPane.PLAIN_MESSAGE);
		if(res != null){
			novoGrupo.setDescricao(res.toString());
			Grupo grupo = grupoFacade.inserir(novoGrupo);
			if(grupo != null){
				JOptionPane.showMessageDialog(this.parent, 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_SUCCESS_ADD_GROUP), 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_MSG), JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.parent, 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_GROUP_ALRADY_REGISTRED), 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_MSG), JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	/**
	 * Responsável por remover um grupo. Quando um
	 * grupo do usuário é removido, todos os seus contatos
	 * são atualizados para um grupo default.
	 */
	public void removerGrupo() {
		GrupoFacadeImpl grupoFacade = new GrupoFacadeImpl();
		List<Grupo> grupos = grupoFacade.listar();
		Object res = JOptionPane.showInputDialog(this.parent, 
				LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_CHOOSE_GROUP), 
				LanguageUtil.getInstance().getMessage(LanguageUtil.LB_REMOVE_GROUP), 
				JOptionPane.PLAIN_MESSAGE, null, grupos.toArray(), null);
		if(res != null){
			for(int i = 0; i < grupos.size(); i++){
				if(grupos.get(i).getDescricao().equals(res.toString())){
					grupoFacade.remover(grupos.get(i));
					JOptionPane.showMessageDialog(this.parent, 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_SUCCESS_REMOVE_GROUP), 
						LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_MSG), JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
		}
	}
}
//#endif
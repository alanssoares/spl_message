//#if ${Status} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.com.message.enums.EnumStatusUsuario;
import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Usuario;
import br.com.message.util.DataStore;
import br.com.message.util.LanguageUtil;

/**
 * @author alsoares
 *
 */
public class FStatus {

	private UsuarioFacade userFacade = new UsuarioFacadeImpl();
	private Component parent;

	public FStatus(Component parent) {
		this.parent = parent;
	}
	
	/**
	 * Método responsável por mostrar o status
	 */
	public void mostrarStatus() {
		Usuario usuario = DataStore.getInstance().getUsuario();
		String status = EnumStatusUsuario.getStatusById(usuario.getIdStatus()).getDescricao();
		JOptionPane.showMessageDialog(this.parent, status, "Status", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Método responsável por alterar o status
	 * do usuário
	 */
	public void alterarStatus() {
		Usuario user = DataStore.getInstance().getUsuario();
		Object selected = null;
		Object[] options = new Object[EnumStatusUsuario.values().length];
		int i = 0;
		
		for(EnumStatusUsuario item : EnumStatusUsuario.values()){
			options[i++] = item.getDescricao();
			if(item.getId() == user.getIdStatus()){
				selected = item.getDescricao();
			}
		}
		
		Object res = JOptionPane.showInputDialog(parent, 
				LanguageUtil.getInstance().getMessage(LanguageUtil.TIT_CHOOSE_STATUS), 
				LanguageUtil.getInstance().getMessage(LanguageUtil.LB_ALTER_STATUS), 
				JOptionPane.PLAIN_MESSAGE, null, options, selected);
		if(res != null){
			for(EnumStatusUsuario item : EnumStatusUsuario.values()){
				if(item.getDescricao().equals(res)){
					user.setIdStatus(item.getId());
					userFacade.update(user);
					JOptionPane.showMessageDialog(this.parent, 
							LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_STATUS_ALTER_SUCCESS), 
							LanguageUtil.getInstance().getMessage(LanguageUtil.MSG_MSG), JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
		}
	}
}
//#endif
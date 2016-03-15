/**
 * 
 */
package br.com.message.util;

import br.com.message.enums.EnumStatusUsuario;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public class DataStore {

	private static DataStore instance;
	private Usuario usuario;
	
	private DataStore(){
		//Not implemented
	}
	
	public static synchronized DataStore getInstance(){
		if(instance == null){
			instance = new DataStore();
		}
		return instance;
	}

	/**
	 * Return the usuario
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Setter the usuario
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.usuario.setIdStatus(EnumStatusUsuario.DISPONIVEL.getId());
		new UsuarioFacadeImpl().update(this.usuario);
	}
	
	public void logout(){
		this.usuario.setIdStatus(EnumStatusUsuario.APARECER_AUSENTE.getId());
		new UsuarioFacadeImpl().update(this.usuario);
	}
}

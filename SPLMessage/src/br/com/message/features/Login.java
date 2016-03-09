/**
 * 
 */
package br.com.message.features;

import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public class Login {

	private static UsuarioFacade usuarioFacade = new UsuarioFacadeImpl();
	
	public static boolean authenticate(String email, String password){
		Usuario usuario = usuarioFacade.authenticate(email, password);
		if(usuario != null){
			return true;
		}
		return false;
	}
}

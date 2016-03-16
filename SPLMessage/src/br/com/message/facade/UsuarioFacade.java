/**
 * 
 */
package br.com.message.facade;

import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public interface UsuarioFacade {

	Usuario authenticate(String email, String password);
	
	Usuario inserir(Usuario usuario);
	
	void update(Usuario usuario);
	
	Usuario findByEmail(String email);
}

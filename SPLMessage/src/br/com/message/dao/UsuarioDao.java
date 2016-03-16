/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public interface UsuarioDao {

	Usuario authenticate(String email, String password);

	Usuario insertUser(Usuario usuario);

	void updateUser(Usuario usuario);

	Usuario findByEmail(String email);
}

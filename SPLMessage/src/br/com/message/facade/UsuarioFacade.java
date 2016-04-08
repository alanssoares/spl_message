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

	/**
	 * Método responsável por autenticar o usuário
	 * @param email do usuário
	 * @param password do usuário
	 * @return Usuario
	 */
	Usuario authenticate(String email, String password);
	
	/**
	 * Método responsável por inserir um novo usuário
	 * @param usuario
	 * @return Usuario
	 */
	Usuario inserir(Usuario usuario);
	
	/**
	 * Método responsável por atualizar os dados do usuário
	 * @param usuario
	 */
	void update(Usuario usuario);
	
	/**
	 * Método responsável por buscar o usuário por email
	 * @param email
	 * @return Usuario
	 */
	Usuario findByEmail(String email);
}

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

	/**
	 * Método responsável por autenticar o usuário
	 * @param email do usuário
	 * @param password do usuário
	 * @return Usuario
	 */
	Usuario authenticate(String email, String password);

	/**
	 * Método responsável por cadastrar um novo usuário
	 * @param usuario a ser cadastrado
	 * @return Usuario
	 */
	Usuario insertUser(Usuario usuario);

	/**
	 * Método responsável por atualizar os dados do usuário
	 * @param usuario a ser atualizado
	 */
	void updateUser(Usuario usuario);

	/**
	 * Método responsável por buscar o usuário por email
	 * @param email usado para busca
	 * @return Usuario
	 */
	Usuario findByEmail(String email);
}

/**
 * 
 */
package br.com.message.facade;

import br.com.message.dao.UsuarioDao;
import br.com.message.dao.UsuarioDaoImpl;
import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public class UsuarioFacadeImpl implements UsuarioFacade {

	private UsuarioDao usuarioDao = new UsuarioDaoImpl();

	@Override
	public Usuario authenticate(String email, String password) {
		return usuarioDao.authenticate(email, password);
	}
}

/**
 * 
 */
package br.com.message.facade;

import java.util.Date;

import br.com.message.dao.UsuarioDao;
import br.com.message.dao.UsuarioDaoImpl;
import br.com.message.enums.EnumStatusUsuario;
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

	@Override
	public Usuario inserir(Usuario usuario) {
		usuario.setIdStatus(EnumStatusUsuario.APARECER_AUSENTE.getId());
		usuario.setDataInclusao(new Date());
		return usuarioDao.insertUser(usuario);
	}

	@Override
	public Usuario recuperarSenha(Usuario usuario) {
		return usuarioDao.recoveryPassword(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioDao.updateUser(usuario);
	}
}
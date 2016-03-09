package br.com.message.dao;

import br.com.message.model.Usuario;

public class UsuarioDaoImpl extends GenericDao<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}

	@Override
	public Usuario authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}

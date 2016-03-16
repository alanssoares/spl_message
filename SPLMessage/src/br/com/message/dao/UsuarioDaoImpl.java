package br.com.message.dao;

import java.util.List;

import br.com.message.model.Usuario;

@SuppressWarnings("unchecked")
public class UsuarioDaoImpl extends GenericDao<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}
	
	@Override
	public Usuario authenticate(String email, String password) {
		List<Usuario> lista = this.entityManager.createQuery(
				"FROM usuario u WHERE u.email = :email AND u.senha = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getResultList();
		if(lista.isEmpty()){
			return null;
		}
		return lista.get(0);
	}

	@Override
	public Usuario insertUser(Usuario usuario) {
		return insert(usuario);
	}

	@Override
	public void updateUser(Usuario usuario) {
		update(usuario);
	}

	@Override
	public Usuario findByEmail(String email) {
		List<Usuario> lista = this.entityManager.createQuery(
				"FROM usuario u WHERE u.email = :email")
				.setParameter("email", email)
				.getResultList();
		if(lista.isEmpty()){
			return null;
		}
		return lista.get(0);
	}
}

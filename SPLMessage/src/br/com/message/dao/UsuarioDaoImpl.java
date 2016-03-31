package br.com.message.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.message.model.Usuario;

@SuppressWarnings("unchecked")
public class UsuarioDaoImpl extends GenericDao<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}
	
	@Override
	public Usuario authenticate(String email, String password) {
		EntityManager em = getEntityManager();
		List<Usuario> lista = em.createQuery(
				"FROM usuario u WHERE u.email = :email AND u.senha = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getResultList();
		em.close();
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
		EntityManager em = getEntityManager();
		List<Usuario> lista = em.createQuery(
				"FROM usuario u WHERE u.email = :email")
				.setParameter("email", email)
				.getResultList();
		em.close();
		if(lista.isEmpty()){
			return null;
		}
		return lista.get(0);
	}
}

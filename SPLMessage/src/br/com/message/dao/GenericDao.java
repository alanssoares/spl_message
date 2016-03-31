/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.message.util.Constantes;

/**
 * @author webstore
 *
 */
public abstract class GenericDao<T, I> {
	
	private EntityManagerFactory entityFactory;
	
	private Class<T> persistedClass;

	protected GenericDao() {
		this.entityFactory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);
	}

	protected GenericDao(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T insert(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(entity);
		em.flush();
		t.commit();
		em.close();
		return entity;
	}

	public T update(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(entity);
		em.flush();
		t.commit();
		em.close();
		return entity;
	}

	public void remove(I id) {
		T entity = find(id);
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		T mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.flush();
		tx.commit();
		em.close();
	}

	public List<T> getList() {
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		List<T> t = em.createQuery(query).getResultList();
		em.close();
		return t;
	}

	public T find(I id) {
		return getEntityManager().find(persistedClass, id);
	}
	
	public EntityManager getEntityManager(){
		return entityFactory.createEntityManager();
	}
}

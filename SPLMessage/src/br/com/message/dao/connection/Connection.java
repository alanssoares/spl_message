/**
 * 
 */
package br.com.message.dao.connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class Connection {

	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(){
		if(entityManager == null){
			entityManager = Persistence.createEntityManagerFactory(Constantes.NAME_DB).createEntityManager();			 
		}
		return entityManager;
	}
	
}
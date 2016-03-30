/**
 * 
 */
package br.com.message.dao.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class Connection {

	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManager(){
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);			 
		}
		return entityManagerFactory;
	}
	
}
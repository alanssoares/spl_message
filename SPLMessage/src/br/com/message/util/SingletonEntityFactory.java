/**
 * 
 */
package br.com.message.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author alsoares
 *
 */
public class SingletonEntityFactory {

	private static SingletonEntityFactory instance;
	private static EntityManagerFactory factory;
	
	private SingletonEntityFactory(){
		//NOT IMPLEMENTED
	}
	
	public static synchronized SingletonEntityFactory getInstance(){
		if(instance == null){
			instance = new SingletonEntityFactory();
			factory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);
		}
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		return factory;
	}
}

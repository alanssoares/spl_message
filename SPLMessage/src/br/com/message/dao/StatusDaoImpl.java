/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Status;

/**
 * @author alsoares
 *
 */
public class StatusDaoImpl extends GenericDao<Status, Integer> implements StatusDao {
	
	public StatusDaoImpl() {
		super(Status.class);
	}
}

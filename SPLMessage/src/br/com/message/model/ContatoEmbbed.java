/**
 * 
 */
package br.com.message.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author alsoares
 *
 */
@Embeddable
public class ContatoEmbbed implements Serializable {
	
	/**
	 * Verison name 
	 */
	private static final long serialVersionUID = 8487285796253191963L;
	
	@Column(name="email_usuario", nullable=false)
	private String emailUsuario;
	
	@Column(name="email_contato", nullable=false)
	private String emailContato;

	/**
	 * Return the emailUsuario
	 * @return the emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * Setter the emailUsuario
	 * @param emailUsuario the emailUsuario to set
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * Return the emailContato
	 * @return the emailContato
	 */
	public String getEmailContato() {
		return emailContato;
	}

	/**
	 * Setter the emailContato
	 * @param emailContato the emailContato to set
	 */
	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
}

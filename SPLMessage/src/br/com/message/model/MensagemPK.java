/**
 * 
 */
package br.com.message.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 * @author alsoares
 *
 */
@Embeddable
public class MensagemPK implements Serializable {

	/**
	 * Default version
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="email_usuario", nullable=false)
	@JoinColumn(name="email_usuario", referencedColumnName="email", table="usuario")
	private String emailUsuario;
	
	@Column(name="email_contato", nullable=false)
	@JoinColumn(name="email_contato", referencedColumnName="email", table="usuario")
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailContato == null) ? 0 : emailContato.hashCode());
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemPK other = (MensagemPK) obj;
		if (emailContato == null) {
			if (other.emailContato != null)
				return false;
		} else if (!emailContato.equals(other.emailContato))
			return false;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		return true;
	}
}
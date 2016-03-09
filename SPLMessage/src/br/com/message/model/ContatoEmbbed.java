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
	
	@Column(name="id_usuario", nullable=false)
	private Integer idUsuario;
	
	@Column(name="id_contato", nullable=false)
	private Integer idContato;
	
	@Column(name="id_grupo", nullable=false)
	private Integer idGrupo;
	
	/**
	 * Return the idUsuario
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Setter the idUsuario
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Return the idContato
	 * @return the idContato
	 */
	public Integer getIdContato() {
		return idContato;
	}
	/**
	 * Setter the idContato
	 * @param idContato the idContato to set
	 */
	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	/**
	 * Return the idGrupo
	 * @return the idGrupo
	 */
	public Integer getIdGrupo() {
		return idGrupo;
	}
	/**
	 * Setter the idGrupo
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
}

/**
 * 
 */
package br.com.message.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author alsoares
 *
 */
@Entity(name="contato")
@Table(name="contato")
public class Contato {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="id_usuario", nullable=false)
	private Integer idUsuario;
	
	@Column(name="id_contato", nullable=false)
	private Integer idContato;
	
	@Column(name="id_grupo", nullable=false)
	private Integer idGrupo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date dataInclusao;
	
	/**
	 * Return the id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter the id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
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
	/**
	 * Return the dataInclusao
	 * @return the dataInclusao
	 */
	public Date getDataInclusao() {
		if(dataInclusao != null){
			return (Date) dataInclusao.clone();
		}
		return null;
	}
	/**
	 * Setter the dataInclusao
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		if(dataInclusao != null){
			this.dataInclusao = (Date) dataInclusao.clone();
		}
	}
}

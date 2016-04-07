/**
 * 
 */
package br.com.message.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author alsoares
 *
 */
@Entity(name="comentario")
@Table(name="comentario")
public class Comentario {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="assunto", nullable=false, length=255)
	private String assunto;
	
	@Column(name="tipo", nullable=false)
	private Integer tipo;
	
	@JoinColumn(name="email_usuario", referencedColumnName="email", table="usuario", nullable=false)
	private String emailUsuario;
	
	@Column(name="descricao", nullable=false, length=1000)
	private String	descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date	dataInclusao;
	
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
	 * Return the assunto
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}
	/**
	 * Setter the assunto
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	/**
	 * Return the tipo
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}
	/**
	 * Setter the tipo
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
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
	 * Return the descricao
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Setter the descricao
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * Return the dataInclusao
	 * @return the dataInclusao
	 */
	public Date getDataInclusao() {
		return dataInclusao;
	}
	/**
	 * Setter the dataInclusao
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}

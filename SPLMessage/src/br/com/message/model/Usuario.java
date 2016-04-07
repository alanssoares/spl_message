/**
 * 
 */
package br.com.message.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.message.enums.EnumStatusUsuario;

/**
 * @author alsoares
 *
 */
@Entity(name="usuario")
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="email", nullable=false, length=255)
	private String email;
	
	@Column(name="nome", nullable=false, length=255)
	private String nome;
	
	@Column(name="senha", nullable=false, length=25)
	private String senha;
	
	@Column(name="id_status", nullable=false)
	@JoinColumn(name="id_status", referencedColumnName="id", table="status_usuario")
	private Integer idStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date dataInclusao;
	
	/**
	 * Return the nome
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Setter the nome
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Return the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter the email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Return the senha
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Setter the senha
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Return the idStatus
	 * @return the idStatus
	 */
	public Integer getIdStatus() {
		return idStatus;
	}
	/**
	 * Setter the idStatus
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
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
	
	@Override
	public String toString() {
		return "Email: " + email + " Status: " + EnumStatusUsuario.getStatusById(idStatus).getDescricao();
	}
}

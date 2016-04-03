/**
 * 
 */
package br.com.message.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	
	@EmbeddedId
	private ContatoPK contatoPK;
	
	@Column(name="id_grupo", nullable=false)
	private Integer idGrupo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date dataInclusao;
	
	public Contato() {
		this.contatoPK = new ContatoPK();
	}
	
	public Contato(String emailUsuario, String emailContato) {
		this.contatoPK = new ContatoPK(emailUsuario, emailContato);
	}

	/**
	 * Return the contatoPK
	 * @return the contatoPK
	 */
	public ContatoPK getContatoPK() {
		return contatoPK;
	}
	/**
	 * Setter the contatoPK
	 * @param contatoPK the contatoPK to set
	 */
	public void setContatoPK(ContatoPK contatoPK) {
		this.contatoPK = contatoPK;
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
	/**
	 * Especifica o email do contato
	 * @param emailContato
	 */
	public void setEmailContato(String emailContato){
		this.contatoPK.setEmailContato(emailContato);
	}
	/**
	 * Retorna emailContato
	 * @return String
	 */
	public String setEmailContato(){
		return this.contatoPK.getEmailContato();
	}
	/**
	 * Especifica emailUsuario
	 * @param emailUsuario
	 */
	public void setEmailUsuario(String emailUsuario){
		this.contatoPK.setEmailUsuario(emailUsuario);
	}
	/**
	 * Retorna emailUsuario
	 * @return String
	 */
	public String getEmailUsuario(){
		return this.contatoPK.getEmailUsuario();
	}

	/**
	 * Return emailContato
	 * @return
	 */
	public String getEmailContato() {
		return this.contatoPK.getEmailContato();
	}
}

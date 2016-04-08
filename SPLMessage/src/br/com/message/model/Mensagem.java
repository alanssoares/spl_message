/**
 * 
 */
package br.com.message.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Entity(name="mensagem")
@Table(name="mensagem")
public class Mensagem implements Serializable {

	/**
	 * Default version
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Integer id;
	
	@EmbeddedId
	private MensagemPK mensagemPK;
	
	@Column(name="descricao", nullable=false, length=1000)
	private String	descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date dataInclusao;
	
	@Column(name="enviada", nullable=false)
	private Integer enviada;
	
	@Column(name="lida", nullable=false)
	private Integer lida;
	
	public Mensagem() {
		mensagemPK = new MensagemPK();
	}
	
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
	 * Return the mensagemPK
	 * @return the mensagemPK
	 */
	public MensagemPK getMensagemPK() {
		return mensagemPK;
	}
	/**
	 * Setter the mensagemPK
	 * @param mensagemPK the mensagemPK to set
	 */
	public void setMensagemPK(MensagemPK mensagemPK) {
		this.mensagemPK = mensagemPK;
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

	/**
	 * Setter the emailUsuario
	 * @param emailUsuario
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.mensagemPK.setEmailUsuario(emailUsuario);
	}
	
	/**
	 * Setter the emailUsuario
	 * @param emailContato
	 */
	public void setEmailContato(String emailContato) {
		this.mensagemPK.setEmailContato(emailContato);
	}
	
	/**
	 * Getter the emailUsuario
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return this.mensagemPK.getEmailUsuario();
	}
	
	/**
	 * Getter the emailUsuario
	 * @return emailContato
	 */
	public String getEmailContato() {
		return this.mensagemPK.getEmailContato();
	}

	/**
	 * Return the enviada
	 * @return the enviada
	 */
	public Integer getEnviada() {
		return enviada;
	}

	/**
	 * Setter the enviada
	 * @param enviada the enviada to set
	 */
	public void setEnviada(Integer enviada) {
		this.enviada = enviada;
	}

	/**
	 * Return the lida
	 * @return the lida
	 */
	public Integer getLida() {
		return lida;
	}

	/**
	 * Setter the lida
	 * @param lida the lida to set
	 */
	public void setLida(Integer lida) {
		this.lida = lida;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mensagemPK == null) ? 0 : mensagemPK.hashCode());
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
		Mensagem other = (Mensagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mensagemPK == null) {
			if (other.mensagemPK != null)
				return false;
		} else if (!mensagemPK.equals(other.mensagemPK))
			return false;
		return true;
	}
}

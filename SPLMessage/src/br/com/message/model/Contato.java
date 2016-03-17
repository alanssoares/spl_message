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
	private ContatoEmbbed chaveComposta;
	
	@Column(name="id_grupo", nullable=false)
	private Integer idGrupo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable=false)
	private Date dataInclusao;
	
	/**
	 * Return the chaveComposta
	 * @return the chaveComposta
	 */
	public ContatoEmbbed getChaveComposta() {
		return chaveComposta;
	}
	/**
	 * Setter the chaveComposta
	 * @param chaveComposta the chaveComposta to set
	 */
	public void setChaveComposta(ContatoEmbbed chaveComposta) {
		this.chaveComposta = chaveComposta;
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

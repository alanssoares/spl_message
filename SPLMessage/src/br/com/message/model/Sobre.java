/**
 * 
 */
package br.com.message.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author alsoares
 *
 */
@Entity(name="sobre")
@Table(name="sobre")
public class Sobre {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="descricao", nullable=false, length=2500)
	private String descricao;
	
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
}

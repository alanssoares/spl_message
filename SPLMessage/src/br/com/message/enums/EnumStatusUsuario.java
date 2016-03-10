/**
 * 
 */
package br.com.message.enums;

/**
 * @author alsoares
 *
 */
public enum EnumStatusUsuario {

	DISPONIVEL(1),
	OCUPADO(2),
	NAO_INCOMODAR(3),
	VOLTO_LOGO(4),
	AUSENTE_DO_TRABALHO(5),
	APARECER_AUSENTE(6);
	
	private EnumStatusUsuario(int id) {
		this.id = id;
	}
	
	private int id;
	
	public int getId(){
		return id;
	}
	
}

/**
 * 
 */
package br.com.message.enums;


/**
 * @author alsoares
 *
 */
public enum EnumStatusUsuario {

	DISPONIVEL(1, "Disponível"),
	OCUPADO(2, "Ocupado"),
	NAO_INCOMODAR(3, "Não Incomodar"),
	VOLTO_LOGO(4, "Volto Logo"),
	AUSENTE_DO_TRABALHO(5, "Ausente do Trabalho"),
	APARECER_AUSENTE(6, "Ausente");
	
	private EnumStatusUsuario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	private int id;
	private String descricao;
	
	public int getId(){
		return id;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public static EnumStatusUsuario getStatusById(int id){
		for(EnumStatusUsuario status : EnumStatusUsuario.values()){
			if(status.getId() == id) return status;
		}
		//The default status
		return APARECER_AUSENTE;
	}
	
}

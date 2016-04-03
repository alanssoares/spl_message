/**
 * 
 */
package br.com.message.enums;

/**
 * @author alsoares
 *
 */
public enum EnumEmoction {

	ALEGRE("<(^.^)>"),
	TRISTE("<(_._)>"),
	RAIVA("<(-.-)>"),
	ENCANTADO("<(*.*)>"),
	DINHEIRO("<($.$)>");
	
	/**
	 * Constructor
	 * @param emoction
	 */
	private EnumEmoction(String emoction) {
		this.emoction = emoction;
	}
	
	private String emoction;

	/**
	 * Return the emoction
	 * @return the emoction
	 */
	public String getEmoction() {
		return emoction;
	}
}

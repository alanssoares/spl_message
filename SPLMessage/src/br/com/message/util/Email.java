/**
 * 
 */
package br.com.message.util;

/**
 * @author alsoares
 *
 */
public class Email {

	private String from;
	private String to;
	private String subject;
	private String text;
	/**
	 * Return the from
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * Setter the from
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * Return the to
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * Setter the to
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * Return the subject
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * Setter the subject
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * Return the text
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * Setter the text
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}

/**
 * 
 */
package br.com.message.views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author alsoares
 *
 */
public class MainScreen {
	
	public static void main(String[] args) {
		final LoginScreen login = new LoginScreen();
		login.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
/**
 * 
 */
package br.com.message.views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.message.features.FLoginScreen;

/**
 * @author alsoares
 *
 */
public class MainScreen {
	
	public static void main(String[] args) {
		final FLoginScreen login = new FLoginScreen();
		login.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
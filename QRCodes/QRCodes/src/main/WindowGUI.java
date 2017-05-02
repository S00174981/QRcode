/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

import java.awt.Color;
import javax.swing.*;

/**
 * This class creates the first content our menu.
 */
public class WindowGUI extends JFrame{
	private static final long serialVersionUID = 1L;

	/**Add components.*/
	public void buildGUI(){ 
		this.setTitle("QRCode");
	    this.setSize(600, 600);
	    setIconImage(new ImageIcon("./src/main/resources/images/myQRCode.png").getImage());
	    this.setBackground(Color.white);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(new Component());
	    this.setVisible(true);
	}
}

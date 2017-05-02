/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

/**
	This class adds all the components we need in our frames.
*/
public class Component extends JPanel{
	private static final long serialVersionUID = 1L;
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JTextField jtf = new JTextField("English");
	JTextField jtf1 = new JTextField("E1006");
	JTextField jtf2 = new JTextField("9:00");
	JTextField jtf3 = new JTextField("10:20");
	JTextField jtf4 = new JTextField("Friday");
	JLabel label = new JLabel("New Subject");
	JLabel label1 = new JLabel("New Room  ");
	JLabel label2 = new JLabel("New Time    ");
	JLabel label3 = new JLabel("New Date    ");
	JLabel label4 = new JLabel(" to ");
	
	/**
		This method displays background of the frame.
	 */
	public void paintComponent(Graphics g){
		try {
		      Image img = ImageIO.read(new File("./src/main/resources/images/itSligo.jpeg"));
		      g.drawImage(img, 110, 0, this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.black);          
	    g.drawString("What do you want to do?", 10, 200);
	    g.drawString("Rev 1 by DESHAYES, KOENIG, CAMBON", 100, 550);
	    menu();
	  }
	
	/**
		This method creates menu with 3 buttons and their placement.
	 */
	public void menu(){
	    JPanel cell1 = new JPanel();
	    JButton b1 = new JButton("Create a new QRCode");
	    cell1.add(b1);
	    cell1.setPreferredSize(new Dimension(200, 40));
	    cell1.setBackground(Color.WHITE);
	    JPanel cell2 = new JPanel();
	    JButton b2 = new JButton("Modify an exisiting QRCode");
	    cell2.add(b2);
	    cell2.setPreferredSize(new Dimension(200, 40));
	    cell2.setBackground(Color.WHITE);
	    JPanel cell3 = new JPanel();
	    JButton b3 = new JButton("Display a QRCode");
	    cell3.add(b3);
	    cell3.setPreferredSize(new Dimension(200, 40));
	    cell3.setBackground(Color.WHITE);
 
	    this.setLayout(new GridBagLayout());
			
	    GridBagConstraints gbc = new GridBagConstraints();

	    gbc.gridx = 0;
	    gbc.gridy = 0;

	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    this.add(cell1, gbc);
	    //---------------------------------------------
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(cell2, gbc);
	  //---------------------------------------------
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(cell3, gbc);
	    
	    b1.addActionListener(new Create());
		b2.addActionListener(new Error());
		b3.addActionListener(new Information());
	}
	
	/**
		This method opens a new window which call another methods "Display()" and "Sound()".
	 */
	class Information implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			JFrame frame = new JFrame();
			JButton b = new JButton("Play Sound");
			frame.setTitle(Main.theSubject);
			frame.setSize(350, 350);
			frame.setIconImage(new ImageIcon("./src/main/resources/images/myQRCode.png").getImage());
			frame.setBackground(Color.white);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setContentPane(new Display());
			frame.add(b);
			b.addActionListener(new Sound());
			frame.setVisible(true);
		}
	}
	
	/**
		This method plays sound with the direction of the concern room.
	 */
	class Sound implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			// get directions
		 	if (Main.directions.validate(Main.theRoom) == false) {
		 		System.out.println("The directions to this room are unknown");
		 	}
		 	else {
		 		System.out.println("DIRECTIONS");
		 		System.out.println(Main.directions.toBuilding());
		 		System.out.println(Main.directions.toFloor());
		 		System.out.println(Main.directions.toLocation());
		 	}
		}
	}
	
	/**
		This method allows to add new information for a new QRCode.
	 */
	class Create implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			JFrame frame = new JFrame();
			JButton b = new JButton ("OK");
			frame.setTitle("Creating");
			frame.setSize(300, 220);
			frame.setIconImage(new ImageIcon("./src/main/resources/images/myQRCode.png").getImage());
			frame.setBackground(Color.white);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
		    JPanel top = new JPanel();
		    Font police = new Font("Arial", Font.PLAIN, 20);
		    Font police1 = new Font("TimesRoman", Font.PLAIN, 20);
		    label.setFont(police1);
		    jtf.setFont(police);
		    jtf.setPreferredSize(new Dimension(180, 30));
		    jtf.setForeground(Color.BLUE);
		    label1.setFont(police1);
		    jtf1.setFont(police);
		    jtf1.setPreferredSize(new Dimension(180, 30));
		    jtf1.setForeground(Color.BLUE);
		    label2.setFont(police1);
		    jtf2.setFont(police);
		    jtf2.setPreferredSize(new Dimension(60, 30));
		    jtf2.setForeground(Color.BLUE);
		    jtf3.setFont(police);
		    label4.setFont(police1);
		    jtf3.setPreferredSize(new Dimension(60, 30));
		    jtf3.setForeground(Color.BLUE);
		    label3.setFont(police1);
		    jtf4.setFont(police);
		    jtf4.setPreferredSize(new Dimension(180, 30));
		    jtf4.setForeground(Color.BLUE);
		    top.add(label);
		    top.add(jtf);
		    top.add(label1);
		    top.add(jtf1);
		    top.add(label2);
		    top.add(jtf2);
		    top.add(label4);
		    top.add(jtf3);
		    top.add(label3);
		    top.add(jtf4);
		    top.add(b);
		    b.addActionListener(new AddInformation());
		    frame.setContentPane(top);
			frame.setVisible(true);
		}
	}
	
	/**
		This method recalls create() method which is in the Main class to create a new QRCode.
	 */
	class AddInformation implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			Main.qrCodeData = "Day: "+jtf4.getText()+"\nTime: "+jtf2.getText()+" to "+jtf3.getText()+"\nSubject: "+jtf.getText()+"\nRoom: "+jtf1.getText();
			try {
				Main.create();
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
		This method opens an error window when you click on "Modify an existing QRCode".
	 */
	class Error implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			JOptionPane.showMessageDialog(null, "In development...", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}

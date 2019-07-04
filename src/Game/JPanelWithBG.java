package Game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelWithBG extends JPanel {
	Image image; 
	public JPanelWithBG(String r) {
		ImageIcon img = new ImageIcon(r);
		image = img.getImage();
	}
	
	// background image
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), this);
	}
}

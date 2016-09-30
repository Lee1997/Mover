package pack;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Render extends JPanel{
	
	@Override
	public void paint(Graphics g){
		super.paintComponent(g);
		mover.m.render((Graphics2D) g);
	}
	
	
	
	
}

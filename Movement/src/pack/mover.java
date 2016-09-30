package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class mover implements ActionListener, KeyListener{
	public static mover m;
	public JFrame frame;
	public Render r;
	public Timer timer;
	public int x = 50, y = 50;
	boolean left = false, right = false, up = false, down = false;
	public final int SPEED = 10;
	
	
	public static void main(String[] args) {
		m = new mover();
	}
	
	public mover(){
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mover");
		Dimension dim = new Dimension();
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
		r = new Render();
		frame.add(r);
		frame.addKeyListener(this);
		
		timer = new Timer(20, this);
		timer.start();
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 50, 50);
		
	}
	
	public void update(){
		if(up && y > 0)
			y -= SPEED;
		else if(down && y < frame.getHeight() - 80)
			y += SPEED;
		else if(left && x > 0)
			x -= SPEED;
		else if(right && x < frame.getWidth() - 60)
			x += SPEED;
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int id = e.getKeyCode();
		
		if(id == KeyEvent.VK_UP)
			up = true;
		else if(id == KeyEvent.VK_DOWN)
			down = true;
		else if(id == KeyEvent.VK_LEFT)
			left = true;
		else if(id == KeyEvent.VK_RIGHT)
			right = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int id = e.getKeyCode();
		
		if(id == KeyEvent.VK_UP)
			up = false;
		else if(id == KeyEvent.VK_DOWN)
			down = false;
		else if(id == KeyEvent.VK_LEFT)
			left = false;
		else if(id == KeyEvent.VK_RIGHT)
			right = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		update();
		r.repaint();
		
	}
	
	
}

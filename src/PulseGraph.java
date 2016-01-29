import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PulseGraph extends Canvas{

	public PulseGraph () {
		setBackground (Color.GRAY);
		setSize(300, 300);
	}

	public void paint (Graphics g) {
		
		g.drawArc(0, 0, getWidth(), getHeight(), 80, 10); 
	}


}
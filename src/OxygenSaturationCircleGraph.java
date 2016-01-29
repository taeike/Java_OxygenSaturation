import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class OxygenSaturationCircleGraph extends JPanel{
	
	private int _oxygenSaturationValue = 95;
	public final static int _circleGraphWidth = 200;
	public final static int _circleGraphHeight= 200;
	
	public OxygenSaturationCircleGraph() {
		
	}
	public void setUp_GUI(){
		this.setSize(_circleGraphWidth,_circleGraphHeight);
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.white);
		g2d.fillOval(0,0,_circleGraphWidth,_circleGraphHeight);
		
		if(_oxygenSaturationValue > 94) g2d.setColor(Color.green); //정상수치
		else g2d.setColor(Color.RED);//비정상 수치
		g2d.fillOval(15,15,_circleGraphWidth-30,_circleGraphHeight-30);
		
		g2d.setFont(new Font("Arial",Font.BOLD ,120));
		if(_oxygenSaturationValue > 94) g2d.setColor(Color.white); //정상수치
		else g2d.setColor(Color.black);//비정상 수치
		g2d.drawString(String.valueOf(_oxygenSaturationValue),35,140);
		
	}
	//******************get,set**********************************
	public int get_oxygenSaturationValue() {
		return _oxygenSaturationValue;
	}
	public void set_oxygenSaturationValue(int _oxygenSaturationValue) {
		this._oxygenSaturationValue = _oxygenSaturationValue;
	}
}

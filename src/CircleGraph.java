import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CircleGraph extends JPanel{
	
	private int _value = 95;
	private int _normalLevels= 0 ;
	private int _changeColor = 0;
	public final static int _circleGraphWidth = 200;
	public final static int _circleGraphHeight= 200;
	
	public CircleGraph(int _nomalLecels) {
		this._normalLevels = _nomalLecels;
	}
	public void setUp_GUI(){
		this.setSize(_circleGraphWidth,_circleGraphHeight);
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		if(_changeColor%3 == 0) g2d.setColor(Color.white);
		if(_changeColor%3 == 1) g2d.setColor(new Color(0,153,153));
		if(_changeColor%3 == 2) g2d.setColor(new Color(255,204,051));
		g2d.fillOval(0,0,_circleGraphWidth,_circleGraphHeight);
		
		if(_value > _normalLevels) g2d.setColor(Color.ORANGE); //정상수치
		else g2d.setColor(Color.RED);//비정상 수치
		g2d.fillOval(15,15,_circleGraphWidth-30,_circleGraphHeight-30);
		
		g2d.setFont(new Font("Arial",Font.BOLD ,120));
		if(_value > _normalLevels){
			if(_changeColor%3 == 0) g2d.setColor(Color.white);
			if(_changeColor%3 == 1) g2d.setColor(new Color(0,153,153));
			if(_changeColor%3 == 2) g2d.setColor(new Color(255,204,051));
		}
		else g2d.setColor(Color.black);//비정상 수치
		g2d.drawString(String.valueOf(_value),35,140);
		
	}
	//******************get,set**********************************
	public void set_Value(int _value) {
		this._value = _value;
	}
	public void changeColor(){
		if(_changeColor+1 < 4 ) this._changeColor+=1;
		else _changeColor = 0;
	}
	
}

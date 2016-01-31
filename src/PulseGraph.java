import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

public class PulseGraph extends JPanel{
	
	public final static int GRAPH_WIDTH = 700;
	public final static int GRAPH_HEIGHT= 300;
	private int   _graphCycle=30;
	private int   _position=1;
	private int   _top = 20;
	private int   _clear = 0;
	private int   _changeColor = 0;
	Vector<QuadCurve2D> _data = new Vector<QuadCurve2D>();

	public PulseGraph(){
		preparData();
		DrawGraph d = new DrawGraph();
		d.start();
		setSize(GRAPH_WIDTH,GRAPH_HEIGHT);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.ORANGE);
		g2D.drawLine(0,GRAPH_HEIGHT/2,GRAPH_WIDTH,GRAPH_HEIGHT/2);
		g2D.fillRect(0, 0, GRAPH_WIDTH, GRAPH_HEIGHT);
		
		if(_changeColor%3 == 0) g2D.setColor(Color.white);
		if(_changeColor%3 == 1) g2D.setColor(new Color(0,153,153));
		if(_changeColor%3 == 2) g2D.setColor(new Color(255,204,051));
		g2D.setStroke(new BasicStroke(10));
		
		for(int i=0;i<_clear;i++){
			for(int j=0;j<i;j++){
				g2D.draw((QuadCurve2D) _data.elementAt(j));
				if(j==21){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	private void dd(){
		repaint();
	}
	private class DrawGraph extends Thread{
		@Override
		public void run() {
			while(true){
				
				if(_clear > 21){
					_position =1;
					_data.clear();
					_clear = 0;
				}
				else{
					_clear = _clear+1;
					_data.clear();
					_position = 1;
					preparData();
					try {
						this.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				dd(); 
			}
		}

	}
	private class PaintThread extends Thread{
		public PaintThread(){
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	
	}
	private void preparData(){

		_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
				(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+_top*0+30, 
				(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
		_position = _position+1;

		for(int i=1;i<5;i++){
			_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
					(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+_top*i+30, 
					(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
			_position = _position+1;

			_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
					(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2-_top*i+30, 
					(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
			_position = _position+1;
		}

		_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
											   (float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+(80*2)+30, 
											   (float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
		
		_position = _position+1;
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
											   (float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2-(80*4)+30, 
											   (float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
		_position = _position+1;
		
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
											   (float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+(80*2)+30, 
											   (float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
		_position = _position+1;
		for(int i=4;i>0;i--){
			_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
					(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2-_top*i+30, 
					(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
			_position = _position+1;

			_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
					(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+_top*i+30, 
					(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
			_position = _position+1;
		}
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphCycle,GRAPH_HEIGHT/2+30,
				(float)_position*_graphCycle+_graphCycle/2,GRAPH_HEIGHT/2+_top*0+30, 
				(float)_position*_graphCycle+_graphCycle,GRAPH_HEIGHT/2+30));
		_position = _position+1;
	}
	public void set_graphPeriodIncrease() {
		this._graphCycle = _graphCycle + 1 ;
	}
	public void set_graphPeriodDecrease() {
		this._graphCycle = _graphCycle - 1 ;
	}
	public void set_clear(int _clear) {
		this._clear = _clear;
	}
	public void changeColor(){
		if(_changeColor+1 < 4 ) this._changeColor+=1;
		else _changeColor = 0;
	}
}
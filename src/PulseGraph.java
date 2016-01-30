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

	private float _frontPulseWidthValue = 0;
	private float _frontPulseHeightValue = 0;
	private float _rearfrontPulseWidthValue = 0;
	private float _rearfrontPulseHeightValue = 0;
	private int   _graphPeriod=30;
	private int   _position=1;
	private int   _top = 20;
	private int   _clear = 0;

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
		g2D.setColor(Color.green);
		g2D.drawLine(0,GRAPH_HEIGHT/2,GRAPH_WIDTH,GRAPH_HEIGHT/2);
		g2D.fillRect(0, 0, GRAPH_WIDTH, GRAPH_HEIGHT);
		g2D.setColor(Color.white);
		g2D.setStroke(new BasicStroke(3));
		
		for(int i=0;i<_clear;i++){
			for(int j=0;j<i;j++){
				g2D.draw((QuadCurve2D) _data.elementAt(j));
				if(j==20){
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

		_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
				(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+_top*0, 
				(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
		_position = _position+1;

		for(int i=1;i<5;i++){
			_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
					(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+_top*i, 
					(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
			_position = _position+1;

			_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
					(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2-_top*i, 
					(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
			_position = _position+1;
		}

		_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
											   (float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+(70*2), 
											   (float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
		
		_position = _position+1;
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
											   (float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2-(70*4), 
											   (float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
		_position = _position+1;
		
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
											   (float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+(70*2), 
											   (float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
		_position = _position+1;
		for(int i=4;i>0;i--){
			_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
					(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2-_top*i, 
					(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
			_position = _position+1;

			_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
					(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+_top*i, 
					(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
			_position = _position+1;
		}
		_data.addElement(new QuadCurve2D.Float((float)_position*_graphPeriod,GRAPH_HEIGHT/2,
				(float)_position*_graphPeriod+_graphPeriod/2,GRAPH_HEIGHT/2+_top*0, 
				(float)_position*_graphPeriod+_graphPeriod,GRAPH_HEIGHT/2));
		_position = _position+1;
	}
	
}
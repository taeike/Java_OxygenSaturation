import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OxygenSaturationPanel extends JPanel{
	
	private JFrame _mainFrame;
	private CircleGraph _oxygenSaturationCircleGraph;
	private CircleGraph _heartRateCircleGraph;
	private PulseGraph _pulseGraph;
	private static final Random random = new Random();
	private JButton _clearButton;
	private JButton _changeGraphPeriodIncreaseButton;
	private JButton _changeGraphPeriodDecreaseButton;
	private JButton _changeColorButton;
	private int _changeColor=0;
	public OxygenSaturationPanel() {
		_oxygenSaturationCircleGraph = new CircleGraph(94);
		_pulseGraph = new PulseGraph();
		_heartRateCircleGraph = new CircleGraph(60);
		setUp_GUI();
	}
	
	private void setUp_GUI(){
		//Frame
		_mainFrame = new JFrame();
		_mainFrame.setLayout(null);
		_mainFrame.setBounds(Main._Start_FRAME_WIDTH,Main._Start_FRAME_HEIGHT,
				             Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
		//Panel
		this.setBounds(0,0,Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
		this.setLayout(null);
		//산소포화도 그래프 삽입.
		_oxygenSaturationCircleGraph.setBounds( 510,580,CircleGraph._circleGraphWidth,CircleGraph._circleGraphHeight);
		this.add(_oxygenSaturationCircleGraph);
		//심박수 원형 그래프 삽입.
		_heartRateCircleGraph.setBounds(515,70,CircleGraph._circleGraphWidth,CircleGraph._circleGraphHeight);
		this.add(_heartRateCircleGraph);
		//맥박 그래프 삽입.
		_pulseGraph.setBounds(90,275,PulseGraph.GRAPH_WIDTH,PulseGraph.GRAPH_HEIGHT);
		this.add(_pulseGraph);
		//clear
		_clearButton = new JButton("clear");
		_clearButton.setBounds(400, 0, 100, 100);
		_clearButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				_pulseGraph.set_clear(0);
			}
		});
		this.add(_clearButton);
		
		//changePeriodIcrease
		 _changeGraphPeriodIncreaseButton = new JButton("CycleIncrease");
		 _changeGraphPeriodIncreaseButton.setBounds(0, 0, 100, 100);
		 _changeGraphPeriodIncreaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_pulseGraph.set_graphPeriodIncrease();
			}
		});
		 this.add(_changeGraphPeriodIncreaseButton);
		 
		//changePeriodDecrease
		 _changeGraphPeriodDecreaseButton = new JButton("CycleDecrease");
		 _changeGraphPeriodDecreaseButton.setBounds(100, 0,100, 100);
		 _changeGraphPeriodDecreaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_pulseGraph.set_graphPeriodDecrease();
			}
		});
		this.add(_changeGraphPeriodDecreaseButton);
		
		 //changeColor
		_changeColorButton = new JButton("Color");
		_changeColorButton.setBounds(200, 0, 100, 100);
		_changeColorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_pulseGraph.changeColor();
				_oxygenSaturationCircleGraph.changeColor();
				_heartRateCircleGraph.changeColor();
				if(_changeColor+1 < 4 ) _changeColor = _changeColor+1;
				else _changeColor = 0;
				_mainFrame.repaint();
			}
		});
		this.add(_changeColorButton);
		
		_mainFrame.add(this);
		_mainFrame.setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.WHITE);
		g2D.fillRect(0,0,Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
		g2D.setColor(Color.ORANGE);
		g2D.fillOval(0, 0,Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
		
		if(_changeColor%3 == 0) g2D.setColor(Color.white);
		if(_changeColor%3 == 1) g2D.setColor(new Color(0,153,153));
		if(_changeColor%3 == 2) g2D.setColor(new Color(255,204,051));
		
		g2D.setFont(new Font("Arial",Font.BOLD ,80));
		g2D.drawString(" Heartrate", 130,160);
		g2D.setFont(new Font("Arial",Font.BOLD ,60));
		g2D.drawString("    per Minute", 110,220);
		
		g2D.setFont(new Font("Arial",Font.BOLD ,80));
		g2D.drawString("   Oxygen", 100,670);
		g2D.setFont(new Font("Arial",Font.BOLD ,70));
		g2D.drawString("  Saturation", 100,730);
	
	}
}

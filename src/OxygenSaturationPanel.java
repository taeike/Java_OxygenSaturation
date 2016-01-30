import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
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
	public OxygenSaturationPanel() {
		_oxygenSaturationCircleGraph = new CircleGraph();
		_pulseGraph = new PulseGraph();
		_heartRateCircleGraph = new CircleGraph();
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
		
		
		g2D.setFont(new Font("Arial",Font.BOLD ,80));
		g2D.setColor(Color.WHITE);
		g2D.drawString(" Heartrate", 130,160);
		g2D.setFont(new Font("Arial",Font.BOLD ,60));
		g2D.drawString("    per Minute", 110,220);
		
		g2D.setFont(new Font("Arial",Font.BOLD ,80));
		g2D.setColor(Color.WHITE);
		g2D.drawString("   Oxygen", 100,670);
		g2D.setFont(new Font("Arial",Font.BOLD ,70));
		g2D.drawString("  Saturation", 100,730);
	
	}
}

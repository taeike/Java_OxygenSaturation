import java.awt.Color;
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
	private PulseGraph _pulseGraph;
	private static final Random random = new Random();
	public OxygenSaturationPanel() {
		_oxygenSaturationCircleGraph = new CircleGraph();
		_pulseGraph = new PulseGraph();
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
		_oxygenSaturationCircleGraph.setBounds( 335,600,
			CircleGraph._circleGraphWidth,CircleGraph._circleGraphHeight);
		this.add(_oxygenSaturationCircleGraph);
		//맥박 그래프 삽입.
		_pulseGraph.setBounds(90,275,PulseGraph.GRAPH_WIDTH,PulseGraph.GRAPH_HEIGHT);
		this.add(_pulseGraph);
		
		_mainFrame.add(this);
		_mainFrame.setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.ORANGE);
		g2D.fillOval(0, 0,Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
	}
}

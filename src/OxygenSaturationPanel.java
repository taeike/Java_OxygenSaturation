import java.awt.Graphics;
import java.awt.Window;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OxygenSaturationPanel extends JPanel{
	
	private JFrame _mainFrame;
	private OxygenSaturationCircleGraph _oxygenSaturationCircleGraph;
	private PulseGraph _pulseGraph;
	private static final Random random = new Random();
	public OxygenSaturationPanel() {
		_oxygenSaturationCircleGraph = new OxygenSaturationCircleGraph();
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
		this.setBounds(Main._Start_FRAME_WIDTH,Main._Start_FRAME_HEIGHT,
	                   Main._FRAME_WIDTH,Main._FRAME_HEIGHT);
		this.setLayout(null);
		//산소포화도 그래프 삽입.
		_oxygenSaturationCircleGraph.setBounds(670,350,
			OxygenSaturationCircleGraph._circleGraphWidth,OxygenSaturationCircleGraph._circleGraphHeight);
		this.add(_oxygenSaturationCircleGraph);
		//맥박 그래프 삽입.
		_pulseGraph.setBounds(0,100,PulseGraph.GRAPH_WIDTH,PulseGraph.GRAPH_HEIGHT);
		this.add(_pulseGraph);
		
		_mainFrame.add(this);
		_mainFrame.setVisible(true);
	}
	
}

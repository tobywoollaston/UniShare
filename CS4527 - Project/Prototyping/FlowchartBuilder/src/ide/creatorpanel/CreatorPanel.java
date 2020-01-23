package ide.creatorpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import ide.Window;
import model.Tool;

@SuppressWarnings("serial")
public class CreatorPanel extends JPanel {
	
	// store the x and y of view
	private int x = 0;
	private int y = 0;
	
	// draws the graph onto the view
	private CreatorPanelGraphicsHandler graphicsHandler;
	
	private Tool.Types tool;
	private Window parent;
	
	private NodeMovingHandler nodeMover;
	private ConnectionCreatorHandler connectionCreator;
	
	public CreatorPanel(Window parent) {
		super();
		this.parent = parent;
		
		this.setupPanel();
		
		this.setupHandlers();
		
	}

	// setup panel basics
	private void setupPanel() {
		
		this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(600, 600));
		this.setBorder(null);
		
	}
	
	private void setupHandlers() {
		graphicsHandler = new CreatorPanelGraphicsHandler(this);
		
		// monitors mouse dragging on the view
		MouseInputHandler input = new MouseInputHandler(this);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
	}
	
	public int getViewX() {
		return x;
	}
	
	public int getViewY() {
		return y;
	}
	
	public Point getViewPosition() {
		return new Point(x, y);
	}
	
	public void setViewPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// draws the graphics on the screen
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		graphicsHandler.draw(g, this.parent.getNetwork(), connectionCreator);
	}
	
	public void setTool(Tool.Types tool) {
		this.tool = tool;
	}
	
	public Tool.Types getTool() {
		return this.tool;
	}
	
	public void addNode(int x, int y) {
		this.parent.getNetwork().createNewNode(x, y);
		this.repaint();
	}
	
	public void beginNodeMovement(int x, int y) {
		nodeMover = new NodeMovingHandler(this.parent.getNetwork(), x, y);
		this.repaint();
	}
	
	public void moveNode(int x, int y) {
		nodeMover.move(x, y);
		this.repaint();
	}
	
	public void createNewConnection(int x, int y) {
		connectionCreator = new ConnectionCreatorHandler(this.parent.getNetwork(), x, y);
	}
	
	public void drawNewConnection(int x, int y) {
		connectionCreator.drawConnectionToo(x, y);
		this.repaint();
	}
	
	public void endNewConnection(int x, int y) {
		connectionCreator.endDrawConnectionToo(x, y);
		this.repaint();
	}
	
}

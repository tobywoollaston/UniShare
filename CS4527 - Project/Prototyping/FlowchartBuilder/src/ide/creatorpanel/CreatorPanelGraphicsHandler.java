package ide.creatorpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import structure.Connection;
import structure.Network;
import structure.Node;

class CreatorPanelGraphicsHandler {
	
	// store the creator panel
	private final CreatorPanel parent;
	
	// square size
	private final int grid_distance = 200;
	
	// colors to use later
	private final Color backgroundColor = new Color(100, 125, 120);
	private final Color gridColor = new Color(180, 220, 220);
	private final Color originColor = new Color(150, 74, 89);
	
	public CreatorPanelGraphicsHandler(final CreatorPanel parent) {
		this.parent = parent;
	}
	
	public void draw(final Graphics g, final Network network, final ConnectionCreatorHandler connectionCreator) {
		// draw background
		g.setColor(backgroundColor);
		g.fillRect(0, 0, parent.getWidth(), parent.getHeight());
		
		this.drawGrid(g);
		
		this.drawConnections(g, connectionCreator, network.getConnections());
		
//		g.translate(parent.getViewX(), parent.getViewY()); 
		
		this.drawNodes(g, network.getNodes());
	}
	
	// draw the grid
	// x = 0 and y = 0 drawn with red line
	private void drawGrid(final Graphics g) {
		
		// vertical lines
		// only show lines on the screen
		for (int sepX = -(parent.getViewX()%grid_distance)-grid_distance; sepX < parent.getWidth(); sepX += grid_distance) {
			if (sepX + parent.getViewX() == 0) {
				g.setColor(originColor);
			} else {
				g.setColor(gridColor);
			}
			g.drawLine(sepX, 0, sepX, parent.getHeight());
		}
		
		// horizontal lines
		// only show lines on the screen
		for (int sepY = -(parent.getViewY()%grid_distance)-grid_distance; sepY < parent.getHeight(); sepY += grid_distance) {
			if (sepY + parent.getViewY() == 0) {
				g.setColor(originColor);
			} else {
				g.setColor(gridColor);
			}
			g.drawLine(0, sepY, parent.getWidth(), sepY);
		}
		
	}
	
	private void drawConnections(final Graphics g, final ConnectionCreatorHandler connectionCreator, final ArrayList<Connection> connections) {
		if (connectionCreator != null) {
			connectionCreator.drawNewConnection((Graphics2D) g);
		}
		
		for (Connection c : connections) {
			c.draw((Graphics2D) g, this.parent.getViewPosition(), parent.getWidth(), parent.getHeight());
		}
		
	}
	
	private void drawNodes(final Graphics g, final ArrayList<Node> nodes) {
		
		for (Node n : nodes) {
			n.draw((Graphics2D) g, this.parent.getViewPosition(), parent.getWidth(), parent.getHeight());
		}
		
	}

}

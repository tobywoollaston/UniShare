package ide.creatorpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import structure.Network;
import structure.Node;

class ConnectionCreatorHandler {
	
	private Network network;
	private Node startingNode;
	private boolean isCreating = false;
	
	private int currentX;
	private int currentY;

	public ConnectionCreatorHandler(Network network, int x, int y) {
		
		this.network = network;
		this.startingNode = this.network.getNodeAt(x, y);
		if (this.startingNode == null) {
			return;
		}
		
		this.isCreating = true;
		this.currentX = x;
		this.currentY = y;
		
	}
	
	public void drawConnectionToo(int x, int y) {
		this.currentX = x;
		this.currentY = y;
	}
	
	public void endDrawConnectionToo(int x, int y) {
		if (!isCreating) {
			return;
		}
		this.isCreating = false;
		
		Node node = this.network.getNodeAt(x, y);
		if (node == null) {
			return;
		}
		if (node == this.startingNode) {
			return;
		}
		
		network.createNewConnection(this.startingNode, node);
		
	}
	
	public void drawNewConnection(Graphics2D g) {
		if (!isCreating) {
			return;
		}
		
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.YELLOW);
		g.drawLine(startingNode.getX(), startingNode.getY(), currentX, currentY);
	}
	
}

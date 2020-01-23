package ide.creatorpanel;

import structure.Network;
import structure.Node;

class NodeMovingHandler {
	
	private Node node;
	private int offsetX;
	private int offsetY;
	
	public NodeMovingHandler(Network network, int x, int y) {
		
		this.node = network.getNodeAt(x, y);
		if (this.node != null) {
			offsetX = x - this.node.getX();
			offsetY = y - this.node.getY();
		}
		
	}
	
	public void move(int x, int y) {
		if (node != null) {
			node.setXY(x - offsetX, y - offsetY);
		}
	}

}

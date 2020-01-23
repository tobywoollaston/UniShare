package structure;

import java.util.ArrayList;

public class Network {
	
	private int idCounter = 0;
	private ArrayList<Node> nodes;
	private ArrayList<Connection> connections;
	
	public Network() {
		this.nodes = new ArrayList<>();
		this.connections = new ArrayList<>();
	}
	
	public void createNewNode(int x, int y) {
		Node node = new Node(idCounter, x, y);
		nodes.add(node);
		idCounter++;
	}
	
	public void createNewConnection(Node start, Node end) {
		Connection con = new Connection(idCounter, start, end);
		connections.add(con);
		idCounter++;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
	
	public Node getNodeAt(int x, int y) {
		Node node = null;
		for (Node n : nodes) {
			if (n.isVisible()) {
				if (n.isPointOn(x, y)) {
					node = n;
				}
			}
		}
		
		return node;
	}
	
	public ArrayList<Connection> getConnections() {
		return this.connections;
	}

}

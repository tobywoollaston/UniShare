package structure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Connection {
	
	private int id;
	private Node startNode;
	private Node endNode;
//	private ArrayList<Point> points;

	public Connection(int id, Node start, Node end) {
		this.id = id;
		this.startNode = start;
		this.endNode = end;
//		this.points = new ArrayList<>();
	}
	
	public void flip() {
		Node temp = startNode;
		this.startNode = this.endNode;
		this.endNode = temp;
	}
	
	public void draw(Graphics2D g, Point viewPoint, int width, int height) {
		
		int x1 = startNode.getX() - viewPoint.x;
		int y1 = startNode.getY() - viewPoint.y;
		int x2 = endNode.getX() - viewPoint.x;
		int y2 = endNode.getY() - viewPoint.y;
		
		if (((x1 > 0 && x1 < width) || (x2 > 0 && x2 < width)) && ((y1 > 0 && y1 < height) || (y2 > 0 && y2 < height))) {
		
			g.setColor(Color.BLACK);
			g.setStroke(new BasicStroke(7));
			g.drawLine(x1, y1, x2, y2);
			
			int dx = (x2 - x1);
			int dy = (y2 - y1);
			double z = Math.sqrt(dx*dx + dy*dy);
			
			double theta = Math.asin(dy/z);
			int r = 18;
			int nodeR = 110/2;
			double newZ = Math.sqrt(nodeR*nodeR + nodeR*nodeR) + r/2;
			
			int y = (int) (Math.sin(theta) * newZ);
			int x = (int) (Math.cos(theta) * newZ);
			
			if (dx < 0) {
				x *= -1;
			}
			
			g.fillOval(x2 - x - r/2, y2 - y - r/2, r, r);
		
		}
		
	}
	
}

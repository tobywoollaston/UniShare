package structure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Node {
	
	private int id;
	private int x;
	private int y;
	private int radius = 125;
	
	private boolean isVisible;
	
	private Node() {
		this.id = -1;
	}
	
	static Node empty() {
		return new Node();
	}
	
	public Node(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
		
		this.isVisible = true;
	}
	
	public void draw(final Graphics2D g, Point viewPoint, int width, int height) {
		this.isVisible = false;
		
		int r = radius;
		
		if (x - viewPoint.x + (r/2) > 0 && x - viewPoint.x - (r/2) < width && y - viewPoint.y + (r/2) > 0 && y - viewPoint.y - (r/2) < height) {
			this.isVisible = true;
			
			int a = 15;
			int drawX = x - (r/2) - viewPoint.x;
			int drawY = y - (r/2) - viewPoint.y;
			
			g.setColor(Color.ORANGE);
			g.fillRoundRect(drawX, drawY, r, r, a, a);
			
			g.setColor(Color.BLACK);
			g.setStroke(new BasicStroke(2));
			g.drawRoundRect(drawX, drawY, r, r, a, a);
			
			g.drawString(String.valueOf(this.id), x - viewPoint.x, y - viewPoint.y);
		}
		
	}
	
	public boolean isPointOn(int x, int y) {
//		System.out.print("(" + String.valueOf(x) + ", " + String.valueOf(y) + ")");
//		System.out.print(" (" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")");
//		System.out.println();
		
		if (x > this.x - (this.radius/2) && x < this.x + (this.radius/2) && y > this.y - (this.radius/2) && y < this.y + (this.radius/2)) {
			return true;
		}
		
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isVisible() {
		return this.isVisible;
	}

}

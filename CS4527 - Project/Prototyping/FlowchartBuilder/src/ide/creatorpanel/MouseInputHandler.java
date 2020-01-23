package ide.creatorpanel;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Optional;

import javax.swing.SwingUtilities;

import model.Tool;

class MouseInputHandler implements MouseListener, MouseMotionListener {
	
	private CreatorPanel panel;
	
	private Optional<Point> pressedPosition = Optional.empty();
	private Optional<Point> initialScreenPosition = Optional.empty();
	
	public MouseInputHandler(CreatorPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		panel.requestFocusInWindow();
		
		pressedPosition = Optional.of(e.getPoint());
		initialScreenPosition = Optional.of(panel.getViewPosition());
		
//		System.out.println("mousePressed: " + panel.getTool().name());
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			
			final int x = pressedPosition.get().x + initialScreenPosition.get().x;
			final int y = pressedPosition.get().y + initialScreenPosition.get().y;
			
			if (panel.getTool() == Tool.Types.ADD_CONNECION) {
				
				panel.createNewConnection(x, y);
				
			} else if (panel.getTool() == Tool.Types.MOVE_NODES) {
				
				panel.beginNodeMovement(x, y);
				
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if (pressedPosition.isPresent() && initialScreenPosition.isPresent()) {
		
			if (SwingUtilities.isLeftMouseButton(e)) {
				
				final int x = e.getPoint().x + panel.getViewX();
				final int y = e.getPoint().y + panel.getViewY(); 
				
				if (panel.getTool() == Tool.Types.ADD_CONNECION) {
					
					panel.drawNewConnection(x, y);
					
				} else if (panel.getTool() == Tool.Types.MOVE_NODES) {
					
					panel.moveNode(x, y);
					
				}
				
			} else if (SwingUtilities.isRightMouseButton(e)) {
				
				final int x = initialScreenPosition.get().x + pressedPosition.get().x - e.getPoint().x;
				final int y = initialScreenPosition.get().y + pressedPosition.get().y - e.getPoint().y;
				panel.setViewPosition(x, y);
				
			}
		}
		
		panel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("mouseClicked: " + panel.getTool().name());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (pressedPosition.isPresent() && initialScreenPosition.isPresent() && SwingUtilities.isLeftMouseButton(e)) {
			
			final int x = e.getPoint().x + panel.getViewX();
			final int y = e.getPoint().y + panel.getViewY(); 
			
			switch(panel.getTool()) {
			case NONE:
				break;
			case SELECT:
				break;
			case ADD_NODE:
				this.panel.addNode(x, y);
				break;
			case ADD_CONNECION:
				this.panel.endNewConnection(x, y);
				break;
			case MOVE_NODES:
				
				break;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}

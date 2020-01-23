package ide.toolpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ide.Window;
import model.Tool;

@SuppressWarnings("serial")
public class ToolPanel extends JPanel {
	
	private Window parent;
	private ArrayList<ToolButton> buttons = new ArrayList<>();
	
	public ToolPanel(Window parent) {
		super();
		this.parent = parent;
		
		this.setupPanel();
		
		this.addButtons();
		
	}
	
	private void setupPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(115, 115, 115));
		this.setMinimumSize(new Dimension(100, 600));
		this.setPreferredSize(new Dimension(100, 600));
		this.setMaximumSize(new Dimension(100, 600));
		this.setBorder(null);
		
	}
	
	private void addButtons() {
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		ToolButton selectButton = new ToolButton("Select", this, Tool.Types.SELECT);
		buttons.add(selectButton);
		this.add(selectButton);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		ToolButton addNodeButton = new ToolButton("Add Node", this, Tool.Types.ADD_NODE);
		buttons.add(addNodeButton);
		this.add(addNodeButton);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		ToolButton addConnectionButton = new ToolButton("Add Connection", this, Tool.Types.ADD_CONNECION);
		buttons.add(addConnectionButton);
		this.add(addConnectionButton);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		ToolButton moveNodeButton = new ToolButton("Move Node", this, Tool.Types.MOVE_NODES);
		buttons.add(moveNodeButton);
		this.add(moveNodeButton);
		
		this.toolChange(Tool.Types.SELECT);
		
	}
	
	protected void toolChange(Tool.Types newTool) {
		for (ToolButton button : buttons) {
			if (newTool == button.getType()) {
				button.selectedOn();
			} else {
				button.selectedOff();
			}
		}
		parent.setTool(newTool);
	}

}

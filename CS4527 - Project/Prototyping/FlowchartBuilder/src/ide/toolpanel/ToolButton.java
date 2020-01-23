package ide.toolpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Tool;

@SuppressWarnings("serial") 
public class ToolButton extends JPanel implements MouseListener {
	
	private final ToolPanel toolPanel;
	private Tool.Types type;
	private boolean selected = false;
	
	private Color onColor = new Color(191, 191, 191);
	private Color offColor = new Color(102, 102, 102);
	
	private String text;
	
	public ToolButton(String text, final ToolPanel toolPanel, Tool.Types type) {
		super();
		this.toolPanel = toolPanel;
		this.type = type;
		this.text = text;
		
		this.setupPanel();
		this.setupLabel();
	}
	
	private void setupPanel() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(offColor);
		this.setMinimumSize(new Dimension(75, 75));
		this.setMaximumSize(new Dimension(75, 75));
		this.addMouseListener(this);
		this.setBorder(null);
		
	}
	
	private void setupLabel() {
		
		JLabel textLabel = new JLabel("<html><center>" + this.text + "</center></html>", SwingConstants.CENTER);
		this.add(textLabel);
		
	}
	
	protected void selectedOn() {
		this.selected = true;
		this.setBackground(onColor);
	}
	
	protected void selectedOff() {
		this.selected = false;
		this.setBackground(offColor);
	}

	protected Tool.Types getType() {
		return this.type;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.toolPanel.toolChange(this.type);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.toolPanel.toolChange(this.type);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.toolPanel.toolChange(this.type);
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

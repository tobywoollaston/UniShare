package ide.infopanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {
	
	public InfoPanel() {
		super();
		
		this.setupPanel();
		
	}
	
	private void setupPanel() {
		
		this.setBackground(new Color(217, 217, 217));
		this.setMinimumSize(new Dimension(500, 100));
		this.setPreferredSize(new Dimension(500, 100));
		this.setMaximumSize(new Dimension(500, 100));
		this.setBorder(null);
		
	}

}

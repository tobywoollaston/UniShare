package ide;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.DimensionUIResource;

import ide.creatorpanel.CreatorPanel;
import ide.infopanel.InfoPanel;
import ide.menupanel.MainMenuBar;
import ide.toolpanel.ToolPanel;
import model.Tool;
import structure.Network;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private CreatorPanel creatorPane;
	private Network network;
	
	public Window() {
		super();
		
		this.initComponents();
		
		this.initBlankNetwork();
	}
	
	// run all the start up functions
	private void initComponents() { 
		this.setupWindow();
		
		this.setupMenuBar();
		this.setupPanels();
		
		this.showWindow();
		
		this.setupClosing();
	}
	
	// set up all JFrame
	private void setupWindow() {
		
		this.setTitle("Flowchart Builder");
		this.setMinimumSize(new DimensionUIResource(800, 600));
		
	}
	
	// set up the menu bar
	private void setupMenuBar() {
		
		setJMenuBar(new MainMenuBar(this));
		
	}
	
	// set up the view panels
	private void setupPanels() {
		
		// the separator for the tools panel and the creator panel
		JSplitPane toolsCreatorSeparator = new JSplitPane();
		toolsCreatorSeparator.setDividerSize(0);
		
		// add the views to the separator
		JSplitPane creatorInfoSeparator = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		creatorInfoSeparator.setDividerSize(0);
		
		InfoPanel infoPane = new InfoPanel();
		creatorPane = new CreatorPanel(this);
		
		creatorInfoSeparator.setTopComponent(infoPane);
		creatorInfoSeparator.setBottomComponent(creatorPane);
		
		ToolPanel toolsPane = new ToolPanel(this);
		
		toolsCreatorSeparator.setLeftComponent(toolsPane);
		toolsCreatorSeparator.setRightComponent(creatorInfoSeparator);
		
		// add the separator to the view
		final GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(toolsCreatorSeparator));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(toolsCreatorSeparator));
		
	}
	
	// display the window to the view and center the frame
	private void showWindow() {
		
		this.pack();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		
		this.setVisible(true);
		
	}
	
	// setup for window closing
	private void setupClosing() {
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	closeProgam();
		    }
		});
		
	}
	
	// ask user if sure they want to close the program
	public void closeProgam() {
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
        	System.exit(0);
        }
	}
	
	public void setTool(Tool.Types tool) {
		creatorPane.setTool(tool);
	}
	
	private void initBlankNetwork() {
		this.network = new Network();
	}
	
	public Network getNetwork() {
		return this.network;
	}

}

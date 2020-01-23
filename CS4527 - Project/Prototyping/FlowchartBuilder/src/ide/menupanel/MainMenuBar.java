package ide.menupanel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ide.Window;

@SuppressWarnings("serial")
public class MainMenuBar extends JMenuBar {
	
	private Window mainWindow;

	public MainMenuBar(Window mainWindow) {
		super();
		this.mainWindow = mainWindow;
		
		this.setupFileMenu();
		
		this.setupEditMenu();
		
	}
	
	private void setupFileMenu() {
		
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		
		JMenuItem newFile = new JMenuItem("New...");
		fileMenu.add(newFile);
		
		JMenuItem openFile = new JMenuItem("Open...");
		fileMenu.add(openFile);
		
		JMenuItem saveFile = new JMenuItem("Save");
		fileMenu.add(saveFile);
		
		JMenuItem saveAsFile = new JMenuItem("Save As...");
		fileMenu.add(saveAsFile);
		
		fileMenu.addSeparator();
		
		JMenu exportFile = new JMenu("Export...");
		fileMenu.add(exportFile);
		
		JMenuItem pngExport = new JMenuItem("Export as PNG");
		exportFile.add(pngExport);
		
		JMenuItem pdfExport = new JMenuItem("Export as PDF");
		exportFile.add(pdfExport);
		
		JMenuItem xmlExport = new JMenuItem("Export as XML");
		exportFile.add(xmlExport);
				
		fileMenu.addSeparator();
		
		JMenuItem exitApp = new JMenuItem("Exit");
		exitApp.addActionListener((event) -> mainWindow.closeProgam());
		fileMenu.add(exitApp);
		
	}
	
	private void setupEditMenu() {
		
		JMenu editMenu = new JMenu("Edit");
		this.add(editMenu);
		
		JMenuItem cutButton = new JMenuItem("Cut");
		editMenu.add(cutButton);
		
		JMenuItem copyButton = new JMenuItem("Copy");
		editMenu.add(copyButton);
		
		JMenuItem pasteButton = new JMenuItem("Paste");
		editMenu.add(pasteButton);
		
		editMenu.addSeparator();
		
		JMenuItem undoButton = new JMenuItem("Undo");
		editMenu.add(undoButton);
		
		JMenuItem redoButton = new JMenuItem("Redo");
		editMenu.add(redoButton);
		
	}
	
}

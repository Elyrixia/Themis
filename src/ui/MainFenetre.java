package ui;

import javax.swing.UIManager;

public class MainFenetre
{
	
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 480;

	// Attributes :
	private FenetreMenu	window;

	// Constructors :
	public MainFenetre()
	{
		this.window = new EnqueteurFenetre();
	}

	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			System.err.println("Could not load the system Look and Feel");
		}
		MainFenetre mainWindow = new MainFenetre();
	}
}

package ui;

import javax.swing.UIManager;

public class MainFenetre
{

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

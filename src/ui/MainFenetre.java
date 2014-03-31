/**
 * @author Alexandre Laffaille
 */

package ui;

import javax.swing.UIManager;

import ui.affaire.AffaireFenetre;

public class MainFenetre
{
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	// Attributes :
	private FenetreMenu	window;

	// Constructors :
	public MainFenetre()
	{
		this.window = new AffaireFenetre();
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

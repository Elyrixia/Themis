package ui;

import javax.swing.JFrame;

import business.CorpsEnqueteur;
import business.CorpsEnqueteurDB;
import business.Enqueteur;
import persistence.*;

class MainFenetre extends JFrame 
{
	public static void main(String []args)
	{
		Factory f = DBFactory.getInstance();
		Enqueteur e = f.createEnqueteur();
		
		
	}
}

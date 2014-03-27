package ui;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import facade.FacadeCorpsEnqueteur;
import business.CorpsEnqueteur;
import business.CorpsEnqueteurDB;
import business.ServiceEnqueteur;
import business.Enqueteur;
import persistence.*;

class MainFenetre extends JFrame 
{
	public static void main(String []args)
	{
		//Factory f = DBFactory.getInstance();
		FacadeCorpsEnqueteur fce = new FacadeCorpsEnqueteur();
		
		try {
			CorpsEnqueteur bob = fce.ajouterCorpsEnqueteur("boby", new ArrayList<ServiceEnqueteur>());
			
			HashMap<String,Object> map = fce.consulterCorpsEnqueteur(bob);
			System.out.println(map.get(":libelle"));
			
			HashMap<String,String> filter = new HashMap<String,String>();
			filter.put("id", "=3");
			ArrayList<CorpsEnqueteur> test = fce.chargerCorpsEnqueteur(filter);
			System.out.println(test.get(0).getLibelle());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Enqueteur e = f.createEnqueteur();
		System.out.println(e.create());
		
		e.setNom("Enrique");
		e.setPrenom("Ricco");
		e.update();
		
		e.delete();
		
		if(e == null)
			System.out.println("Delete succeed");
		
		HashMap<String, String> test = new HashMap<>();
		
		test.put(":test", "Ceci");
		test.put(":truc", "est");
		test.put(":lol", "un");
		test.put(":gqgq", "fsqfsqf");
		test.put(":lsfq", "hfdshr");
		test.put(":fsqfqs", "test");
		
		String str = ":test :truc :lol :fsqfqs";
		
		for(String s : test.keySet())
		{
			System.out.println(s);
			System.out.println(test.get(s));
			str = str.replace(s, test.get(s));
		}
		
		System.out.println(str);*/
	}
}

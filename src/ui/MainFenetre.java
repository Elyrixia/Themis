package ui;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import persistence.SQLManager;
import business.CorpsEnqueteur;
import business.EnqueteurDB;
import business.ServiceEnqueteur;
import common.Utilitaire;
import facade.FacadeCorpsEnqueteur;

class MainFenetre extends JFrame 
{
	public static void main(String []args)
	{
		//Factory f = DBFactory.getInstance();
		
		/*ArrayList<String> l = new ArrayList<String>();
		l.add("Bob");
		l.add("Henri");
		l.add("Bobette");
		System.out.println(Utilitaire.implode(",", l));
		*/
		
		/*SQLManager s = SQLManager.getConnection();
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("nom", "nom_test");
		hm.put("prenom", "prenom_test");
		s.insert("enqueteur", hm);
		
		
		HashMap<String, String> m = new HashMap<>();
		m.put("test1", "abc");
		m.put("test2", "def");
		m.put("test3", "ghi");
		
		String w = "TEST = 1 AND W = 24 AND Z = 'lol'";
		
		s.update(EnqueteurDB.TABLE_NAME, m, w); */
		
		
		FacadeCorpsEnqueteur fce = new FacadeCorpsEnqueteur();
		
		try {
			CorpsEnqueteur bob = fce.ajouterCorpsEnqueteur("henri");
			
			HashMap<String,Object> map = fce.consulterCorpsEnqueteur(bob);
			System.out.println(map.get(":libelle"));
			
			HashMap<String,String> filter = new HashMap<String,String>();
			filter.put("id", "=5");
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

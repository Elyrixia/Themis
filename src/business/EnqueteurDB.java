package business;

import java.util.HashMap;

import persistence.SQLManager;

public class EnqueteurDB extends Enqueteur
{
	
	private static SQLManager sqlManager = SQLManager.getConnection();
	
	@Override
	public int create()
	{
		// TODO Auto-generated method stub
		HashMap<String, String> correspondance = new HashMap<>();
		correspondance.put(":test", "Jack");
		correspondance.put(":truc", "John");
		sqlManager.query("INSERT INTO enqueteur(nom, prenom) VALUES(':test', ':truc')", correspondance);
		
		this.id = sqlManager.getLastID();
		return this.id;
	}

	@Override
	public void update()
	{
		HashMap<String, String> correspondance = new HashMap<>();
		correspondance.put(":nom", this.nom);
		correspondance.put(":prenom", this.prenom);
		correspondance.put(":id", String.valueOf(this.id));
		
		sqlManager.query("UPDATE enqueteur SET nom=':nom', prenom=':prenom' WHERE id=:id", correspondance);
	}

	@Override
	public void load(HashMap map)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete()
	{
		// TODO Auto-generated method stub
		HashMap<String, String> correspondance = new HashMap<>();
		correspondance.put(":id", String.valueOf(this.id));
		
		sqlManager.query("DELETE FROM enqueteur WHERE id=:id", correspondance);
	}

}

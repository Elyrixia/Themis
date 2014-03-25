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
		
		return sqlManager.getLastID();
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
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
		
	}

}

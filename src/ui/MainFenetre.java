package ui;
public class MainFenetre {
	
	//Attributes :
	private FenetreMenu window;
	
	//Constructors :
	public MainFenetre(){
		this.window = new EnqueteurFenetre();
	}

	
	public static void main(String[] args) {
		MainFenetre mainWindow = new MainFenetre();
	}
}

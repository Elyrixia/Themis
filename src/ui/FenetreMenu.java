package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// Classe fenetre avec juste les menus
public class FenetreMenu extends JFrame implements ActionListener{
	
	//Attributes :
	
	//Menus
	private JMenuBar menuBar;
	//Titres menus
	private JMenu menuThemis;
	private JMenu menuGestionAffaire;
	private JMenu menuGestionTGI;
	private JMenu menuGestionEnqueteur;
	private JMenu menuGestionCompta;
	//Sous menus
	private JMenuItem sousMenuQuitter;
	
	private JMenuItem sousMenuSuiviAffaire;
	private JMenuItem sousMenuGestionScelle;
	private JMenuItem sousMenuGestionMission;
	private JMenuItem sousMenuGestionFacturation;
	
	private JMenuItem sousMenuGestionTGI;
	private JMenuItem sousMenuGestionJuge;
	private JMenuItem sousMenuGestionGreffier;
	private JMenuItem sousMenuGestionProcureur;
	
	private JMenuItem sousMenuEnqueteur;
	private JMenuItem sousMenuServiceEnqueteur;
	private JMenuItem sousMenuCorpsEnqueteur;
	
	private JMenuItem sousMenuCoutAnnuel;
	private JMenuItem sousMenuGestionOutil;
	
	FenetreMenu(){
		super();
		// Au niveau de la taille, il faut au moins 450 pour afficher les menus en longueur correctement
		this.setSize(650,550);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createMenus();
	}
	
	private void createMenus() {
		//Menus
		//Initialisation Menus
		this.menuBar = new JMenuBar();
		this.menuThemis = new JMenu("Themis");
		this.menuGestionAffaire = new JMenu("Gestion Affaire");
		this.menuGestionTGI = new JMenu("Gestion TGI");
		this.menuGestionEnqueteur = new JMenu("Gestion Enqueteur");
		this.menuGestionCompta = new JMenu("Gestion Compta");
		this.sousMenuQuitter = new JMenuItem("Quitter"); sousMenuQuitter.addActionListener(this);
		this.sousMenuSuiviAffaire = new JMenuItem("Suivi des Affaires");
		this.sousMenuGestionScelle = new JMenuItem("Gestion des Scelles");
		this.sousMenuGestionMission = new JMenuItem("Gestion des Missions");
		this.sousMenuGestionFacturation = new JMenuItem("Gestion Facturation");
		this.sousMenuGestionTGI = new JMenuItem("Gestion des TGI");
		this.sousMenuGestionJuge = new JMenuItem("Gestion des Juges");
		this.sousMenuGestionGreffier = new JMenuItem("Gestion des Greffiers");
		this.sousMenuGestionProcureur = new JMenuItem("Gestion des Procureurs");
		this.sousMenuEnqueteur = new JMenuItem("Gestion Enqueteur"); sousMenuEnqueteur.addActionListener(this);
		this.sousMenuServiceEnqueteur = new JMenuItem("Gestion Service"); sousMenuServiceEnqueteur.addActionListener(this);
		this.sousMenuCorpsEnqueteur = new JMenuItem("Gestion Corps"); sousMenuCorpsEnqueteur.addActionListener(this);
		this.sousMenuCoutAnnuel = new JMenuItem("Gestion Couts Annuels");
		this.sousMenuGestionOutil = new JMenuItem("Gestion des Outils");
		//Ajout Titres Menus
		this.menuBar.add(menuThemis);
		this.menuBar.add(menuGestionAffaire);
		this.menuBar.add(menuGestionTGI);
		this.menuBar.add(menuGestionEnqueteur);
		this.menuBar.add(menuGestionCompta);
		//Ajout Sous Menus
		this.menuGestionAffaire.add(sousMenuSuiviAffaire);
		this.menuGestionAffaire.add(sousMenuGestionScelle);
		this.menuGestionAffaire.add(sousMenuGestionMission);
		this.menuGestionAffaire.add(sousMenuGestionFacturation);
		this.menuGestionTGI.add(sousMenuGestionTGI);
		this.menuGestionTGI.add(sousMenuGestionJuge);
		this.menuGestionTGI.add(sousMenuGestionGreffier);
		this.menuGestionTGI.add(sousMenuGestionProcureur);
		this.menuGestionEnqueteur.add(sousMenuEnqueteur);
		this.menuGestionEnqueteur.add(sousMenuServiceEnqueteur);
		this.menuGestionEnqueteur.add(sousMenuCorpsEnqueteur);
		this.menuGestionCompta.add(sousMenuCoutAnnuel);
		this.menuGestionCompta.add(sousMenuGestionOutil);
		this.menuThemis.add(sousMenuQuitter);
		
		this.setJMenuBar(menuBar);
	}
	
	FenetreMenu getFenetre(){
		return this;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == sousMenuQuitter){
			System.exit(0);
		}else if(e.getSource() == sousMenuEnqueteur){
			this.dispose();
			FenetreMenu fen = new EnqueteurFenetre();
		}else if(e.getSource() == sousMenuServiceEnqueteur){
			this.dispose();
			FenetreMenu fen = new ServiceEnqueteurFenetre();
		}else if(e.getSource() == sousMenuCorpsEnqueteur){
			this.dispose();
			FenetreMenu fen = new CorpsEnqueteurFenetre();
		}
			
	}

}

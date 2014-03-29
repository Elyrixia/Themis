package ui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import business.enqueteur.Enqueteur;
import business.enqueteur.TitreEnqueteur;
import facade.FacadeEnqueteur;
import facade.FacadeTitreEnqueteur;


public class EnqueteurFenetre extends FenetreMenu implements ActionListener{

	//Attributes :
	private FacadeEnqueteur facadeEnqueteur;
	private FacadeTitreEnqueteur facadeTitreEnqueteur;
	private ArrayList<Enqueteur> listeEnqueteur;
	private ArrayList<TitreEnqueteur> listeTitreEnqueteur;
	private JFrame fenetreParent;
	
	//Onglets
	private JTabbedPane panelOnglet;
	private JPanel panelEnqueteur, panelTitreEnqueteur;
	//Elements des panels
	private JLabel labelEnqueteur;
	private JLabel labelTitreEnqueteur;
	
	private JScrollPane panneauListeEnqueteur;
	private JList listeSelectionEnqueteur;
    private DefaultListModel modelListEnqueteur;
    
    private DefaultListModel modelListTitreEnqueteur;
	private JList listeSelectionTitreEnqueteur;
	private JScrollPane panneauListeTitreEnqueteur;
    
	private JButton boutonAjouterEnqueteur;
	private JButton boutonConsulterEnqueteur;
	private JButton boutonModifierEnqueteur;
	private JButton boutonSupprimerEnqueteur;
	private JButton boutonAjouterTitreEnqueteur;
	private JButton boutonConsulterTitreEnqueteur;
	private JButton boutonModifierTitreEnqueteur;
	private JButton boutonSupprimerTitreEnqueteur;
	
	
	// Constructor
	public EnqueteurFenetre() {
		super();
		facadeEnqueteur = new FacadeEnqueteur();
		this.facadeTitreEnqueteur = new FacadeTitreEnqueteur();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Gestion Enqueteur");
		this.createOnglets();
		//Ajout listener sur boutons
		this.boutonAjouterEnqueteur.addActionListener(this);
		this.boutonAjouterTitreEnqueteur.addActionListener(this);
		this.boutonConsulterEnqueteur.addActionListener(this);
		this.boutonConsulterTitreEnqueteur.addActionListener(this);
		this.boutonModifierEnqueteur.addActionListener(this);
		this.boutonModifierTitreEnqueteur.addActionListener(this);
		this.boutonSupprimerEnqueteur.addActionListener(this);
		this.boutonSupprimerTitreEnqueteur.addActionListener(this);
		this.setVisible(true);
	}

	public void createOnglets(){
		//Onglets
		panelOnglet = new JTabbedPane();
		//Creation onglets
		panelEnqueteur = new JPanel(new GridBagLayout());
		panelTitreEnqueteur = new JPanel(new GridBagLayout());
		//Creation composants simples
		labelEnqueteur = new JLabel("Liste des enqueteurs enregistres");
		labelTitreEnqueteur = new JLabel("Liste titres enqueteurs enregistres");
		boutonAjouterEnqueteur = new JButton("Ajouter Enqueteur");
		boutonAjouterTitreEnqueteur = new JButton("Ajouter Titre Enqueteur");
		boutonConsulterEnqueteur = new JButton("Consulter");
		boutonConsulterTitreEnqueteur = new JButton ("Consulter");
		boutonModifierEnqueteur = new JButton("Modifier");
		boutonModifierTitreEnqueteur = new JButton("Modifier");
		boutonSupprimerEnqueteur = new JButton("Supprimer");
		boutonSupprimerTitreEnqueteur = new JButton("Supprimer");
		
		//Creation liste
	    modelListEnqueteur = new DefaultListModel();
		listeSelectionEnqueteur = new JList(modelListEnqueteur);
	    panneauListeEnqueteur = new JScrollPane(listeSelectionEnqueteur);
	    listeSelectionEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    modelListTitreEnqueteur = new DefaultListModel();
		listeSelectionTitreEnqueteur = new JList(modelListTitreEnqueteur);
	    panneauListeTitreEnqueteur = new JScrollPane(listeSelectionTitreEnqueteur);
	    listeSelectionTitreEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	    /*
	     * TODO : Aller chercher les listes avec facade et les mettre ci-dessus
	     */
	    HashMap<String,String> filtre = new HashMap<String, String>();
	    listeEnqueteur = facadeEnqueteur.chargerEnqueteur(filtre);
	    for (int i=0; i < this.listeEnqueteur.size(); i++) {
			modelListEnqueteur.addElement(this.listeEnqueteur.get(i));
		}
	    
	    HashMap<String,String> filtreTitre = new HashMap<String, String>();
	    listeTitreEnqueteur = facadeTitreEnqueteur.chargerTitreEnqueteur(filtreTitre);
	    for (int i=0; i < this.listeTitreEnqueteur.size(); i++) {
			modelListTitreEnqueteur.addElement(this.listeTitreEnqueteur.get(i));
		}
		
		//Creation contraintes
		GridBagConstraints contrainteBoutonAjouterEnqueteur = new GridBagConstraints();
		contrainteBoutonAjouterEnqueteur.gridx=1; contrainteBoutonAjouterEnqueteur.gridy=0;
		contrainteBoutonAjouterEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAjouterEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteLabelEnqueteur = new GridBagConstraints();
		contrainteLabelEnqueteur.gridx=1; contrainteLabelEnqueteur.gridy=1;
		contrainteLabelEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteLabelEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteListeEnqueteur = new GridBagConstraints();
		contrainteListeEnqueteur.gridx=0; contrainteListeEnqueteur.gridy=2;
		contrainteListeEnqueteur.gridwidth=3; 
		contrainteListeEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonConsulterEnqueteur = new GridBagConstraints();
		contrainteBoutonConsulterEnqueteur.gridx=0; contrainteBoutonConsulterEnqueteur.gridy=3;
		contrainteBoutonConsulterEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonModifierEnqueteur = new GridBagConstraints();
		contrainteBoutonModifierEnqueteur.gridx=1; contrainteBoutonModifierEnqueteur.gridy=3;
		contrainteBoutonModifierEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonModifierEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonSupprimerEnqueteur = new GridBagConstraints();
		contrainteBoutonSupprimerEnqueteur.gridx=2; contrainteBoutonSupprimerEnqueteur.gridy=3;
		contrainteBoutonSupprimerEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonSupprimerEnqueteur.anchor = GridBagConstraints.CENTER;
		
		GridBagConstraints contrainteBoutonAjouterTitreEnqueteur = new GridBagConstraints();
		contrainteBoutonAjouterTitreEnqueteur.gridx=1; contrainteBoutonAjouterTitreEnqueteur.gridy=0;
		contrainteBoutonAjouterTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAjouterTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteLabelTitreEnqueteur = new GridBagConstraints();
		contrainteLabelTitreEnqueteur.gridx=1; contrainteLabelTitreEnqueteur.gridy=1;
		contrainteLabelTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteListeTitreEnqueteur = new GridBagConstraints();
		contrainteListeTitreEnqueteur.gridx=0; contrainteListeTitreEnqueteur.gridy=2;
		contrainteListeTitreEnqueteur.gridwidth=3;
		contrainteListeTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonConsulterTitreEnqueteur = new GridBagConstraints();
		contrainteBoutonConsulterTitreEnqueteur.gridx=0; contrainteBoutonConsulterTitreEnqueteur.gridy=3;
		contrainteBoutonConsulterTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonModifierTitreEnqueteur = new GridBagConstraints();
		contrainteBoutonModifierTitreEnqueteur.gridx=1; contrainteBoutonModifierTitreEnqueteur.gridy=3;
		contrainteBoutonConsulterTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonSupprimerTitreEnqueteur = new GridBagConstraints();
		contrainteBoutonSupprimerTitreEnqueteur.gridx=2; contrainteBoutonSupprimerTitreEnqueteur.gridy=3;
		contrainteBoutonConsulterTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		
		//Ajout composants avec contraintes au panel
		panelEnqueteur.add(labelEnqueteur, contrainteLabelEnqueteur);
		panelEnqueteur.add(panneauListeEnqueteur, contrainteListeEnqueteur);
		panelEnqueteur.add(boutonAjouterEnqueteur, contrainteBoutonAjouterEnqueteur);
		panelEnqueteur.add(boutonConsulterEnqueteur, contrainteBoutonConsulterEnqueteur);
		panelEnqueteur.add(boutonModifierEnqueteur, contrainteBoutonModifierEnqueteur);
		panelEnqueteur.add(boutonSupprimerEnqueteur, contrainteBoutonSupprimerEnqueteur);
		
		panelTitreEnqueteur.add(labelTitreEnqueteur, contrainteLabelTitreEnqueteur);
		panelTitreEnqueteur.add(panneauListeTitreEnqueteur, contrainteListeTitreEnqueteur);
		panelTitreEnqueteur.add(boutonAjouterTitreEnqueteur, contrainteBoutonAjouterTitreEnqueteur);
		panelTitreEnqueteur.add(boutonConsulterTitreEnqueteur, contrainteBoutonConsulterTitreEnqueteur);
		panelTitreEnqueteur.add(boutonModifierTitreEnqueteur, contrainteBoutonModifierTitreEnqueteur);
		panelTitreEnqueteur.add(boutonSupprimerTitreEnqueteur, contrainteBoutonSupprimerTitreEnqueteur);
		
		//Ajout onglet a la fenetre
		getPanelOnglet().addTab("Enqueteurs", null, panelEnqueteur);
		getPanelOnglet().addTab("Titres d'Enqueteurs", null, panelTitreEnqueteur);
		this.fenetreParent.getContentPane().add(getPanelOnglet());
	}

	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		if (e.getSource() == boutonAjouterEnqueteur)
		{
			this.getPanelOnglet().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un enqueteur");
			
			PanelAjouterEnqueteur panelAjoutEnqueteur = new PanelAjouterEnqueteur();
			panelAjoutEnqueteur.setFenetre(this);
			this.fenetreParent.getContentPane().add(panelAjoutEnqueteur);
			//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonAjouterTitreEnqueteur){
			this.getPanelOnglet().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un titre enqueteur");
			
			PanelAjouterTitreEnqueteur panelAjoutTitreEnqueteur = new PanelAjouterTitreEnqueteur();
			panelAjoutTitreEnqueteur.setFenetre(this);
			this.fenetreParent.getContentPane().add(panelAjoutTitreEnqueteur);
			//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonConsulterEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO
			}
		}
		else if(e.getSource() == boutonConsulterTitreEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO
			}
		}
		else if(e.getSource() == boutonModifierEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO : v�rif d'une s�lection de la liste + modif par rapport � ajout
				this.getPanelOnglet().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un enqueteur");
			
				PanelModifEnqueteur panelModifEnqueteur = new PanelModifEnqueteur();
				panelModifEnqueteur.setFenetre(this);
				this.fenetreParent.getContentPane().add(panelModifEnqueteur);
				//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
		}
		else if(e.getSource() == boutonModifierTitreEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO : v�rif d'une s�lection de la liste + modif par rapport � ajout
				this.getPanelOnglet().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un titre enqueteur");
				
				PanelModifTitreEnqueteur panelModifTitreEnqueteur = new PanelModifTitreEnqueteur();
				panelModifTitreEnqueteur.setFenetre(this);
				this.fenetreParent.getContentPane().add(panelModifTitreEnqueteur);
				//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
			
		}
		else if(e.getSource() == boutonSupprimerEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO
			}
			
		}
		else if(e.getSource() == boutonSupprimerTitreEnqueteur){
			if (!(this.listeSelectionEnqueteur.getSelectedValue() == null)){
				//TODO
			}
		}
		
		
	}

	//M�thode appell�e par les Panels comme Ajout ou Modifier pour revenir sur la page d'accueil en cas d'annulation ou de validation
	public JTabbedPane getPanelOnglet() {
		return panelOnglet;
	}

	//getter de la facade pour que les panels ajouter et modifier puisse appeller les fonctions correspondantes
	public FacadeTitreEnqueteur getFacadeTitreEnqueteur() {
		return facadeTitreEnqueteur;
	}

	
}

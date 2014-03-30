package ui.affaire;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import business.affaire.Objet;
import business.affaire.Scelle;
import business.affaire.TypeObjet;
import facade.FacadeAffaire;
import facade.FacadeScelle;
import facade.FacadeObjet;
import facade.FacadeTypeObjet;
import ui.FenetreMenu;
import ui.MainFenetre;
import ui.MyRenderer;

public class ScelleFenetre extends FenetreMenu implements ActionListener{
	
	//Attributes :
	private FacadeScelle facadeScelle;
	private FacadeObjet facadeObjet;
	private FacadeTypeObjet facadeTypeObjet;
	private FacadeAffaire facadeAffaire; //pour dire à quelle affaire va un scelle
	private ArrayList<Scelle> listeScelle;
	private ArrayList<Objet> listeObjet;
	private ArrayList<TypeObjet> listeTypeObjet;
	private JFrame fenetreParent;
	
	//Onglets & panels
	private JTabbedPane panelOnglet;
	private JPanel panelScelle, panelObjet, panelTypeObjet;
	
	//Elements des panels
	private JLabel labelScelle;
	private JLabel labelObjet;
	private JLabel labelTypeObjet;
	
	private JList listeSelectionScelle;
	private DefaultListModel modelListScelle;
	private JScrollPane panneauListeScelle;
	   
	private DefaultListModel modelListObjet;
	private JList listeSelectionObjet;
	private JScrollPane panneauListeObjet;
	
	private DefaultListModel modelListTypeObjet;
	private JList listeSelectionTypeObjet;
	private JScrollPane panneauListeTypeObjet;
	   
	private JButton boutonAjouterScelle;
	private JButton boutonConsulterScelle;
	private JButton boutonModifierScelle;
	private JButton boutonSupprimerScelle;
	private JButton boutonAjouterObjet;
	private JButton boutonConsulterObjet;
	private JButton boutonModifierObjet;
	private JButton boutonSupprimerObjet;
	private JButton boutonAjouterTypeObjet;
	private JButton boutonConsulterTypeObjet;
	private JButton boutonModifierTypeObjet;
	private JButton boutonSupprimerTypeObjet;
	// Constructor
	public ScelleFenetre() {
		super();
		this.facadeScelle = new FacadeScelle();
		this.facadeObjet = new FacadeObjet();
		this.facadeTypeObjet = new FacadeTypeObjet();
		this.facadeAffaire = new FacadeAffaire();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Gestion Scelle");
		this.createOnglets();
		this.setVisible(true);
	}
	
	public void createOnglets(){		
		//Onglets
		panelOnglet = new JTabbedPane();
		//Creation onglets
		panelScelle = new JPanel(new GridBagLayout());
		panelObjet = new JPanel(new GridBagLayout());
		panelTypeObjet = new JPanel(new GridBagLayout());
		//Creation composants simples
		labelScelle = new JLabel("Liste des scelles enregistres");
		labelObjet = new JLabel("Liste objets enregistres");
		labelTypeObjet = new JLabel("Liste type objets enregistres");
		boutonAjouterScelle = new JButton("Ajouter Scelle");
		boutonAjouterObjet = new JButton("Ajouter Objet");
		boutonAjouterTypeObjet = new JButton("Ajouter Type Objet");
		boutonConsulterScelle = new JButton("Consulter");
		boutonConsulterObjet = new JButton ("Consulter");
		boutonConsulterTypeObjet = new JButton ("Consulter");
		boutonModifierScelle = new JButton("Modifier");
		boutonModifierObjet = new JButton("Modifier");
		boutonModifierTypeObjet = new JButton("Modifier");
		boutonSupprimerScelle = new JButton("Supprimer");
		boutonSupprimerObjet = new JButton("Supprimer");
		boutonSupprimerTypeObjet = new JButton("Supprimer");
		
		//Ajout listener sur boutons
		this.boutonAjouterScelle.addActionListener(this);
		this.boutonAjouterObjet.addActionListener(this);
		this.boutonAjouterTypeObjet.addActionListener(this);
		this.boutonConsulterScelle.addActionListener(this);
		this.boutonConsulterObjet.addActionListener(this);
		this.boutonConsulterTypeObjet.addActionListener(this);
		this.boutonModifierScelle.addActionListener(this);
		this.boutonModifierObjet.addActionListener(this);
		this.boutonModifierTypeObjet.addActionListener(this);
		this.boutonSupprimerScelle.addActionListener(this);
		this.boutonSupprimerObjet.addActionListener(this);
		this.boutonSupprimerTypeObjet.addActionListener(this);
		
		//Creation liste
	    modelListScelle = new DefaultListModel();
		listeSelectionScelle = new JList(modelListScelle);
	    panneauListeScelle = new JScrollPane(listeSelectionScelle);
	    listeSelectionScelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageScelle = new MyRenderer(facadeScelle);
	    listeSelectionScelle.setCellRenderer(affichageScelle);
	    
	    modelListObjet = new DefaultListModel();
		listeSelectionObjet = new JList(modelListObjet);
	    panneauListeObjet = new JScrollPane(listeSelectionObjet);
	    listeSelectionObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageObjet = new MyRenderer(facadeObjet);
	    listeSelectionObjet.setCellRenderer(affichageObjet);
	    
	    modelListTypeObjet = new DefaultListModel();
		listeSelectionTypeObjet = new JList(modelListTypeObjet);
	    panneauListeTypeObjet = new JScrollPane(listeSelectionTypeObjet);
	    listeSelectionTypeObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageTypeObjet = new MyRenderer(facadeTypeObjet);
	    listeSelectionTypeObjet.setCellRenderer(affichageTypeObjet);
		
	    HashMap<String,String> filtreScelle = new HashMap<String, String>();
	    listeScelle = facadeScelle.chargerScelle(filtreScelle);
	    for (int i=0; i < listeScelle.size(); i++) {
			modelListScelle.addElement(listeScelle.get(i));
		}
	    
	    HashMap<String,String> filtreObjet = new HashMap<String, String>();
	    listeObjet = facadeObjet.chargerObjet(filtreObjet);
	    for (int i=0; i < listeObjet.size(); i++) {
			modelListObjet.addElement(listeObjet.get(i));
		}
	    
	    HashMap<String,String> filtreTypeObjet = new HashMap<String, String>();
	    listeTypeObjet = facadeTypeObjet.chargerTypeObjet(filtreTypeObjet);
	    for (int i=0; i < listeTypeObjet.size(); i++) {
			modelListTypeObjet.addElement(listeTypeObjet.get(i));
		}
	    
	    //Creation contraintes
	    GridBagConstraints contrainteBoutonAjouterScelle = new GridBagConstraints();
	    contrainteBoutonAjouterScelle.gridx=1; contrainteBoutonAjouterScelle.gridy=0;
	    contrainteBoutonAjouterScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteBoutonAjouterScelle.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteLabelScelle = new GridBagConstraints();
	    contrainteLabelScelle.gridx=1; contrainteLabelScelle.gridy=1;
	    contrainteLabelScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteLabelScelle.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteListeScelle = new GridBagConstraints();
	    contrainteListeScelle.gridx=0; contrainteListeScelle.gridy=2;
	    contrainteListeScelle.gridwidth=3; 
	    contrainteListeScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteListeScelle.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteBoutonConsulterScelle = new GridBagConstraints();
	    contrainteBoutonConsulterScelle.gridx=0; contrainteBoutonConsulterScelle.gridy=3;
	    contrainteBoutonConsulterScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteBoutonConsulterScelle.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteBoutonModifierScelle = new GridBagConstraints();
	    contrainteBoutonModifierScelle.gridx=1; contrainteBoutonModifierScelle.gridy=3;
	    contrainteBoutonModifierScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteBoutonModifierScelle.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteBoutonSupprimerScelle = new GridBagConstraints();
	    contrainteBoutonSupprimerScelle.gridx=2; contrainteBoutonSupprimerScelle.gridy=3;
	    contrainteBoutonSupprimerScelle.insets = new Insets(0, 0, 5, 2);
	    contrainteBoutonSupprimerScelle.anchor = GridBagConstraints.CENTER;
	  
	    GridBagConstraints contrainteBoutonAjouterObjet = new GridBagConstraints();
	    contrainteBoutonAjouterObjet.gridx=1; contrainteBoutonAjouterObjet.gridy=0;
	    contrainteBoutonAjouterObjet.insets = new Insets(0, 0, 5, 2);
	    contrainteBoutonAjouterObjet.anchor = GridBagConstraints.CENTER;
	    GridBagConstraints contrainteLabelObjet = new GridBagConstraints();
	    contrainteLabelObjet.gridx=1; contrainteLabelObjet.gridy=1;
	  	contrainteLabelObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteLabelObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteListeObjet = new GridBagConstraints();
	  	contrainteListeObjet.gridx=0; contrainteListeObjet.gridy=2;
	  	contrainteListeObjet.gridwidth=3;
	  	contrainteListeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteListeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonConsulterObjet = new GridBagConstraints();
	  	contrainteBoutonConsulterObjet.gridx=0; contrainteBoutonConsulterObjet.gridy=3;
	  	contrainteBoutonConsulterObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonModifierObjet = new GridBagConstraints();
	  	contrainteBoutonModifierObjet.gridx=1; contrainteBoutonModifierObjet.gridy=3;
	  	contrainteBoutonConsulterObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonSupprimerObjet = new GridBagConstraints();
	  	contrainteBoutonSupprimerObjet.gridx=2; contrainteBoutonSupprimerObjet.gridy=3;
	  	contrainteBoutonConsulterObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterObjet.anchor = GridBagConstraints.CENTER;
	  
	  	GridBagConstraints contrainteBoutonAjouterTypeObjet = new GridBagConstraints();
	  	contrainteBoutonAjouterTypeObjet.gridx=1; contrainteBoutonAjouterTypeObjet.gridy=0;
	  	contrainteBoutonAjouterTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonAjouterTypeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteLabelTypeObjet = new GridBagConstraints();
	  	contrainteLabelTypeObjet.gridx=1; contrainteLabelTypeObjet.gridy=1;
	  	contrainteLabelTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteLabelTypeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteListeTypeObjet = new GridBagConstraints();
	  	contrainteListeTypeObjet.gridx=0; contrainteListeTypeObjet.gridy=2;
	  	contrainteListeTypeObjet.gridwidth=3;
	  	contrainteListeTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteListeTypeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonConsulterTypeObjet = new GridBagConstraints();
	  	contrainteBoutonConsulterTypeObjet.gridx=0; contrainteBoutonConsulterTypeObjet.gridy=3;
	  	contrainteBoutonConsulterTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterTypeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonModifierTypeObjet = new GridBagConstraints();
	  	contrainteBoutonModifierTypeObjet.gridx=1; contrainteBoutonModifierTypeObjet.gridy=3;
	  	contrainteBoutonConsulterTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterTypeObjet.anchor = GridBagConstraints.CENTER;
	  	GridBagConstraints contrainteBoutonSupprimerTypeObjet = new GridBagConstraints();
	  	contrainteBoutonSupprimerTypeObjet.gridx=2; contrainteBoutonSupprimerObjet.gridy=3;
	  	contrainteBoutonConsulterTypeObjet.insets = new Insets(0, 0, 5, 2);
	  	contrainteBoutonConsulterTypeObjet.anchor = GridBagConstraints.CENTER;
	  
	  	//Ajout composants avec contraintes au panel
	  	panelScelle.add(labelScelle, contrainteLabelScelle);
	  	panelScelle.add(panneauListeScelle, contrainteListeScelle);
	  	panelScelle.add(boutonAjouterScelle, contrainteBoutonAjouterScelle);
	  	panelScelle.add(boutonConsulterScelle, contrainteBoutonConsulterScelle);
	  	panelScelle.add(boutonModifierScelle, contrainteBoutonModifierScelle);
	 	panelScelle.add(boutonSupprimerScelle, contrainteBoutonSupprimerScelle);
	
	 	panelObjet.add(labelObjet, contrainteLabelObjet);
	 	panelObjet.add(panneauListeObjet, contrainteListeObjet);
	 	panelObjet.add(boutonAjouterObjet, contrainteBoutonAjouterObjet);
	 	panelObjet.add(boutonConsulterObjet, contrainteBoutonConsulterObjet);
		panelObjet.add(boutonModifierObjet, contrainteBoutonModifierObjet);
		panelObjet.add(boutonSupprimerObjet, contrainteBoutonSupprimerObjet);
		
		panelTypeObjet.add(labelTypeObjet, contrainteLabelTypeObjet);
	 	panelTypeObjet.add(panneauListeTypeObjet, contrainteListeTypeObjet);
	 	panelTypeObjet.add(boutonAjouterTypeObjet, contrainteBoutonAjouterTypeObjet);
	 	panelTypeObjet.add(boutonConsulterTypeObjet, contrainteBoutonConsulterTypeObjet);
		panelTypeObjet.add(boutonModifierTypeObjet, contrainteBoutonModifierTypeObjet);
		panelTypeObjet.add(boutonSupprimerTypeObjet, contrainteBoutonSupprimerTypeObjet);
	
		//Ajout onglet a la fenetre
		getPanelOnglet().addTab("Scelles", null, new JScrollPane(panelScelle));
		getPanelOnglet().addTab("Objets", null, new JScrollPane(panelObjet));
		getPanelOnglet().addTab("Type Objets", null, new JScrollPane(panelTypeObjet));
		this.fenetreParent.getContentPane().add(getPanelOnglet());
	}
	
	public void actionPerformed(ActionEvent e) {	
		super.actionPerformed(e);
		
		Scelle scelle = (Scelle) listeSelectionScelle.getSelectedValue();
		Objet objet = (Objet) listeSelectionObjet.getSelectedValue();
		TypeObjet typeObjet = (TypeObjet) listeSelectionTypeObjet.getSelectedValue();
		
		if (e.getSource() == boutonAjouterScelle)
		{
			this.getPanelOnglet().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un scelle");
			
			PanelAjouterScelle panelAjoutScelle = new PanelAjouterScelle(this);
			this.fenetreParent.getContentPane().add(new JScrollPane(panelAjoutScelle));
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonAjouterObjet){
			this.getPanelOnglet().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un objet");
			
			PanelAjouterObjet panelAjoutObjet = new PanelAjouterObjet(this);
			this.fenetreParent.getContentPane().add(new JScrollPane(panelAjoutObjet));
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonAjouterTypeObjet){
			this.getPanelOnglet().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un type objet");
			
			PanelAjouterTypeObjet panelAjoutTypeObjet = new PanelAjouterTypeObjet(this);
			this.fenetreParent.getContentPane().add(new JScrollPane(panelAjoutTypeObjet));
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonConsulterScelle){
			if (scelle != null){
				HashMap<String, Object> hashMapScelle = facadeScelle.consulterScelle(scelle);
				String descriptionScelle = "";
				for (Map.Entry entry : hashMapScelle.entrySet()) {
				    descriptionScelle += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionScelle);
			}
		}
		else if(e.getSource() == boutonConsulterObjet){
			if (objet != null){
				HashMap<String, Object> hashMapObjet = facadeObjet.consulterObjet(objet);
				String descriptionObjet = "";
				for (Map.Entry entry : hashMapObjet.entrySet()) {
				    descriptionObjet += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionObjet);
			}
		}
		else if(e.getSource() == boutonConsulterTypeObjet){
			if (typeObjet != null){
				HashMap<String, Object> hashMapTypeObjet = facadeTypeObjet.consulterTypeObjet(typeObjet);
				String descriptionTypeObjet = "";
				for (Map.Entry entry : hashMapTypeObjet.entrySet()) {
				    descriptionTypeObjet += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionTypeObjet);
			}
		}
		else if(e.getSource() == boutonModifierScelle){
			if (scelle != null){
				this.getPanelOnglet().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un scelle");
			
				PanelModifScelle panelModifScelle = new PanelModifScelle(this, scelle);
				this.fenetreParent.getContentPane().add(new JScrollPane(panelModifScelle));
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
		}
		else if(e.getSource() == boutonModifierObjet){
			if (objet != null){
				this.getPanelOnglet().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un objet");
				
				PanelModifObjet panelModifObjet = new PanelModifObjet(this, objet);
				this.fenetreParent.getContentPane().add(new JScrollPane(panelModifObjet));
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
			
		}
		else if(e.getSource() == boutonModifierTypeObjet){
			if (typeObjet != null){
				this.getPanelOnglet().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un type objet");
				
				PanelModifTypeObjet panelModifTypeObjet = new PanelModifTypeObjet(this, typeObjet);
				this.fenetreParent.getContentPane().add(new JScrollPane(panelModifTypeObjet));
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
			
		}
		else if(e.getSource() == boutonSupprimerScelle){
			if (scelle != null){
				if(verifierSuppressionScelle()){
					try {
						facadeScelle.supprimerScelle(scelle);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelOnglet().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelOnglet);
					this.createOnglets();
				}
			}
			
		}
		else if(e.getSource() == boutonSupprimerObjet){
			if (objet != null){
				if(verifierSuppressionObjet()){
					try {
						facadeObjet.supprimerObjet(objet);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelOnglet().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelOnglet);
					this.createOnglets();
				}
			}
		}
		else if(e.getSource() == boutonSupprimerTypeObjet){
			if (typeObjet != null){
				if(verifierSuppressionTypeObjet()){
					try {
						facadeTypeObjet.supprimerTypeObjet(typeObjet);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelOnglet().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelOnglet);
					this.createOnglets();
				}
			}
		}
	}
	
	public boolean verifierSuppressionScelle() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionScelle.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}
	
	public boolean verifierSuppressionObjet() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionObjet.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}
	
	public boolean verifierSuppressionTypeObjet() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionTypeObjet.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}

	//Methode appellee par les Panels comme Ajout ou Modifier pour revenir sur la page d'accueil en cas d'annulation ou de validation
	public JTabbedPane getPanelOnglet() {
		return panelOnglet;
	}

	public FacadeObjet getFacadeObjet() {
		return facadeObjet;
	}

	public FacadeScelle getFacadeScelle() {
		return facadeScelle;
	}
	
	public FacadeTypeObjet getFacadeTypeObjet(){
		return facadeTypeObjet;
	}
	
	public FacadeAffaire getFacadeAffaire(){
		return facadeAffaire;
	}
}

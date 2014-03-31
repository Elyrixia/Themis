/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

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
import javax.swing.ListSelectionModel;

import business.affaire.Affaire;
import facade.FacadeAffaire;
import facade.FacadeEnqueteur;
import ui.FenetreMenu;
import ui.MainFenetre;
import ui.MyRenderer;

public class AffaireFenetre extends FenetreMenu implements ActionListener{
	
	private FacadeAffaire facadeAffaire;
	private FacadeEnqueteur facadeEnqueteur; //pour choisir l'enqueteur qui a refile l'affaire
	private ArrayList<Affaire> listeAffaire;
	private JFrame fenetreParent;
	
	private JPanel panelAffaire;
	
	private JLabel labelAffaire;
	
	private JScrollPane panneauListeAffaire;
	private JList listeSelectionAffaire;
    private DefaultListModel modelListAffaire;
    
    private JButton boutonAjouterAffaire;
	private JButton boutonConsulterAffaire;
	private JButton boutonModifierAffaire;
	private JButton boutonSupprimerAffaire;
	
	
	// Constructor
	public AffaireFenetre() {
		super();
		this.facadeAffaire = new FacadeAffaire();
		this.facadeEnqueteur = new FacadeEnqueteur();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Suivi Affaire");
		this.createPanel();
		this.setVisible(true);
	}
	
	public void createPanel() {
		panelAffaire = new JPanel(new GridBagLayout());
		//initialisation label & boutons
		labelAffaire = new JLabel("Liste des affaires enregistres");
		boutonAjouterAffaire = new JButton("Ajouter Affaire");
		boutonConsulterAffaire = new JButton("Consulter");
		boutonModifierAffaire = new JButton("Modifier");
		boutonSupprimerAffaire = new JButton("Supprimer");
		
		//Ajout listener sur boutons
		this.boutonAjouterAffaire.addActionListener(this);
		this.boutonConsulterAffaire.addActionListener(this);
		this.boutonModifierAffaire.addActionListener(this);
		this.boutonSupprimerAffaire.addActionListener(this);
		
		//Creation liste
		modelListAffaire = new DefaultListModel();
		listeSelectionAffaire = new JList(modelListAffaire);
	    panneauListeAffaire = new JScrollPane(listeSelectionAffaire);
	    listeSelectionAffaire.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageAffaire = new MyRenderer(facadeAffaire);
	    listeSelectionAffaire.setCellRenderer(affichageAffaire);
	    
	    HashMap<String,String> filtreAffaire = new HashMap<String, String>();
	    listeAffaire = facadeAffaire.chargerAffaire(filtreAffaire);
	    for (int i=0; i < listeAffaire.size(); i++) {
			modelListAffaire.addElement(listeAffaire.get(i));
		}
		
		//Creation contraintes
		GridBagConstraints contrainteBoutonAjouterAffaire = new GridBagConstraints();
		contrainteBoutonAjouterAffaire.gridx=1; contrainteBoutonAjouterAffaire.gridy=0;
		contrainteBoutonAjouterAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAjouterAffaire.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteLabelAffaire = new GridBagConstraints();
		contrainteLabelAffaire.gridx=1; contrainteLabelAffaire.gridy=1;
		contrainteLabelAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteLabelAffaire.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteListeAffaire = new GridBagConstraints();
		contrainteListeAffaire.gridx=0; contrainteListeAffaire.gridy=2;
		contrainteListeAffaire.gridwidth=3; 
		contrainteListeAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteListeAffaire.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonConsulterAffaire = new GridBagConstraints();
		contrainteBoutonConsulterAffaire.gridx=0; contrainteBoutonConsulterAffaire.gridy=3;
		contrainteBoutonConsulterAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterAffaire.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonModifierAffaire = new GridBagConstraints();
		contrainteBoutonModifierAffaire.gridx=1; contrainteBoutonModifierAffaire.gridy=3;
		contrainteBoutonModifierAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonModifierAffaire.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonSupprimerAffaire = new GridBagConstraints();
		contrainteBoutonSupprimerAffaire.gridx=2; contrainteBoutonSupprimerAffaire.gridy=3;
		contrainteBoutonSupprimerAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonSupprimerAffaire.anchor = GridBagConstraints.CENTER;
		
		//Ajout composants avec contraintes au panel
		panelAffaire.add(labelAffaire, contrainteLabelAffaire);
		panelAffaire.add(panneauListeAffaire, contrainteListeAffaire);
		panelAffaire.add(boutonAjouterAffaire, contrainteBoutonAjouterAffaire);
		panelAffaire.add(boutonConsulterAffaire, contrainteBoutonConsulterAffaire);
		panelAffaire.add(boutonModifierAffaire, contrainteBoutonModifierAffaire);
		panelAffaire.add(boutonSupprimerAffaire, contrainteBoutonSupprimerAffaire);
		
		//Ajout onglet a la fenetre
		this.fenetreParent.getContentPane().add(panelAffaire);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		Affaire affaire = (Affaire) listeSelectionAffaire.getSelectedValue();
		
		if (e.getSource() == boutonAjouterAffaire)
		{
			this.getPanelAffaire().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'une affaire");
			
			PanelAjouterAffaire panelAjoutAffaire = new PanelAjouterAffaire(this);
			this.fenetreParent.getContentPane().add(panelAjoutAffaire);
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT+120));
			this.fenetreParent.pack();
		}
		
		else if(e.getSource() == boutonConsulterAffaire){
			if (affaire != null){
				HashMap<String, Object> hashMapAffaire = facadeAffaire.consulterAffaire(affaire);
				String descriptionAffaire = "";
				for (Map.Entry entry : hashMapAffaire.entrySet()) {
				    descriptionAffaire += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionAffaire);
			}
		}
		else if(e.getSource() == boutonModifierAffaire){
			if (affaire != null){
				this.getPanelAffaire().setVisible(false);
				this.fenetreParent.setTitle("Modification d'une affaire");
				
				PanelModifAffaire panelModifAffaire = new PanelModifAffaire(this, affaire);
				this.fenetreParent.getContentPane().add(panelModifAffaire);
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT+120));
				this.fenetreParent.pack();
			}
		}
		
		else if(e.getSource() == boutonSupprimerAffaire){
			if (affaire != null){
				if(verifierSuppressionAffaire()){
					try {
						facadeAffaire.supprimerAffaire(affaire);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelAffaire().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelAffaire);
					this.createPanel();
				}
			}
			
		}
		
	}
	
	public boolean verifierSuppressionAffaire() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionAffaire.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}
	
	//Pour que les panneaux ajout ou modifier puisse acceder au panel accueil
	public JPanel getPanelAffaire() {
		return panelAffaire;
	}
	
	//getter de la facade pour que les panels ajouter et modifier puisse ajouter/modif une affaire
	public FacadeAffaire getFacadeAffaire() {
		return facadeAffaire;
	}

	public FacadeEnqueteur getFacadeEnqueteur() {
		return facadeEnqueteur;
	}
}

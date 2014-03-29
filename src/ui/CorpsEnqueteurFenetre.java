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
import javax.swing.ListSelectionModel;

import business.enqueteur.CorpsEnqueteur;
import facade.FacadeCorpsEnqueteur;


public class CorpsEnqueteurFenetre extends FenetreMenu implements ActionListener{
	
	private FacadeCorpsEnqueteur facadeCorpsEnqueteur;
	private ArrayList<CorpsEnqueteur> listeCorpsEnqueteur;
	
	private JFrame fenetreParent;
	
	private JPanel panelCorps;
	
	private JLabel labelCorpsEnqueteur;
	
	private JScrollPane panneauListeCorpsEnqueteur;
	private JList listeSelectionCorpsEnqueteur;
    private DefaultListModel modelListCorpsEnqueteur;
    
    private JButton boutonAjouterCorpsEnqueteur;
	private JButton boutonConsulterCorpsEnqueteur;
	private JButton boutonModifierCorpsEnqueteur;
	private JButton boutonSupprimerCorpsEnqueteur;
	
	// Constructor
		public CorpsEnqueteurFenetre() {
			super();
			this.facadeCorpsEnqueteur = new FacadeCorpsEnqueteur();
			this.fenetreParent = super.getFenetre();
			this.fenetreParent.setTitle("Accueil Gestion Corps");
			this.createPanel();
			//Ajout listener sur boutons
			this.boutonAjouterCorpsEnqueteur.addActionListener(this);
			this.boutonConsulterCorpsEnqueteur.addActionListener(this);
			this.boutonModifierCorpsEnqueteur.addActionListener(this);
			this.boutonSupprimerCorpsEnqueteur.addActionListener(this);
			
			this.setVisible(true);
		}

		public void createPanel() {
			panelCorps = new JPanel(new GridBagLayout());
			
			labelCorpsEnqueteur = new JLabel("Liste des corps enqueteurs enregistres");
			boutonAjouterCorpsEnqueteur = new JButton("Ajouter Corps Enqueteur");
			boutonConsulterCorpsEnqueteur = new JButton("Consulter");
			boutonModifierCorpsEnqueteur = new JButton("Modifier");
			boutonSupprimerCorpsEnqueteur = new JButton("Supprimer");
			
			//Creation liste
		    modelListCorpsEnqueteur = new DefaultListModel();
			listeSelectionCorpsEnqueteur = new JList(modelListCorpsEnqueteur);
		    panneauListeCorpsEnqueteur = new JScrollPane(listeSelectionCorpsEnqueteur);
		    listeSelectionCorpsEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    
		    /*
		     * TODO : Aller chercher les listes avec facade et les mettre ci-dessus
		     */
		    HashMap<String,String> filtre = new HashMap<String, String>();
		    listeCorpsEnqueteur = facadeCorpsEnqueteur.chargerCorpsEnqueteur(filtre);
		    ArrayList<String> apercus = facadeCorpsEnqueteur.getApercu(listeCorpsEnqueteur);
		    for (int i=0; i < apercus.size(); i++) {
		    	modelListCorpsEnqueteur.addElement(apercus.get(i));
			}
			
			//Creation contraintes
			GridBagConstraints contrainteBoutonAjouterCorpsEnqueteur = new GridBagConstraints();
			contrainteBoutonAjouterCorpsEnqueteur.gridx=1; contrainteBoutonAjouterCorpsEnqueteur.gridy=0;
			contrainteBoutonAjouterCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteBoutonAjouterCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			GridBagConstraints contrainteLabelCorpsEnqueteur = new GridBagConstraints();
			contrainteLabelCorpsEnqueteur.gridx=1; contrainteLabelCorpsEnqueteur.gridy=1;
			contrainteLabelCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteLabelCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			GridBagConstraints contrainteListeCorpsEnqueteur = new GridBagConstraints();
			contrainteListeCorpsEnqueteur.gridx=0; contrainteListeCorpsEnqueteur.gridy=2;
			contrainteListeCorpsEnqueteur.gridwidth=3; 
			contrainteListeCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteListeCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			GridBagConstraints contrainteBoutonConsulterCorpsEnqueteur = new GridBagConstraints();
			contrainteBoutonConsulterCorpsEnqueteur.gridx=0; contrainteBoutonConsulterCorpsEnqueteur.gridy=3;
			contrainteBoutonConsulterCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteBoutonConsulterCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			GridBagConstraints contrainteBoutonModifierCorpsEnqueteur = new GridBagConstraints();
			contrainteBoutonModifierCorpsEnqueteur.gridx=1; contrainteBoutonModifierCorpsEnqueteur.gridy=3;
			contrainteBoutonModifierCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteBoutonModifierCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			GridBagConstraints contrainteBoutonSupprimerCorpsEnqueteur = new GridBagConstraints();
			contrainteBoutonSupprimerCorpsEnqueteur.gridx=2; contrainteBoutonSupprimerCorpsEnqueteur.gridy=3;
			contrainteBoutonSupprimerCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
			contrainteBoutonSupprimerCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
			
			//Ajout composants avec contraintes au panel
			panelCorps.add(labelCorpsEnqueteur, contrainteLabelCorpsEnqueteur);
			panelCorps.add(panneauListeCorpsEnqueteur, contrainteListeCorpsEnqueteur);
			panelCorps.add(boutonAjouterCorpsEnqueteur, contrainteBoutonAjouterCorpsEnqueteur);
			panelCorps.add(boutonConsulterCorpsEnqueteur, contrainteBoutonConsulterCorpsEnqueteur);
			panelCorps.add(boutonModifierCorpsEnqueteur, contrainteBoutonModifierCorpsEnqueteur);
			panelCorps.add(boutonSupprimerCorpsEnqueteur, contrainteBoutonSupprimerCorpsEnqueteur);
			
			//Ajout onglet a la fenetre
			this.fenetreParent.add(panelCorps);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			super.actionPerformed(e);
			
			if (e.getSource() == boutonAjouterCorpsEnqueteur)
			{
				this.getPanelCorps().setVisible(false);
				this.fenetreParent.setTitle("Ajout d'un corps enqueteur");
				
				PanelAjouterCorpsEnqueteur panelAjoutCorpsEnqueteur = new PanelAjouterCorpsEnqueteur();
				panelAjoutCorpsEnqueteur.setFenetre(this);
				this.fenetreParent.getContentPane().add(panelAjoutCorpsEnqueteur);
				//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
			
			else if(e.getSource() == boutonConsulterCorpsEnqueteur){
				if (!(this.listeSelectionCorpsEnqueteur.getSelectedValue() == null)){
					//TODO
				}
			}
			
			else if(e.getSource() == boutonModifierCorpsEnqueteur){
				if (!(this.listeSelectionCorpsEnqueteur.getSelectedValue() == null)){
					//TODO : v�rif d'une s�lection de la liste + modif par rapport � ajout
					this.getPanelCorps().setVisible(false);
					this.fenetreParent.setTitle("Modification d'un corps enqueteur");
				
					PanelModifCorpsEnqueteur panelModifCorpsEnqueteur = new PanelModifCorpsEnqueteur();
					panelModifCorpsEnqueteur.setFenetre(this);
					this.fenetreParent.getContentPane().add(panelModifCorpsEnqueteur);
					//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
					this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
					this.fenetreParent.pack();
				}
			}
			
			else if(e.getSource() == boutonSupprimerCorpsEnqueteur){
				if (!(this.listeSelectionCorpsEnqueteur.getSelectedValue() == null)){
					//TODO
				}
				
			}
			
		}

		//Pour que les panneaux ajout ou modifier puisse acc�der au panel accueil
		public JPanel getPanelCorps() {
			return panelCorps;
		}

		//getter de la facade pour que les panels ajouter et modifier puisse appeller les fonctions correspondantes
		public FacadeCorpsEnqueteur getFacadeCorpsEnqueteur() {
			return facadeCorpsEnqueteur;
		}
	
}

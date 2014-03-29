package ui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class ServiceEnqueteurFenetre extends FenetreMenu implements ActionListener{

	//private FacadeServiceEnqueteur detectiveServiceFacade;
	//private ArrayList<ServiceEnqueteur> listeServiceEnqueteur;
	
	private JFrame fenetreParent;
	
	private JPanel panelService;
	
	private JLabel labelServiceEnqueteur;
	
	private JScrollPane panneauListeServiceEnqueteur;
	private JList listeSelectionServiceEnqueteur;
    private DefaultListModel modelListServiceEnqueteur;
    
    private JButton boutonAjouterServiceEnqueteur;
	private JButton boutonConsulterServiceEnqueteur;
	private JButton boutonModifierServiceEnqueteur;
	private JButton boutonSupprimerServiceEnqueteur;
	
	ServiceEnqueteurFenetre(){
		super();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Gestion Service");
		this.createPanel();
		//Ajout listener sur boutons
		this.boutonAjouterServiceEnqueteur.addActionListener(this);
		this.boutonConsulterServiceEnqueteur.addActionListener(this);
		this.boutonModifierServiceEnqueteur.addActionListener(this);
		this.boutonSupprimerServiceEnqueteur.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public void createPanel() {
		panelService = new JPanel(new GridBagLayout());
		
		labelServiceEnqueteur = new JLabel("Liste des services enqueteurs enregistres");
		boutonAjouterServiceEnqueteur = new JButton("Ajouter Service Enqueteur");
		boutonConsulterServiceEnqueteur = new JButton("Consulter");
		boutonModifierServiceEnqueteur = new JButton("Modifier");
		boutonSupprimerServiceEnqueteur = new JButton("Supprimer");
		
		//Creation liste
	    modelListServiceEnqueteur = new DefaultListModel();
		listeSelectionServiceEnqueteur = new JList(modelListServiceEnqueteur);
	    panneauListeServiceEnqueteur = new JScrollPane(listeSelectionServiceEnqueteur);
	    listeSelectionServiceEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    /*
	     * TODO : Aller chercher les listes avec facade et les mettre ci-dessus
	     */
		
		//Creation contraintes
		GridBagConstraints contrainteBoutonAjouterServiceEnqueteur = new GridBagConstraints();
		contrainteBoutonAjouterServiceEnqueteur.gridx=1; contrainteBoutonAjouterServiceEnqueteur.gridy=0;
		contrainteBoutonAjouterServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAjouterServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteLabelServiceEnqueteur = new GridBagConstraints();
		contrainteLabelServiceEnqueteur.gridx=1; contrainteLabelServiceEnqueteur.gridy=1;
		contrainteLabelServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteLabelServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteListeServiceEnqueteur = new GridBagConstraints();
		contrainteListeServiceEnqueteur.gridx=0; contrainteListeServiceEnqueteur.gridy=2;
		contrainteListeServiceEnqueteur.gridwidth=3; 
		contrainteListeServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonConsulterServiceEnqueteur = new GridBagConstraints();
		contrainteBoutonConsulterServiceEnqueteur.gridx=0; contrainteBoutonConsulterServiceEnqueteur.gridy=3;
		contrainteBoutonConsulterServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonModifierServiceEnqueteur = new GridBagConstraints();
		contrainteBoutonModifierServiceEnqueteur.gridx=1; contrainteBoutonModifierServiceEnqueteur.gridy=3;
		contrainteBoutonModifierServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonModifierServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonSupprimerServiceEnqueteur = new GridBagConstraints();
		contrainteBoutonSupprimerServiceEnqueteur.gridx=2; contrainteBoutonSupprimerServiceEnqueteur.gridy=3;
		contrainteBoutonSupprimerServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonSupprimerServiceEnqueteur.anchor = GridBagConstraints.CENTER;
		
		//Ajout composants avec contraintes au panel
		panelService.add(labelServiceEnqueteur, contrainteLabelServiceEnqueteur);
		panelService.add(panneauListeServiceEnqueteur, contrainteListeServiceEnqueteur);
		panelService.add(boutonAjouterServiceEnqueteur, contrainteBoutonAjouterServiceEnqueteur);
		panelService.add(boutonConsulterServiceEnqueteur, contrainteBoutonConsulterServiceEnqueteur);
		panelService.add(boutonModifierServiceEnqueteur, contrainteBoutonModifierServiceEnqueteur);
		panelService.add(boutonSupprimerServiceEnqueteur, contrainteBoutonSupprimerServiceEnqueteur);
		
		//Ajout onglet a la fenetre
		this.fenetreParent.add(panelService);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		if (e.getSource() == boutonAjouterServiceEnqueteur)
		{
			this.getPanelService().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un services enqueteur");
			
			PanelAjouterServiceEnqueteur panelAjoutServiceEnqueteur = new PanelAjouterServiceEnqueteur();
			panelAjoutServiceEnqueteur.setFenetre(this);
			this.fenetreParent.getContentPane().add(panelAjoutServiceEnqueteur);
			//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		
		else if(e.getSource() == boutonConsulterServiceEnqueteur){
			if (!(this.listeSelectionServiceEnqueteur.getSelectedValue() == null)){
				//TODO
			}
		}
		
		else if(e.getSource() == boutonModifierServiceEnqueteur){
			if (!(this.listeSelectionServiceEnqueteur.getSelectedValue() == null)){
				//TODO : v�rif d'une s�lection de la liste + modif par rapport � ajout
				this.getPanelService().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un services enqueteur");
			
				PanelModifServiceEnqueteur panelModifServiceEnqueteur = new PanelModifServiceEnqueteur();
				panelModifServiceEnqueteur.setFenetre(this);
				this.fenetreParent.getContentPane().add(panelModifServiceEnqueteur);
				//On change la taille de la fenetre avant de pack pour �viter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
		}
		
		else if(e.getSource() == boutonSupprimerServiceEnqueteur){
			if (!(this.listeSelectionServiceEnqueteur.getSelectedValue() == null)){
				//TODO
			}
			
		}
		
	}

	//Pour que les panneaux ajout ou modifier puisse acc�der au panel accueil
	public JPanel getPanelService() {
		return panelService;
	}
}

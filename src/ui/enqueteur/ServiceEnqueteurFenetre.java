/**
 * @author Nathan Marin
 */

package ui.enqueteur;
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

import ui.FenetreMenu;
import ui.MainFenetre;
import ui.MyRenderer;
import business.enqueteur.ServiceEnqueteur;
import facade.FacadeCorpsEnqueteur;
import facade.FacadeServiceEnqueteur;


public class ServiceEnqueteurFenetre extends FenetreMenu implements ActionListener{

	private FacadeServiceEnqueteur facadeServiceEnqueteur;
	private FacadeCorpsEnqueteur facadeCorpsEnqueteur;
	private ArrayList<ServiceEnqueteur> listeServiceEnqueteur;
	
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
	
	public ServiceEnqueteurFenetre(){
		super();
		this.facadeServiceEnqueteur = new FacadeServiceEnqueteur();
		this.facadeCorpsEnqueteur = new FacadeCorpsEnqueteur();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Gestion Service");
		this.createPanel();
		this.setVisible(true);
	}
	
	public void createPanel() {
		panelService = new JPanel(new GridBagLayout());
		
		labelServiceEnqueteur = new JLabel("Liste des services enqueteurs enregistres");
		boutonAjouterServiceEnqueteur = new JButton("Ajouter Service Enqueteur");
		boutonConsulterServiceEnqueteur = new JButton("Consulter");
		boutonModifierServiceEnqueteur = new JButton("Modifier");
		boutonSupprimerServiceEnqueteur = new JButton("Supprimer");
		
		//Ajout listener sur boutons
		this.boutonAjouterServiceEnqueteur.addActionListener(this);
		this.boutonConsulterServiceEnqueteur.addActionListener(this);
		this.boutonModifierServiceEnqueteur.addActionListener(this);
		this.boutonSupprimerServiceEnqueteur.addActionListener(this);
		
		//Creation liste
		modelListServiceEnqueteur = new DefaultListModel();
		listeSelectionServiceEnqueteur = new JList(modelListServiceEnqueteur);
	    panneauListeServiceEnqueteur = new JScrollPane(listeSelectionServiceEnqueteur);
	    listeSelectionServiceEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageServiceEnqueteur = new MyRenderer(facadeServiceEnqueteur);
	    listeSelectionServiceEnqueteur.setCellRenderer(affichageServiceEnqueteur);
	    
	    HashMap<String,String> filtreService = new HashMap<String, String>();
	    listeServiceEnqueteur = facadeServiceEnqueteur.chargerServiceEnqueteur(filtreService);
	    for (int i=0; i < listeServiceEnqueteur.size(); i++) {
			modelListServiceEnqueteur.addElement(listeServiceEnqueteur.get(i));
		}
		
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
		this.fenetreParent.getContentPane().add(panelService);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		ServiceEnqueteur service = (ServiceEnqueteur) listeSelectionServiceEnqueteur.getSelectedValue();
		
		if (e.getSource() == boutonAjouterServiceEnqueteur)
		{
			this.getPanelService().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un service enqueteur");
			
			PanelAjouterServiceEnqueteur panelAjoutServiceEnqueteur = new PanelAjouterServiceEnqueteur(this);
			this.fenetreParent.getContentPane().add(panelAjoutServiceEnqueteur);
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetreParent.pack();
		}
		else if(e.getSource() == boutonConsulterServiceEnqueteur){
			if (service != null){
				HashMap<String, Object> hashMapServiceEnqueteur = facadeServiceEnqueteur.consulterServiceEnqueteur(service);
				String descriptionServiceEnqueteur = "";
				for (Map.Entry entry : hashMapServiceEnqueteur.entrySet()) {
				    descriptionServiceEnqueteur += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionServiceEnqueteur);
			}
		}
		else if(e.getSource() == boutonModifierServiceEnqueteur){
			if (service != null){
				this.getPanelService().setVisible(false);
				this.fenetreParent.setTitle("Modification d'un service enqueteur");
				
				PanelModifServiceEnqueteur panelModifServiceEnqueteur = new PanelModifServiceEnqueteur(this, service);
				this.fenetreParent.getContentPane().add(panelModifServiceEnqueteur);
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
				this.fenetreParent.pack();
			}
			
		}
		else if(e.getSource() == boutonSupprimerServiceEnqueteur){
			if (service != null){
				if(verifierSuppressionServiceEnqueteur()){
					try {
						facadeServiceEnqueteur.supprimerServiceEnqueteur(service);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelService().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelService);
					this.createPanel();
				}
			}
		}
	}

	//Pour que les panneaux ajout ou modifier puisse acceder au panel accueil
	public JPanel getPanelService() {
		return panelService;
	}
	
	public boolean verifierSuppressionServiceEnqueteur() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionServiceEnqueteur.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}
	
	public FacadeServiceEnqueteur getFacadeServiceEnqueteur(){
		return facadeServiceEnqueteur;
	}
	
	public FacadeCorpsEnqueteur getFacadeCorpsEnqueteur(){
		return facadeCorpsEnqueteur;
	}
}

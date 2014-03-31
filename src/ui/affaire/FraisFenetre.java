/**
 * Tristan Sallé
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

import business.affaire.Frais;
import facade.FacadeFrais;
import facade.FacadeAffaire;
import ui.FenetreMenu;
import ui.MainFenetre;
import ui.MyRenderer;

public class FraisFenetre extends FenetreMenu implements ActionListener{
	
	private FacadeFrais facadeFrais;
	private FacadeAffaire facadeAffaire; //pour choisir l'affaire qui concerne ce frais
	private ArrayList<Frais> listeFrais;
	private JFrame fenetreParent;
	
	private JPanel panelFrais;
	
	private JLabel labelFrais;
	
	private JScrollPane panneauListeFrais;
	private JList listeSelectionFrais;
    private DefaultListModel modelListFrais;
    
    private JButton boutonAjouterFrais;
	private JButton boutonConsulterFrais;
	private JButton boutonModifierFrais;
	private JButton boutonSupprimerFrais;
	
	
	// Constructor
	public FraisFenetre() {
		super();
		this.facadeFrais = new FacadeFrais();
		this.facadeAffaire = new FacadeAffaire();
		this.fenetreParent = super.getFenetre();
		this.fenetreParent.setTitle("Accueil Gestion Frais");
		this.createPanel();
		this.setVisible(true);
	}
	
	public void createPanel() {
		panelFrais = new JPanel(new GridBagLayout());
		//initialisation label & boutons
		labelFrais = new JLabel("Liste des frais enregistres");
		boutonAjouterFrais = new JButton("Ajouter Frais");
		boutonConsulterFrais = new JButton("Consulter");
		boutonModifierFrais = new JButton("Modifier");
		boutonSupprimerFrais = new JButton("Supprimer");
		
		//Ajout listener sur boutons
		this.boutonAjouterFrais.addActionListener(this);
		this.boutonConsulterFrais.addActionListener(this);
		this.boutonModifierFrais.addActionListener(this);
		this.boutonSupprimerFrais.addActionListener(this);
		
		//Creation liste
		modelListFrais = new DefaultListModel();
		listeSelectionFrais = new JList(modelListFrais);
	    panneauListeFrais = new JScrollPane(listeSelectionFrais);
	    listeSelectionFrais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageFrais = new MyRenderer(facadeFrais);
	    listeSelectionFrais.setCellRenderer(affichageFrais);
	    
	    HashMap<String,String> filtreFrais = new HashMap<String, String>();
	    listeFrais = facadeFrais.chargerFrais(filtreFrais);
	    for (int i=0; i < listeFrais.size(); i++) {
			modelListFrais.addElement(listeFrais.get(i));
		}
		
		//Creation contraintes
		GridBagConstraints contrainteBoutonAjouterFrais = new GridBagConstraints();
		contrainteBoutonAjouterFrais.gridx=1; contrainteBoutonAjouterFrais.gridy=0;
		contrainteBoutonAjouterFrais.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAjouterFrais.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteLabelFrais = new GridBagConstraints();
		contrainteLabelFrais.gridx=1; contrainteLabelFrais.gridy=1;
		contrainteLabelFrais.insets = new Insets(0, 0, 5, 2);
		contrainteLabelFrais.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteListeFrais = new GridBagConstraints();
		contrainteListeFrais.gridx=0; contrainteListeFrais.gridy=2;
		contrainteListeFrais.gridwidth=3; 
		contrainteListeFrais.insets = new Insets(0, 0, 5, 2);
		contrainteListeFrais.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonConsulterFrais = new GridBagConstraints();
		contrainteBoutonConsulterFrais.gridx=0; contrainteBoutonConsulterFrais.gridy=3;
		contrainteBoutonConsulterFrais.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonConsulterFrais.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonModifierFrais = new GridBagConstraints();
		contrainteBoutonModifierFrais.gridx=1; contrainteBoutonModifierFrais.gridy=3;
		contrainteBoutonModifierFrais.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonModifierFrais.anchor = GridBagConstraints.CENTER;
		GridBagConstraints contrainteBoutonSupprimerFrais = new GridBagConstraints();
		contrainteBoutonSupprimerFrais.gridx=2; contrainteBoutonSupprimerFrais.gridy=3;
		contrainteBoutonSupprimerFrais.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonSupprimerFrais.anchor = GridBagConstraints.CENTER;
		
		//Ajout composants avec contraintes au panel
		panelFrais.add(labelFrais, contrainteLabelFrais);
		panelFrais.add(panneauListeFrais, contrainteListeFrais);
		panelFrais.add(boutonAjouterFrais, contrainteBoutonAjouterFrais);
		panelFrais.add(boutonConsulterFrais, contrainteBoutonConsulterFrais);
		panelFrais.add(boutonModifierFrais, contrainteBoutonModifierFrais);
		panelFrais.add(boutonSupprimerFrais, contrainteBoutonSupprimerFrais);
		
		//Ajout onglet a la fenetre
		this.fenetreParent.getContentPane().add(panelFrais);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		Frais frais = (Frais) listeSelectionFrais.getSelectedValue();
		
		if (e.getSource() == boutonAjouterFrais)
		{
			this.getPanelFrais().setVisible(false);
			this.fenetreParent.setTitle("Ajout d'un frais");
			
			PanelAjouterFrais panelAjoutFrais = new PanelAjouterFrais(this);
			this.fenetreParent.getContentPane().add(panelAjoutFrais);
			//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
			this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT+120));
			this.fenetreParent.pack();
		}
		
		else if(e.getSource() == boutonConsulterFrais){
			if (frais != null){
				HashMap<String, Object> hashMapFrais = facadeFrais.consulterFrais(frais);
				String descriptionFrais = "";
				for (Map.Entry entry : hashMapFrais.entrySet()) {
				    descriptionFrais += entry.getKey() + " : " + entry.getValue() + "\n";
				}
				JOptionPane.showMessageDialog(null, descriptionFrais);
			}
		}
		else if(e.getSource() == boutonModifierFrais){
			if (frais != null){
				this.getPanelFrais().setVisible(false);
				this.fenetreParent.setTitle("Modification d'une frais");
				
				PanelModifFrais panelModifFrais = new PanelModifFrais(this, frais);
				this.fenetreParent.getContentPane().add(panelModifFrais);
				//On change la taille de la fenetre avant de pack pour eviter d'avoir une fenetre trop grande pleine de vide
				this.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT+120));
				this.fenetreParent.pack();
			}
		}
		
		else if(e.getSource() == boutonSupprimerFrais){
			if (frais != null){
				if(verifierSuppressionFrais()){
					try {
						facadeFrais.supprimerFrais(frais);
						JOptionPane.showMessageDialog(null,"Suppression reussie");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					this.getPanelFrais().setVisible(false);
					this.fenetreParent.getContentPane().remove(panelFrais);
					this.createPanel();
				}
			}
			
		}
		
	}
	
	public boolean verifierSuppressionFrais() {
		int reply = JOptionPane.showConfirmDialog(null, "Etes-vous certains de vouloir supprimer " + this.listeSelectionFrais.getSelectedValue() + " ?", "Suppression", JOptionPane.YES_NO_OPTION);
		return reply == JOptionPane.YES_OPTION;
	}
	
	//Pour que les panneaux ajout ou modifier puisse acceder au panel accueil
	public JPanel getPanelFrais() {
		return panelFrais;
	}
	
	//getter de la facade pour que les panels ajouter et modifier puisse ajouter/modif une frais
	public FacadeFrais getFacadeFrais() {
		return facadeFrais;
	}

	public FacadeAffaire getFacadeAffaire() {
		return facadeAffaire;
	}
}
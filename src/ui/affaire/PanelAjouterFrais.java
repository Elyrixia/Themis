/**
 * @author: Tristan Sallé
 */

package ui.affaire;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import business.affaire.Affaire;
import ui.MainFenetre;
import ui.MyRenderer;

public class PanelAjouterFrais extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected FraisFenetre fenetre;
	//Labels
	protected JLabel labelLibelle;
	protected JLabel labelMontant;
	protected JLabel labelAffaire;
	//Inputs
	protected JTextField inputLibelle;
	protected JFormattedTextField inputMontant;
	//JList pour choisir l'enqueteur qui a donne l'affaire
    private DefaultListModel modelListAffaire;
	protected JList listeSelectionAffaire;
	private JScrollPane panneauListeAffaire;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterFrais(FraisFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		labelLibelle = new JLabel("Libelle :");
		GridBagConstraints contrainteLabelLibelle = new GridBagConstraints();
		contrainteLabelLibelle.gridx = 0;
		contrainteLabelLibelle.gridy = 0;
		contrainteLabelLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLibelle.anchor = GridBagConstraints.WEST;
		this.add(labelLibelle, contrainteLabelLibelle);
		
		inputLibelle = new JTextField(); inputLibelle.setColumns(15);
		GridBagConstraints contrainteInputLibelle = new GridBagConstraints();
		contrainteInputLibelle.gridx = 1;
		contrainteInputLibelle.gridy = 0;
		contrainteInputLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteInputLibelle.anchor = GridBagConstraints.WEST;
		this.add(inputLibelle, contrainteInputLibelle);
		
		labelMontant = new JLabel("Montant :");
		GridBagConstraints contrainteLabelMontant = new GridBagConstraints();
		contrainteLabelMontant.gridx = 0;
		contrainteLabelMontant.gridy = 1;
		contrainteLabelMontant.insets = new Insets(0, 0, 5, 2);
		contrainteLabelMontant.anchor = GridBagConstraints.WEST;
		this.add(labelMontant, contrainteLabelMontant);
		
		inputMontant = new JFormattedTextField(NumberFormat.getNumberInstance()); inputMontant.setColumns(10);
		GridBagConstraints contrainteInputMontant = new GridBagConstraints();
		contrainteInputMontant.gridx = 1;
		contrainteInputMontant.gridy = 1;
		contrainteInputMontant.insets = new Insets(0, 0, 5, 2);
		contrainteInputMontant.anchor = GridBagConstraints.WEST;
		this.add(inputMontant, contrainteInputMontant);
		
		//Liste affaire
		labelAffaire = new JLabel("Affaire :");
		GridBagConstraints contrainteLabelAffaire = new GridBagConstraints();
		contrainteLabelAffaire.gridx = 0;
		contrainteLabelAffaire.gridy = 2;
		contrainteLabelAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteLabelAffaire.anchor = GridBagConstraints.WEST;
		this.add(labelAffaire, contrainteLabelAffaire);
		
		modelListAffaire = new DefaultListModel();
		listeSelectionAffaire = new JList(modelListAffaire);
	    panneauListeAffaire = new JScrollPane(listeSelectionAffaire);
	    listeSelectionAffaire.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageAffaire = new MyRenderer(this.fenetre.getFacadeAffaire());
	    listeSelectionAffaire.setCellRenderer(affichageAffaire);
	    GridBagConstraints contrainteListeAffaire = new GridBagConstraints();
		contrainteListeAffaire.gridx=1; contrainteListeAffaire.gridy=2;
		contrainteListeAffaire.gridwidth=2;
		contrainteListeAffaire.insets = new Insets(0, 0, 5, 2);
		contrainteListeAffaire.anchor = GridBagConstraints.CENTER;
		
		ArrayList<Affaire> listeAffaire;
	    HashMap<String,String> filtreAffaire = new HashMap<String, String>();
	    listeAffaire = this.fenetre.getFacadeAffaire().chargerAffaire(filtreAffaire);
	    for (int i=0; i < listeAffaire.size(); i++) {
			modelListAffaire.addElement(listeAffaire.get(i));
		}
	    this.add(panneauListeAffaire, contrainteListeAffaire);
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 3;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		boutonValider.addActionListener(this);
		add(boutonValider, contrainteBoutonValider);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 3;
		contrainteBoutonAnnuler.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAnnuler.anchor = GridBagConstraints.WEST;
		boutonAnnuler.addActionListener(this);
		add(boutonAnnuler, contrainteBoutonAnnuler);
				
		this.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{			
			this.retourFenetre();
		}
		else if(e.getSource() == boutonValider){
			String libelle = inputLibelle.getText(); Number montant = (Number) inputMontant.getValue(); 
			Affaire affaire = (Affaire) listeSelectionAffaire.getSelectedValue();
			if(libelle.equals("") || montant == null || affaire == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeFrais().ajouterFrais(libelle, montant.intValue(), affaire);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Ajout reussi");
				this.retourFenetre();
			}
		}
	}
	
	//Methode qui enleve ce panel de la fenetre pour remettre le panel d'accueil
	public void retourFenetre(){
		this.fenetre.getContentPane().remove(this);
		this.fenetre.setTitle("Accueil Gestion Frais");
		this.fenetre.createPanel();
		
		this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
		this.fenetre.pack();
	}

}

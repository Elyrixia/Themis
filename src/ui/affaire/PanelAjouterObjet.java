package ui.affaire;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ui.MainFenetre;
import ui.MyRenderer;
import business.affaire.TypeObjet;
import business.affaire.Objet;
import business.affaire.Scelle;

public class PanelAjouterObjet extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected ScelleFenetre fenetre;
	//Labels
	protected JLabel labelLibelle;
	protected JLabel labelCommentaire;
	protected JLabel labelTypeObjet;
	protected JLabel labelScelle;
	protected JLabel labelObjet;
		
	//Inputs
	protected JTextField inputLibelle;
	protected JTextArea inputCommentaire;
	//JList pour choisir le scelle qui concerne l'objet
	private DefaultListModel modelListScelle;
	protected JList listeSelectionScelle;
	private JScrollPane panneauListeScelle;
	//JList pour choisir le type qui concerne l'objet
	private DefaultListModel modelListTypeObjet;
	protected JList listeSelectionTypeObjet;
	private JScrollPane panneauListeTypeObjet;
	//JList pour choisir eventuellement un objet si c'est un sous objet en cours d'ajout
	private DefaultListModel modelListObjet;
	protected JList listeSelectionObjet;
	private JScrollPane panneauListeObjet;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterObjet(ScelleFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		labelLibelle = new JLabel("Lieu Recup :");
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
		
		labelCommentaire = new JLabel("Commentaire :");
		GridBagConstraints contrainteLabelCommentaire = new GridBagConstraints();
		contrainteLabelCommentaire.gridx = 0;
		contrainteLabelCommentaire.gridy = 1;
		contrainteLabelCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteLabelCommentaire.anchor = GridBagConstraints.WEST;
		this.add(labelCommentaire, contrainteLabelCommentaire);
		
		inputCommentaire = new JTextArea(5,20); inputCommentaire.setText("");
		GridBagConstraints contrainteInputCommentaire = new GridBagConstraints();
		contrainteInputCommentaire.gridx = 1;
		contrainteInputCommentaire.gridy = 1;
		contrainteInputCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteInputCommentaire.anchor = GridBagConstraints.WEST;
		
		JScrollPane areaScrollPane = new JScrollPane(inputCommentaire);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(200, 100));
		this.add(areaScrollPane, contrainteInputCommentaire);
		
		//Liste Type Objet
		labelTypeObjet = new JLabel("Type Objet :");
		GridBagConstraints contrainteLabelTypeObjet = new GridBagConstraints();
		contrainteLabelTypeObjet.gridx = 0;
		contrainteLabelTypeObjet.gridy = 2;
		contrainteLabelTypeObjet.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTypeObjet.anchor = GridBagConstraints.WEST;
		this.add(labelTypeObjet, contrainteLabelTypeObjet);
				
		modelListTypeObjet = new DefaultListModel();
		listeSelectionTypeObjet = new JList(modelListTypeObjet);
		panneauListeTypeObjet = new JScrollPane(listeSelectionTypeObjet);
		listeSelectionTypeObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MyRenderer affichageTypeObjet = new MyRenderer(this.fenetre.getFacadeTypeObjet());
		listeSelectionTypeObjet.setCellRenderer(affichageTypeObjet);
		GridBagConstraints contrainteListeTypeObjet = new GridBagConstraints();
		contrainteListeTypeObjet.gridx=1; contrainteListeTypeObjet.gridy=2;
		contrainteListeTypeObjet.gridwidth=2;
		contrainteListeTypeObjet.insets = new Insets(0, 0, 5, 2);
		contrainteListeTypeObjet.anchor = GridBagConstraints.CENTER;
		
		ArrayList<TypeObjet> listeTypeObjet;
		HashMap<String,String> filtreTypeObjet = new HashMap<String, String>();
		listeTypeObjet = this.fenetre.getFacadeTypeObjet().chargerTypeObjet(filtreTypeObjet);
		for (int i=0; i < listeTypeObjet.size(); i++) {
			modelListTypeObjet.addElement(listeTypeObjet.get(i));
		}
		this.add(panneauListeTypeObjet, contrainteListeTypeObjet);
		
		//Liste Scelle
		labelScelle = new JLabel("Scelle :");
		GridBagConstraints contrainteLabelScelle = new GridBagConstraints();
		contrainteLabelScelle.gridx = 0;
		contrainteLabelScelle.gridy = 3;
		contrainteLabelScelle.insets = new Insets(0, 0, 5, 2);
		contrainteLabelScelle.anchor = GridBagConstraints.WEST;
		this.add(labelScelle, contrainteLabelScelle);
						
		modelListScelle = new DefaultListModel();
		listeSelectionScelle = new JList(modelListScelle);
		panneauListeScelle = new JScrollPane(listeSelectionScelle);
		listeSelectionScelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MyRenderer affichageScelle = new MyRenderer(this.fenetre.getFacadeScelle());
		listeSelectionScelle.setCellRenderer(affichageScelle);
		GridBagConstraints contrainteListeScelle = new GridBagConstraints();
		contrainteListeScelle.gridx=1; contrainteListeTypeObjet.gridy=3;
		contrainteListeScelle.gridwidth=2;
		contrainteListeScelle.insets = new Insets(0, 0, 5, 2);
		contrainteListeScelle.anchor = GridBagConstraints.CENTER;
				
		ArrayList<Scelle> listeScelle;
		HashMap<String,String> filtreScelle = new HashMap<String, String>();
		listeScelle = this.fenetre.getFacadeScelle().chargerScelle(filtreScelle);
		for (int i=0; i < listeScelle.size(); i++) {
			modelListScelle.addElement(listeScelle.get(i));
		}
		this.add(panneauListeScelle, contrainteListeScelle);
		   
		//Liste objets parents
		labelObjet = new JLabel("Objet Parent :");
		GridBagConstraints contrainteLabelObjet = new GridBagConstraints();
		contrainteLabelObjet.gridx = 0;
		contrainteLabelObjet.gridy = 4;
		contrainteLabelObjet.insets = new Insets(0, 0, 5, 2);
		contrainteLabelObjet.anchor = GridBagConstraints.WEST;
		this.add(labelObjet, contrainteLabelObjet);
		
		modelListObjet = new DefaultListModel();
		listeSelectionObjet = new JList(modelListObjet);
		panneauListeObjet = new JScrollPane(listeSelectionObjet);
		listeSelectionObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MyRenderer affichageObjet = new MyRenderer(this.fenetre.getFacadeObjet());
		listeSelectionObjet.setCellRenderer(affichageObjet);
		GridBagConstraints contrainteListeObjet = new GridBagConstraints();
		contrainteListeObjet.gridx=1; contrainteListeObjet.gridy=4;
		contrainteListeObjet.gridwidth=2;
		contrainteListeObjet.insets = new Insets(0, 0, 5, 2);
		contrainteListeObjet.anchor = GridBagConstraints.CENTER;
		 		
		ArrayList<Objet> listeObjet;
		HashMap<String,String> filtreObjet = new HashMap<String, String>();
		listeObjet = this.fenetre.getFacadeObjet().chargerObjet(filtreObjet);
		modelListObjet.addElement(null);
		for (int i=0; i < listeObjet.size(); i++) {
			modelListObjet.addElement(listeObjet.get(i));
		}
		this.add(panneauListeObjet, contrainteListeObjet);
			
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 5;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		boutonValider.addActionListener(this);
		add(boutonValider, contrainteBoutonValider);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 5;
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
			String libelle = inputLibelle.getText(); String commentaire = inputCommentaire.getText(); 
			Scelle scelle = (Scelle) listeSelectionScelle.getSelectedValue(); 
			TypeObjet typeObjet = (TypeObjet) listeSelectionTypeObjet.getSelectedValue();
			Objet objet = (Objet) listeSelectionObjet.getSelectedValue();
			if(libelle.equals("") || scelle == null || typeObjet == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeObjet().ajouterObjet(libelle, commentaire, scelle, typeObjet, objet);
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
			this.fenetre.getContentPane().remove(this.getParent().getParent()); //double getParent() a cause du JScrollPane
			this.fenetre.setTitle("Accueil Suivi Objet");
			this.fenetre.createOngletsScelle();
			
			this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetre.pack();
	}
}

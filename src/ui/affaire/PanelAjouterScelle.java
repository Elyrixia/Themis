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
import business.affaire.Scelle;
import ui.MainFenetre;
import ui.MyRenderer;

public class PanelAjouterScelle extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected ScelleFenetre fenetre;
	//Labels
	protected JLabel labelNumPV;
	protected JLabel labelDateRecup;
	protected JLabel labelLieuRecup;
	protected JLabel labelCommentaire;
	protected JLabel labelAffaire;
	protected JLabel labelScelle;
	
	//Inputs
	protected JFormattedTextField inputNumPV;
	protected JFormattedTextField inputDateRecup;
	protected JTextField inputLieuRecup;
	protected JTextArea inputCommentaire;
	//JList pour choisir eventuellement un scelle si c'est un sous scelle en cours d'ajout
	private DefaultListModel modelListScelle;
	protected JList listeSelectionScelle;
	private JScrollPane panneauListeScelle;
	//JList pour choisir l'affaire qui concerne le scelle
	private DefaultListModel modelListAffaire;
	protected JList listeSelectionAffaire;
	private JScrollPane panneauListeAffaire;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterScelle(ScelleFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		labelNumPV = new JLabel("Numero Proces Verbal :");
		GridBagConstraints contrainteLabelNumPV = new GridBagConstraints();
		contrainteLabelNumPV.gridx = 0;
		contrainteLabelNumPV.gridy = 1;
		contrainteLabelNumPV.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNumPV.anchor = GridBagConstraints.WEST;
		this.add(labelNumPV, contrainteLabelNumPV);
		
		inputNumPV = new JFormattedTextField(NumberFormat.getNumberInstance()); inputNumPV.setColumns(10);
		GridBagConstraints contrainteInputNumPV = new GridBagConstraints();
		contrainteInputNumPV.gridx = 1;
		contrainteInputNumPV.gridy = 1;
		contrainteInputNumPV.insets = new Insets(0, 0, 5, 2);
		contrainteInputNumPV.anchor = GridBagConstraints.WEST;
		this.add(inputNumPV, contrainteInputNumPV);
		
		labelDateRecup = new JLabel("Date Recup (jj/mm/aaaa) :");
		GridBagConstraints contrainteLabelDateRecup = new GridBagConstraints();
		contrainteLabelDateRecup.gridx = 0;
		contrainteLabelDateRecup.gridy = 2;
		contrainteLabelDateRecup.insets = new Insets(0, 0, 5, 2);
		contrainteLabelDateRecup.anchor = GridBagConstraints.WEST;
		this.add(labelDateRecup, contrainteLabelDateRecup);
		
		DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		inputDateRecup = new JFormattedTextField(formatDate); inputDateRecup.setColumns(10);
		GridBagConstraints contrainteInputDateRecup = new GridBagConstraints();
		contrainteInputDateRecup.gridx = 1;
		contrainteInputDateRecup.gridy = 2;
		contrainteInputDateRecup.insets = new Insets(0, 0, 5, 2);
		contrainteInputDateRecup.anchor = GridBagConstraints.WEST;
		this.add(inputDateRecup, contrainteInputDateRecup);
		
		labelLieuRecup = new JLabel("Lieu Recup :");
		GridBagConstraints contrainteLabelLieuRecup = new GridBagConstraints();
		contrainteLabelLieuRecup.gridx = 0;
		contrainteLabelLieuRecup.gridy = 3;
		contrainteLabelLieuRecup.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLieuRecup.anchor = GridBagConstraints.WEST;
		this.add(labelLieuRecup, contrainteLabelLieuRecup);
		
		inputLieuRecup = new JTextField(); inputLieuRecup.setColumns(15);
		GridBagConstraints contrainteInputLieuRecup = new GridBagConstraints();
		contrainteInputLieuRecup.gridx = 1;
		contrainteInputLieuRecup.gridy = 3;
		contrainteInputLieuRecup.insets = new Insets(0, 0, 5, 2);
		contrainteInputLieuRecup.anchor = GridBagConstraints.WEST;
		this.add(inputLieuRecup, contrainteInputLieuRecup);
		
		labelCommentaire = new JLabel("Commentaire :");
		GridBagConstraints contrainteLabelCommentaire = new GridBagConstraints();
		contrainteLabelCommentaire.gridx = 0;
		contrainteLabelCommentaire.gridy = 4;
		contrainteLabelCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteLabelCommentaire.anchor = GridBagConstraints.WEST;
		this.add(labelCommentaire, contrainteLabelCommentaire);
		
		inputCommentaire = new JTextArea(5,20); inputCommentaire.setText("");
		GridBagConstraints contrainteInputCommentaire = new GridBagConstraints();
		contrainteInputCommentaire.gridx = 1;
		contrainteInputCommentaire.gridy = 4;
		contrainteInputCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteInputCommentaire.anchor = GridBagConstraints.WEST;
		
		JScrollPane areaScrollPane = new JScrollPane(inputCommentaire);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(200, 100));
		this.add(areaScrollPane, contrainteInputCommentaire);
		
		//Liste affaire
		labelAffaire = new JLabel("Affaire :");
		GridBagConstraints contrainteLabelAffaire = new GridBagConstraints();
		contrainteLabelAffaire.gridx = 0;
		contrainteLabelAffaire.gridy = 5;
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
		contrainteListeAffaire.gridx=1; contrainteListeAffaire.gridy=5;
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
	    
	    //Liste scelle
	    labelScelle = new JLabel("Scelle :");
	    GridBagConstraints contrainteLabelScelle = new GridBagConstraints();
	    contrainteLabelScelle.gridx = 0;
	    contrainteLabelScelle.gridy = 6;
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
	  	contrainteListeScelle.gridx=1; contrainteListeScelle.gridy=6;
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
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 9;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		boutonValider.addActionListener(this);
		add(boutonValider, contrainteBoutonValider);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 9;
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
			String lieuRecup = inputLieuRecup.getText(); Number numPV = (Number) inputNumPV.getValue(); Date dateRecup = (Date) inputDateRecup.getValue(); 
			String commentaire = inputCommentaire.getText(); Affaire affaire = (Affaire) listeSelectionAffaire.getSelectedValue();
			Scelle scelle = (Scelle) listeSelectionScelle.getSelectedValue();
			if(lieuRecup.equals("") || numPV == null || dateRecup == null || lieuRecup == null || affaire == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeScelle().ajouterScelle(numPV.intValue(), dateRecup, lieuRecup, commentaire, affaire, scelle);
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
			this.fenetre.setTitle("Accueil Suivi Affaire");
			this.fenetre.createOnglets();
			
			this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
			this.fenetre.pack();
	}
}

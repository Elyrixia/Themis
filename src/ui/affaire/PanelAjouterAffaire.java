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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.MainFenetre;


public class PanelAjouterAffaire extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected AffaireFenetre fenetre;
	//Labels
	protected JLabel labelNom;
	protected JLabel labelNumInstruction;
	protected JLabel labelNumDossier;
	protected JLabel labelNumParquet;
	protected JLabel labelDateOrdre;
	protected JLabel labelDelai;
	protected JLabel labelDateMaxRendu;
	protected JLabel labelCommentaire;
	//Inputs
	protected JTextField inputNom;
	protected JFormattedTextField inputNumInstruction;
	protected JFormattedTextField inputNumDossier;
	protected JFormattedTextField inputNumParquet;
	protected JFormattedTextField inputDateOrdre;
	protected JCheckBox inputDelai;
	protected JFormattedTextField inputDateMaxRendu;
	protected JTextArea inputCommentaire;
	
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterAffaire(AffaireFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		labelNom = new JLabel("Nom :");
		GridBagConstraints contrainteLabelNom = new GridBagConstraints();
		contrainteLabelNom.gridx = 0;
		contrainteLabelNom.gridy = 0;
		contrainteLabelNom.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNom.anchor = GridBagConstraints.WEST;
		this.add(labelNom, contrainteLabelNom);
		
		inputNom = new JTextField(); inputNom.setColumns(15);
		GridBagConstraints contrainteInputNom = new GridBagConstraints();
		contrainteInputNom.gridx = 1;
		contrainteInputNom.gridy = 0;
		contrainteInputNom.insets = new Insets(0, 0, 5, 2);
		contrainteInputNom.anchor = GridBagConstraints.WEST;
		this.add(inputNom, contrainteInputNom);
		
		labelNumInstruction = new JLabel("Numero Instruction :");
		GridBagConstraints contrainteLabelNumInstruction = new GridBagConstraints();
		contrainteLabelNumInstruction.gridx = 0;
		contrainteLabelNumInstruction.gridy = 1;
		contrainteLabelNumInstruction.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNumInstruction.anchor = GridBagConstraints.WEST;
		this.add(labelNumInstruction, contrainteLabelNumInstruction);
		
		inputNumInstruction = new JFormattedTextField(NumberFormat.getNumberInstance()); inputNumInstruction.setColumns(10);
		GridBagConstraints contrainteInputNumInstruction = new GridBagConstraints();
		contrainteInputNumInstruction.gridx = 1;
		contrainteInputNumInstruction.gridy = 1;
		contrainteInputNumInstruction.insets = new Insets(0, 0, 5, 2);
		contrainteInputNumInstruction.anchor = GridBagConstraints.WEST;
		this.add(inputNumInstruction, contrainteInputNumInstruction);
		
		labelNumDossier = new JLabel("Numero Dossier :");
		GridBagConstraints contrainteLabelNumDossier = new GridBagConstraints();
		contrainteLabelNumDossier.gridx = 0;
		contrainteLabelNumDossier.gridy = 2;
		contrainteLabelNumDossier.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNumDossier.anchor = GridBagConstraints.WEST;
		this.add(labelNumDossier, contrainteLabelNumDossier);
		
		inputNumDossier = new JFormattedTextField(NumberFormat.getNumberInstance()); inputNumDossier.setColumns(10);
		GridBagConstraints contrainteInputNumDossier = new GridBagConstraints();
		contrainteInputNumDossier.gridx = 1;
		contrainteInputNumDossier.gridy = 2;
		contrainteInputNumDossier.insets = new Insets(0, 0, 5, 2);
		contrainteInputNumDossier.anchor = GridBagConstraints.WEST;
		this.add(inputNumDossier, contrainteInputNumDossier);
		
		labelNumParquet = new JLabel("Numero Parquet :");
		GridBagConstraints contrainteLabelNumParquet = new GridBagConstraints();
		contrainteLabelNumParquet.gridx = 0;
		contrainteLabelNumParquet.gridy = 3;
		contrainteLabelNumParquet.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNumParquet.anchor = GridBagConstraints.WEST;
		this.add(labelNumParquet, contrainteLabelNumParquet);
		
		inputNumParquet = new JFormattedTextField(NumberFormat.getNumberInstance()); inputNumParquet.setColumns(10);
		GridBagConstraints contrainteInputNumParquet = new GridBagConstraints();
		contrainteInputNumParquet.gridx = 1;
		contrainteInputNumParquet.gridy = 3;
		contrainteInputNumParquet.insets = new Insets(0, 0, 5, 2);
		contrainteInputNumParquet.anchor = GridBagConstraints.WEST;
		this.add(inputNumParquet, contrainteInputNumParquet);
		
		labelDateOrdre = new JLabel("Date Ordre (yyyy-MM-dd) :");
		GridBagConstraints contrainteLabelDateOrdre = new GridBagConstraints();
		contrainteLabelDateOrdre.gridx = 0;
		contrainteLabelDateOrdre.gridy = 4;
		contrainteLabelDateOrdre.insets = new Insets(0, 0, 5, 2);
		contrainteLabelDateOrdre.anchor = GridBagConstraints.WEST;
		this.add(labelDateOrdre, contrainteLabelDateOrdre);
		
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		
		inputDateOrdre = new JFormattedTextField(formatDate); inputDateOrdre.setColumns(10);
		GridBagConstraints contrainteInputDateOrdre = new GridBagConstraints();
		contrainteInputDateOrdre.gridx = 1;
		contrainteInputDateOrdre.gridy = 4;
		contrainteInputDateOrdre.insets = new Insets(0, 0, 5, 2);
		contrainteInputDateOrdre.anchor = GridBagConstraints.WEST;
		this.add(inputDateOrdre, contrainteInputDateOrdre);
		
		labelDelai = new JLabel("Delai 10 jours :");
		GridBagConstraints contrainteLabelDelai = new GridBagConstraints();
		contrainteLabelDelai.gridx = 0;
		contrainteLabelDelai.gridy = 5;
		contrainteLabelDelai.insets = new Insets(0, 0, 5, 2);
		contrainteLabelDelai.anchor = GridBagConstraints.WEST;
		this.add(labelDelai, contrainteLabelDelai);
		
		inputDelai = new JCheckBox();
		inputDelai.addActionListener(this);
		
		GridBagConstraints contrainteInputDelai = new GridBagConstraints();
		contrainteInputDelai.gridx = 1;
		contrainteInputDelai.gridy = 5;
		contrainteInputDelai.insets = new Insets(0, 0, 5, 2);
		contrainteInputDelai.anchor = GridBagConstraints.WEST;
		this.add(inputDelai, contrainteInputDelai);
		
		labelDateMaxRendu = new JLabel("Date Max Rendu (yyyy-MM-dd) :");
		GridBagConstraints contrainteLabelDateMaxRendu = new GridBagConstraints();
		contrainteLabelDateMaxRendu.gridx = 0;
		contrainteLabelDateMaxRendu.gridy = 6;
		contrainteLabelDateMaxRendu.insets = new Insets(0, 0, 5, 2);
		contrainteLabelDateMaxRendu.anchor = GridBagConstraints.WEST;
		this.add(labelDateMaxRendu, contrainteLabelDateMaxRendu);
		
		inputDateMaxRendu = new JFormattedTextField(formatDate); inputDateMaxRendu.setColumns(10);
		GridBagConstraints contrainteInputDateMaxRendu = new GridBagConstraints();
		contrainteInputDateMaxRendu.gridx = 1;
		contrainteInputDateMaxRendu.gridy = 6;
		contrainteInputDateMaxRendu.insets = new Insets(0, 0, 5, 2);
		contrainteInputDateMaxRendu.anchor = GridBagConstraints.WEST;
		this.add(inputDateMaxRendu, contrainteInputDateMaxRendu);
		
		labelCommentaire = new JLabel("Commentaire :");
		GridBagConstraints contrainteLabelCommentaire = new GridBagConstraints();
		contrainteLabelCommentaire.gridx = 0;
		contrainteLabelCommentaire.gridy = 7;
		contrainteLabelCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteLabelCommentaire.anchor = GridBagConstraints.WEST;
		this.add(labelCommentaire, contrainteLabelCommentaire);
		
		inputCommentaire = new JTextArea(5,20); inputCommentaire.setText("");
		GridBagConstraints contrainteInputCommentaire = new GridBagConstraints();
		contrainteInputCommentaire.gridx = 1;
		contrainteInputCommentaire.gridy = 7;
		contrainteInputCommentaire.insets = new Insets(0, 0, 5, 2);
		contrainteInputCommentaire.anchor = GridBagConstraints.WEST;
		//this.add(inputCommentaire, contrainteInputCommentaire);
		
		JScrollPane areaScrollPane = new JScrollPane(inputCommentaire);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(200, 100));
		this.add(areaScrollPane, contrainteInputCommentaire);
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 8;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		boutonValider.addActionListener(this);
		add(boutonValider, contrainteBoutonValider);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 8;
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
			String nom = inputNom.getText(); Number numInstruction = (Number) inputNumInstruction.getValue(); 
			Number numDossier = (Number) inputNumDossier.getValue(); Number numParquet = (Number) inputNumParquet.getValue();
			Date dateOrdre = (Date) inputDateOrdre.getValue(); Date dateRendu = (Date) inputDateMaxRendu.getValue();
			boolean delai = inputDelai.isSelected(); String commentaire = inputCommentaire.getText();
			if(nom.equals("") || numInstruction == null || numDossier == null || numParquet == null || 
					dateOrdre == null || dateRendu == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeAffaire().ajouterAffaire(nom, numDossier.intValue(), numInstruction.intValue(), numParquet.intValue(),
							dateOrdre, dateRendu, delai, commentaire);
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
		this.fenetre.setTitle("Accueil Suivi Affaire");
		this.fenetre.createPanel();
		
		this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
		this.fenetre.pack();
	}

}

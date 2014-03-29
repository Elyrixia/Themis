package ui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelAjouterEnqueteur extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected EnqueteurFenetre fenetre;
	//Labels
	protected JLabel labelNom;
	protected JLabel labelPrenom;
	protected JLabel labelAdresse;
	protected JLabel labelTelPerso;
	protected JLabel labelTelPro;
	protected JLabel labelFax;
	protected JLabel labelMail;
	
	//Inputs
	protected JTextField inputNom;
	protected JTextField inputPrenom;
	protected JTextField inputAdresse;
	protected JTextField inputTelPro;
	protected JTextField inputTelPerso;
	protected JTextField inputFax;
	protected JTextField inputMail;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterEnqueteur(){
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		 
		labelNom = new JLabel("Nom :");
		GridBagConstraints contrainteLabelNom = new GridBagConstraints();
		contrainteLabelNom.gridx = 0;
		contrainteLabelNom.gridy = 0;
		contrainteLabelNom.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNom.anchor = GridBagConstraints.WEST;
		this.add(labelNom, contrainteLabelNom);
		
		inputNom = new JTextField(); inputNom.setColumns(10);
		GridBagConstraints contrainteInputNom = new GridBagConstraints();
		contrainteInputNom.gridx = 1;
		contrainteInputNom.gridy = 0;
		contrainteInputNom.insets = new Insets(0, 0, 5, 2);
		contrainteInputNom.anchor = GridBagConstraints.WEST;
		add(inputNom, contrainteInputNom);
		
		labelPrenom = new JLabel("Prenom :");
		GridBagConstraints contrainteLabelPrenom = new GridBagConstraints();
		contrainteLabelPrenom.gridx = 0;
		contrainteLabelPrenom.gridy = 1;
		contrainteLabelPrenom.insets = new Insets(0, 0, 5, 2);
		contrainteLabelPrenom.anchor = GridBagConstraints.WEST;
		this.add(labelPrenom, contrainteLabelPrenom);
		
		inputPrenom = new JTextField(); inputPrenom.setColumns(10);
		GridBagConstraints contrainteInputPrenom = new GridBagConstraints();
		contrainteInputPrenom.gridx = 1;
		contrainteInputPrenom.gridy = 1;
		contrainteInputPrenom.insets = new Insets(0, 0, 5, 2);
		contrainteInputPrenom.anchor = GridBagConstraints.WEST;
		add(inputPrenom, contrainteInputPrenom);
		
		labelAdresse = new JLabel("Adresse :");
		GridBagConstraints contrainteLabelAdresse = new GridBagConstraints();
		contrainteLabelAdresse.gridx = 0;
		contrainteLabelAdresse.gridy = 2;
		contrainteLabelAdresse.insets = new Insets(0, 0, 5, 2);
		contrainteLabelAdresse.anchor = GridBagConstraints.WEST;
		this.add(labelAdresse, contrainteLabelAdresse);
		
		inputAdresse = new JTextField(); inputAdresse.setColumns(30);
		GridBagConstraints contrainteInputAdresse = new GridBagConstraints();
		contrainteInputAdresse.gridx = 1;
		contrainteInputAdresse.gridy = 2;
		contrainteInputAdresse.insets = new Insets(0, 0, 5, 2);
		contrainteInputAdresse.anchor = GridBagConstraints.WEST;
		add(inputAdresse, contrainteInputAdresse);
		
		labelTelPro = new JLabel("Tel Pro :");
		GridBagConstraints contrainteLabelTelPro = new GridBagConstraints();
		contrainteLabelTelPro.gridx = 0;
		contrainteLabelTelPro.gridy = 3;
		contrainteLabelTelPro.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelPro.anchor = GridBagConstraints.WEST;
		this.add(labelTelPro, contrainteLabelTelPro);
		
		inputTelPro = new JTextField(); inputTelPro.setColumns(10);
		GridBagConstraints contrainteInputTelPro = new GridBagConstraints();
		contrainteInputTelPro.gridx = 1;
		contrainteInputTelPro.gridy = 3;
		contrainteInputTelPro.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelPro.anchor = GridBagConstraints.WEST;
		add(inputTelPro, contrainteInputTelPro);
		
		labelTelPerso = new JLabel("Tel Perso :");
		GridBagConstraints contrainteLabelTelPerso = new GridBagConstraints();
		contrainteLabelTelPerso.gridx = 0;
		contrainteLabelTelPerso.gridy = 4;
		contrainteLabelTelPerso.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelPerso.anchor = GridBagConstraints.WEST;
		this.add(labelTelPerso, contrainteLabelTelPerso);
		
		inputTelPerso = new JTextField(); inputTelPerso.setColumns(10);
		GridBagConstraints contrainteInputTelPerso = new GridBagConstraints();
		contrainteInputTelPerso.gridx = 1;
		contrainteInputTelPerso.gridy = 4;
		contrainteInputTelPerso.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelPerso.anchor = GridBagConstraints.WEST;
		add(inputTelPerso, contrainteInputTelPerso);
		
		labelFax = new JLabel("Fax :");
		GridBagConstraints contrainteLabelFax = new GridBagConstraints();
		contrainteLabelFax.gridx = 0;
		contrainteLabelFax.gridy = 5;
		contrainteLabelFax.insets = new Insets(0, 0, 5, 2);
		contrainteLabelFax.anchor = GridBagConstraints.WEST;
		this.add(labelFax, contrainteLabelFax);
		
		inputFax = new JTextField(); inputFax.setColumns(10);
		GridBagConstraints contrainteInputFax = new GridBagConstraints();
		contrainteInputFax.gridx = 1;
		contrainteInputFax.gridy = 5;
		contrainteInputFax.insets = new Insets(0, 0, 5, 2);
		contrainteInputFax.anchor = GridBagConstraints.WEST;
		add(inputFax, contrainteInputFax);
		
		labelMail = new JLabel("Mail :");
		GridBagConstraints contrainteLabelMail = new GridBagConstraints();
		contrainteLabelMail.gridx = 0;
		contrainteLabelMail.gridy = 6;
		contrainteLabelMail.insets = new Insets(0, 0, 5, 2);
		contrainteLabelMail.anchor = GridBagConstraints.WEST;
		this.add(labelMail, contrainteLabelMail);
		
		inputMail = new JTextField(); inputMail.setColumns(15);
		GridBagConstraints contrainteInputMail = new GridBagConstraints();
		contrainteInputMail.gridx = 1;
		contrainteInputMail.gridy = 6;
		contrainteInputMail.insets = new Insets(0, 0, 5, 2);
		contrainteInputMail.anchor = GridBagConstraints.WEST;
		add(inputMail, contrainteInputMail);

		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 7;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		add(boutonValider, contrainteBoutonValider);
		boutonValider.addActionListener(this);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 7;
		contrainteBoutonAnnuler.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAnnuler.anchor = GridBagConstraints.WEST;
		add(boutonAnnuler, contrainteBoutonAnnuler);
		boutonAnnuler.addActionListener(this);
		
		this.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
	}
	
	public void setFenetre(EnqueteurFenetre fen){
		fenetre = fen;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{
		this.retourFenetre();
		}else if (e.getSource() == boutonValider){
			//TODO
		}
	}
		
	public void retourFenetre(){
		this.fenetre.getContentPane().remove(this);
		this.fenetre.setTitle("Accueil Gestion Enqueteur");
		this.fenetre.createOnglets();
			
		this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
		this.fenetre.pack();
	}
	

}

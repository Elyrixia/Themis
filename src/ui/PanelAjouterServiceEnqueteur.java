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


public class PanelAjouterServiceEnqueteur extends JPanel implements ActionListener{
	//Liste Attributs
	protected ServiceEnqueteurFenetre fenetre;
	//Labels
	protected JLabel labelLibelle;
	protected JLabel labelTelephone;
	protected JLabel labelLieu;
	
	//Inputs
	protected JTextField inputLibelle;
	protected JTextField inputTelephone;
	protected JTextField inputLieu;
	
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterServiceEnqueteur(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		 
		labelLibelle = new JLabel("Libelle :");
		GridBagConstraints contrainteLabelLibelle = new GridBagConstraints();
		contrainteLabelLibelle.gridx = 0;
		contrainteLabelLibelle.gridy = 0;
		contrainteLabelLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLibelle.anchor = GridBagConstraints.WEST;
		this.add(labelLibelle, contrainteLabelLibelle);
		
		inputLibelle = new JTextField(); inputLibelle.setColumns(10);
		GridBagConstraints contrainteInputLibelle = new GridBagConstraints();
		contrainteInputLibelle.gridx = 1;
		contrainteInputLibelle.gridy = 0;
		contrainteInputLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteInputLibelle.anchor = GridBagConstraints.WEST;
		add(inputLibelle, contrainteInputLibelle);
		
		labelTelephone = new JLabel("Telephone :");
		GridBagConstraints contrainteLabelTelephone = new GridBagConstraints();
		contrainteLabelTelephone.gridx = 0;
		contrainteLabelTelephone.gridy = 1;
		contrainteLabelTelephone.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelephone.anchor = GridBagConstraints.WEST;
		this.add(labelTelephone, contrainteLabelTelephone);
		
		inputTelephone = new JTextField(); inputTelephone.setColumns(10);
		GridBagConstraints contrainteInputTelephone = new GridBagConstraints();
		contrainteInputTelephone.gridx = 1;
		contrainteInputTelephone.gridy = 1;
		contrainteInputTelephone.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelephone.anchor = GridBagConstraints.WEST;
		add(inputTelephone, contrainteInputTelephone);
		
		labelLieu = new JLabel("Lieu :");
		GridBagConstraints contrainteLabelLieu = new GridBagConstraints();
		contrainteLabelLieu.gridx = 0;
		contrainteLabelLieu.gridy = 2;
		contrainteLabelLieu.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLieu.anchor = GridBagConstraints.WEST;
		this.add(labelLieu, contrainteLabelLieu);
		
		inputLieu = new JTextField(); inputLieu.setColumns(30);
		GridBagConstraints contrainteInputLieu = new GridBagConstraints();
		contrainteInputLieu.gridx = 1;
		contrainteInputLieu.gridy = 2;
		contrainteInputLieu.insets = new Insets(0, 0, 5, 2);
		contrainteInputLieu.anchor = GridBagConstraints.WEST;
		add(inputLieu, contrainteInputLieu);
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 3;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		add(boutonValider, contrainteBoutonValider);
		boutonValider.addActionListener(this);
				
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 3;
		contrainteBoutonAnnuler.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAnnuler.anchor = GridBagConstraints.WEST;
		add(boutonAnnuler, contrainteBoutonAnnuler);
		boutonAnnuler.addActionListener(this);
				
		this.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
	}
	
	public void setFenetre(ServiceEnqueteurFenetre fen){
		fenetre = fen;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{
			this.fenetre.getContentPane().remove(this);
			this.fenetre.setTitle("Accueil Gestion Enqueteur");
			this.fenetre.getPanelService().setVisible(true);
			
			//On remet la taille de la fenetre d'accueil avant de pack sinon la fenetre n'aura pas une taille convenable (affichage que du menu)
			this.fenetre.setPreferredSize(new Dimension(650,550));
			this.fenetre.pack();
		}else if (e.getSource() == boutonValider){
			//TODO
		}
		
	}
}

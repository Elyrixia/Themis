package ui.enqueteur;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.MainFenetre;


public class PanelAjouterTitreEnqueteur extends JPanel implements ActionListener{

	//Liste Attributs
	protected EnqueteurFenetre fenetre;
	//Label
	protected JLabel labelLibelle;
	//Input
	protected JTextField inputLibelle;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	
	PanelAjouterTitreEnqueteur(EnqueteurFenetre fen){
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
		
		inputLibelle = new JTextField(); inputLibelle.setColumns(10);
		GridBagConstraints contrainteInputLibelle = new GridBagConstraints();
		contrainteInputLibelle.gridx = 1;
		contrainteInputLibelle.gridy = 0;
		contrainteInputLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteInputLibelle.anchor = GridBagConstraints.WEST;
		add(inputLibelle, contrainteInputLibelle);
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 1;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		add(boutonValider, contrainteBoutonValider);
		boutonValider.addActionListener(this);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 1;
		contrainteBoutonAnnuler.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAnnuler.anchor = GridBagConstraints.WEST;
		add(boutonAnnuler, contrainteBoutonAnnuler);
		boutonAnnuler.addActionListener(this);
			
		this.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{			
			this.retourFenetre();
		}
		else if(e.getSource() == boutonValider){
			if(inputLibelle.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Vous devez remplir le champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeTitreEnqueteur().ajouterTitreEnqueteur(inputLibelle.getText());
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
		this.fenetre.getContentPane().remove(this.getParent().getParent()); //double getParent() � cause du JScrollPane
		this.fenetre.setTitle("Accueil Gestion Titre Enqueteur");
		this.fenetre.createOngletsEnqueteur();
		
		this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH,MainFenetre.WINDOW_HEIGHT));
		this.fenetre.pack();
	}
	

}

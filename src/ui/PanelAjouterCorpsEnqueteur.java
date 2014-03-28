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


public class PanelAjouterCorpsEnqueteur extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected CorpsEnqueteurFenetre fenetre;
	//Labels
	protected JLabel labelLibelle;
	//Inputs
	protected JTextField inputLibelle;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterCorpsEnqueteur(){
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		 
		labelLibelle = new JLabel("Nom :");
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

	public void setFenetre(CorpsEnqueteurFenetre fen) {
		fenetre = fen;
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{
			this.fenetre.getContentPane().remove(this);
			this.fenetre.setTitle("Accueil Gestion Corps Enqueteur");
			this.fenetre.getPanelCorps().setVisible(true);
			
			//On remet la taille de la fenetre d'accueil avant de pack sinon la fenetre n'aura pas une taille convenable (affichage que du menu)
			this.fenetre.setPreferredSize(new Dimension(650,550));
			this.fenetre.pack();
		}else if (e.getSource() == boutonValider){
			//TODO
		}
	}

}

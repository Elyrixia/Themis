package ui.enqueteur;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;
import business.enqueteur.TitreEnqueteur;


public class PanelModifTitreEnqueteur extends PanelAjouterTitreEnqueteur {
	
	private TitreEnqueteur titre;

	PanelModifTitreEnqueteur(EnqueteurFenetre fen, TitreEnqueteur t){
		super(fen);
		titre = t;
		HashMap<String, Object> hashMapTitre = this.fenetre.getFacadeTitreEnqueteur().consulterTitreEnqueteur(titre);
		String libelle = (String) hashMapTitre.get("libelle");
		super.inputLibelle.setText(libelle);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if (e.getSource() == boutonValider){
			if(inputLibelle.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Vous devez remplir le champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeTitreEnqueteur().modifierTitreEnqueteur(titre, inputLibelle.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}
}

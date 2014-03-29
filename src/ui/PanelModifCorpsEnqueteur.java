package ui;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.enqueteur.CorpsEnqueteur;



public class PanelModifCorpsEnqueteur extends PanelAjouterCorpsEnqueteur {
	
	private CorpsEnqueteur corps;

	PanelModifCorpsEnqueteur(CorpsEnqueteurFenetre fen, CorpsEnqueteur c){
		super(fen);
		corps=c;
		HashMap<String, Object> hashMapCorps = this.fenetre.getFacadeCorpsEnqueteur().consulterCorpsEnqueteur(corps);
		String libelle = (String) hashMapCorps.get("libelle");
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
					this.fenetre.getFacadeCorpsEnqueteur().modifierCorpsEnqueteur(corps, inputLibelle.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}

}

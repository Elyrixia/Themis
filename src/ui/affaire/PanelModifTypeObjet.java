package ui.affaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.affaire.TypeObjet;
import ui.enqueteur.EnqueteurFenetre;

public class PanelModifTypeObjet extends PanelAjouterTypeObjet implements ActionListener{

	private TypeObjet typeObjet;

	PanelModifTypeObjet(ScelleFenetre fen, TypeObjet t){
		super(fen);
		typeObjet = t;
		HashMap<String, Object> hashMapTitre = this.fenetre.getFacadeTypeObjet().consulterTypeObjet(typeObjet);
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
					this.fenetre.getFacadeTypeObjet().modifierTypeObjet(typeObjet, inputLibelle.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}
}

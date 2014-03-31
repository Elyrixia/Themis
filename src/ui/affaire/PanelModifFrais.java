/**
 * Tristan Sallé
 */

package ui.affaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.affaire.Affaire;
import business.affaire.Frais;

public class PanelModifFrais extends PanelAjouterFrais implements ActionListener{

	private Frais frais;
	
	PanelModifFrais(FraisFenetre fen, Frais aff) {
		super(fen);
		frais = aff;
		
		HashMap<String, Object> hashMapFrais = this.fenetre.getFacadeFrais().consulterFrais(frais);
		String libelle = (String) hashMapFrais.get("libelle");
		super.inputLibelle.setText(libelle);
		
		Integer montant = (Integer) hashMapFrais.get("prix");
		super.inputMontant.setValue(montant);
		
		Affaire affaire = (Affaire) hashMapFrais.get("id_affaire");
		for(int i = 0; i < listeSelectionAffaire.getModel().getSize(); i++) {
			Affaire a = (Affaire) listeSelectionAffaire.getModel().getElementAt(i);
			if(a.equals(affaire)) {
				listeSelectionAffaire.setSelectedValue(a, true);
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if(e.getSource() == boutonValider){
			String libelle = inputLibelle.getText(); Number montant = (Number) inputMontant.getValue(); 
			Affaire affaire = (Affaire) listeSelectionAffaire.getSelectedValue();
			if(libelle.equals("") || montant == null || affaire == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeFrais().modifierFrais(frais, libelle, montant.intValue(), affaire);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}

}

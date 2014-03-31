package ui.affaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.affaire.Affaire;
import business.affaire.Scelle;

public class PanelModifScelle extends PanelAjouterScelle implements ActionListener{

	private Scelle scelle;
	
	PanelModifScelle(ScelleFenetre fen, Scelle sc){
		super(fen);
		scelle = sc;
		
		HashMap<String, Object> hashMapScelle = this.fenetre.getFacadeScelle().consulterScelle(scelle);
		String lieu = (String) hashMapScelle.get("lieu_recup");
		super.inputLieuRecup.setText(lieu);
		
		Integer numPV = (Integer) hashMapScelle.get("num_proces");
		super.inputNumPV.setValue(numPV);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dateRecup = format.parse((String) hashMapScelle.get("date_recup"));
			super.inputDateRecup.setValue(dateRecup);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String commentaire = (String) hashMapScelle.get("comment");
		super.inputCommentaire.setText(commentaire);
		
		Affaire affaire = (Affaire) hashMapScelle.get("id_affaire");
		for(int i = 0; i < listeSelectionAffaire.getModel().getSize(); i++) {
			Affaire a = (Affaire) listeSelectionAffaire.getModel().getElementAt(i);
			if(a.equals(affaire)) {
				listeSelectionAffaire.setSelectedValue(a, true);
				break;
			}
		}
		
		if(hashMapScelle.get("id_scelle") instanceof String){
			listeSelectionScelle.setSelectedIndex(0);
		}else{
			Scelle scelleParent = (Scelle) hashMapScelle.get("id_scelle");
			for(int i = 0; i < listeSelectionScelle.getModel().getSize(); i++) {
				Scelle s = (Scelle) listeSelectionScelle.getModel().getElementAt(i);
				if(s.equals(scelleParent)) {
					listeSelectionScelle.setSelectedValue(s, true);
					break;
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{			
			this.retourFenetre();
		}
		else if(e.getSource() == boutonValider){
			String lieuRecup = inputLieuRecup.getText(); Number numPV = (Number) inputNumPV.getValue(); Date dateRecup = (Date) inputDateRecup.getValue(); 
			String commentaire = inputCommentaire.getText(); Affaire affaire = (Affaire) listeSelectionAffaire.getSelectedValue();
			Scelle scelleParent = (Scelle) listeSelectionScelle.getSelectedValue();
			if(lieuRecup.equals("") || numPV == null || dateRecup == null || lieuRecup == null || affaire == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(scelle.equals(scelleParent)){
				JOptionPane.showMessageDialog(null, "Vous ne pouvez pas mettre ce scelle comme son propre parent !", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					this.fenetre.getFacadeScelle().modifierScelle(scelle, numPV.intValue(), dateRecup, lieuRecup, commentaire, affaire, scelleParent);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}
}

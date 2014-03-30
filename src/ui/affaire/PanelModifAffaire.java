package ui.affaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.affaire.Affaire;
import business.enqueteur.Enqueteur;

public class PanelModifAffaire extends PanelAjouterAffaire implements ActionListener{

	private Affaire affaire;
	
	PanelModifAffaire(AffaireFenetre fen, Affaire aff) {
		super(fen);
		affaire = aff;
		
		HashMap<String, Object> hashMapAffaire = this.fenetre.getFacadeAffaire().consulterAffaire(affaire);
		String nom = (String) hashMapAffaire.get("nom");
		super.inputNom.setText(nom);
		
		Integer numInstruction = (Integer) hashMapAffaire.get("num_instruction");
		super.inputNumInstruction.setValue(numInstruction);
		
		Integer numDossier = (Integer) hashMapAffaire.get("num_dossier");
		super.inputNumDossier.setValue(numDossier);
		
		Integer numParquet = (Integer) hashMapAffaire.get("num_parquet");
		super.inputNumParquet.setValue(numParquet);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dateOrdre = format.parse((String) hashMapAffaire.get("date_ordre"));
			super.inputDateOrdre.setValue(dateOrdre);
			Date dateRendu = format.parse((String) hashMapAffaire.get("date_rendu"));
			super.inputDateMaxRendu.setValue(dateRendu);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		boolean delai = (boolean) hashMapAffaire.get("delai");
		super.inputDelai.setSelected(delai);
		
		String commentaire = (String) hashMapAffaire.get("commentaire");
		super.inputCommentaire.setText(commentaire);
		
		Enqueteur enqueteur = (Enqueteur) hashMapAffaire.get("id_enqueteur");
		for(int i = 0; i < listeSelectionEnqueteur.getModel().getSize(); i++) {
			Enqueteur e = (Enqueteur) listeSelectionEnqueteur.getModel().getElementAt(i);
			if(e.equals(enqueteur)) {
				listeSelectionEnqueteur.setSelectedValue(e, true);
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if(e.getSource() == boutonValider){
			String nom = inputNom.getText(); Number numInstruction = (Number) inputNumInstruction.getValue(); 
			Number numDossier = (Number) inputNumDossier.getValue(); Number numParquet = (Number) inputNumParquet.getValue();
			Date dateOrdre = (Date) inputDateOrdre.getValue(); Date dateRendu = (Date) inputDateMaxRendu.getValue();
			boolean delai = inputDelai.isSelected(); String commentaire = inputCommentaire.getText();
			Enqueteur enqueteur = (Enqueteur) listeSelectionEnqueteur.getSelectedValue();
			if(nom.equals("") || numInstruction == null || numDossier == null || numParquet == null || 
					dateOrdre == null || dateRendu == null || enqueteur == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeAffaire().modifierAffaire(affaire, nom, numDossier.intValue(), numInstruction.intValue(), numParquet.intValue(),
							dateOrdre, dateRendu, delai, commentaire, enqueteur);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussi");
				this.retourFenetre();
			}
		}
	}

}

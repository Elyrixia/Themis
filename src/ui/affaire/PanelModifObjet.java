package ui.affaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.affaire.TypeObjet;
import business.affaire.Objet;
import business.affaire.Scelle;

public class PanelModifObjet extends PanelAjouterObjet implements ActionListener{
	
	private Objet objet;
	
	PanelModifObjet(ScelleFenetre fen, Objet obj){
		super(fen);
		objet = obj;
		
		HashMap<String, Object> hashMapObjet = this.fenetre.getFacadeObjet().consulterObjet(objet);
		String libelle = (String) hashMapObjet.get("libelle");
		super.inputLibelle.setText(libelle);
		
		String commentaire = (String) hashMapObjet.get("comment");
		super.inputCommentaire.setText(commentaire);
		
		TypeObjet typeObjet = (TypeObjet) hashMapObjet.get("id_type");
		for(int i = 0; i < listeSelectionTypeObjet.getModel().getSize(); i++) {
			TypeObjet t = (TypeObjet) listeSelectionTypeObjet.getModel().getElementAt(i);
			if(t.equals(typeObjet)) {
				listeSelectionTypeObjet.setSelectedValue(t, true);
				break;
			}
		}
		
		Scelle scelle = (Scelle) hashMapObjet.get("id_scelle");
		for(int i = 0; i < listeSelectionScelle.getModel().getSize(); i++) {
			Scelle s = (Scelle) listeSelectionScelle.getModel().getElementAt(i);
			if(s.equals(scelle)) {
				listeSelectionScelle.setSelectedValue(s, true);
				break;
			}
		}
		
		Objet objet = (Objet) hashMapObjet.get("id_objet");
		for(int i = 0; i < listeSelectionObjet.getModel().getSize(); i++) {
			Scelle s = (Scelle) listeSelectionObjet.getModel().getElementAt(i);
			if(s.equals(objet)) {
				listeSelectionObjet.setSelectedValue(s, true);
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{			
			this.retourFenetre();
		}
		else if(e.getSource() == boutonValider){
			String libelle = inputLibelle.getText(); String commentaire = inputCommentaire.getText(); 
			Scelle scelle = (Scelle) listeSelectionScelle.getSelectedValue(); 
			TypeObjet typeObjet = (TypeObjet) listeSelectionTypeObjet.getSelectedValue();
			Objet objet;
			if(listeSelectionObjet.getSelectedValue() instanceof String){
				objet = null;
			}else{
				objet = (Objet) listeSelectionObjet.getSelectedValue();
			}
			if(libelle.equals("") || scelle == null || typeObjet == null){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeObjet().modifierObjet(objet, libelle, commentaire, scelle, typeObjet, objet);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}

}

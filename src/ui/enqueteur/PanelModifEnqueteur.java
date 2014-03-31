/**
 * @author Alexandre Laffaille
 */

package ui.enqueteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.enqueteur.Enqueteur;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.TitreEnqueteur;


public class PanelModifEnqueteur extends PanelAjouterEnqueteur implements ActionListener{
	
	private Enqueteur enqueteur;
	
	PanelModifEnqueteur(EnqueteurFenetre fen, Enqueteur e){
		super(fen);
		
		enqueteur = e;
		HashMap<String, Object> hashMapEnqueteur = this.fenetre.getFacadeEnqueteur().consulterEnqueteur(enqueteur);
		String nom = (String) hashMapEnqueteur.get("nom");
		inputNom.setText(nom);
		
		String prenom = (String) hashMapEnqueteur.get("prenom");
		inputPrenom.setText(prenom);
		
		String adresse = (String) hashMapEnqueteur.get("adresse");
		inputAdresse.setText(adresse);
		
		String telPro = (String) hashMapEnqueteur.get("telephone_pro");
		inputTelPro.setText(telPro);
		
		String telPerso = (String) hashMapEnqueteur.get("telephone_perso");
		inputTelPerso.setText(telPerso);
		
		String mail = (String) hashMapEnqueteur.get("email");
		inputMail.setText(mail);
		
		String fax = (String) hashMapEnqueteur.get("fax_pro");
		inputFax.setText(fax);
		
		ServiceEnqueteur service = (ServiceEnqueteur) hashMapEnqueteur.get("id_service");
		for(int i = 0; i < listeSelectionServiceEnqueteur.getModel().getSize(); i++) {
			ServiceEnqueteur se = (ServiceEnqueteur) listeSelectionServiceEnqueteur.getModel().getElementAt(i);
			if(fenetre.getFacadeEnqueteur().compare(se, service)) {
				listeSelectionServiceEnqueteur.setSelectedValue(se, true);
				break;
			}
		}
		
		TitreEnqueteur titre = (TitreEnqueteur) hashMapEnqueteur.get("id_titre");
		for(int i = 0; i < listeSelectionTitreEnqueteur.getModel().getSize(); i++) {
			TitreEnqueteur te = (TitreEnqueteur) listeSelectionTitreEnqueteur.getModel().getElementAt(i);
			if(fenetre.getFacadeEnqueteur().compare(te, titre)) {
				listeSelectionTitreEnqueteur.setSelectedValue(te, true);
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
			String nom = inputNom.getText(); String prenom = inputPrenom.getText(); String adresse = inputAdresse.getText();
			String telPerso = inputTelPerso.getText(); String telPro = inputTelPro.getText(); String fax = inputFax.getText(); 
			String mail = inputMail.getText(); TitreEnqueteur titre = (TitreEnqueteur) listeSelectionTitreEnqueteur.getSelectedValue();
			ServiceEnqueteur service = (ServiceEnqueteur) listeSelectionServiceEnqueteur.getSelectedValue();
			if(nom.equals("") || prenom.equals("") || adresse.equals("") || telPerso.equals("") || telPro.equals("") || fax.equals("") 
					|| mail.equals("") || titre == null || service == null ){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeEnqueteur().modifierEnqueteur(enqueteur, nom, prenom, adresse, telPro, telPerso, mail, fax, titre, service);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}
	
}

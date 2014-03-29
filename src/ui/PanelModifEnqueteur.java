package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
		super.inputNom.setText(nom);
		
		String prenom = (String) hashMapEnqueteur.get("prenom");
		super.inputPrenom.setText(prenom);
		
		String adresse = (String) hashMapEnqueteur.get("adresse");
		super.inputAdresse.setText(adresse);
		
		String telPro = (String) hashMapEnqueteur.get("telephone_pro");
		super.inputTelPro.setText(telPro);
		
		String telPerso = (String) hashMapEnqueteur.get("telephone_perso");
		super.inputTelPerso.setText(telPerso);
		
		String mail = (String) hashMapEnqueteur.get("email");
		super.inputMail.setText(mail);
		
		String fax = (String) hashMapEnqueteur.get("fax_pro");
		super.inputFax.setText(fax);
		
		ServiceEnqueteur service = (ServiceEnqueteur) hashMapEnqueteur.get("id_service");
		super.listeSelectionServiceEnqueteur.setSelectedValue(service, true);
		
		String titre = (String) hashMapEnqueteur.get("id_titre");
		super.listeSelectionTitreEnqueteur.setSelectedValue(titre, true);
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
				JOptionPane.showMessageDialog(null,"Ajout reussi");
				this.retourFenetre();
			}
		}
	}
	
}

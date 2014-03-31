/**
 * @author Nathan Marin
 */

package ui.enqueteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.CorpsEnqueteur;


public class PanelModifServiceEnqueteur extends PanelAjouterServiceEnqueteur implements ActionListener{

	private ServiceEnqueteur service;
	
	PanelModifServiceEnqueteur(ServiceEnqueteurFenetre fen, ServiceEnqueteur serv){
		super(fen);
		service = serv;
		
		HashMap<String, Object> hashMapEnqueteur = this.fenetre.getFacadeServiceEnqueteur().consulterServiceEnqueteur(service);
		String libelle = (String) hashMapEnqueteur.get("libelle");
		inputLibelle.setText(libelle);
		
		String telephone = (String) hashMapEnqueteur.get("telephone");
		inputTelephone.setText(telephone);
		
		String lieu = (String) hashMapEnqueteur.get("lieu");
		inputLieu.setText(lieu);
		
		CorpsEnqueteur corps = (CorpsEnqueteur) hashMapEnqueteur.get("id_corps");
		for(int i = 0; i < listeSelectionCorpsEnqueteur.getModel().getSize(); i++) {
			CorpsEnqueteur te = (CorpsEnqueteur) listeSelectionCorpsEnqueteur.getModel().getElementAt(i);
			if(fenetre.getFacadeCorpsEnqueteur().compare(te, corps)) {
				listeSelectionCorpsEnqueteur.setSelectedValue(te, true);
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
			String libelle = inputLibelle.getText(); String telephone = inputTelephone.getText(); String lieu = inputLieu.getText();
			CorpsEnqueteur corps = (CorpsEnqueteur) listeSelectionCorpsEnqueteur.getSelectedValue();
			if(libelle.equals("") || telephone.equals("") || lieu.equals("") || service == null ){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeServiceEnqueteur().modifierServiceEnqueteur(service, libelle, telephone, lieu, corps);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Modification reussie");
				this.retourFenetre();
			}
		}
	}
}

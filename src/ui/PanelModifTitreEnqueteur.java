package ui;
import java.awt.event.ActionEvent;


public class PanelModifTitreEnqueteur extends PanelAjouterTitreEnqueteur {

	PanelModifTitreEnqueteur(){
		super();
		//TODO pr�-remplir le champ
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if (e.getSource() == boutonValider){
			//TODO Red�finition car comportement diff�rent
		}
	}
}

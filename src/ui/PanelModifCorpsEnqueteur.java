package ui;
import java.awt.event.ActionEvent;


public class PanelModifCorpsEnqueteur extends PanelAjouterCorpsEnqueteur {

	PanelModifCorpsEnqueteur(){
		super();
		//TODO pr�-remplir les champs
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if (e.getSource() == boutonValider){
			//TODO Red�finition car comportement diff�rent
		}
	}

}

package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModifServiceEnqueteur extends PanelAjouterServiceEnqueteur implements ActionListener{

	PanelModifServiceEnqueteur(){
		super();
		//TODO pré-remplir les champs
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler){
			super.actionPerformed(e);
		}else if (e.getSource() == boutonValider){
			//TODO Redéfinition car comportement différent
		}
	}
}

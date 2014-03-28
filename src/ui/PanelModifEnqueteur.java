package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelModifEnqueteur extends PanelAjouterEnqueteur implements ActionListener{
	
	PanelModifEnqueteur(){
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

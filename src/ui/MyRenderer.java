package ui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import business.Business;
import facade.FacadeAbstraite;

public class MyRenderer extends DefaultListCellRenderer { 
	private FacadeAbstraite facade; 
	
	public MyRenderer(FacadeAbstraite f) { 
		facade = f; 
	} 
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) { 
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
		setText(facade.getApercu((Business) value)); 
		return c; 
	}
}

package ui.enqueteur;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ui.MainFenetre;
import ui.MyRenderer;
import business.enqueteur.CorpsEnqueteur;


public class PanelAjouterServiceEnqueteur extends JPanel implements ActionListener{
	//Liste Attributs
	protected ServiceEnqueteurFenetre fenetre;
	//Labels
	protected JLabel labelLibelle;
	protected JLabel labelTelephone;
	protected JLabel labelLieu;
	//Inputs
	protected JTextField inputLibelle;
	protected JTextField inputTelephone;
	protected JTextField inputLieu;
	//JList pour choisir un corps
    private DefaultListModel modelListCorpsEnqueteur;
	protected JList listeSelectionCorpsEnqueteur;
	private JScrollPane panneauListeCorpsEnqueteur;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterServiceEnqueteur(ServiceEnqueteurFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		 
		labelLibelle = new JLabel("Libelle :");
		GridBagConstraints contrainteLabelLibelle = new GridBagConstraints();
		contrainteLabelLibelle.gridx = 0;
		contrainteLabelLibelle.gridy = 0;
		contrainteLabelLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLibelle.anchor = GridBagConstraints.WEST;
		this.add(labelLibelle, contrainteLabelLibelle);
		
		inputLibelle = new JTextField(); inputLibelle.setColumns(10);
		GridBagConstraints contrainteInputLibelle = new GridBagConstraints();
		contrainteInputLibelle.gridx = 1;
		contrainteInputLibelle.gridy = 0;
		contrainteInputLibelle.insets = new Insets(0, 0, 5, 2);
		contrainteInputLibelle.anchor = GridBagConstraints.WEST;
		add(inputLibelle, contrainteInputLibelle);
		
		labelTelephone = new JLabel("Telephone :");
		GridBagConstraints contrainteLabelTelephone = new GridBagConstraints();
		contrainteLabelTelephone.gridx = 0;
		contrainteLabelTelephone.gridy = 1;
		contrainteLabelTelephone.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelephone.anchor = GridBagConstraints.WEST;
		this.add(labelTelephone, contrainteLabelTelephone);
		
		inputTelephone = new JTextField(); inputTelephone.setColumns(10);
		GridBagConstraints contrainteInputTelephone = new GridBagConstraints();
		contrainteInputTelephone.gridx = 1;
		contrainteInputTelephone.gridy = 1;
		contrainteInputTelephone.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelephone.anchor = GridBagConstraints.WEST;
		add(inputTelephone, contrainteInputTelephone);
		
		labelLieu = new JLabel("Lieu :");
		GridBagConstraints contrainteLabelLieu = new GridBagConstraints();
		contrainteLabelLieu.gridx = 0;
		contrainteLabelLieu.gridy = 2;
		contrainteLabelLieu.insets = new Insets(0, 0, 5, 2);
		contrainteLabelLieu.anchor = GridBagConstraints.WEST;
		this.add(labelLieu, contrainteLabelLieu);
		
		inputLieu = new JTextField(); inputLieu.setColumns(30);
		GridBagConstraints contrainteInputLieu = new GridBagConstraints();
		contrainteInputLieu.gridx = 1;
		contrainteInputLieu.gridy = 2;
		contrainteInputLieu.insets = new Insets(0, 0, 5, 2);
		contrainteInputLieu.anchor = GridBagConstraints.WEST;
		add(inputLieu, contrainteInputLieu);
		
		modelListCorpsEnqueteur = new DefaultListModel();
		listeSelectionCorpsEnqueteur = new JList(modelListCorpsEnqueteur);
	    panneauListeCorpsEnqueteur = new JScrollPane(listeSelectionCorpsEnqueteur);
	    listeSelectionCorpsEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageCorpsEnqueteur = new MyRenderer(this.fenetre.getFacadeCorpsEnqueteur());
	    listeSelectionCorpsEnqueteur.setCellRenderer(affichageCorpsEnqueteur);
	    GridBagConstraints contrainteListeCorpsEnqueteur = new GridBagConstraints();
		contrainteListeCorpsEnqueteur.gridx=0; contrainteListeCorpsEnqueteur.gridy=3;
		contrainteListeCorpsEnqueteur.gridwidth=2;
		contrainteListeCorpsEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeCorpsEnqueteur.anchor = GridBagConstraints.CENTER;
		
		ArrayList<CorpsEnqueteur> listeCorpsEnqueteur;
	    HashMap<String,String> filtreCorps = new HashMap<String, String>();
	    listeCorpsEnqueteur = this.fenetre.getFacadeCorpsEnqueteur().chargerCorpsEnqueteur(filtreCorps);
	    for (int i=0; i < listeCorpsEnqueteur.size(); i++) {
			modelListCorpsEnqueteur.addElement(listeCorpsEnqueteur.get(i));
		}
	    this.add(panneauListeCorpsEnqueteur, contrainteListeCorpsEnqueteur);
		
		
		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 4;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		add(boutonValider, contrainteBoutonValider);
		boutonValider.addActionListener(this);
				
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 4;
		contrainteBoutonAnnuler.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonAnnuler.anchor = GridBagConstraints.WEST;
		add(boutonAnnuler, contrainteBoutonAnnuler);
		boutonAnnuler.addActionListener(this);
				
		this.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonAnnuler)
		{			
			this.retourFenetre();
		}
		else if(e.getSource() == boutonValider){
			String libelle = inputLibelle.getText(); String telephone = inputTelephone.getText(); String lieu = inputLieu.getText();
			CorpsEnqueteur corps = (CorpsEnqueteur) listeSelectionCorpsEnqueteur.getSelectedValue();
			if(libelle.equals("") || telephone.equals("") || lieu.equals("") || corps == null ){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeServiceEnqueteur().ajouterServiceEnqueteur(libelle, telephone, lieu, corps);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Ajout reussi");
				this.retourFenetre();
			}
		}
		
	}
	
	//Methode qui enleve ce panel de la fenetre pour remettre le panel d'accueil
		public void retourFenetre(){
			this.fenetre.getContentPane().remove(this);
			this.fenetre.setTitle("Accueil Gestion Service Enqueteur");
			this.fenetre.createPanel();
				
			this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH, MainFenetre.WINDOW_HEIGHT));
			this.fenetre.pack();
		}
}

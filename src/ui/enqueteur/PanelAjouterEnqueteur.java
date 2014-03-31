/**
 * @author Alexandre Laffaille
 */

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
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.TitreEnqueteur;


public class PanelAjouterEnqueteur extends JPanel implements ActionListener{
	
	//Liste Attributs
	protected EnqueteurFenetre fenetre;
	//Labels
	protected JLabel labelNom;
	protected JLabel labelPrenom;
	protected JLabel labelAdresse;
	protected JLabel labelTelPerso;
	protected JLabel labelTelPro;
	protected JLabel labelFax;
	protected JLabel labelMail;
	//Inputs
	protected JTextField inputNom;
	protected JTextField inputPrenom;
	protected JTextField inputAdresse;
	protected JTextField inputTelPro;
	protected JTextField inputTelPerso;
	protected JTextField inputFax;
	protected JTextField inputMail;
	//JList pour choisir un titre et un service
	protected JList listeSelectionServiceEnqueteur;
    private DefaultListModel modelListServiceEnqueteur;
    private JScrollPane panneauListeServiceEnqueteur;
    private DefaultListModel modelListTitreEnqueteur;
	protected JList listeSelectionTitreEnqueteur;
	private JScrollPane panneauListeTitreEnqueteur;
	//Boutons
	protected JButton boutonValider;
	protected JButton boutonAnnuler;
	
	PanelAjouterEnqueteur(EnqueteurFenetre fen){
		fenetre = fen;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		 
		labelNom = new JLabel("Nom :");
		GridBagConstraints contrainteLabelNom = new GridBagConstraints();
		contrainteLabelNom.gridx = 0;
		contrainteLabelNom.gridy = 0;
		contrainteLabelNom.insets = new Insets(0, 0, 5, 2);
		contrainteLabelNom.anchor = GridBagConstraints.WEST;
		this.add(labelNom, contrainteLabelNom);
		
		inputNom = new JTextField(); inputNom.setColumns(10);
		GridBagConstraints contrainteInputNom = new GridBagConstraints();
		contrainteInputNom.gridx = 1;
		contrainteInputNom.gridy = 0;
		contrainteInputNom.insets = new Insets(0, 0, 5, 2);
		contrainteInputNom.anchor = GridBagConstraints.WEST;
		add(inputNom, contrainteInputNom);
		
		labelPrenom = new JLabel("Prenom :");
		GridBagConstraints contrainteLabelPrenom = new GridBagConstraints();
		contrainteLabelPrenom.gridx = 0;
		contrainteLabelPrenom.gridy = 1;
		contrainteLabelPrenom.insets = new Insets(0, 0, 5, 2);
		contrainteLabelPrenom.anchor = GridBagConstraints.WEST;
		this.add(labelPrenom, contrainteLabelPrenom);
		
		inputPrenom = new JTextField(); inputPrenom.setColumns(10);
		GridBagConstraints contrainteInputPrenom = new GridBagConstraints();
		contrainteInputPrenom.gridx = 1;
		contrainteInputPrenom.gridy = 1;
		contrainteInputPrenom.insets = new Insets(0, 0, 5, 2);
		contrainteInputPrenom.anchor = GridBagConstraints.WEST;
		add(inputPrenom, contrainteInputPrenom);
		
		labelAdresse = new JLabel("Adresse :");
		GridBagConstraints contrainteLabelAdresse = new GridBagConstraints();
		contrainteLabelAdresse.gridx = 0;
		contrainteLabelAdresse.gridy = 2;
		contrainteLabelAdresse.insets = new Insets(0, 0, 5, 2);
		contrainteLabelAdresse.anchor = GridBagConstraints.WEST;
		this.add(labelAdresse, contrainteLabelAdresse);
		
		inputAdresse = new JTextField(); inputAdresse.setColumns(30);
		GridBagConstraints contrainteInputAdresse = new GridBagConstraints();
		contrainteInputAdresse.gridx = 1;
		contrainteInputAdresse.gridy = 2;
		contrainteInputAdresse.insets = new Insets(0, 0, 5, 2);
		contrainteInputAdresse.anchor = GridBagConstraints.WEST;
		add(inputAdresse, contrainteInputAdresse);
		
		labelTelPro = new JLabel("Tel Pro :");
		GridBagConstraints contrainteLabelTelPro = new GridBagConstraints();
		contrainteLabelTelPro.gridx = 0;
		contrainteLabelTelPro.gridy = 3;
		contrainteLabelTelPro.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelPro.anchor = GridBagConstraints.WEST;
		this.add(labelTelPro, contrainteLabelTelPro);
		
		inputTelPro = new JTextField(); inputTelPro.setColumns(10);
		GridBagConstraints contrainteInputTelPro = new GridBagConstraints();
		contrainteInputTelPro.gridx = 1;
		contrainteInputTelPro.gridy = 3;
		contrainteInputTelPro.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelPro.anchor = GridBagConstraints.WEST;
		add(inputTelPro, contrainteInputTelPro);
		
		labelTelPerso = new JLabel("Tel Perso :");
		GridBagConstraints contrainteLabelTelPerso = new GridBagConstraints();
		contrainteLabelTelPerso.gridx = 0;
		contrainteLabelTelPerso.gridy = 4;
		contrainteLabelTelPerso.insets = new Insets(0, 0, 5, 2);
		contrainteLabelTelPerso.anchor = GridBagConstraints.WEST;
		this.add(labelTelPerso, contrainteLabelTelPerso);
		
		inputTelPerso = new JTextField(); inputTelPerso.setColumns(10);
		GridBagConstraints contrainteInputTelPerso = new GridBagConstraints();
		contrainteInputTelPerso.gridx = 1;
		contrainteInputTelPerso.gridy = 4;
		contrainteInputTelPerso.insets = new Insets(0, 0, 5, 2);
		contrainteInputTelPerso.anchor = GridBagConstraints.WEST;
		add(inputTelPerso, contrainteInputTelPerso);
		
		labelFax = new JLabel("Fax :");
		GridBagConstraints contrainteLabelFax = new GridBagConstraints();
		contrainteLabelFax.gridx = 0;
		contrainteLabelFax.gridy = 5;
		contrainteLabelFax.insets = new Insets(0, 0, 5, 2);
		contrainteLabelFax.anchor = GridBagConstraints.WEST;
		this.add(labelFax, contrainteLabelFax);
		
		inputFax = new JTextField(); inputFax.setColumns(10);
		GridBagConstraints contrainteInputFax = new GridBagConstraints();
		contrainteInputFax.gridx = 1;
		contrainteInputFax.gridy = 5;
		contrainteInputFax.insets = new Insets(0, 0, 5, 2);
		contrainteInputFax.anchor = GridBagConstraints.WEST;
		add(inputFax, contrainteInputFax);
		
		labelMail = new JLabel("Mail :");
		GridBagConstraints contrainteLabelMail = new GridBagConstraints();
		contrainteLabelMail.gridx = 0;
		contrainteLabelMail.gridy = 6;
		contrainteLabelMail.insets = new Insets(0, 0, 5, 2);
		contrainteLabelMail.anchor = GridBagConstraints.WEST;
		this.add(labelMail, contrainteLabelMail);
		
		inputMail = new JTextField(); inputMail.setColumns(15);
		GridBagConstraints contrainteInputMail = new GridBagConstraints();
		contrainteInputMail.gridx = 1;
		contrainteInputMail.gridy = 6;
		contrainteInputMail.insets = new Insets(0, 0, 5, 2);
		contrainteInputMail.anchor = GridBagConstraints.WEST;
		add(inputMail, contrainteInputMail);
		
		//Creation liste
	    modelListServiceEnqueteur = new DefaultListModel();
		listeSelectionServiceEnqueteur = new JList(modelListServiceEnqueteur);
	    panneauListeServiceEnqueteur = new JScrollPane(listeSelectionServiceEnqueteur);
	    listeSelectionServiceEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageServiceEnqueteur = new MyRenderer(this.fenetre.getFacadeServiceEnqueteur());
	    listeSelectionServiceEnqueteur.setCellRenderer(affichageServiceEnqueteur);
	    GridBagConstraints contrainteListeServiceEnqueteur = new GridBagConstraints();
		contrainteListeServiceEnqueteur.gridx=0; contrainteListeServiceEnqueteur.gridy=7;
		contrainteListeServiceEnqueteur.gridwidth=2; 
		contrainteListeServiceEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeServiceEnqueteur.anchor = GridBagConstraints.CENTER;
	    
	    modelListTitreEnqueteur = new DefaultListModel();
		listeSelectionTitreEnqueteur = new JList(modelListTitreEnqueteur);
	    panneauListeTitreEnqueteur = new JScrollPane(listeSelectionTitreEnqueteur);
	    listeSelectionTitreEnqueteur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    MyRenderer affichageTitreEnqueteur = new MyRenderer(this.fenetre.getFacadeTitreEnqueteur());
	    listeSelectionTitreEnqueteur.setCellRenderer(affichageTitreEnqueteur);
	    GridBagConstraints contrainteListeTitreEnqueteur = new GridBagConstraints();
		contrainteListeTitreEnqueteur.gridx=0; contrainteListeTitreEnqueteur.gridy=8;
		contrainteListeTitreEnqueteur.gridwidth=2;
		contrainteListeTitreEnqueteur.insets = new Insets(0, 0, 5, 2);
		contrainteListeTitreEnqueteur.anchor = GridBagConstraints.CENTER;
		
		ArrayList<ServiceEnqueteur> listeServiceEnqueteur;
	    HashMap<String,String> filtreService = new HashMap<String, String>();
	    listeServiceEnqueteur = this.fenetre.getFacadeServiceEnqueteur().chargerServiceEnqueteur(filtreService);
	    for (int i=0; i < listeServiceEnqueteur.size(); i++) {
			modelListServiceEnqueteur.addElement(listeServiceEnqueteur.get(i));
		}
	    
	    ArrayList<TitreEnqueteur> listeTitreEnqueteur;
	    HashMap<String,String> filtreTitre = new HashMap<String, String>();
	    listeTitreEnqueteur = this.fenetre.getFacadeTitreEnqueteur().chargerTitreEnqueteur(filtreTitre);
	    for (int i=0; i < listeTitreEnqueteur.size(); i++) {
			modelListTitreEnqueteur.addElement(listeTitreEnqueteur.get(i));
		}
	    
	    this.add(panneauListeServiceEnqueteur, contrainteListeServiceEnqueteur);
	    this.add(panneauListeTitreEnqueteur, contrainteListeTitreEnqueteur);

		//Boutons :
		boutonValider = new JButton("Valider");
		GridBagConstraints contrainteBoutonValider = new GridBagConstraints();
		contrainteBoutonValider.gridx = 0;
		contrainteBoutonValider.gridy = 9;
		contrainteBoutonValider.insets = new Insets(0, 0, 5, 2);
		contrainteBoutonValider.anchor = GridBagConstraints.WEST;
		add(boutonValider, contrainteBoutonValider);
		boutonValider.addActionListener(this);
		
		boutonAnnuler = new JButton("Annuler");
		GridBagConstraints contrainteBoutonAnnuler = new GridBagConstraints();
		contrainteBoutonAnnuler.gridx = 1;
		contrainteBoutonAnnuler.gridy = 9;
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
			String nom = inputNom.getText(); String prenom = inputPrenom.getText(); String adresse = inputAdresse.getText();
			String telPerso = inputTelPerso.getText(); String telPro = inputTelPro.getText(); String fax = inputFax.getText(); 
			String mail = inputMail.getText(); TitreEnqueteur titre = (TitreEnqueteur) listeSelectionTitreEnqueteur.getSelectedValue();
			ServiceEnqueteur service = (ServiceEnqueteur) listeSelectionServiceEnqueteur.getSelectedValue();
			if(nom.equals("") || prenom.equals("") || adresse.equals("") || telPerso.equals("") || telPro.equals("") || fax.equals("") 
					|| mail.equals("") || titre == null || service == null ){
				JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champ !", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				try {
					this.fenetre.getFacadeEnqueteur().ajouterEnqueteur(nom, prenom, adresse, telPro, telPerso, mail, fax, titre, service);
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
		this.fenetre.getContentPane().remove(this.getParent().getParent()); //double getParent() � cause du JScrollPane
		this.fenetre.setTitle("Accueil Gestion Enqueteur");
		this.fenetre.createOngletsEnqueteur();
			
		this.fenetre.setPreferredSize(new Dimension(MainFenetre.WINDOW_WIDTH, MainFenetre.WINDOW_HEIGHT));
		this.fenetre.pack();
	}
	

}

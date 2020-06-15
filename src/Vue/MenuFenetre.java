package Vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import Controller.CommBase;
import Controller.LangueConfig;


/*******************************************************************
 * @Titre_Classe: MENU FENETRE
 * 
 * @Resumer:
 * Cree le menu sur la fenetre de l'application.
 * Ajout de JRadioButtons pour selectionner le type de tri.
 * Le type de tri peut etre croissant oudecroissant.
 * Pour chaque options du menu, on retrouve un raccourcis clavier.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 18 juin 2017 
 * 
 *******************************************************************/
public class MenuFenetre extends JMenuBar implements ActionListener{

	/***************************
	 * Classes instanciees
	 ***************************/

	// Pour activer ou desactiver la communication avec le serveur
	private CommBase commBase; 

	/********************
	 * Constantes
	 ********************/
	private static final int DELAI_QUITTER_MSEC = 200;

	private static final long serialVersionUID = 1536336192561843187L;

	//Appuyer sur CTRL pour atteindre le raccourcis
	private static final int
	FICHIER_OBTENIR_MASK = ActionEvent.CTRL_MASK,
	ORDRE_SEQ_CROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_SEQ_DECROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_AIRE_CROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_AIRE_DECROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_FORME_CROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_FORME_DECROISSANT_MASK = ActionEvent.CTRL_MASK,
	ORDRE_FORME_DISTANCE_MASK = ActionEvent.CTRL_MASK;

	//Les touches du raccourcis
	private static final char
	FICHIER_OBTENIR_TOUCHE_RACC = KeyEvent.VK_Q,
	ORDRE_SEQ_CROISSANT_RACC = KeyEvent.VK_S,
	ORDRE_SEQ_DECROISSANT_RACC = KeyEvent.VK_X,
	ORDRE_AIRE_CROISSANT_RACC = KeyEvent.VK_A,
	ORDRE_AIRE_DECROISSANT_RACC = KeyEvent.VK_Z,
	ORDRE_FORME_CROISSANT_RACC = KeyEvent.VK_F,
	ORDRE_FORME_DECROISSANT_RACC = KeyEvent.VK_V,
	ORDRE_FORME_DISTANCE_RACC = KeyEvent.VK_D;

	private static final String
	MENU_FICHIER_TITRE = "Fichier",
	FICHIER_OBTENIR = "Obtenir formes",

	MENU_ORDRE_TITRE = "Ordre",
	ORDRE_CROISSANT_TITRE = "Croissant",
	ORDRE_DECROISSANT_TITRE = "Decroissant",

	SEQ_CROISSANT = "Numero_Sequence_C",
	SEQ_DECROISSANT = "Numero_Sequence_D",
	AIRE_CROISSANT = "Aire_Forme_C",
	AIRE_DECROISSANT = "Aire_Forme_D",
	FORME_CROISSANT = "Type_Forme_C",
	FORME_DERCROISSANT = "Type_Forme_D",
	ORDRE_DISTANCE = "Distance_Forme_C",
	
	MENU_AIDE_TITRE = "app.frame.menus.help.title",
	AIDE_PROPOS = "app.frame.menus.help.about",
	DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	/********************
	 * Objets Swing
	 ********************/

	//RadioButton permettant la selection du type de tri
	private JRadioButtonMenuItem 
	boutonSeqCroissant,
	boutonSeqDecroissant,
	boutonAireCroissant,
	boutonAireDecroissant,
	boutonFormeCroissant,
	boutonFormeDecroissant,
	boutonDistanceOrdre;

	private JMenu 
	ongletCroissant,
	ongletDecroissant;
	
	private ButtonGroup regroupement;

	/********************
	 * Variable
	 ********************/

	private String typeAlgorithme = null;

	/********************
	 * Constructeur
	 ********************/
	public MenuFenetre(CommBase commBase) {

		this.commBase = commBase;

		addMenuFichier();

		addMenuOrdre();

		addMenuAide();

	}

	/*******************************************************************
	 * @Titre: MENU FILE
	 * 
	 * @Resumer:
	 * Creation du menu "File".
	 * Section du menu qui permet la demande de formes.
	 * 
	 *******************************************************************/
	protected void addMenuFichier() {

		JMenu menu = creerMenuSimple(MENU_FICHIER_TITRE, new String[] {FICHIER_OBTENIR});

		menu.getItem(0).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				commBase.start();

				try {

					Thread.sleep(DELAI_QUITTER_MSEC);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});

		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(
				FICHIER_OBTENIR_TOUCHE_RACC, FICHIER_OBTENIR_MASK));

		add(menu);
	}

	/*******************************************************************
	 * @Titre: MENU AIDE
	 * 
	 * @Resumer:
	 * Creation du menu "Help".
	 * Rien a ete change de la version du "Squelette" fourni.
	 * 
	 *******************************************************************/
	protected void addMenuAide() {

		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { AIDE_PROPOS });

		menu.getItem(0).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null,  
						LangueConfig.getResource(DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(AIDE_PROPOS), 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/*******************************************************************
	 * @Titre: MENU ORDRE
	 * 
	 * @Resumer:
	 * Creation du menu "ordre".
	 * Creation de deux onglets (croissant et decroissant).
	 * Boutons permettent la selection du type de tri.
	 * 
	 *******************************************************************/
	protected void addMenuOrdre(){

		//Permet la creation des boutons avec parametres 
		creationBoutons();

		//Permet aux boutons de "communiquer" entre eux
		regroupementBoutons();

		//Permet d'associer des raccourcis claviers aux boutons
		raccourcisBoutons();
		
		//Demarrage par defaut du tri numero de sequence en ordre croissant
		setTypeAlgorithme(SEQ_CROISSANT);

		JMenu menu = new JMenu(MENU_ORDRE_TITRE);

		//Ajout des deux onglets au menu 
		menu.add(ongletCroissant);
		menu.add(ongletDecroissant);

		add(menu);
	}

	/*******************************************************************
	 * @Titre: RADIO BUTTON
	 * 
	 * @Resumer:
	 * Creation des JRadioButton. On leurs associent respectivement un 
	 * titre, un raccourcis (clavier), une action et un ActionListener.
	 * 
	 * @Source:
	 * setMnemonic: 	http://www.java2s.com/Code/Java/Swing-JFC/RadioButtonMnemonicKey.htm
	 * ActionCommand: 	http://www.java2s.com/Code/JavaAPI/javax.swing/JRadioButtonsetActionCommandStringactionCommand.htm
	 *  
	 *******************************************************************/
	private void creationBoutons(){

		//Numero de sequence par ordre croissant
		boutonSeqCroissant = new JRadioButtonMenuItem(SEQ_CROISSANT);
		boutonSeqCroissant.setMnemonic(ORDRE_SEQ_CROISSANT_RACC);
		boutonSeqCroissant.setActionCommand(SEQ_CROISSANT);
		boutonSeqCroissant.addActionListener(this);
		boutonSeqCroissant.setSelected(true);

		//Numero de sequence par ordre decroissant
		boutonSeqDecroissant = new JRadioButtonMenuItem(SEQ_DECROISSANT);
		boutonSeqDecroissant.setMnemonic(ORDRE_SEQ_DECROISSANT_RACC);
		boutonSeqDecroissant.setActionCommand(SEQ_DECROISSANT);
		boutonSeqDecroissant.addActionListener(this);
		boutonSeqDecroissant.setSelected(true);

		//Aire des formes par ordre croissant
		boutonAireCroissant = new JRadioButtonMenuItem(AIRE_CROISSANT);
		boutonAireCroissant.setMnemonic(ORDRE_AIRE_CROISSANT_RACC);
		boutonAireCroissant.setActionCommand(AIRE_CROISSANT);
		boutonAireCroissant.addActionListener(this);
		boutonAireCroissant.setSelected(true);

		//Aire des formes par ordre decroissant
		boutonAireDecroissant = new JRadioButtonMenuItem(AIRE_DECROISSANT);
		boutonAireDecroissant.setMnemonic(ORDRE_AIRE_DECROISSANT_RACC);
		boutonAireDecroissant.setActionCommand(AIRE_DECROISSANT);
		boutonAireDecroissant.addActionListener(this);
		boutonAireDecroissant.setSelected(true);

		//Type de forme par ordre croissant
		boutonFormeCroissant = new JRadioButtonMenuItem(FORME_CROISSANT);
		boutonFormeCroissant.setMnemonic(ORDRE_FORME_CROISSANT_RACC);
		boutonFormeCroissant.setActionCommand(FORME_CROISSANT);
		boutonFormeCroissant.addActionListener(this);
		boutonFormeCroissant.setSelected(true);

		//Type de forme par ordre decroissant
		boutonFormeDecroissant = new JRadioButtonMenuItem(FORME_DERCROISSANT);
		boutonFormeDecroissant.setMnemonic(ORDRE_FORME_DECROISSANT_RACC);
		boutonFormeDecroissant.setActionCommand(FORME_DERCROISSANT);
		boutonFormeDecroissant.addActionListener(this);
		boutonFormeDecroissant.setSelected(true);

		//Distance des formes par ordre croissant
		boutonDistanceOrdre = new JRadioButtonMenuItem(ORDRE_DISTANCE);
		boutonDistanceOrdre.setMnemonic(ORDRE_FORME_DISTANCE_RACC);
		boutonDistanceOrdre.setActionCommand(ORDRE_DISTANCE);
		boutonDistanceOrdre.addActionListener(this);
		boutonDistanceOrdre.setSelected(true);
		

	}

	/*******************************************************************
	 * @Titre: REGROUPEMENT RADIO BUTTON
	 * 
	 * @Resumer:
	 * On s'assure de regrouper les JRadioButtons pour les rendre exclusif.
	 * Ensuite on ajoute les JRadioButtons dans un menu defilant.
	 * 
	 * @Source:
	 * Group: 	http://www.java2s.com/Code/Java/Swing-JFC/RadioButtonMnemonicKey.htm
	 * 	  
	 *******************************************************************/
	private void regroupementBoutons(){

		//Pour que les boutons agissent dans un but commun
		regroupement = new ButtonGroup();

		regroupement.add(boutonSeqCroissant);
		regroupement.add(boutonSeqDecroissant);
		regroupement.add(boutonAireCroissant);
		regroupement.add(boutonAireDecroissant);
		regroupement.add(boutonFormeCroissant);
		regroupement.add(boutonFormeDecroissant);
		regroupement.add(boutonDistanceOrdre);

		//Onglet du menu defilant permettant de mettre en ordre croissant
		ongletCroissant = new JMenu(ORDRE_CROISSANT_TITRE);

		ongletCroissant.add(boutonSeqCroissant);
		ongletCroissant.add(boutonAireCroissant);
		ongletCroissant.add(boutonFormeCroissant);
		ongletCroissant.add(boutonDistanceOrdre);

		//Onglet du menu defilant permettant de mettre en ordre decroissant
		ongletDecroissant = new JMenu(ORDRE_DECROISSANT_TITRE);

		ongletDecroissant.add(boutonSeqDecroissant);
		ongletDecroissant.add(boutonAireDecroissant);
		ongletDecroissant.add(boutonFormeDecroissant);
	}

	/*******************************************************************
	 * @Titre: RACCOURCIS RADIO BUTTON
	 * 
	 * @Resumer:
	 * Permet simplement d'ajoutrer des raccourcis clavier aux JRadioButtons
	 *  
	 *******************************************************************/
	private void raccourcisBoutons(){

		boutonSeqCroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_SEQ_CROISSANT_RACC, 
				ORDRE_SEQ_CROISSANT_MASK));

		boutonSeqDecroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_SEQ_DECROISSANT_RACC, 
				ORDRE_SEQ_DECROISSANT_MASK));

		boutonAireCroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_AIRE_CROISSANT_RACC, 
				ORDRE_AIRE_CROISSANT_MASK));

		boutonAireDecroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_AIRE_DECROISSANT_RACC, 
				ORDRE_AIRE_DECROISSANT_MASK));

		boutonFormeCroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_FORME_CROISSANT_RACC, 
				ORDRE_FORME_CROISSANT_MASK));

		boutonFormeDecroissant.setAccelerator(KeyStroke.getKeyStroke(ORDRE_FORME_DECROISSANT_RACC, 
				ORDRE_FORME_DECROISSANT_MASK));

		boutonDistanceOrdre.setAccelerator(KeyStroke.getKeyStroke(ORDRE_FORME_DISTANCE_RACC, 
				ORDRE_FORME_DISTANCE_MASK));
	}

	/*******************************************************************
	 * @Titre: CREATION MENU
	 * 
	 * @Resumer:
	 * Creer un element de menu a partir d'un champs principal et ses elements.
	 * 
	 * @param titleKey champs principal
	 * @param itemKeys elements
	 * @return le menu
	 *
	 *******************************************************************/
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {

		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));

		for(int i = 0; i < itemKeys.length; ++i) {

			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}

	/*******************************************************************
	 * @Titre: CREATION MENU SIMPLE
	 * 
	 * @Resumer:
	 * Ajout des onglets "Obtenir formes" et "Ordre" au menu, suivi 
	 * de leurs sous-options.
	 * 
	 * @param titleKey champs principal
	 * @param itemKeys elements
	 * @return le menu
	 *
	 *******************************************************************/
	private static JMenu creerMenuSimple(String titleKey, String[] itemKeys) {

		JMenu menu = new JMenu(titleKey);

		for(int i=0; i < itemKeys.length; ++i) {

			menu.add(new JMenuItem(itemKeys[i]));
		}

		return menu;
	}

	/*******************************************************************
	 * @Titre: ACTION EVENT
	 * 
	 * @Resumer:
	 * Permet de reperer le type de tri selectionne avec l'aide d'un String.
	 *
	 *******************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
	
		typeAlgorithme = e.getActionCommand();

	}

	/********************
	 * Get Type Tri
	 ********************/
	public String getTypeAlgorithme() {

		return typeAlgorithme;
	}

	/********************
	 * Set Type Tri
	 ********************/
	public void setTypeAlgorithme(String typeAlgorithme) {

		this.typeAlgorithme = typeAlgorithme;
	}
}
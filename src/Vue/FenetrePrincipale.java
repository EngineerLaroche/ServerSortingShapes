package Vue;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

import Controller.CommBase;
import Controller.DemarrageTri;
import Model.FormesAbstraites;

/*******************************************************************
 * @Titre_Classe: FENETRE PRINCIPALE
 * 
 * @Resumer: Cette classe represente la fenetre principale de l'application
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 25 juin 2017
 * 
 *******************************************************************/
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	/***************************
	 * Classes instanciees
	 ***************************/

	private MenuFenetre menuFenetre;
	private FenetreFormes fenetreFormes;

	/********************
	 * Constantes
	 ********************/

	private static final long serialVersionUID = -1210804336046370508L;

	// On donne respectivement le nombre maximum de formes et les dimensions de la
	// fenetre.
	private static final int WIDTH = 500, HEIGHT = 500;

	/********************
	 * Constructeur
	 ********************/
	public FenetrePrincipale() {
	}

	public FenetrePrincipale(CommBase commBase) {

		menuFenetre = new MenuFenetre(commBase);
		fenetreFormes = new FenetreFormes();

		// Ajuste la dimension de la fenetre principale selon ses composants
		this.pack();

		// Rend la fenetre principale visible.
		this.setVisible(true);

		this.setResizable(false);

		// Donne une dimension de depart e la fenetre
		this.setSize(WIDTH, HEIGHT);

		// Regroupement des composants graphiques
		this.setLayout(new BorderLayout());

		// Ajout du menu e la fenetre principale
		this.add(menuFenetre, BorderLayout.NORTH);

		// Ajout de la fenetre de formes e la fenetre principale
		this.add(fenetreFormes, BorderLayout.CENTER);

		// Fermeture de l'application e la fermeture de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Donne un titre e la fenetre
		this.setTitle("Fenetre Principale");
	}

	/*******************************************************************
	 * @Titre: CHANGEMENT DE PROPRIETE
	 * 
	 * @Resumer: Appelee lorsque le sujet lance "firePropertyChanger".
	 * 
	 *******************************************************************/
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		System.out.print(">> Event: " + arg0.getPropertyName() + "\n");

		if (arg0.getPropertyName().equals("VIDER-LISTE")) {

			// Permet de vider la liste dynamique au besoin
			fenetreFormes.viderListeChaine();
		}

		// Demarre la selection du tri et insertion des formes dans une liste dynamique
		else if (arg0.getPropertyName().equals("ENVOIE-FORME")) {

			// Affiche une forme a la fenetre en envoyant en parametre la classe
			// FormesAbstraite
			fenetreFormes.ajoutforme((FormesAbstraites) arg0.getNewValue());

			// Demarrage du systeme de tri avec la liste dynamique et type de tri selon la
			// selection
			DemarrageTri.trier(fenetreFormes.getListeAbstraites(), menuFenetre.getTypeAlgorithme());

			repaint();
		}
	}
}

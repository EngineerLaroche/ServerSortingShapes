package Vue;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

import Controller.ListeChaine;
import Model.FormesAbstraites;

/*******************************************************************
 * @Titre_Classe: FENETRE FORMES
 * 
 * @Resumer: 
 * Cette fenetre gere l'affichage des forme e l'ecran.
 * La fenetre possede une dimension fixe de 500 x 500 et 
 * supporte un maximum de 10 formes. 
 * Permet le deplacement des formes avec des bons de 40 (40,40).
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 20 juin 2017 
 * 
 *******************************************************************/ 
public class FenetreFormes extends JComponent{

	/***************************
	 * Classes instanciees
	 ***************************/

	private final Dimension dimension;

	private ListeChaine<FormesAbstraites> listeAbstraites;

	/********************
	 * Constantes
	 ********************/

	private static final long serialVersionUID = -2262235643903749505L;

	//On donne les dimensions de la fenetre et la quantite maximale de formes 
	private static final int 
	WIDTH = 500,
	HEIGHT = 500;

	/********************
	 * Variable
	 ********************/

	//Utilis� pour compter le nombre de formes deplacer les formes
	private int 
	nombreFormes = 0,
	deplacer = 0;


	/********************
	 * Constructeur
	 ********************/
	public FenetreFormes(){

		//On donnes les dimensions de la fenetre
		dimension = new Dimension(WIDTH, HEIGHT);

		//On cree une liste qui peut garder en memoire des formes abstraites
		listeAbstraites = new ListeChaine<FormesAbstraites>();
	}

	/*******************************************************************
	 * @Titre: AJOUTER FORME
	 * 
	 * @Resumer:
	 * Deplace les formes averc des bons de 40 en X et 40 en Y.
	 * S'assure de ne pas depasser la position de la dixieme forme (400,400).
	 * Garde le nombre de formes a l'affiche avec un maximum de 10 formes.
	 * 
	 *******************************************************************/
	public void ajoutforme(FormesAbstraites formesAbstraites){
		
		//Ajout des formes dans une Array List.
		listeAbstraites.ajouterFin(formesAbstraites);
		
		//si on atteint 11 formes
		if(listeAbstraites.getSize() >= 11){
			
			//On enleve la premiere forme dans la liste
			listeAbstraites.enlever(0);
		}
	}


	/*******************************************************************
	 * @Titre: VIDER CHAINE
	 * 
	 * @Resumer:
	 * Remet le premier Noeud et le dernier Noeud a null pour vider la 
	 * liste dynamique composee de formes.
	 * 
	 *******************************************************************/
	public void viderListeChaine() {

		listeAbstraites.viderChaine();
	}	


	/*******************************************************************
	 * @Titre: AFFICHE FORMES
	 * 
	 * @Resumer:
	 * Affiche a l'ecran les formes gardees en memoire de la liste dynamique.
	 * 
	 *******************************************************************/
	@Override 
	public void paintComponent(Graphics g){

		for (int i = 0; i < listeAbstraites.getSize(); i++){
			
			deplacer = i * 40;
			
			//On procede au deplacement des formes a partir de (0,0) avec des bons de (40,40)
			listeAbstraites.getElement(i).setPositionXY(deplacer, deplacer);
			
			//Affiche e l'ecran les formes de la liste
			listeAbstraites.getElement(i).graphiqueForme(g);

		}
	}

	/************************
	 * Set liste dynamique
	 ************************/ 
	public void afficheListeFormes(ListeChaine<FormesAbstraites> listeAbstraites){

		this.listeAbstraites = listeAbstraites;

		nombreFormes = listeAbstraites.getSize();
	}

	/********************
	 * Get Liste Formes
	 ********************/ 
	public ListeChaine<FormesAbstraites> getListeAbstraites(){

		return listeAbstraites;
	}


	/********************
	 * Get dimension
	 ********************/ 
	@Override 
	public Dimension getPreferredSize(){

		return dimension;
	}
}
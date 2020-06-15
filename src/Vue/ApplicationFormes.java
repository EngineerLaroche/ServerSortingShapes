package Vue;
import Controller.CommBase;

/******************************************************************
 *																  * 
 *@Institution: ETS				  								  *
 *															      *
 ******************************************************************															  
 *																  *
 *@Auteur:	 		Alexandre Laroche		  					  *
 *																  *
 *@Cours:			LOG121-03									  *
 *@Date: 			25 juin 2017								  *
 *																  *                                               
 *                                                                *
/*******************************************************************

 * @Titre_Classe: DEMARRAGE APPLICATION
 * 
 * @Résumer:
 * Represente l'application dans son ensemble.
 * On cree une nouvelle Base de Communication avec des listeners 
 * et une nouvelle fenetre, qui est celle l'application. 
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 10 juin 2017 
 *******************************************************************/
public class ApplicationFormes{

	public static void main(String[] args) {
		
		//Demarrage d'une nouvelle application 
		new ApplicationFormes();
		
	}

	/********************
	 * Constructeur
	 ********************/
	public ApplicationFormes(){
		
		//Demarre un nouveau processus de communication
		CommBase comm = new CommBase();

		//Demarre une nouvelle fenetre d'affichage
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
				
		//Interruption connexion si la fenetre principale est ferme
		comm.setPropertyChangeListener(fenetre);
		
		//Permet d'envoyer un message si on ferme la fenetre principale
		fenetre.addWindowListener(comm); 

	}
}
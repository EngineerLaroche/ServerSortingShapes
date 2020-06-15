package Vue;
import java.awt.Graphics;

/*******************************************************************
 * @Titre: INTERFACE FORME
 * 
 * @R�sumer:
 * La classe InterfaceForme est concue de fa�on a etre minimaliste. 
 * On y retrouve une forme, son aire et sa distance.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 15 juin 2017
 *******************************************************************/
public interface InterfaceFormes {

	//Objet graphique (forme)
	public void graphiqueForme(Graphics g);

	//Repr�sente l'aire d'une forme
	public double aireForme();

	//L'espace (zone) que prend une forme
	public double distanceForme();
}
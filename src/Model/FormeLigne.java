package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*******************************************************************
 * @Titre: FORME LIGNE
 * 
 * @Resumer:
 * Creation d'un objet graphique de type ligne 2D. 
 * On identifie la forme a l'aide d'un remplissage colore.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 20 juin 2017
 * 
 *******************************************************************/
public class FormeLigne extends FormesAbstraites{

	/********************
	 * Variables
	 ********************/
	private int x_1, y_1;

	private int deltaInverseX, deltaInverseY;

	private static final int NUMEROTRI = 5;

	/********************
	 * Constructeur
	 ********************/
	public FormeLigne(int nseq, String nomForme, int positionX, int positionY, int x1, int y1){

		//Numero de sequence et nom de la forme
		super(nseq, nomForme, positionX, positionY, NUMEROTRI);

		this.x_1 = x1;
		this.y_1 = y1;

		deltaInverseX = (x_1 - getPositionX());
		deltaInverseY = (y_1 - getPositionY());
	}

	/********************
	 * Aire de la Forme
	 ********************/
	public double aireForme() {

		double aireForme = Math.sqrt(Math.abs((deltaInverseX ^ 2) + (deltaInverseY ^ 2)));

		return  aireForme;
	}

	/********************
	 * Espace Totale
	 ********************/
	public double distanceForme() {

		double espaceForme = Math.sqrt(Math.abs((deltaInverseX ^ 2) + (deltaInverseY ^ 2)));

		return  espaceForme;
	}

	/*******************************************************************
	 * @Titre: GRAPHIQUE LIGNE
	 * 
	 * @Resumer:
	 * Creation d'un objet ligne.
	 * On y retrouve ensuite un rectangle pointille autour de la forme.
	 * Il faut creer 4 lignes pour faire le tour de la ligne principale. 
	 * Sinon, lorsque la ligne principale se dirige vers l'axe des X negatifs, 
	 * le cadrage ne suit pas.
	 * 
	 * @Source:
	 * Stroke Line: 	https://docstore.mik.ua/orelly/java-ent/jfc/ch04_05.htm
	 * Transparance: 	http://www.java2s.com/Code/Java/2D-Graphics-GUI/Drawcanvaswithcolorandtext.htm
	 *
	 *******************************************************************/
	@Override
	public void graphiqueForme(Graphics g) {

		//Creation d'un objet graphique de type ligne
		Graphics2D ligne = (Graphics2D) g;
		
		//Remplissage colore de la forme
		ligne.setColor(Color.BLACK); 
		ligne.drawLine(getPositionX(), getPositionY(), x_1, y_1);

		//Pour creer un perimetre autour de la ligne principale peut importe sa position, il faut creer 4 lignes.
		Graphics2D ligneBase1 = (Graphics2D) g;
		Graphics2D ligneHauteur1 = (Graphics2D) g;
		Graphics2D ligneBase2 = (Graphics2D) g;
		Graphics2D ligneHauteur2 = (Graphics2D) g;

		//Obtenir un cadrage pointille autour de la forme
		ligneBase1.setColor(Color.GRAY);
		ligneBase1.setStroke(getStroke());
		ligneBase1.drawLine(getPositionX(), getPositionY(), x_1, getPositionY());

		//Obtenir un cadrage pointille autour de la forme
		ligneHauteur1.setColor(Color.GRAY);
		ligneHauteur1.setStroke(getStroke());
		ligneHauteur1.drawLine(x_1, getPositionY(), x_1, y_1);

		//Obtenir un cadrage pointille autour de la forme
		ligneBase2.setColor(Color.GRAY);
		ligneBase2.setStroke(getStroke());
		ligneBase2.drawLine(getPositionX(), y_1, x_1, y_1);

		//Obtenir un cadrage pointille autour de la forme
		ligneHauteur2.setColor(Color.GRAY);
		ligneHauteur2.setStroke(getStroke());
		ligneHauteur2.drawLine(getPositionX(), getPositionY(), getPositionX(), y_1);
				
	}
}
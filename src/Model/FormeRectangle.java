package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/*******************************************************************
 * @Titre: FORME RECTANGLE
 * 
 * @Resumer:
 * Creation d'un objet graphique de type rectangle 2D. 
 * On identifie la forme  l'aide d'un remplissage colore.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 20 juin 2017
 * 
 *******************************************************************/
public class FormeRectangle extends FormesAbstraites{

	/********************
	 * Variables
	 ********************/
	private int x1, y1;
	
	private int deltaX, deltaInverseX, deltaY, deltaInverseY;
	
	private static final Color ORANGE = new Color(255, 165, 0, 150);
	
	/********************
	 * Constante
	 ********************/
	
	private static final int NUMEROTRI = 2;

	/********************
	 * Constructeur
	 ********************/
	public FormeRectangle(int nsec, String nomForme, int x1, int y1, int positionX, int positionY){

		//Numero de sequence et nom de la forme
		super(nsec, nomForme, positionX, positionY, NUMEROTRI);

		this.x1 = x1;
		this.y1 = y1;
		
		deltaX = (getPositionX() - this.x1);
		deltaY = (getPositionY() - this.y1);
		deltaInverseX = (this.x1 - getPositionX());
		deltaInverseY = (this.y1 - getPositionY());		
	}

	/********************
	 * Aire de la Forme
	 ********************/
	public double aireForme() {

		double aireForme = Math.abs((deltaInverseX) * (deltaInverseY));

		return aireForme;
	}
	
	/********************
	 * Espace Totale
	 ********************/
	public double distanceForme() {

		double espaceForme = Math.sqrt(((deltaInverseX) ^ 2) + ((deltaInverseY) ^ 2));

		return espaceForme;
	}

	/*******************************************************************
	 * @Titre: GRAPHIQUE RECTANGLE
	 * 
	 * @Resumer:
	 * Creation d'un objet rectangle muni d'un couleure avec effet de transparance.
	 * On y retrouve ensuite un rectangle pointille autour de la forme.
	 * 
	 * @Source:
	 * Stroke Line: 	https://docstore.mik.ua/orelly/java-ent/jfc/ch04_05.htm
	 * Transparance: 	http://www.java2s.com/Code/Java/2D-Graphics-GUI/Drawcanvaswithcolorandtext.htm
	 *
	 *******************************************************************/
	@Override
	public void graphiqueForme(Graphics g){

		//Creation d'un objet graphique de type rectangle
		Graphics2D rectangle = (Graphics2D) g;

		//Creation d'un rectangle autour des dimensions maximale de la forme
		Rectangle2D contourRectangle = new Rectangle2D.Float(getPositionX() - 1, getPositionY() - 1, deltaX + 2, deltaY + 2);
		
		//Obtenir un cadrage pointille autour de la forme
		rectangle.setColor(Color.GRAY);
		rectangle.fill(getStroke().createStrokedShape(contourRectangle));

		//Remplissage colore avec une transparance 
		rectangle.setColor(ORANGE);
		rectangle.fillRect(getPositionX(), getPositionY(), deltaX, deltaY);

		//Contour colore de la forme
		rectangle.setColor(Color.ORANGE);
		rectangle.drawRect(getPositionX(), getPositionY(), deltaX, deltaY);
	}
}
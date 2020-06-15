package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/*******************************************************************
 * @Titre: FORME CARRE
 * 
 * @Resumer:
 * Creation d'un objet graphique de type carre 2D. 
 * On identifie la forme a l'aide d'un remplissage colore.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 20 juin 2017
 * 
 *******************************************************************/

public class FormeCarre extends FormesAbstraites{
	
	/********************
	 * Variables
	 ********************/
	private int x1, y1;
	
	private int deltaX, deltaInverseX, deltaY, deltaInverseY;
	
	private static final Color ROUGE = new Color(255, 0, 0, 150);
	
	/********************
	 * Constante
	 ********************/
	
	private static final int NUMEROTRI = 1;

	/********************
	 * Constructeur
	 ********************/
	public FormeCarre(int nseq, String nomForme, int x1, int y1, int positionX, int positionY){
		
		//Numero de sequence et nom de la forme
		super(nseq, nomForme, positionX, positionY, NUMEROTRI);
		
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
		
		double distance = Math.sqrt(((deltaInverseX) ^ 2) + ((deltaInverseY) ^ 2));
		
		return distance;
	}

	/*******************************************************************
	 * @Titre: GRAPHIQUE CARRE
	 * 
	 * @Resumer:
	 * Creation d'un objet carre muni d'un couleure avec effet de transparance.
	 * On y retrouve ensuite un rectangle pointille autour de la forme.
	 * 
	 * @Source:
	 * Stroke Line: 	https://docstore.mik.ua/orelly/java-ent/jfc/ch04_05.htm
	 * Transparance: 	http://www.java2s.com/Code/Java/2D-Graphics-GUI/Drawcanvaswithcolorandtext.htm
	 *
	 *******************************************************************/
	@Override
	public void graphiqueForme(Graphics g){
	
		//Creation d'un objet graphique de type Carre
		Graphics2D carre = (Graphics2D) g;
		
		//Creation d'un rectangle autour des dimensions maximale de la forme
		Rectangle2D contourRectangle = new Rectangle2D.Float(getPositionX() - 1, getPositionY() - 1, deltaX + 2, deltaY + 2);
		
		//Obtenir un cadrage pointille autour de la forme
		carre.setColor(Color.GRAY);
		carre.fill(getStroke().createStrokedShape(contourRectangle));
		
		//Remplissage colore avec une transparance 
		carre.setColor(ROUGE);
		carre.fillRect(getPositionX(), getPositionY(), deltaX, deltaY);

		//Contour colore de la forme
		carre.setColor(Color.RED);
		carre.drawRect(getPositionX(), getPositionY(), deltaX, deltaY);
	}
}
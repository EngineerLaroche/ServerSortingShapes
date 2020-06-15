package Model;
import java.awt.BasicStroke;
import java.awt.Stroke;

import Vue.InterfaceFormes;
import ca.etsmtl.log.util.IDLogger;

/*******************************************************************
 * @Titre: FORMES ABSTRAITES
 * 
 * @Resumer:
 * On retrouve toute l'information associee a une forme.
 * On retrouve le numero de sequence, le nom de la forme,
 * ses coordonnees en X et Y et un numero qui associe a
 * une forme bien specifique pour aider a faire le tri.
 * Utilisation de l'heritage pour creer des formes.
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 20 juin 2017
 * 
 *******************************************************************/
public abstract class FormesAbstraites implements InterfaceFormes{

	/********************
	 * Variables
	 ********************/
	
	//Numero de sequence d'une forme
	protected int numeroSeq;
	protected String nomForme;
	
	//Numero d'importance pour le tri
	protected int numeroTri;

	protected int 
	positionX,
	positionY;

	//Methode statique qui permet l'ajout d'un numero de sequence au Journal
	IDLogger logger = IDLogger.getInstance();

	/********************
	 * Constructeur
	 ********************/
	
	public FormesAbstraites(int nseq, String nomForme, int valeurX, int valeurY, int numeroTri){

		this.numeroSeq = nseq;
		this.nomForme = nomForme;
		this.positionX = valeurX;
		this.positionY = valeurY;
		this.numeroTri = numeroTri;
		
		//Utilise pour la validation 
		logger.logID(nseq);

	}

	/*******************************************************************
	 * @Titre: GET STROKE
	 * 
	 * @Resumer:
	 * On donne les parametres e la classe Stroke pour obtenir une ligne
	 * pointillee qui sera utilise pour former un cadrage autour de la forme.
	 * On retourne le type de ligne pointillee.
	 * 
	 * @Source: 
	 * Stroke Line: https://docstore.mik.ua/orelly/java-ent/jfc/ch04_05.htm
	 * 
	 *******************************************************************/
	public Stroke getStroke(){

		float[] pointiller = { 6F, 6F };

		//Parametre pour creer la ligne de contour pointiller voulu
		Stroke stroke = new BasicStroke( 1F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 2F, pointiller, 0F );

		return stroke;
	}

	/********************
	 * Get Numero Seq
	 ********************/ 
	public int getNumeroSeq() {

		return numeroSeq;
	}
	
	/********************
	 * Get Nom Forme
	 ********************/ 
	public String getNomForme() {

		return nomForme;
	}

	/********************
	 * Get Position X
	 ********************/ 
	public int getPositionX() {

		return positionX;
	}

	/********************
	 * Get Position Y
	 ********************/ 
	public int getPositionY() {

		return positionY;
	}

	/********************
	 * set Position X et Y
	 ********************/ 
	public void setPositionXY(int valeurX, int valeurY) {
		
		this.positionX = valeurX;
		this.positionY = valeurY;
	}
	
	/********************
	 * Get Numero Tri
	 ********************/ 
	public int getNumeroTri() {

		return numeroTri;
	}
}
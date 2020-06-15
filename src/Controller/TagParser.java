package Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*******************************************************************
 * @Titre_Classe: TAG PARSER
 * 
 * @Resumer: 
 * Permet de decomposer les chaînes de caractères recue par le
 * ServeurForme a l'aide de certaines informations comme le numero de 
 * sequence d'une forme par exemple. 
 * 
 * @SOurce:
 * Expressions rationnelles: https://cours.etsmtl.ca/log121/private/lab/lab1/expressionsRationnelles.shtml
 * Syntaxe: http://www.commentcamarche.net/php/phpreg.php3
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 31 mai 2017 
 * 
 *******************************************************************/ 
public final class TagParser {
	
	/********************
	 * Constante
	 ********************/

	//Represente un ensemble de caractère permettent d'identifer un argument.
	//Espaces ajoutees entre chaque pour aider a la detection du numero de sequence et autre.
	private static String 
	numeroSeq = null,
	identiteForme = null,
	dimensionsForme = null,
	CARACTERE_PATTERN = "(.*) <(.*)> (.*) </\\2>";


	/*******************************************************************
	 * @Titre: MAIN PATTERN
	 * 
	 * @Resumer:
	 * Recupere l'information en fonction des caracteres speciaux et
	 * retourne l'information vers CommBase pour la creation de formes.
	 *
	 *******************************************************************/
	public static final String[] main(String informationForme) {

		Pattern pattern = Pattern.compile(CARACTERE_PATTERN); 

		//Retourne l'information complète d'une forme 
		return findTag(pattern, informationForme);
	}

	/*******************************************************************
	 * @Titre: FIND TAG
	 * 
	 * @Resumer:
	 * Condense l'information d'une forme a un endroit.
	 * Permet d'identifier/confirmer une correspondance avec une forme.
	 * 
	 *******************************************************************/
	private static String[] findTag(Pattern pattern, String informationForme) {

		//Liste qui garde en memoire toute l'information concernant une forme
		String[] descriptionCompleteForme = new String[3];

		//Identification correspondance avec une forme abstraite
		Matcher matcher = pattern.matcher(informationForme);

		//Si un resultat est identifie, la primitive "resultat" tombe a true.
		boolean resultat = matcher.find();

		//On valide le resultat (true)
		if (resultat == true) {

			numeroSeq = matcher.group(1);
			identiteForme = matcher.group(2);
			dimensionsForme = matcher.group(3);
			
			System.out.println("\n*****************************\nPARAMÈTRES FORME:  " + matcher.group(2) + "\n*****************************");
			System.out.println("Numero de sequence: " + matcher.group(1) + "\nData: " + matcher.group(3) + "\n");

		}

		//Insertition des elements qui composent l'identte d'une forme dans une liste
		descriptionCompleteForme[0] = numeroSeq;
		descriptionCompleteForme[1] = identiteForme; 
		descriptionCompleteForme[2] = dimensionsForme;

		//Retourne l'identite d'une forme et ses paramètres
		return descriptionCompleteForme;
	}	
}
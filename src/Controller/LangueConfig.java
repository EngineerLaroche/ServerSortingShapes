package Controller;
import java.util.Locale;
import java.util.ResourceBundle;	

/*******************************************************************
 * @Titre_Classe: CONFIGURATION LANGUE
 * 
 * @Resumer: 
 * Utilitaire pour obtenir un mot dans la langue de l'application.
 * Rien a ete change de la version du "Squelette" fourni.
 * Ce code est base d'un exemple sur Internet, de David Geary.
 * 
 * @Source
 * http://www.javaworld.com/javaworld/jw-05-2003/jw-0530-designpatterns-p2.html
 *  
 * @Auteur: Alexandre Laroche
 * @Date: 26 mai 2017 
 * 
 *******************************************************************/ 
public class LangueConfig {

	/***************************
	 * Classes instanciees
	 ***************************/
	
	private static ResourceBundle preferences, resources;
	private static Locale locale;

	/********************
	 * Constantes
	 ********************/

	static private final String 
	PREFS_BUNDLE_BASENAME = "prefs",
	PREFERRED_LOCALE_KEY = "locale",
	BUNDLE_BASENAME = "app";

	static {
		
		try {

			preferences = ResourceBundle.getBundle(PREFS_BUNDLE_BASENAME);
			
			locale = new Locale(preferences.getString(PREFERRED_LOCALE_KEY));

		}
		catch(java.util.MissingResourceException ex) {

			System.err.println("ERROR: cannot find preferences properties file " + BUNDLE_BASENAME);
		}
		try {

			resources = ResourceBundle.getBundle(BUNDLE_BASENAME, locale);
		}
		catch(java.util.MissingResourceException ex) {

			System.err.println("ERROR: cannot find properties file for " + BUNDLE_BASENAME);
		}
	};

	/*******************************************************************
	 * @Titre: OBTENIR RESSOURCES
	 * 
	 * @Resumer:
	 * Retourne un mot (dans la langue de l'application) lie�a un champs
	 * qui poss�de en param�tre le String "key".
	 * Rien a ete change de la version du "Squelette" fourni.
	 * 
	 *******************************************************************/
	public static String getResource(String key) {

		return (resources == null) ? null : resources.getString(key);
	}
}

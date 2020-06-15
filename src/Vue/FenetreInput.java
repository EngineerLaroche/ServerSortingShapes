package Vue;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*************************************************************************
 * @Titre: FENETRE INPUT 
 * 
 * @Resumer:
 * Demande e l'utilisateur d'inscrire un nom d'hote et un 
 * numero de port pour creer une connexion au serveur. 
 * S'assusre que l'utilisateur entre les bons caracteres 
 * dans les bonnes cases pour eviter d'eventuels problemes de connexions.
 * 
 * @Source 
 * JOptionPane Erreurs: 	https://stackoverflow.com/questions/34391402/show-input-dialog-box-after-error-message-dialog-box
 * JOptionPane Inputs: 		https://stackoverflow.com/questions/27207887/java-jbutton-opening-another-jframe-that-i-can-input-into
 * 
 * @Auteur: Alexandre Laroche et Tomy Nguyen
 * @Date: 12 juin 2017 
 * 
 *************************************************************************/
public class FenetreInput {

	/********************
	 * Variables
	 ********************/ 

	//Garde en memoire la selection du bouton JOptionPane
	private int option;

	//Garde en memoire le nom qui identifie l'hote et numero de port de la connexion TCP/IP
	private String nomHote, numeroPort;

	//Si l'utilisateur decide d'annuler la creation d'une connexion.
	private boolean annulationConnexion;

	/********************
	 * Constructeur
	 ********************/ 
	public FenetreInput(){

		nomHote = null;
		numeroPort = null;
		annulationConnexion = false;
	}

	/*************************************************************************
	 * @Titre: FENETRE INPUT CONNEXION
	 * 
	 * @Resumer:
	 * S'assusre que l'utilisateur entre les bons caracteres 
	 * dans les bonnes cases pour eviter d'eventuels problemes de connexions.
	 * 
	 * @Source 
	 * JOptionPane Erreurs: 	https://stackoverflow.com/questions/34391402/show-input-dialog-box-after-error-message-dialog-box
	 * JOptionPane Inputs: 		https://stackoverflow.com/questions/27207887/java-jbutton-opening-another-jframe-that-i-can-input-into
	 *************************************************************************/
	public void fenetreInputConnexion(){

		//Espaces pour ecrire le nom de l'hote et le numero de port
		JTextField hote = new JTextField("localhost");
		JTextField port = new JTextField("10000");

		//Affichent les messages d'erreurs du nom de l'hote et du numero de 
		JLabel erreurHote = new JLabel();
		JLabel erreurPort = new JLabel();

		//Regroupement des messages d'erreurs et des zones d'ecritures pour le JOptionPane
		Object[] message = {erreurHote, "Nom Hote:", hote, 
				erreurPort, "Numero Port:", port};

		//On procede e des verifications pour eviter les erreurs d'inscriptions
		do{

			//Fenetre qui demande le nom d'hote et le numero de port du serveur formes
			option = JOptionPane.showConfirmDialog(null, message, "Parametres de connexion", JOptionPane.OK_CANCEL_OPTION);

			//Garde en memoire le nom de l'hote entre
			nomHote = hote.getText();

			//Garde en memoire le numero de port entre
			numeroPort = port.getText();

			//Si l'utilisateur selectionne le bouton "Ok"
			if (option == JOptionPane.OK_OPTION) {

				//Si l'utilisateur entre autre chose que des lettres ou laisse un espace vide
				if(!nomHote.matches("[a-zA-Z]+") || nomHote.equals("")){ 

					//Message d'avertissement en rouge
					erreurHote.setText("<html><b style='color:red'>Entrez uniquement des lettres</b><br>");
				}

				//Si l'utilisateur entre des lettres et qu'il n'y pas d'espace vide, on retire le message d'erreur
				if(nomHote.matches("[a-zA-Z]+") && !nomHote.equals("")){ 

					//Retire message d'avertissement 
					erreurHote.setText("");
				}

				//Si l'utilisateur entre autre chose que des nombres ou laisse un espace vide
				if(!numeroPort.matches("[0-9]+") || numeroPort.equals("")){ 

					//Message d'avertissement en rouge
					erreurPort.setText("<html><b style='color:red'>Entrez uniquement des nombres</b><br>");
				}

				//Si l'utilisateur entre des nombres et qu'il n'y pas d'espace vide, on retire le message d'erreur
				if(numeroPort.matches("[0-9]+") && !numeroPort.equals("")){ 

					//Retire message d'avertissement 
					erreurPort.setText("");
				}
			}
			//Si l'utilisateur selectionne le bouton "Cancel"
			else if (option == JOptionPane.CANCEL_OPTION){

				annulationConnexion = true;

				//Met fin e la fenetre JOptionPane
				return;
			}	
			//Si l'utilisateur selectionne le bouton "X"
			else if(option == JOptionPane.CLOSED_OPTION){

				annulationConnexion = true;

				//Met fin e la fenetre JOptionPane
				return;
			}
		}
		//Tant qu'il n'y a pas d'erreurs d'inscription pour la creation d'une connexion TCP/IP, on procede.
		while(nomHote != "" && !nomHote.matches("[a-zA-Z]+") || numeroPort != "" && !numeroPort.matches("[0-9]+")); 

	}

	/*************************************************************************
	 * @Titre: FENETRE ERREUR CONNEXION
	 * 
	 * @Resumer:
	 * Fenetre JOptionPane qui avertis l'utilisateur d'un probleme de connexion 
	 * avec le serveur.
	 * 
	 * @Source 
	 * JOptionPane Erreurs: 	https://stackoverflow.com/questions/34391402/show-input-dialog-box-after-error-message-dialog-box
	 * JOptionPane Inputs: 		https://stackoverflow.com/questions/27207887/java-jbutton-opening-another-jframe-that-i-can-input-into
	 *************************************************************************/
	public void fenetreErreurConnexion(){

		//On averti l'utilisateur que le port entre ne concorde avec aucuns ServeurForme
		JOptionPane.showMessageDialog(null, "<html><b style='color:red'>Tentative de connexion au ServeurForme impossible.</b><br>"
				+ "\n\n<html><b style='color:orange'>Veuillez vous assurer de la conformite du </b><br>"
				+ "<html><b style='color:orange'>numero de port et de l'activite du serveur.</b><br>"
				+ "\n\nAppuyez sur <OK> pour une nouvelle tentative de connexion. ", "Avertissement", 
				JOptionPane.WARNING_MESSAGE);
	}

	/********************
	 * Get Nom Hote
	 ********************/ 
	public String getNomHote(){

		return nomHote;
	}

	/********************
	 * Get Numero Port
	 ********************/ 
	public int getNumeroPort(){

		return Integer.parseInt(numeroPort);
	}

	/********************
	 * Get Annulation
	 ********************/ 
	public boolean isAnnulationConnexion(){

		return annulationConnexion;
	}
}

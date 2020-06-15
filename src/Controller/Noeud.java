package Controller;

/*******************************************************************
 * @Titre_Classe: NOEUD
 * 
 * @Resumer: 
 * Cette classe supporte la classe ListeChaine pour faire avancer ou 
 * reculer les formes. Permet de creer des liaisons entre les formes
 * pour un tri dynamique. 
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 18 juin 2017 
 * 
 * @Source:
 * Inspiration generale: http://pages.cs.wisc.edu/~vernon/cs367/notes/4.LINKED-LIST.html
 * 
 *******************************************************************/ 
public class Noeud<E> {

	private E contenu;
	public Noeud<E> prochain;

	/********************
	 * Constructeurs
	 ********************/
	public Noeud() {}
	
	public Noeud(E contenu) {
		this.contenu = contenu;
		prochain = null;
	}

	public Noeud(E contenu, Noeud<E> prochain) {
		this.contenu = contenu;
		this.prochain = prochain;
	}

	/********************
	 * Get Contenu
	 ********************/ 
	public E getContenu() {
		return contenu;
	}

	/********************
	 * Set Contenu
	 ********************/ 
	public void setContenu(E contenu) {
		this.contenu = contenu;
	}
	/********************
	 * Get prochain Noeud
	 ********************/ 
	public Noeud<E> getProchain() {
		return prochain;
	}
	/********************
	 * Set prochain Noeud
	 ********************/ 
	public void setProchain(Noeud<E> prochain) {
		this.prochain = prochain;
	}
}

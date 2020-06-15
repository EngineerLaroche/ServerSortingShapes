# ServerSortingShapes

## Description

Cette application client (JAVA) se connecte au serveur en utilisant un protocole TCP/IP (port 10000) et utilise deux commandes (GET/SEND) pour interagir avec ce dernier.

L'application client ouvre une fenêtre graphique de 500 pixels par 500 pixels et affiche, une à une, les formes reçues du serveur, jusqu'à un maximum de 10 formes. Par la suite, la forme la plus ancienne est effacée pour permettre à une nouvelle forme de s'afficher. Une fois connecté au serveur, le client fait des requêtes de formes au serveur.

Les formes sont remplies et donc, n'affichent que leurs contours. Une couleur unique est utilisée pour chaque type de forme afin de bien discerner les formes semblables (carré vs rectangle).


## Utilisation

1- Double-cliquer sur ServeurForme.jar situé dans le projet.<br />
2- Double-cliquer sur 'ApplicationCLient.jar' ou démarrer à partir de 'ApplicationFormes.java' situé dans le code source du projet.<br />
3- Une fois l'application client ouvert, sélectionnez 'Ordre' pour choisir le type de tri de formes.<br />
4- Dans l'application, sélectionnez 'Fichier' puis 'Obtenir Formes'. 


## Notions exploitées

####Programmation orientée objet:

⦁	concepts de classe, de sous-classe, de l'héritage <br />
⦁	utilisation des méthodes pour faire interagir des objets <br />
⦁	diagramme de classe en UML <br />
⦁	rédiger et faire compiler un fichier .java source <br />
⦁	exécuter une application Java <br />

### Client-serveur:

⦁	notion de socket en TCP/IP, ouverture, lecture, écriture, fermeture

### Contexte graphique:

⦁	afficher/effacer une forme dans une fenêtre

### Méthodes pour décortiquer une ligne de commande textuelle:

⦁	Integer.parseInt, String.split, java.util.regex, etc.


## Description serveur

Le serveur que vous devrez utiliser est une petite application TCP/IP qui répond uniquement à deux commandes envoyées par la connexion réseau :

⦁	END : qui permet de terminer l'exécution du serveur<br />
⦁	GET : qui permet d'obtenir une ligne textuelle qui comprend le nom d'une forme géométrique simple ainsi que les paramètres l'accompagnant. 

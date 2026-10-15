## Interprétation du résultat de la console

Lors de l'exécution de la classe `Server`, la console affiche le résultat suivant :

1. **Au lancement du serveur :**
   `Je suis un serveur en attente la connexion d'un client`
   *Interprétation :* Le programme instancie un objet `ServerSocket` sur le port 1234. Il affiche ce message pour indiquer qu'il est prêt et qu'il écoute les connexions entrantes. À ce stade, le programme est bloqué sur la ligne `serverSocket.accept()`, ce qui signifie qu'il attend patiemment qu'un client se manifeste.


   <img height="150" src="D:\screenshots\1.1.jpg" width="150"/>


2. **Lorsqu'un client se connecte :**
   `un client est connecté`
   *Interprétation :* Dès qu'un client établit une connexion avec le serveur sur le port 1234, la méthode `accept()` retourne un objet `Socket` représentant cette connexion. Le programme sort de son état d'attente et affiche ce second message.


   <img height="150" src="D:\screenshots\1.b.jpg" width="150"/>


3. **À la fin de l'exécution :**
   Le programme ferme immédiatement la connexion avec le client grâce à `socket.close()`.


   <img height="150" src="D:\screenshots\1.c.jpg" width="150"/>
<img height="150" src="D:\screenshots\1.d.jpg" width="150"/>


4. **Conclusion :** Ce code illustre le fonctionnement de base d'un serveur TCP en Java : il se met en écoute sur un port spécifique, bloque son exécution jusqu'à la réception d'une connexion cliente, traite la connexion, puis se ferme.
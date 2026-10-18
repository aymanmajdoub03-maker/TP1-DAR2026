package serverpackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // Étape 1 : Récupérer l'adresse IP réelle de la machine
        InetAddress adresseLocale = InetAddress.getLocalHost();
        int port = 1234;

        // Création de l'adresse d'écoute
        InetSocketAddress adresseEcoute = new InetSocketAddress(adresseLocale, port);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(adresseEcoute); // Lier le serveur à l'IP réelle

        System.out.println("Serveur démarré sur l'adresse IP : " + adresseLocale.getHostAddress() + ":" + port);
        System.out.println("En attente d'un client...");

        Socket socket = serverSocket.accept();
        System.out.println("Un client distant est connecté (" + socket.getInetAddress().getHostAddress() + ")");

        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        int choix;
        while (true) {
            // Lire le choix de l'opération
            choix = is.readInt();

            // Si le client choisit 0, on quitte la boucle
            if (choix == 0) {
                System.out.println("Le client a quitté. Fermeture du serveur.");
                break;
            }

            // Lire les deux opérandes
            int x = is.readInt();
            int y = is.readInt();
            int resultat = 0;

            // Effectuer le calcul selon le choix
            switch (choix) {
                case 1: resultat = x + y; break;
                case 2: resultat = x - y; break;
                case 3: resultat = x * y; break;
                case 4:
                    if (y != 0) {
                        resultat = x / y;
                    } else {
                        System.out.println("Erreur : division par zéro demandée par le client.");
                        resultat = 0; // ou envoyer un code d'erreur
                    }
                    break;
                default:
                    System.out.println("Choix invalide reçu.");
                    break;
            }

            // Renvoyer le résultat
            os.writeInt(resultat);
            os.flush();

            System.out.println("Calcul : " + x + " (op " + choix + ") " + y + " = " + resultat);
        }

        socket.close();
        serverSocket.close();
    }
}
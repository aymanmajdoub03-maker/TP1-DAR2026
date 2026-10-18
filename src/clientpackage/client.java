package clientpackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Étape 1 : Remplacer "localhost" par l'adresse IP réelle du serveur
        // Par exemple : "192.168.1.15"
        String ipServeur = "192.168.1.15"; // <--- MODIFIEZ CETTE LIGNE
        int port = 1234;

        InetAddress adresseServeur = InetAddress.getByName(ipServeur);
        InetSocketAddress adresseConnexion = new InetSocketAddress(adresseServeur, port);

        System.out.println("Tentative de connexion au serveur " + ipServeur + "...");
        Socket socket = new Socket();
        socket.connect(adresseConnexion);
        System.out.println("Connecté avec succès !");

        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        DataInputStream is = new DataInputStream(socket.getInputStream());

        int choix;
        do {
            // Menu de choix
            System.out.println("\n--- MENU ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Soustraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            if (choix >= 1 && choix <= 4) {
                System.out.print("Entrez le premier entier (x) : ");
                int x = sc.nextInt();
                System.out.print("Entrez le deuxième entier (y) : ");
                int y = sc.nextInt();

                // Envoi des données au serveur
                os.writeInt(choix);
                os.writeInt(x);
                os.writeInt(y);
                os.flush();

                // Réception du résultat
                int resultat = is.readInt();
                System.out.println("--> Résultat renvoyé par le serveur : " + resultat);
            } else if (choix == 0) {
                // Envoi du signal de fin
                os.writeInt(0);
                os.flush();
                System.out.println("Fermeture de la connexion...");
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }

        } while (choix != 0);

        socket.close();
        sc.close();
    }
}
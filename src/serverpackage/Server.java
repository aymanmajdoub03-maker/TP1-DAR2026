package serverpackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args)throws IOException {
        // La première étape :
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");
        // La deuxième étape :
        Socket socket = serverSocket.accept();
        System.out.println("un client est connecté");
        // 4. Lire la requête envoyée par le client
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os =new DataOutputStream(socket.getOutputStream()) ;
        int x;
        while (true) {

            x = is.readInt();
            if (x == 0) {
                System.out.println("Le client a envoyé 0. Fermeture de la communication.");
                break;
            }

            int nb = x * 5;
            os.writeInt(nb);
            os.flush();
            System.out.println("Calcul effectué : "+x+" * 5 = "+nb);
        }
        // 5. Traiter, puis envoyer la réponse
        int nb = x * 5;

        os.writeInt(nb);
        os.flush();
        // La dernière étape : Fermer socket
        socket.close();
    }
}


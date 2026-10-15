package serverpackage;

import java.io.IOException;
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
        // La dernière étape : Fermer socket
        socket.close();
    }
}

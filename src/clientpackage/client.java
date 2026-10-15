package clientpackage;

import java.io.IOException;
import java.net.Socket;

public class client {
    static void main(String[] args)throws IOException {
        // La première étape :

        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket("localhost", 1234);
        System.out.println("je suis un client connecté");
// La dernière étape : Fermer socket
        socket.close();
    }
}

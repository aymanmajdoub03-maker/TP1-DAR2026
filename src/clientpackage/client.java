package clientpackage;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    static void main(String[] args)throws IOException {
        // La première étape :
        Scanner sc = new Scanner(System.in);
        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket("localhost", 1234);
        System.out.println("je suis un client connecté");
        // 4. Envoyer la requête
        int x = sc.nextInt();
        DataOutputStream os =new DataOutputStream(socket.getOutputStream()) ;
        DataInputStream is =new DataInputStream(socket.getInputStream()) ;
// 5. Attendre et lire la réponse
        do {
            System.out.print("Veuillez saisir un entier x (0 pour quitter) : ");
            x = sc.nextInt();
            os.writeInt(x);
            os.flush();


            if (x != 0) {
                int resultat = is.readInt();
                System.out.println("Le résultat de "+x+" * 5 est "+resultat);
            }
        } while (x != 0);
        int resultat = is.readInt();
        System.out.println("La résultat de "+x+"* 5 est " + resultat);
// La dernière étape : Fermer socket
        socket.close();
    }
}

package ca.csf.dominionchat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
	static ServerSocket serverSocket;
	static List<Socket> clientSockets;

	public static void main(String[] args) {
		try {
			// Initialiser le serveur sur le port 4444
			serverSocket = new ServerSocket(4444);

			// Références vers les sockets client, quand le serveur accepte une connexion
			clientSockets = new LinkedList<Socket>();

			while (true) {
				try {
					// On attend continuellement des connexions :
					waitForConnection();
				} catch (IOException e){
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void waitForConnection() throws IOException {
		System.out.println("Waiting for connection");
		Socket clientSocket = serverSocket.accept();
		System.out.println("Connected to client socket at " + clientSocket.getInetAddress());
		clientSockets.add(clientSocket);
		// On indique au client que ce dernier est connecté au serveur.
		pushMessage("You're matched, sweetie.");
	}

	private static void pushMessage(String message) throws IOException {
		for (Socket socket : clientSockets) { // Pour chaque socket, envoie un message
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.flush();
			pw.write(message);
			pw.close();
		}
		
	}
}

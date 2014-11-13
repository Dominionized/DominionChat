package ca.csf.dominionchat;

import java.io.IOException;
import java.net.*;

public class DominionChatClient {

	Socket clientSocket;
	
	public void newConnection(String address, int port) throws UnknownHostException, IOException{
		clientSocket = new Socket(address, port);
	}
}
